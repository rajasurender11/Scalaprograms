package com.demo.main

object LoopDemoMain {

  def main(args: Array[String]): Unit = {
    var i = 0
    while (i <= 10) {
      println("#1 while loop Iteration " + i)
      i = i + 1
    }

    i = 15
    while (i != 0 && i <= 20) {
      println("#2 while loop Iteration " + i)
      i = i + 1
    }

    val testList = List("CHN", "BNG", "HYD")
    val listSize = testList.size
    var itr = 0
    if (testList.nonEmpty || listSize > 0) {

      while (itr < listSize) {
        println("#3 while loop iteration " + testList(itr))
        itr = itr + 1
      }
    }

    for (j <- 0 to 10) {
      println("#4 for loop iteration " + j)
    }

    for (j <- 0 until 10) {
      println("#5 for loop iteration " + j)
    }

    if (testList.isEmpty || listSize > 0) {

      for (itr <- testList) {
        println("#6 for loop iteration " + itr)
      }
    }


    testList.foreach(elem => println("#7 Foreach iteration " + elem))

  }

}
