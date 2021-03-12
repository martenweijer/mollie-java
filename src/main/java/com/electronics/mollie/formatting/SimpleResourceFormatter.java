package com.electronics.mollie.formatting;

import com.electronics.mollie.exceptions.MollieResponseJsonException;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;

public class SimpleResourceFormatter<T> implements ResourceFormatter<T> {
    private final ObjectMapper objectMapper;

    public SimpleResourceFormatter() {
        this.objectMapper = new ObjectMapper();
        objectMapper.setVisibility(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
    }

    @Override
    public T fromJson(Class<T> resourceType, String json) throws MollieResponseJsonException {
        try {
            return objectMapper.readValue(json, resourceType);
        } catch (JsonProcessingException e) {
            throw new MollieResponseJsonException(e);
        }
    }

    @Override
    public String toJson(T resource) throws MollieResponseJsonException {
        try {
            return objectMapper.writeValueAsString(resource);
        } catch (JsonProcessingException e) {
            throw new MollieResponseJsonException(e);
        }
    }
}
