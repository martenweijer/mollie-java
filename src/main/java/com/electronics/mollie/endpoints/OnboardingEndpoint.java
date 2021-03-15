package com.electronics.mollie.endpoints;

import com.electronics.mollie.QueryMap;
import com.electronics.mollie.exceptions.MollieException;
import com.electronics.mollie.formatting.ResourceFormatter;
import com.electronics.mollie.http.MollieHttpClient;
import com.electronics.mollie.resources.Onboarding;

public class OnboardingEndpoint {
    private final MollieHttpClient mollieHttpClient;
    private final ResourceFormatter<Onboarding> resourceFormatter;

    public OnboardingEndpoint(MollieHttpClient mollieHttpClient, ResourceFormatter<Onboarding> resourceFormatter) {
        this.mollieHttpClient = mollieHttpClient;
        this.resourceFormatter = resourceFormatter;
    }

    public Onboarding get() throws MollieException {
        return get(new QueryMap());
    }

    public Onboarding get(QueryMap queryMap) throws MollieException {
        String json = mollieHttpClient.get("/onboarding/me"+ queryMap.toQueryUrl());
        return resourceFormatter.fromJson(Onboarding.class, json);
    }

    public void submit(Onboarding onboarding) throws MollieException {
        submit(onboarding, new QueryMap());
    }

    public void submit(Onboarding onboarding, QueryMap queryMap) throws MollieException {
        mollieHttpClient.post("/onboarding/me"+ queryMap.toQueryUrl(), resourceFormatter.toJson(onboarding));
    }
}
