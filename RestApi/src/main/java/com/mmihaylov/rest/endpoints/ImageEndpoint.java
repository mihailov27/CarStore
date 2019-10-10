package com.mmihaylov.rest.endpoints;

import com.mmihaylov.backend.facade.service.ImageService;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.logging.Logger;

@Path("image")
@RequestScoped
public class ImageEndpoint {

    private static final Logger LOGGER = Logger.getLogger(ImageEndpoint.class.getName());

    @EJB
    private ImageService imageService;

    @Path("/{carId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getImagesList(@PathParam("carId") Long carId) {
        return Response.ok()
    }

}
