package com.mmihaylov.rest.endpoints;

import com.mmihaylov.backend.facade.service.CarService;
import com.mmihaylov.model.db.Car;
import com.mmihaylov.model.dto.CarDto;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Path("/car")
@RequestScoped
public class CarEndpoint {

    private static final Logger LOGGER = Logger.getLogger(CarEndpoint.class.getName());

    @EJB
    private CarService carService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(CarDto carDto) {

        LOGGER.info("POST '/car' : \n" + carDto);
        Long id = this.carService.create(carDto);
        Map<String, Object> response = new HashMap<>();
        response.put("created", id);
        return Response.status(Response.Status.CREATED)
                .entity(response).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") Long id, CarDto carDto) {

        LOGGER.info("PUT '/car/" + id + "':\n" + carDto);
        Car updatedCar = this.carService.update(id, carDto);
        return Response.status(Response.Status.OK)
                .entity(updatedCar).build();
    }

    @Path("/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response detele(@PathParam("id") Long id) {

        LOGGER.info("DELETE '/car'" + id);
        Map<String, Object> response = new HashMap<>();
        response.put("deleted", id);
        return Response.status(Response.Status.OK)
                .entity(response).build();
    }

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") Long id) {

        LOGGER.info("GET '/car'" + id);
        CarDto carDto = this.carService.getCar(id);
        return Response.ok().entity(carDto).build();
    }

    @Path("/cars")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCars(
            @QueryParam("page") @DefaultValue("0") Integer page,
            @QueryParam("count") @DefaultValue("20") Integer count) {

        LOGGER.info("GET '/cars', page " + page + ", count " + count);
        List<CarDto> cars = this.carService.getCars(page, count);
        return Response.ok().entity(cars).build();
    }

}
