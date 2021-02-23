package com.electronics;

import com.electronics.exceptions.MollieException;
import com.electronics.models.CreatePayment;
import com.electronics.models.Payment;
import com.electronics.models.Result;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

public class Mollie {
    private static final Logger logger = LoggerFactory.getLogger(Mollie.class);

    private static final String MOLLIE_ENDPOINT = "https://api.mollie.com/v2";

    private final String apiKey;

    private Mollie(final String apiKey) {
        this.apiKey = apiKey;
    }

    public static Mollie create(final String apiKey) {
        return new Mollie(apiKey);
    }

    public List<Payment> getPayments() throws MollieException {
        try {
            String json = get("/payments");
            ObjectMapper objectMapper = new ObjectMapper();
            Result result = objectMapper.readValue(json, Result.class);
            return result.embedded.payments;
        } catch (IOException e) {
            throw new MollieException(e);
        }
    }

    public Payment findPayment(String id) throws MollieException {
        try {
            String json = get("/payments/"+ id);
            ObjectMapper objectMapper = new ObjectMapper();
            Payment payment = objectMapper.readValue(json, Payment.class);
            return payment;
        } catch (IOException e) {
            throw new MollieException(e);
        }
    }

    public Payment createPayment(CreatePayment createPayment) throws MollieException {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String body = objectMapper.writeValueAsString(createPayment);
            String json = post("/payments", body);
            Payment payment = objectMapper.readValue(json, Payment.class);
            return payment;
        } catch (IOException e) {
            throw new MollieException(e);
        }
    }

    private String get(String path) throws IOException {
        try {
            String url = MOLLIE_ENDPOINT + path;
            logger.info("Request GET {}", url);

            CloseableHttpClient client = HttpClients.createDefault();
            HttpGet get = new HttpGet(url);
            get.addHeader("Authorization", "Bearer "+ apiKey);
            get.addHeader("Content-Type", "application/json");

            String response = client.execute(get, new ResponseHandler());
            logger.info("Response GET {}", response);

            return response;
        } catch (HttpResponseException e) {
            logger.error("Response GET {}", e.getReasonPhrase());
            throw e;
        }
    }

    private String post(String path, String json) throws IOException {
        try {
            String url = MOLLIE_ENDPOINT + path;
            logger.info("Request POST {} {}", url, json);

            CloseableHttpClient client = HttpClients.createDefault();
            HttpPost post = new HttpPost(url);
            post.addHeader("Authorization", "Bearer "+ apiKey);
            post.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON));

            String response = client.execute(post, new ResponseHandler());
            logger.info("Response POST {}", response);

            return response;
        } catch (HttpResponseException e) {
            logger.error("Response POST {}", e.getReasonPhrase());
            throw e;
        }
    }

    private static class ResponseHandler extends BasicResponseHandler {
        @Override
        public String handleResponse(HttpResponse response) throws IOException {
            final StatusLine statusLine = response.getStatusLine();
            final HttpEntity entity = response.getEntity();
            String body = entity == null ? null : handleEntity(entity);

            if (statusLine.getStatusCode() >= 300) {
                throw new HttpResponseException(statusLine.getStatusCode(), body);
            }

            return body;
        }
    }
}
