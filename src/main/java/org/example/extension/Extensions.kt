package org.example.extension

import com.google.inject.AbstractModule
import com.google.inject.binder.AnnotatedBindingBuilder
import org.slf4j.LoggerFactory

/**
 * Helper function to create a Logger.
 */
fun <T> loggerFor(clazz: Class<T>) = LoggerFactory.getLogger(clazz)


//inline fun <reified T> AbstractModule.bin() = bind(javaClass<T>())
//
//inline fun <reified T> AnnotatedBindingBuilder<in T>.to() = to(javaClass<T>())