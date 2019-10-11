package com.mmihaylov.rest.endpoints;

import com.mmihaylov.rest.ResponseMapBuilder;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/test")
public class TestEndpoint {

    private static final String message = "CarStorse Rest API is up.";

    @GET
    @Path("/text")
    @Produces(MediaType.TEXT_PLAIN)
    public Response test() {
        return Response.ok(message).build();
    }

    @GET
    @Path("/json")
    @Produces(MediaType.APPLICATION_JSON)
    public Response testJson() {
        return Response
                .status(Response.Status.OK)
                .type(MediaType.APPLICATION_JSON)
                .entity(new ResponseMapBuilder("msg", message).get())
                .build();
    }

}
