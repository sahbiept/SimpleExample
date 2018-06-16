package com.traitement.spark
import org.apache.spark.sql.SparkSession

object ReadObject {
  def readExcel(file: String,spark:SparkSession) = {
    spark.read
      .format("com.crealytics.spark.excel")
      .option("location", file)
      .option("useHeader", "true")
      .option("treatEmptyValuesAsNulls", "true")
      .option("inferSchema", "true")
      .option("addColorColumns", "False")
      .load()
  }



}
