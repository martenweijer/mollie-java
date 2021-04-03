package com.electronics.mollie.http;

import com.electronics.mollie.exceptions.MollieHttpException;

public interface MollieHttpClient {
    String get(String url) throws MollieHttpException;
    String post(String url) throws MollieHttpException;
    String post(String url, String json) throws MollieHttpException;
    String patch(String url, String json) throws MollieHttpException;
    String delete(String url) throws MollieHttpException;
    String delete(String url, String json) throws MollieHttpException;
}
