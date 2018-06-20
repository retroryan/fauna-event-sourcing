package fauna

object LoadProfile {

  def createClientProfile(id: Int): Map[String, Any] = Map("clientId" -> id)

  val clientsGenerator: Iterator[Map[String, Any]] = Iterator.range(0, Int.MaxValue).flatMap(x => Seq(createClientProfile(x)))

}
