package org.example.myapp.main;

import org.avaje.jettyrunner.JettyRun;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.websocket.jsr356.server.ServerContainer;
import org.eclipse.jetty.websocket.jsr356.server.deploy.WebSocketServerContainerInitializer;

/**
 * Created by rob on 10/06/15.
 */
public class XJettyRun extends JettyRun {

  protected void setupWebSocket() {

    try {
      ServerContainer serverContainer = WebSocketServerContainerInitializer.configureContext(webapp);
      //serverContainer.addEndpoint(MetricEvents.class);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void runServer() {
    super.runServer();
  }

  @Override
  public void startServer() {
    this.server = new Server(this.httpPort);
    this.server.setHandler(this.wrapHandlers());
    setupWebSocket();
    try {
      this.server.start();
      log.info("server started", new Object[0]);
      //Runtime.getRuntime().addShutdownHook(new Thread(new BaseRunner.ShutdownRunnable()));
      if(this.useStdInShutdown) {
        System.in.read();
        this.shutdownNicely(false);
      }
    } catch (Exception var2) {
      var2.printStackTrace();
      System.exit(100);
    }

  }
}
