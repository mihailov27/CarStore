package com.mmihaylov.rest.endpoints;

import com.mmihaylov.backend.facade.service.ImageService;
import com.mmihaylov.model.dto.CarImagesDto;
import com.mmihaylov.rest.ResponseMapBuilder;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.logging.Logger;

@Path("images")
@RequestScoped
public class ImageEndpoint {

    private static final Logger LOGGER = Logger.getLogger(ImageEndpoint.class.getName());

    @EJB
    private ImageService imageService;

    @Path("/{carId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getImagesList(@PathParam("carId") Long carId) {
        CarImagesDto carImagesDto = this.imageService.getCarImagesDto(carId);
        return Response.ok().entity(carImagesDto).build();
    }

    @Path("/{imageId}")
    @GET
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response getImageData(@PathParam("imageId") Long imageId) {
        byte[] data = this.imageService.getImageData(imageId);
        return Response.ok().entity(data).build();
    }

    @Path("/{carId}")
    @POST
    @Consumes(MediaType.APPLICATION_OCTET_STREAM)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createImage(@PathParam("carId") Long carId, byte[] data) {
        Long imageId = this.imageService.createImage(carId, data);
        return Response
                .status(Response.Status.CREATED)
                .entity(new ResponseMapBuilder("created", true).with("imageId", imageId).get())
                .build();
    }

    @Path("/{imageId}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteImage(@PathParam("imageId") Long imageId) {
        this.imageService.deleteImageId(imageId);
        return Response
                .status(Response.Status.OK)
                .entity(new ResponseMapBuilder("deleted", true).with("imageId", imageId).get())
                .build();
    }

    @Path("/{imageId}")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateImage(@PathParam("imageId") Long imageId, byte[] data) {
        this.imageService.updateImage(imageId, data);
        return Response
                .status(Response.Status.OK)
                .entity(new ResponseMapBuilder("updated", true).with("imageId", imageId).get())
                .build();
    }

}
