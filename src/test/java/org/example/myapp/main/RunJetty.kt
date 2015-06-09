package org.example.myapp.main

import org.avaje.jettyrunner.JettyRun

/**
 * A Kotlin main method to run Jetty.
 */
fun main(args: Array<String>) {

  println("starting jetty ...")

  val jettyRun = JettyRun()
  jettyRun.setHttpPort(9090)
  jettyRun.runServer()

}