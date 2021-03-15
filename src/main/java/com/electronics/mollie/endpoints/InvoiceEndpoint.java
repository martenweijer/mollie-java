package com.electronics.mollie.endpoints;

import com.electronics.mollie.QueryMap;
import com.electronics.mollie.exceptions.MollieException;
import com.electronics.mollie.formatting.ResourceFormatter;
import com.electronics.mollie.http.MollieHttpClient;
import com.electronics.mollie.resources.Invoice;
import com.electronics.mollie.resources.Page;

public class InvoiceEndpoint {
    private final MollieHttpClient mollieHttpClient;
    private final ResourceFormatter<Invoice> resourceFormatter;

    public InvoiceEndpoint(MollieHttpClient mollieHttpClient, ResourceFormatter<Invoice> resourceFormatter) {
        this.mollieHttpClient = mollieHttpClient;
        this.resourceFormatter = resourceFormatter;
    }

    public Invoice get(String invoiceId) throws MollieException {
        return get(invoiceId, new QueryMap());
    }

    public Invoice get(String invoiceId, QueryMap queryMap) throws MollieException {
        String json = mollieHttpClient.get("/invoices/"+ invoiceId + queryMap.toQueryUrl());
        return resourceFormatter.fromJson(Invoice.class, json);
    }

    public Page<Invoice> page() throws MollieException {
        return page(new QueryMap());
    }

    public Page<Invoice> page(QueryMap queryMap) throws MollieException {
        String json = mollieHttpClient.get("/invoices"+ queryMap.toQueryUrl());
        return resourceFormatter.fromJsonCollection(Invoice.class, json);
    }
}
