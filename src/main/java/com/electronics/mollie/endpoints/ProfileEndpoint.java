package com.electronics.mollie.endpoints;

import com.electronics.mollie.QueryMap;
import com.electronics.mollie.exceptions.MollieException;
import com.electronics.mollie.formatting.ResourceFormatter;
import com.electronics.mollie.http.MollieHttpClient;
import com.electronics.mollie.resources.Page;
import com.electronics.mollie.resources.Profile;

public class ProfileEndpoint {
    private final MollieHttpClient mollieHttpClient;
    private final ResourceFormatter<Profile> resourceFormatter;

    public ProfileEndpoint(MollieHttpClient mollieHttpClient, ResourceFormatter<Profile> resourceFormatter) {
        this.mollieHttpClient = mollieHttpClient;
        this.resourceFormatter = resourceFormatter;
    }

    public Profile get(String profileId) throws MollieException {
        return get(profileId, new QueryMap());
    }

    public Profile get(String profileId, QueryMap queryMap) throws MollieException {
        String json = mollieHttpClient.get("/profiles/"+ profileId + queryMap.toQueryUrl());
        return resourceFormatter.fromJson(Profile.class, json);
    }

    public Profile create(Profile profile) throws MollieException {
        return create(profile, new QueryMap());
    }

    public Profile create(Profile profile, QueryMap queryMap) throws MollieException {
        String json = mollieHttpClient.post("/profiles"+ queryMap.toQueryUrl(), resourceFormatter.toJson(profile));
        return resourceFormatter.fromJson(Profile.class, json);
    }

    public Profile update(String profileId, Profile profile) throws MollieException {
        return update(profileId, profile, new QueryMap());
    }

    public Profile update(String profileId, Profile profile, QueryMap queryMap) throws MollieException {
        String json = mollieHttpClient.patch("/profiles/"+ profileId + queryMap.toQueryUrl(), resourceFormatter.toJson(profile));
        return resourceFormatter.fromJson(Profile.class, json);
    }

    public void delete(String profileId) throws MollieException {
        delete(profileId, new QueryMap());
    }

    public void delete(String profileId, QueryMap queryMap) throws MollieException {
        mollieHttpClient.delete("/profiles/"+ profileId + queryMap.toQueryUrl());
    }

    public Page<Profile> all() throws MollieException {
        return all(new QueryMap());
    }

    public Page<Profile> all(QueryMap queryMap) throws MollieException {
        String json = mollieHttpClient.get("/profiles"+ queryMap.toQueryUrl());
        return resourceFormatter.fromJsonCollection(Profile.class, json);
    }
}
