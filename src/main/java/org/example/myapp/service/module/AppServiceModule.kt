package org.example.myapp.service.module

import com.google.inject.AbstractModule
import com.google.inject.Binder
import com.google.inject.Injector
import com.google.inject.binder.AnnotatedBindingBuilder
import org.example.extension.loggerFor
import org.example.myapp.service.DummyEmailSender
import org.example.myapp.service.EmailSender
import org.example.myapp.service.MetricService
import org.jetbrains.kotlin.utils.sure

/**
 *
 */
public class AppServiceModule : AbstractModule() {

  private val logger = loggerFor(javaClass)

  inline fun <reified T> AbstractModule.bind() = bind(javaClass<T>())

  inline fun <reified T> AnnotatedBindingBuilder<in T>.to() = to(javaClass<T>())

  override fun configure() {

    logger.debug("configuring module ...")

//    bind(javaClass<MetricService>()).asEagerSingleton()
//    bind(javaClass<EmailSender>()).to(javaClass<DummyEmailSender>())

    bind<MetricService>().asEagerSingleton()
    bind<EmailSender>().to<DummyEmailSender>()
  }

}