package org.example.myapp.web.api

import org.avaje.metric.AbstractTimedMetric
import org.avaje.metric.MetricManager
import org.avaje.metric.MetricName
import org.avaje.metric.RequestTiming
import org.example.extension.loggerFor
import javax.inject.Singleton
import javax.ws.rs.Consumes
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.PathParam
import javax.ws.rs.core.MediaType

/**
 * Controls metrics.
 */
@Singleton
@Path("/metric")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MetricResource {

  private val logger = loggerFor(javaClass)

  @GET
  @Path("/collecting")
  fun collecting(): MutableList<AbstractTimedMetric>? {

    return MetricManager.getRequestTimingMetrics()
  }


  @GET
  @Path("/collect/{className}/{methodName}")
  @Produces(MediaType.TEXT_PLAIN)
  fun setCollection(@PathParam("className") className: String,
                    @PathParam("methodName") methodName: String): String {

    logger.info("set collect 5 on {}.{}", className, methodName)

    val clazz = Class.forName(className);

    val metricName = MetricManager.name(clazz, methodName);
    val timedMetric = MetricManager.getTimedMetric(metricName)
    timedMetric.setRequestTimingCollection(5)

    logger.info("set collect 5 on {}", metricName)

    return "done"
  }
}