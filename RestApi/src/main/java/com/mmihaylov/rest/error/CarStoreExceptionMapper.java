package com.mmihaylov.rest.error;

import com.mmihaylov.backend.facade.CarStoreBusinessException;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class CarStoreExceptionMapper implements ExceptionMapper<CarStoreBusinessException> {

    @Override
    public Response toResponse(CarStoreBusinessException e) {
        Error error = new Error(e.getMessage());
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .type(MediaType.APPLICATION_JSON).entity(error).build();
    }
}
