package org.example.myapp.service

import org.example.extension.loggerFor
import org.slf4j.LoggerFactory
import javax.inject.Singleton

/**
 * A very efficient email sender implementation based on not sending at all.
 */
@Singleton
public class DummyEmailSender : EmailSender {

  private val logger = loggerFor(javaClass)

  override fun send(message: EmailMessage) {

    yeahNah()
  }

  fun yeahNah() {
    logger.debug("sending message ... yeah, nah!")
  }
}