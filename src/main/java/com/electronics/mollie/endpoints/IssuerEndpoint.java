package com.electronics.mollie.endpoints;

import com.electronics.mollie.QueryMap;
import com.electronics.mollie.exceptions.MollieException;
import com.electronics.mollie.formatting.ResourceFormatter;
import com.electronics.mollie.http.MollieHttpClient;
import com.electronics.mollie.resources.Issuer;

public class IssuerEndpoint {
    private final MollieHttpClient mollieHttpClient;
    private final ResourceFormatter<Issuer> resourceFormatter;

    public IssuerEndpoint(MollieHttpClient mollieHttpClient, ResourceFormatter<Issuer> resourceFormatter) {
        this.mollieHttpClient = mollieHttpClient;
        this.resourceFormatter = resourceFormatter;
    }

    public Issuer enableGiftcard(String profileId, String issuer) throws MollieException {
        return enableGiftcard(profileId, issuer, new QueryMap());
    }

    public Issuer enableGiftcard(String profileId, String issuer, QueryMap queryMap) throws MollieException {
        String json = mollieHttpClient.post("/profiles/"+ profileId +"/methods/giftcard/issuers/"+ issuer + queryMap.toQueryUrl());
        return resourceFormatter.fromJson(Issuer.class, json);
    }

    public void disableGiftcard(String profileId, String issuer) throws MollieException {
        disableGiftcard(profileId, issuer, new QueryMap());
    }

    public void disableGiftcard(String profileId, String issuer, QueryMap queryMap) throws MollieException {
        mollieHttpClient.delete("/profiles/"+ profileId +"/methods/giftcard/issuers/"+ issuer + queryMap.toQueryUrl());
    }

    public Issuer enableVoucher(String profileId, String issuer) throws MollieException {
        return enableVoucher(profileId, issuer, new QueryMap());
    }

    public Issuer enableVoucher(String profileId, String issuer, QueryMap queryMap) throws MollieException {
        String json = mollieHttpClient.post("/profiles/"+ profileId +"/methods/voucher/issuers/"+ issuer + queryMap.toQueryUrl());
        return resourceFormatter.fromJson(Issuer.class, json);
    }

    public void disableVoucher(String profileId, String issuer) throws MollieException {
        disableVoucher(profileId, issuer, new QueryMap());
    }

    public void disableVoucher(String profileId, String issuer, QueryMap queryMap) throws MollieException {
        mollieHttpClient.delete("/profiles/"+ profileId +"/methods/voucher/issuers/"+ issuer + queryMap.toQueryUrl());
    }
}
