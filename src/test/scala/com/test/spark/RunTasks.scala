package com.test.spark
import com.traitement.spark._

import org.apache.spark.sql.SparkSession
import org.scalatest.{BeforeAndAfterEach, FunSuite}

class RunTasks extends FunSuite with BeforeAndAfterEach {
  val pathcontract = "C:\\Users\\benme\\Desktop\\contrat.xlsx"
  val pathgravity = "C:\\Users\\benme\\Desktop\\gravity.xlsx"

  override protected def beforeEach(): Unit = {
    SparkSession.builder()
      .config("spark.ui.showConsoleProgress", "false")
      .master("local[*]")
      .getOrCreate()
  }

  override protected def afterEach(): Unit = {
    //SparkSession.getActiveSession.foreach(_.close())
  }

  test("Run Tasks...") {

    MainClass(pathcontract,pathgravity).run()
  }
}
