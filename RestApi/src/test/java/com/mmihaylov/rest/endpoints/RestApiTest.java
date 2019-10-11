package com.mmihaylov.rest.endpoints;

import org.junit.Before;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

public abstract class RestApiTest {

    protected Client client;

    @Before
    public void setUp() {
        client = ClientBuilder.newClient();
    }

}
