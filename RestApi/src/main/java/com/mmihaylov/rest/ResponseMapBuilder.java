package com.mmihaylov.rest;

import javax.ws.rs.client.Entity;
import java.util.HashMap;
import java.util.Map;

public final class ResponseMapBuilder {

    Map<String, Object> responseMap = new HashMap<>();

    public ResponseMapBuilder() {

    }

    public ResponseMapBuilder(String key, Object value) {
        this.responseMap.put(key, value);
    }

    public ResponseMapBuilder with(String key, Object value) {
        this.responseMap.put(key, value);
        return this;
    }

    public Map<String, Object> get() {
        return responseMap;
    }
}
