package com.electronics.mollie.endpoints;

import com.electronics.mollie.QueryMap;
import com.electronics.mollie.exceptions.MollieException;
import com.electronics.mollie.formatting.ResourceFormatter;
import com.electronics.mollie.http.MollieHttpClient;
import com.electronics.mollie.resources.Capture;
import com.electronics.mollie.resources.Page;

public class CaptureEndpoint {
    private final MollieHttpClient mollieHttpClient;
    private final ResourceFormatter<Capture> resourceFormatter;

    public CaptureEndpoint(MollieHttpClient mollieHttpClient, ResourceFormatter<Capture> resourceFormatter) {
        this.mollieHttpClient = mollieHttpClient;
        this.resourceFormatter = resourceFormatter;
    }

    public Capture get(String paymentId, String captureId) throws MollieException {
        return get(paymentId, captureId, new QueryMap());
    }

    public Capture get(String paymentId, String captureId, QueryMap queryMap) throws MollieException {
        String json = mollieHttpClient.get("/payments/"+ paymentId +"/captures/"+ captureId + queryMap.toQueryUrl());
        return resourceFormatter.fromJson(Capture.class, json);
    }

    public Page<Capture> all(String paymentId) throws MollieException {
        return all(paymentId, new QueryMap());
    }

    public Page<Capture> all(String paymentId, QueryMap queryMap) throws MollieException {
        String json = mollieHttpClient.get("/payments/"+ paymentId +"/captures"+ queryMap.toQueryUrl());
        return resourceFormatter.fromJsonCollection(Capture.class, json);
    }

    public Page<Capture> bySettlement(String settlementId) throws MollieException {
        return bySettlement(settlementId, new QueryMap());
    }

    public Page<Capture> bySettlement(String settlementId, QueryMap queryMap) throws MollieException {
        String json = mollieHttpClient.get("/settlements/"+ settlementId +"/captures"+ queryMap.toQueryUrl());
        return resourceFormatter.fromJsonCollection(Capture.class, json);
    }
}
