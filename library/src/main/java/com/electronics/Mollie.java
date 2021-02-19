package com.electronics;

import com.electronics.exceptions.MollieException;
import com.electronics.models.Payment;
import com.electronics.models.Result;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.fluent.Request;
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

    private String get(String path) throws IOException {
        String url = MOLLIE_ENDPOINT + path;

        logger.info("Request GET {}", url);

        String response = Request.Get(url)
                .addHeader("Authorization", "Bearer "+ apiKey)
                .addHeader("Content-Type", "application/json")
                .execute()
                .returnContent()
                .asString();

        logger.info("Response GET {}", response);

        return response;
    }
}
