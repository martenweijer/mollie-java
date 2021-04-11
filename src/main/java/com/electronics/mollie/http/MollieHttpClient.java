package com.electronics.mollie.http;

import com.electronics.mollie.exceptions.MollieHttpException;

public interface MollieHttpClient {
    /**
     * Execute a GET request.
     * @param url The url
     * @return The response body
     * @throws MollieHttpException When the request fails
     */
    String get(String url) throws MollieHttpException;

    /**
     * Execute a POST request.
     * @param url The url
     * @return The response body
     * @throws MollieHttpException When the request fails
     */
    String post(String url) throws MollieHttpException;

    /**
     * Execute a POST request.
     * @param url The url
     * @param json The request body
     * @return The response body
     * @throws MollieHttpException When the request fails
     */
    String post(String url, String json) throws MollieHttpException;

    /**
     * Execute a PATCH request.
     * @param url The url
     * @param json The request body
     * @return The response body
     * @throws MollieHttpException When the request fails
     */
    String patch(String url, String json) throws MollieHttpException;

    /**
     * Execute a DELETE request.
     * @param url The url
     * @return The response body
     * @throws MollieHttpException When the request fails
     */
    String delete(String url) throws MollieHttpException;

    /**
     * Execute a DELETE request.
     * @param url The url
     * @param json The request body
     * @return The response body
     * @throws MollieHttpException When the request fails
     */
    String delete(String url, String json) throws MollieHttpException;
}
