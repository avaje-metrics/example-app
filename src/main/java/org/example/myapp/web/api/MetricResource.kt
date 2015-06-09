package org.example.myapp.web.api

import org.avaje.metric.*
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
  @Path("/allTiming/{match}")
  fun allTiming(@PathParam("match") match:String): MutableList<TimingMetricInfo>? {

    return MetricManager.getAllTimingMetrics(match)
  }


  @GET
  @Path("/requestTiming/{match}")
  fun collecting(@PathParam("match") match: String): MutableList<TimingMetricInfo>? {

    return MetricManager.getRequestTimingMetrics(match)
  }


  @GET
  @Path("/collectUsingMatch/{match}/{count}")
  @Produces(MediaType.TEXT_PLAIN)
  fun setCollection(@PathParam("match") match: String,
                    @PathParam("count") count: Int): String {

    logger.info("set collect {} using match {}", count, match)


    val metricCount = MetricManager.setRequestTimingCollectionUsingMatch(match, count);

    return "set ${count} on ${metricCount} metrics"
  }

  @GET
  @Path("/collect/{className}/{methodName}")
  @Produces(MediaType.TEXT_PLAIN)
  fun setCollection(@PathParam("className") className: String,
                    @PathParam("methodName") methodName: String): String {

    logger.info("set collect 5 on {}.{}", className, methodName)

    val clazz = Class.forName(className);
    val success = MetricManager.setRequestTimingCollection(clazz, methodName, 6);

    return if (success) "done" else "not found"
  }
}