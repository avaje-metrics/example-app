package org.example.myapp.service

import javax.inject.Inject
import javax.inject.Singleton

/**
 * Music layer service.
 */
@Singleton
public class MusicLayer {

  protected val radioHead : RadioHead

  protected val emailSender : EmailSender

  @Inject
  constructor(radioHead : RadioHead, emailSender : EmailSender) {
    this.radioHead = radioHead
    this.emailSender = emailSender
  }

  fun playItSon() {

    emailSender.send(EmailMessage("rob@foo.com", "from@asd.com"))
    radioHead.kidA();
    radioHead.theBends();

  }
}