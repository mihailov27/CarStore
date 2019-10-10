package com.mmihaylov.rest.endpoints;

import com.mmihaylov.backend.facade.service.ImportCarTaskService;
import com.mmihaylov.model.dto.ImportCarRequestDto;
import com.mmihaylov.model.dto.ImportCarTaskDto;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.logging.Logger;

@Path("/import-car")
@RequestScoped
public class ImportCarEndpoint {

    private static final Logger LOGGER = Logger.getLogger(ImportCarEndpoint.class.getName());

    @EJB
    private ImportCarTaskService importCarTaskService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createImportTask(ImportCarRequestDto importCarRequestDto) {
        LOGGER.info("Received a new POST request for import a car from external source: " +
                importCarRequestDto.getSource());
        ImportCarTaskDto importCarTask = this.importCarTaskService.createTask(importCarRequestDto);
        return Response
                .ok()
                .entity(importCarTask)
                .build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getImportTask(@PathParam("id") Long id) {
        LOGGER.info("Getting info for import task id: " + id);
        return Response
                .ok()
                .entity(this.importCarTaskService.getImportTaskStatus(id))
                .build();
    }
}
