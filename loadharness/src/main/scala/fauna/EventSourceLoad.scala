package fauna


import io.gatling.commons.validation.{ Success => S, Failure => F, Validation }
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration.DurationInt


/**

  The test time is in minutes

  export EVENT_SERVER_HOST=localhost
  export EVENT_SERVER_PORT=8080
  export TEST_TIME=5
  export USER_LOAD=5

 */
class EventSourceLoad extends Simulation {

  private val EVENT_SERVER_HOST = sys.env("EVENT_SERVER_HOST")
  private val EVENT_SERVER_PORT = sys.env("EVENT_SERVER_PORT")

  private val eventServerUrl = s"http://${EVENT_SERVER_HOST}:${EVENT_SERVER_PORT}"
  println(s"EVENT SERVER URL: $eventServerUrl")

  private val TEST_TIME = sys.env("TEST_TIME").toInt
  private val TIME_FOR_RAMP = 60.seconds
  private val USER_LOAD = sys.env.get("USER_LOAD").map(_.toInt).getOrElse(5)

  val httpConf = http
    .baseURL(s"$eventServerUrl")

  val stress_fauna =
    exec(
      exec { session =>
        println(s"USERID: ${session.userId}")
        session.set("counter", 0).set("userId", session.userId)
      },
      repeat(10, "n") {
        exec(
         exec {
            http("add")
              .post("/add")
              .body(StringBody("""{ "clientId": ${clientId}, "counter": ${counter}, "type":"DEPOSIT","description":"NEW DEPOSIT", "amount":${n} }"""))
             .asJSON
          },
          exec(session => session.set("counter", session("counter").as[Int] + 3))
        )
      }
    )

  val scn = scenario("add deposits")
    .feed(LoadProfile.feeder)
    .exec(stress_fauna)

  setUp(
    scn.inject(
      rampUsersPerSec(1).to(USER_LOAD.toDouble).during(60.seconds),
      constantUsersPerSec(USER_LOAD.toDouble).during(TEST_TIME.minutes.minus(60.seconds))
    )
  ).protocols(httpConf.shareConnections)
}
