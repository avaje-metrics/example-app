package org.example.myapp.service.module

import com.google.inject.AbstractModule
import com.google.inject.binder.AnnotatedBindingBuilder
import org.example.extension.loggerFor
import org.example.myapp.service.DummyEmailSender
import org.example.myapp.service.EmailSender
import org.example.myapp.service.MetricService
import kotlin.reflect.jvm.java

/**
 *
 */
public class AppServiceModule : AbstractModule() {

  private val logger = loggerFor(javaClass)

//  inline fun <reified T> AppServiceModule.bind() = bind(javaClass<T>())
//
//  inline fun <reified T> AnnotatedBindingBuilder<in T>.to() = to(javaClass<T>())

  override fun configure() {

    logger.debug("configuring module ...")

    bind(MetricService::class.java).asEagerSingleton()
    bind(EmailSender::class.java).to(DummyEmailSender::class.java)

//    bind<MetricService>().asEagerSingleton()
//    bind<EmailSender>().to<DummyEmailSender>()
  }

}
