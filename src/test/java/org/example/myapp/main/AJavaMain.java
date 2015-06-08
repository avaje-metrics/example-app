package org.example.myapp.main;

import org.avaje.jettyrunner.JettyRun;

/**
 * Java main method to run Jetty.
 */
public class AJavaMain {

  public static void main(String[] args) {

    JettyRun jetty = new JettyRun();
    jetty.runServer();

  }
}
