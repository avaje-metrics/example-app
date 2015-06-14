package org.example.myapp.service

import org.avaje.metric.RequestTiming
import org.avaje.metric.annotation.NotTimed
import org.avaje.metric.report.BasicRequestTimingWriter
import org.avaje.metric.report.MetricReportConfig
import org.avaje.metric.report.MetricReportManager
import org.avaje.metric.report.RequestTimingListener
import org.example.extension.loggerFor
import java.io.StringWriter
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Metric service to initialise metrics reporting.
 */
@NotTimed
@Singleton
public class MetricService {

  private val logger = loggerFor(javaClass)

  private val requestWriter : BasicRequestTimingWriter

  protected val reporter: MetricReportManager

  protected val broadcast: MetricBroadcast


  @Inject
  constructor(broadcast: MetricBroadcast) {

    logger.debug("initialise the MetricReportManager")

    this.broadcast = broadcast
    val config = MetricReportConfig()
    // report aggregate statistics every 10 seconds
    config.setFreqInSeconds(10)
    // can set threshold to say 1 percent (to reduce noise)
    config.setRequestTimingThreshold(0)
    config.addRequestTimingListener(Listener())

    // threshold of 1 percent
    requestWriter = BasicRequestTimingWriter(1)

    reporter = MetricReportManager(config)
  }

  /**
   * Broadcast the requestTiming via webSockets to any interested parties.
   */
  private fun broadcast(requestTiming: RequestTiming?) {

    // could write as JSON but just use plain text for the moment
    val buffer = StringWriter()
    requestWriter.writeEntry(buffer, requestTiming);
    broadcast.broadcast(buffer.toString())
  }

  inner class Listener : RequestTimingListener {

    override fun onRequestTiming(requestTiming: RequestTiming?) {
      // broadcast the requestTiming
      broadcast(requestTiming)
    }

  }
}