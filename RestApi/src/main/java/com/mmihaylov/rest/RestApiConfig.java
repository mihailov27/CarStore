package com.mmihaylov.rest;


import com.mmihaylov.rest.endpoints.CarEndpoint;
import com.mmihaylov.rest.endpoints.ImageEndpoint;
import com.mmihaylov.rest.endpoints.ImportCarEndpoint;
import com.mmihaylov.rest.endpoints.TestEndpoint;
import com.mmihaylov.rest.error.BadRequestExceptionMapper;
import com.mmihaylov.rest.error.CarStoreExceptionMapper;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

public class RestApiConfig extends Application {

    private Set<Object> singletons = new HashSet<Object>();
    private Set<Class<?>> classes = new HashSet<Class<?>>();

    public RestApiConfig() {
        super();

        // endpoints
        classes.add(CarEndpoint.class);
        classes.add(ImageEndpoint.class);
        classes.add(ImportCarEndpoint.class);
        classes.add(TestEndpoint.class);
        // error handlers
        classes.add(BadRequestExceptionMapper.class);
        classes.add(CarStoreExceptionMapper.class);
    }

    @Override
    public Set<Class<?>> getClasses() {
        return classes;
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}
