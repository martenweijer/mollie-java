package com.electronics.mollie.http;

import com.electronics.mollie.exceptions.MollieHttpException;
import com.electronics.mollie.exceptions.MollieResponseStatusCodeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class SimpleMollieHttpClient implements MollieHttpClient {
    private static final Logger logger = LoggerFactory.getLogger(SimpleMollieHttpClient.class);

    private final String endpoint;
    private final String apiKey;

    public SimpleMollieHttpClient(String endpoint, String apiKey) {
        this.endpoint = endpoint;
        this.apiKey = apiKey;
    }

    public String get(String url) throws MollieHttpException {
        try {
            String uri = endpoint + url;
            logger.info("Request GET {}", uri);

            HttpClient client = HttpClient.newBuilder().build();
            HttpRequest request = HttpRequest.newBuilder().GET()
                    .header("Authorization", "Bearer " + apiKey)
                    .uri(new URI(uri)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            logger.info("Response GET {}", response.body());

            if (response.statusCode() >= 300) {
                throw new MollieResponseStatusCodeException(response);
            }

            return response.body();
        } catch (IOException | InterruptedException | URISyntaxException e) {
            throw new MollieHttpException(e);
        }
    }

    public String post(String url) throws MollieHttpException {
        try {
            String uri = endpoint + url;
            logger.info("Request POST {} {}", uri);

            HttpClient client = HttpClient.newBuilder().build();
            HttpRequest request = HttpRequest.newBuilder().POST(HttpRequest.BodyPublishers.noBody())
                    .header("Authorization", "Bearer " + apiKey)
                    .uri(new URI(uri)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            logger.info("Response POST {}", response.body());

            if (response.statusCode() >= 300) {
                throw new MollieResponseStatusCodeException(response);
            }

            return response.body();
        } catch (IOException | InterruptedException | URISyntaxException e) {
            throw new MollieHttpException(e);
        }
    }

    public String post(String url, String json) throws MollieHttpException {
        try {
            String uri = endpoint + url;
            logger.info("Request POST {} {}", uri, json);

            HttpClient client = HttpClient.newBuilder().build();
            HttpRequest request = HttpRequest.newBuilder().POST(HttpRequest.BodyPublishers.ofString(json))
                    .header("Authorization", "Bearer " + apiKey)
                    .uri(new URI(uri)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            logger.info("Response POST {}", response.body());

            if (response.statusCode() >= 300) {
                throw new MollieResponseStatusCodeException(response);
            }

            return response.body();
        } catch (IOException | InterruptedException | URISyntaxException e) {
            throw new MollieHttpException(e);
        }
    }

    @Override
    public String patch(String url, String json) throws MollieHttpException {
        try {
            String uri = endpoint + url;
            logger.info("Request PATCH {} {}", uri, json);

            HttpClient client = HttpClient.newBuilder().build();
            HttpRequest request = HttpRequest.newBuilder().method("PATCH", HttpRequest.BodyPublishers.ofString(json))
                    .header("Authorization", "Bearer " + apiKey)
                    .uri(new URI(uri)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            logger.info("Response PATCH {}", response.body());

            if (response.statusCode() >= 300) {
                throw new MollieResponseStatusCodeException(response);
            }

            return response.body();
        } catch (IOException | InterruptedException | URISyntaxException e) {
            throw new MollieHttpException(e);
        }
    }

    public String delete(String url) throws MollieHttpException {
        try {
            String uri = endpoint + url;
            logger.info("Request DELETE {}", uri);

            HttpClient client = HttpClient.newBuilder().build();
            HttpRequest request = HttpRequest.newBuilder().DELETE()
                    .header("Authorization", "Bearer " + apiKey)
                    .uri(new URI(uri)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            logger.info("Response DELETE {}", response.body());

            if (response.statusCode() >= 300) {
                throw new MollieResponseStatusCodeException(response);
            }

            return response.body();
        } catch (IOException | InterruptedException | URISyntaxException e) {
            throw new MollieHttpException(e);
        }
    }

    @Override
    public String delete(String url, String json) throws MollieHttpException {
        try {
            String uri = endpoint + url;
            logger.info("Request DELETE {}", uri);

            HttpClient client = HttpClient.newBuilder().build();
            HttpRequest request = HttpRequest.newBuilder().method("DELETE", HttpRequest.BodyPublishers.ofString(json))
                    .header("Authorization", "Bearer " + apiKey)
                    .uri(new URI(uri)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            logger.info("Response DELETE {}", response.body());

            if (response.statusCode() >= 300) {
                throw new MollieResponseStatusCodeException(response);
            }

            return response.body();
        } catch (IOException | InterruptedException | URISyntaxException e) {
            throw new MollieHttpException(e);
        }
    }
}
