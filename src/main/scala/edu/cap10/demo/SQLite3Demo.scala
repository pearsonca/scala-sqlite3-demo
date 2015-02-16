package edu.cap10.demo

import java.sql.DriverManager
import java.sql.Connection

object SQLite3Demo extends App {

  val driver = "org.sqlite.JDBC"
  Class.forName(driver)
  try { 
    val connection = DriverManager.getConnection("jdbc:sqlite:./testdb.db")
    val statement = connection.prepareStatement("SELECT name FROM test;")
    val rs = statement.executeQuery()
    while (rs.next()) println(rs.getString("name"))
  } catch {
    case e : Throwable => e.printStackTrace()
  }
  
  
}