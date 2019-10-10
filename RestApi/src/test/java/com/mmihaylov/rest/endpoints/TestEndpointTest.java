package com.mmihaylov.rest.endpoints;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.Map;

public class TestEndpointTest {

    private Client client;

    @Before
    public void setUp() {
        client = ClientBuilder.newClient();
    }

    @Test
    public void testPlainText() {
         Response response = client.target(RestApiEndpoints.TEST_TEXT_ENDPOINT)
                 .request(MediaType.TEXT_PLAIN).get();

         String data = response.readEntity(String.class);
         int status = response.getStatus();

        Assert.assertEquals(200, status);
        Assert.assertEquals("CarStorse Rest API is up.", data);
    }

    @Test
    public void testPlainJson() {

        try {
            Response response = client.target(RestApiEndpoints.TEST_JSON_ENDPOINT)
                    .request(MediaType.APPLICATION_JSON).get();
            String data = response.readEntity(String.class);
            ObjectMapper objMapper = new ObjectMapper();
            Map<String, Object> dataMap = objMapper.readValue(data, Map.class);
            int status = response.getStatus();
            Assert.assertEquals(200, status);
            Assert.assertTrue(dataMap.size() == 1);
            Assert.assertTrue(dataMap.containsKey("msg"));
            Assert.assertEquals("CarStorse Rest API is up.", dataMap.get("msg"));
        } catch (IOException ioe) {
            Assert.fail("Failed to parse JSON.\n" + ioe);
        }

    }

}
