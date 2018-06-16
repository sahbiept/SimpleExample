package com.traitement.spark

import org.apache.spark.sql.SparkSession

case class MainClass(path1:String,path2:String) extends Runnable {
 // def main(args: Array[String]): Unit = {

    private val spark = SparkSession
                .builder().appName("first application")
      .getOrCreate()

    import spark.implicits._
    override def run(): Unit = {
    val dfc = ReadObject.readExcel(path1,spark)
    val dfg = ReadObject.readExcel(path2,spark)

    //dfc.show()
    //dfg.show()

    val dfg1=dfg.groupBy("pole_id","appli_emet").min("contract_gravity").withColumnRenamed("min(contract_gravity)", "contract_gravity")
    dfc.join(dfg1,Seq("pole_id", "appli_emet"),"left_outer").orderBy($"contract_id".asc).show()

  }

}
