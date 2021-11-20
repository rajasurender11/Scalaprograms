package com.demo.main

import com.demo.utils.DemoUtils

import org.json4s._
import org.json4s.native.JsonMethods._

object JsonMain {

case class EmpContacts(primaryContactNo:String,secondaryContactNo:String)
case class EmpProjects(projectId:String,projectLocation:String,projectDomain:String,projectType:String)

  def main(args: Array[String]): Unit = {
    implicit val formats = DefaultFormats
    val jsonFileLoc = "C:\\surender\\hadoop_course\\4_inputfiles\\json_records.txt"
    val jsonRecord = DemoUtils.readLocalFileAsList(jsonFileLoc)
    println(jsonRecord.size)

    for(i <- jsonRecord) {
      println(i)
      val jObject = parse(i).asInstanceOf[JObject]

      val empId = (jObject \\ "empId").extract[String]
      println(empId)
    }



    val customJson =
      """{
 "empId":"E100",
 "empSkills": ["hadoop", "spark"],
 "empCurrentSalary":"25000",
 "empHandiCappped" : false,
 "empContacts" :
                  {
                    "primaryContactNo"   : "87543721723",
                    "secondaryContactNo" : "99765428332"
                  }

 "empProjects" : [
                    {
                      "projectId" : "P1001",
                      "projectLocation": "US",
                      "projectDomain": "BANKING",
                      "projectType" : "support"
                    },
                    {
                      "projectId" : "P1002",
                      "projectLocation": "UK",
                      "projectDomain": "BANKING",
                      "projectType" : "development"
                    }
 ]
 }"""

    val jsonObject = parse(customJson).asInstanceOf[JObject]
    println(jsonObject)
    val empId = (jsonObject \ "empId").extract[String] //monad
    val empSkills = (jsonObject \\ "empSkills").extract[List[String]]
    val empCurrentSalary = (jsonObject \ "empCurrentSalary").extract[String]
    val isHandiCapped = (jsonObject \ "empHandiCappped").extract[Boolean]
    val empPrimaryContact = (jsonObject \ "empContacts" \ "primaryContactNo" ).extract[String]
    val empSecondaryContact = (jsonObject \ "empContacts" \ "secondaryContactNo" ).extract[String]
    val empContacts = (jsonObject \\ "empContacts").extract[EmpContacts]
    println(empId)
    println(empSkills)
    println(empCurrentSalary)
    if(isHandiCapped)
      {
        println(isHandiCapped)
      }
    println(empPrimaryContact)
    println(empSecondaryContact)

    println(s"Employee contacts ${empContacts.primaryContactNo} , ${empContacts.secondaryContactNo}")

    val empProjects = (jsonObject \\ "empProjects").extract[Seq[EmpProjects]]
    empProjects.foreach({ empProject => println(empProject.projectId)
    })

  }

}
