package org.example.myapp.service

import org.avaje.metric.annotation.NotTimed
import org.avaje.metric.report.MetricReportConfig
import org.avaje.metric.report.MetricReportManager
import org.example.extension.loggerFor
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Metric service to initialise metrics reporting.
 */
@NotTimed
@Singleton
public class MetricService {

  private val logger = loggerFor(javaClass)

  protected val reporter : MetricReportManager

  @Inject
  constructor() {

    logger.debug("initialise the MetricReportManager")
    val config = MetricReportConfig()
    config.setFreqInSeconds(10)

    reporter = MetricReportManager(config)
  }
}