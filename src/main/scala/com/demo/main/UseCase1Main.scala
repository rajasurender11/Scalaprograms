package com.demo.main

import com.demo.utils.DemoUtils


object UseCase1Main {
  case class AtmTrans(account_id:String,atm_id:String,trans_dt:String,trans_amt:String,status:String)
  def main(args: Array[String]): Unit = {

    val fileLocMap = Map(
      ("accounts_profile", "C:\\surender\\hadoop_course\\4_inputfiles\\accounts_profile.txt"),
      ("atm_trans", "C:\\surender\\hadoop_course\\4_inputfiles\\atm_trans.txt"),
      ("orders", "C:\\surender\\hadoop_course\\4_inputfiles\\orders.txt")
    )

    fileLocMap.foreach(elem => {
      val fileName = elem._1
      val filePath = elem._2
      val fileData = DemoUtils.readLocalFileAsList(filePath)
      val resultArray = fileName.toUpperCase match {
        case "ACCOUNTS_PROFILE" => processAccountsProfile(fileData)
        case "ATM_TRANS" => processAtmTrans(fileData)
        case "ORDERS" => processOrders(fileData)
        case _ => Array("EMPTY")
      }
      println(s"resultArray for $fileName : ")
      for (elem <- resultArray) {
        println(elem)
      }

    })
  }

  def processAccountsProfile(fileData: List[String]):Array[String] = {
//   println("Printing the data for accounts profile... " )
//    fileData.foreach(println)
    if(fileData.nonEmpty) {
      fileData
        .zipWithIndex
        .map(rec => (rec._1,rec._2+1))
        .filter(rec => rec._2%2 != 0)
        .map(rec => rec._1)
        .toArray

    }
    else {
      Array("EMPTY")
    }

  }

  def processAtmTrans(fileData: List[String]):Array[String] = {
//    println("Printing the data for atm trans... " )
    fileData
      .filter(rec => rec.endsWith("S"))
      .map(rec => {
        var arr = rec.split("\\|")
        AtmTrans(arr(0),arr(1),arr(2),arr(3),arr(4))
      })
      .filter(atmTrans => atmTrans.trans_amt.toInt > 3000)
      .map(atmTrans => doConcat(atmTrans.account_id,atmTrans.trans_dt,atmTrans.trans_amt))
      .toArray


  }

  def processOrders(fileData: List[String]):Array[String] = {
   //println("Printing the data for orders... " )
    fileData.toArray

  }

  def doConcat(s1:String,s2:String,s3:String):String = {
    s"$s1,$s2,$s3"
  }

}
