package org.example.myapp.web.api

import org.example.extension.loggerFor
import org.example.myapp.common.Customer
import org.example.myapp.common.CustomerData
import org.example.myapp.service.EmailMessage
import org.example.myapp.service.EmailSender
import org.example.myapp.service.MusicLayer
import org.example.myapp.service.RadioHead
import java.sql.Timestamp
import javax.inject.Inject
import javax.inject.Singleton
import javax.ws.rs.Consumes
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType

/**
 * Customer web resource.
 */
@Singleton
@Path("/customer")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
open class CustomerResource {

  private val logger = loggerFor(javaClass)

  protected val musicLayer: MusicLayer;

  @Inject
  constructor(musicLayer: MusicLayer) {
    this.musicLayer = musicLayer
  }


  @Produces(MediaType.TEXT_PLAIN)
  @GET
  fun hello(): String {

    logger.debug("plain boring hello ...")

    return "Hello";
  }

  @GET
  @Path("/bean")
  fun asBean(): Customer {

    logger.debug("bean ...")

    musicLayer.playItSon()

    val customer = Customer("Rob", "rob@foo.com")
    customer.lastUpdate = Timestamp(System.currentTimeMillis())
    return customer;
  }

  @GET
  @Path("/data")
  fun useData(): List<CustomerData> {

    logger.debug("data ... (uses a kotlin data bean)")

    val rob = CustomerData("Rob")
    val jim = CustomerData("Jim", "jim@foo.com")
    val trev = CustomerData("Trevor", "trevor@bar.com", Timestamp(System.currentTimeMillis() - 900011))

    return listOf(rob, jim, trev);
  }

}
