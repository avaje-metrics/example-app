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
import kotlin.reflect.jvm.java

/**
 * Main module binding the web and lower layers
 */
public class WebModule : AbstractModule() {

    private val logger = loggerFor(javaClass)

    override fun configure() {

        logger.debug("configuring module ...")

        install(AppServiceModule())

        bind(CustomerResource::class.java).asEagerSingleton()
        bind(MetricResource::class.java).asEagerSingleton()

    }

}