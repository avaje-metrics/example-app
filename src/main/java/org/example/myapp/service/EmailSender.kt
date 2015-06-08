package org.example.myapp.service

/**
 * Email sending service
 */
public interface EmailSender {

  fun send(message : EmailMessage)
}


