package com.demo.utils

import scala.io.Source

object DemoUtils {

  def readLocalFileAsList(fileLoc: String): Iterator[String] = {
    Source.fromFile(fileLoc, "UTF-8").getLines()
  }

}
