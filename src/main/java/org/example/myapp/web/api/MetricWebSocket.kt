package org.example.myapp.web.api

import org.example.extension.loggerFor
import org.example.myapp.service.MetricBroadcast
import java.util.concurrent.ConcurrentHashMap
import javax.inject.Singleton
import javax.websocket.OnClose
import javax.websocket.OnMessage
import javax.websocket.OnOpen
import javax.websocket.Session
import javax.websocket.server.ServerEndpoint

/**
 * WebSocket endpoint used to broadcast metric request timing's to interested clients.
 */
@Singleton
@ServerEndpoint("/metric-ws")
public class MetricWebSocket : MetricBroadcast {

  private val log = loggerFor(javaClass)

  val sessionMap = ConcurrentHashMap<String,Session>()

  /**
   * Send a message to all the clients.
   */
  override fun broadcast(message : String): Int {

    var count = 0;
    val sessions = sessionMap.values()
    for (session in sessions) {
      if (session.isOpen()) {
        session.getBasicRemote().sendText(message)
        count++;
      }
    }
    return count;
  }

  @OnMessage
  fun onMessage(message: String, session: Session): String {

    log.debug("received message [{}]", message)

    val openSessions = session.getOpenSessions();
    for (clientSession in openSessions) {
      if (clientSession.isOpen()) {
        clientSession.getBasicRemote().sendText("fromServer[${message}]")
      }
    }

    return "echo back (" + message + ")";
  }

  @OnOpen
  fun onOpen(session: Session) {

    val id = session.getId()
    log.debug("on open id:{}", id)
    sessionMap.put(id, session)
  }


  @OnClose
  fun onClose(session: Session) {

    val id = session.getId()
    log.debug("onClose id:{}", id)
    sessionMap.remove(id)
  }
}