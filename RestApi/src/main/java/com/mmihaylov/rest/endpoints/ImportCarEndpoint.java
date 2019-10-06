package com.mmihaylov.rest.endpoints;

import com.mmihaylov.backend.facade.service.ImportCarTaskService;
import com.mmihaylov.model.db.ImportCarTask;
import com.mmihaylov.model.dto.ImportCarRequestDto;
import com.mmihaylov.model.dto.ImportCarTaskDto;
import com.mmihaylov.model.util.ImportCarTaskMapper;
import org.glassfish.jersey.server.ManagedAsync;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.AsyncResponse;
import javax.ws.rs.container.Suspended;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.Executor;
import java.util.logging.Logger;

@Path("/import-car")
public class ImportCarEndpoint {

    private static final Logger LOGGER = Logger.getLogger(ImportCarEndpoint.class.getName());

    @EJB
    private ImportCarTaskService importCarTaskService;

    /**
     * Creating a new 'import car' task. It's async endpoint (not blocking thread operation)
     * @param importCarRequestDto
     * @param asyncResponse
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @ManagedAsync
    public void createImportTask(ImportCarRequestDto importCarRequestDto,
                                 @Suspended final AsyncResponse asyncResponse) {
        LOGGER.info("Received a new POST request for import a car from external source: " +
                importCarRequestDto.getSource());
        ImportCarTask importCarTask = importCarTaskService.createTask(importCarRequestDto);
        ImportCarTaskDto dto = ImportCarTaskMapper.toDto(importCarTask);
        asyncResponse.resume(dto);
    }
}
