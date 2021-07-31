package pkg

import scala.util.control.NonFatal

object Test:
  def main(args: Array[String]): Unit =
    try
      val srcLoc =
        getClass().getProtectionDomain().getCodeSource().getLocation().getPath()
      println(s"my source location: $srcLoc")
    catch
      // should not happen.
      case NonFatal(e) =>
        println(s"could not get my source location: $e")
