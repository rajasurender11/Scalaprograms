package com.demo.main

import com.demo.utils.DemoUtils

import scala.collection.mutable.ArrayBuffer

object CollectionsMain {

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

    val cityMap = scala.collection.mutable.Map(
      "CHN" -> "CHENNAI",
      "BNG" -> "BANGALORE",
      "HYD" -> "HYDERABAD",
      "MUM" -> "MUMBAI"
    )


    println(cityMap("BNG"))
    cityMap("BNG") = "BENGALURU"

    if(cityMap.contains("BNG")){
      println(cityMap("BNG"))
    }

    val stateMap = Map(
      ("TN" ,"TAMILNADU"),
      ("KL", "KERALA"),
      ("KAR", "KARNATAKA"),
      ("DEL" , "DELHI")
    )

    println(stateMap("TN"))
  }

}
