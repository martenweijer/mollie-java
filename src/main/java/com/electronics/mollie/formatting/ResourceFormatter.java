package com.electronics.mollie.formatting;

import com.electronics.mollie.exceptions.MollieResponseJsonException;
import com.electronics.mollie.resources.Page;

public interface ResourceFormatter<T> {
    /**
     * Converts json to java object.
     * @param resourceType The result type
     * @param json The json string
     * @return The java object
     * @throws MollieResponseJsonException When converting fails
     */
    T fromJson(Class<T> resourceType, String json) throws MollieResponseJsonException;

    /**
     * Converts json to a java Page object.
     * @param resourceType The result type
     * @param json The json string
     * @return The java object
     * @throws MollieResponseJsonException When converting fails
     */
    Page<T> fromJsonCollection(Class<T> resourceType, String json) throws MollieResponseJsonException;

    /**
     * Converts a java object to json string.
     * @param resource The java object
     * @return The json string
     * @throws MollieResponseJsonException When converting fails
     */
    String toJson(T resource) throws MollieResponseJsonException;
}
