package org.example.myapp.web.api

import org.example.extension.loggerFor
import javax.inject.Singleton
import javax.ws.rs.Consumes
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType


@Singleton
@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class IndexResource {

  private val logger = loggerFor(javaClass)

  @GET
  fun index(): String {

    logger.debug("index...")
    return "Hello";
  }
}