package com.electronics.mollie.endpoints;

import com.electronics.mollie.QueryMap;
import com.electronics.mollie.exceptions.MollieException;
import com.electronics.mollie.formatting.ResourceFormatter;
import com.electronics.mollie.http.MollieHttpClient;
import com.electronics.mollie.resources.Customer;
import com.electronics.mollie.resources.Page;

public class CustomerEndpoint {
    private final MollieHttpClient mollieHttpClient;
    private final ResourceFormatter<Customer> resourceFormatter;

    public CustomerEndpoint(MollieHttpClient mollieHttpClient, ResourceFormatter<Customer> resourceFormatter) {
        this.mollieHttpClient = mollieHttpClient;
        this.resourceFormatter = resourceFormatter;
    }

    public Customer get(String customerId) throws MollieException {
        return get(customerId, new QueryMap());
    }

    public Customer get(String customerId, QueryMap queryMap) throws MollieException {
        String json = mollieHttpClient.get("/customers/"+ customerId + queryMap.toQueryUrl());
        return resourceFormatter.fromJson(Customer.class, json);
    }

    public Customer create(Customer customer) throws MollieException {
        return create(customer, new QueryMap());
    }

    public Customer create(Customer customer, QueryMap queryMap) throws MollieException {
        String json = mollieHttpClient.post("/customers"+ queryMap.toQueryUrl(), resourceFormatter.toJson(customer));
        return resourceFormatter.fromJson(Customer.class, json);
    }

    public Customer update(String customerId, Customer customer) throws MollieException {
        return update(customerId, customer, new QueryMap());
    }

    public Customer update(String customerId, Customer customer, QueryMap queryMap) throws MollieException {
        String json = mollieHttpClient.patch("/customers/"+ customerId + queryMap.toQueryUrl(), resourceFormatter.toJson(customer));
        return resourceFormatter.fromJson(Customer.class, json);
    }

    public void delete(String customerId) throws MollieException {
        delete(customerId, new QueryMap());
    }

    public void delete(String customerId, QueryMap queryMap) throws MollieException {
        mollieHttpClient.delete("/customers/"+ customerId + queryMap.toQueryUrl());
    }

    public Page<Customer> all() throws MollieException {
        return all(new QueryMap());
    }

    public Page<Customer> all(QueryMap queryMap) throws MollieException {
        String json = mollieHttpClient.get("/customers"+ queryMap.toQueryUrl());
        return resourceFormatter.fromJsonCollection(Customer.class, json);
    }
}
