package org.example.myapp.web.module

import com.google.inject.AbstractModule
import com.google.inject.Binder
import com.google.inject.Module
import com.google.inject.binder.AnnotatedBindingBuilder
import org.avaje.metric.Metric
import org.example.myapp.web.api.CustomerResource
import org.example.myapp.web.api.MetricResource
import org.example.extension.loggerFor
import org.example.myapp.service.DummyEmailSender
import org.example.myapp.service.EmailSender
import org.example.myapp.service.module.AppServiceModule
import org.slf4j.LoggerFactory
import kotlin.reflect.KClass

/**
 * Main module binding the web and lower layers
 */
public class WebModule : AbstractModule() {

  private val logger = loggerFor(javaClass)

  override fun configure() {

    logger.debug("configuring module ...")

    install(AppServiceModule())

    bind(javaClass<CustomerResource>())
    bind(javaClass<MetricResource>())

//    bind(CustomerResource::class.javaClass)
//    bind(EmailSender::class.javaClass).to(DummyEmailSender::class.javaClass)

  }

//  fun <T> bindK(clazz : KClass<T>) {
//    val clazz1 = clazz.javaClass;
//    bind(clazz1)
//  }
//
//  fun <T> bindK(clazz : KClass<T>, toClazz : KClass<out T>) {
//    bind(clazz.javaClass).to(toClazz.javaClass)
//  }
}