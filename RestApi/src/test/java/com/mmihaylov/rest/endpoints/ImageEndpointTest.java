package com.mmihaylov.rest.endpoints;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Logger;

public class ImageEndpointTest {

    private static final Logger LOGGER = Logger.getLogger(ImageEndpointTest.class.getName());

    private Client client;

    @Before
    public void setUp() {
        client = ClientBuilder.newClient();
    }

    @Test
    public void createImageTest() {
        try {
            byte[] imageBytes = FileUtils.readFileToByteArray(new File(getClass().getClassLoader()
                    .getResource("unhaggle-golf.jpg").getFile()));
            // Send a POST request to create an image.
            Response response = client.target(RestApiEndpoints.IMAGE_ENDPOINT + "/2")
                    .request(MediaType.APPLICATION_JSON)
                    .post(Entity.entity(imageBytes, MediaType.APPLICATION_OCTET_STREAM_TYPE));

            String data = response.readEntity(String.class);
            ObjectMapper objMapper = new ObjectMapper();
            Map<String, Object> dataMap = objMapper.readValue(data, Map.class);
        } catch (IOException ioe) {
            LOGGER.severe("Failed to send the image data.\n" + ioe.getMessage());
            Assert.fail("Sent Image data test failed.");
        }

    }

}
