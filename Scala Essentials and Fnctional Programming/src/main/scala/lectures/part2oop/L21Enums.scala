package lectures.part2oop

object L21Enums {

  sealed trait Permissions {
    def openDocument(): Unit = {
      if (this == Permissions.READ) println("opening document ...")
      else println("reading not allowed.")
    }
  }

  object Permissions {
    case object READ extends Permissions
    case object WRITE extends Permissions
    case object EXECUTE extends Permissions
    case object NONE extends Permissions
  }

  val somePermissions: Permissions = Permissions.READ

  def main(args: Array[String]): Unit = {
    somePermissions.openDocument()
  }
}