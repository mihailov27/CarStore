package com.mmihaylov.rest;


import org.glassfish.jersey.server.ResourceConfig;

public class RestApiConfig extends ResourceConfig {

    public RestApiConfig() {
        packages("com.mmihaylov.rest");
    }
}
