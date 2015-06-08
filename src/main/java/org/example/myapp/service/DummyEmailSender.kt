package org.example.myapp.service

import org.example.extension.loggerFor
import org.slf4j.LoggerFactory
import javax.inject.Singleton

/**
 * Created by rob on 8/06/15.
 */
@Singleton
public class DummyEmailSender : EmailSender {

  private val logger = loggerFor(javaClass)

  override fun send(message: EmailMessage) {

    logger.debug("sending message ... but not really")

  }
}