package pkg

object Test:
  def main(args: Array[String]): Unit =
    args.toList match
      case Nil => println(Seq(1, 2, 3))
      case _   => println(args.mkString(" - "))
