package com.demo.main

import com.demo.utils.DemoUtils

import scala.collection.mutable.{ArrayBuffer, ListBuffer}
import scala.io.Source

object DemoMain {

  /*
  This is the entry point . This DemoMain can be executed as it has main method
   */
  def main(args: Array[String]): Unit = {

    val fileLoc = "C:\\surender\\hadoop_course\\4_inputfiles\\accounts_profile.txt"
    val fileRecords = DemoUtils.readLocalFileAsList(fileLoc)

    val myArrayBuffer = fileRecords.toArray.toBuffer
    val myList1 = fileRecords.toList.toBuffer
    //myList1.foreach(println)
    //myList1.foreach(rec => println(rec))


  val  myArray = Array("surender","raja")
    println(myArray.size)
    println(myArray(0))
    println(myArray(1))

    myArray(0) = "hadoop"

    println(myArray(0))
    println(myArray(1))

    myArray.foreach(println)

    myArray.+("spark")
    println(myArray.size)
    myArray.foreach(println)
    myArray.drop(1)


    val myAbuffer =  ArrayBuffer("100", "101")

    println(myAbuffer.size)
    myAbuffer.foreach(println)
    myAbuffer.append("102")
    println(myAbuffer.size)
    myAbuffer.foreach(println)


    val myList = List("100|surender|CTS", "101|Raja|TCS")

   //val mappedList =  myList.map(elem =>  (elem,elem.split("\\|").length) )

    val mappedList =  myList.map(elem => elem.length)

    // List((100|surender|CTS,3), (101|Raja|TCS,3) )

    mappedList.foreach(println)

   val result = if(10 > 20 ){
     val data = 10+20
     println("TRUE Scenario")
      data
    }
   else if(10 < 10 ) {
     DemoUtils.readLocalFileAsList(fileLoc)
     99
   }
   else {
     println("FALSE Scenario")
     23
   }

    val city = "CHN"
    val out = city match {
      case "CHN" => "Chennai"
      case "MUM" => "Mumbai"
      case _ => "ANYTHING"
    }
    out
println(result)

    if(result > 10) {
      println("Reaached")
    }



val m = {
  val i =100
  i + 20
  67
}
    val i = 100
    val m1 = i +20

    println(s"m $m")
    println(s"m1 $m1")


    val dataList = List("100|surender|CTS", "101|Raja|TCS", "102|kumar|CTS")

    //val mappedDataList = dataList.map(elem => elem.split("\\|")(1).toUpperCase().substring(0,2)) ::: List("AM")
    dataList.filter(elem => elem.split("\\|")(2) == "CTS")
    val mappedDataList = dataList.map(elem => elem.split("\\|"))

    val flattenedList = dataList.flatMap(elem => elem.split("\\|"))

    val flatList = List("1", "2")

    flatList.map(elem => {
      elem.concat("M")
    })
    flatList.flatMap(elem => Array(elem.concat("M")))













  }


}
