package org.start.quarkus.microservices.book;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@RegisterRestClient(configKey = "isbnProxy")
@Path("/api/isbn")
public interface BookNumberProxy {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    IsbnNumbersThirteen generateIsbNumbers();
}