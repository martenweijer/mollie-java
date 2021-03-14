package com.electronics.mollie.formatting;

import com.electronics.mollie.exceptions.MollieResponseJsonException;
import com.electronics.mollie.resources.Page;

public interface ResourceFormatter<T> {
    T fromJson(Class<T> resourceType, String json) throws MollieResponseJsonException;
    Page<T> fromJsonCollection(Class<T> resourceType, String json) throws MollieResponseJsonException;
    String toJson(T resource) throws MollieResponseJsonException;
}
