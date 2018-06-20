package fauna

import io.gatling.app.Gatling
import io.gatling.core.config.GatlingPropertiesBuilder

object FaunaStress extends App {

  for (indx <- (1 to 20)) {
    println(s"indx: $indx")
    val map = LoadProfile.feeder.next()
    println(s"map: $map")
  }

  val props = new GatlingPropertiesBuilder
  props.simulationClass("fauna.EventSourceLoad")
  Gatling.fromMap(props.build)

}
