package org.example.myapp.web.api

import org.example.extension.loggerFor
import org.example.myapp.common.Customer
import org.example.myapp.common.CustomerData
import org.example.myapp.service.EmailMessage
import org.example.myapp.service.EmailSender
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
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Singleton
@Path("/customer")
open class CustomerResource {

  private val logger = loggerFor(javaClass)

  protected val emailSender : EmailSender;

  @Inject
  constructor(emailSender : EmailSender) {
    this.emailSender = emailSender;
  }


  @Produces(MediaType.TEXT_PLAIN)
  @GET
  fun hello() : String {

    logger.debug("plan boring hello ...")

    return "Hello";
  }

  @GET
  @Path("/bean")
  fun asBean() : Customer {

    logger.debug("hello bean ...")

    emailSender.send(EmailMessage("rob@foo.com", "from@asd.com"))

    val customer = Customer("Rob", "rob@foo.com")
    customer.lastUpdate = Timestamp(System.currentTimeMillis())
    return customer;
  }

  @GET
  @Path("/data")
  fun useData() : List<CustomerData> {

    logger.debug("hello useData ...")

    val c0 = CustomerData("Rob")
    val c1 = CustomerData("Jim","jim@foo.com")
    val c2 = CustomerData("Trevor","trevor@bar.com", Timestamp(System.currentTimeMillis()-900011))

    return listOf(c0, c1, c2);
  }

}