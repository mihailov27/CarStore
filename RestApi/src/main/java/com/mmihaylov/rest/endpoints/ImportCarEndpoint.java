package com.mmihaylov.rest.endpoints;

import com.mmihaylov.backend.facade.service.ImportCarTaskService;
import com.mmihaylov.model.db.ImportCarTask;
import com.mmihaylov.model.dto.ImportCarRequestDto;
import com.mmihaylov.model.dto.ImportCarTaskDto;
import com.mmihaylov.model.util.ImportCarTaskMapper;

import javax.annotation.ManagedBean;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
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
        ImportCarTask importCarTask = importCarTaskService.createTask(importCarRequestDto);

        ImportCarTaskDto dto = ImportCarTaskMapper.toDto(importCarTask);
        return Response.ok(dto).build();
    }
}
