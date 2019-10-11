package com.mmihaylov.rest.endpoints;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mmihaylov.model.dto.CarDto;
import com.mmihaylov.model.enums.Currency;
import com.mmihaylov.model.enums.Status;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.Calendar;
import java.util.Map;
import java.util.logging.Logger;

public class CarEndpointTest {

    private static final Logger LOGGER = Logger.getLogger(CarEndpointTest.class.getName());

    private Client client;

    @Before
    public void setUp() {
        client = ClientBuilder.newClient();
    }

    @Test
    public void testCreate() {

        try {
            CarDto carDto = new CarDto();
            carDto.setBrand("VW");
            carDto.setModel("Golf Plus");
            carDto.setCurrency(Currency.BGN);
            carDto.setPrice(5000L);
            carDto.setStatus(Status.FOR_SALE);
            carDto.setMileage(120000L);

            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR, 2001);
            calendar.set(Calendar.MONTH, 1);
            calendar.set(Calendar.DAY_OF_MONTH, 10);
            carDto.setFirstRegistration(calendar.getTime());

            // Send a POST request.
            Response response = client.target(RestApiEndpoints.CAR_ENDPOINT)
                    .request(MediaType.APPLICATION_JSON).post(Entity.entity(carDto, MediaType.APPLICATION_JSON_TYPE));
            String data = response.readEntity(String.class);
            ObjectMapper objMapper = new ObjectMapper();
            Map<String, Object> dataMap = objMapper.readValue(data, Map.class);
        } catch (IOException ioe) {
            LOGGER.severe(ioe.getMessage());
            Assert.fail("Failed to send POST request for new car.");
        }
    }

    @Test
    public void testGet() {
        CarDto carDto = client.target(RestApiEndpoints.CAR_ENDPOINT + "/2")
                .request(MediaType.APPLICATION_JSON).get(CarDto.class);

        Assert.assertTrue(carDto != null);
        Assert.assertTrue(carDto.getId() == 2L);
        Assert.assertEquals("VW", carDto.getBrand());
    }

}
