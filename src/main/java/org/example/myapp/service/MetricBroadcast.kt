package org.example.myapp.service

/**
 * Created by rob on 14/06/15.
 */
public interface MetricBroadcast {

  /**
   * Send a message to all the clients.
   */
  fun broadcast(message : String): Int

}