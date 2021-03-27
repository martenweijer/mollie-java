package com.electronics.mollie.endpoints;

import com.electronics.mollie.MollieApiClient;
import com.electronics.mollie.exceptions.MollieException;
import com.electronics.mollie.http.MollieHttpClient;
import com.electronics.mollie.resources.Customer;
import com.electronics.mollie.resources.Page;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CustomerEndpointTest {
    @Test
    void getCustomer() throws MollieException {
        MollieHttpClient mollieHttpClient = mock(MollieHttpClient.class);
        when(mollieHttpClient.get(anyString())).thenReturn("{\n" +
                "    \"resource\": \"customer\",\n" +
                "    \"id\": \"cst_kEn1PlbGa\",\n" +
                "    \"mode\": \"test\",\n" +
                "    \"name\": \"Customer A\",\n" +
                "    \"email\": \"customer@example.org\",\n" +
                "    \"locale\": \"nl_NL\",\n" +
                "    \"metadata\": null,\n" +
                "    \"createdAt\": \"2018-04-06T13:23:21.0Z\",\n" +
                "    \"_links\": {\n" +
                "        \"self\": {\n" +
                "            \"href\": \"https://api.mollie.com/v2/customers/cst_kEn1PlbGa\",\n" +
                "            \"type\": \"application/hal+json\"\n" +
                "        },\n" +
                "        \"dashboard\": {\n" +
                "            \"href\": \"https://www.mollie.com/dashboard/org_123456789/customers/cst_kEn1PlbGa\",\n" +
                "            \"type\": \"text/html\"\n" +
                "        },\n" +
                "        \"mandates\": {\n" +
                "            \"href\": \"https://api.mollie.com/v2/customers/cst_kEn1PlbGa/mandates\",\n" +
                "            \"type\": \"application/hal+json\"\n" +
                "        },\n" +
                "        \"subscriptions\": {\n" +
                "            \"href\": \"https://api.mollie.com/v2/customers/cst_kEn1PlbGa/subscriptions\",\n" +
                "            \"type\": \"application/hal+json\"\n" +
                "        },\n" +
                "        \"payments\": {\n" +
                "            \"href\": \"https://api.mollie.com/v2/customers/cst_kEn1PlbGa/payments\",\n" +
                "            \"type\": \"application/hal+json\"\n" +
                "        },\n" +
                "        \"documentation\": {\n" +
                "            \"href\": \"https://docs.mollie.com/reference/v2/customers-api/get-customer\",\n" +
                "            \"type\": \"text/html\"\n" +
                "        }\n" +
                "    }\n" +
                "}");

        MollieApiClient mollieApiClient = new MollieApiClient(mollieHttpClient);
        Customer customer = mollieApiClient.customers().get("foo");
        Assertions.assertNotNull(customer);
        Assertions.assertEquals("cst_kEn1PlbGa", customer.getId());
    }

    @Test
    void createCustomer() throws MollieException {
        MollieHttpClient mollieHttpClient = mock(MollieHttpClient.class);
        when(mollieHttpClient.post(anyString(), anyString())).thenReturn("{\n" +
                "    \"resource\": \"customer\",\n" +
                "    \"id\": \"cst_8wmqcHMN4U\",\n" +
                "    \"mode\": \"test\",\n" +
                "    \"name\": \"Customer A\",\n" +
                "    \"email\": \"customer@example.org\",\n" +
                "    \"locale\": null,\n" +
                "    \"metadata\": null,\n" +
                "    \"createdAt\": \"2018-04-06T13:10:19.0Z\",\n" +
                "    \"_links\": {\n" +
                "        \"self\": {\n" +
                "            \"href\": \"https://api.mollie.com/v2/customers/cst_8wmqcHMN4U\",\n" +
                "            \"type\": \"application/hal+json\"\n" +
                "        },\n" +
                "        \"dashboard\": {\n" +
                "            \"href\": \"https://www.mollie.com/dashboard/org_123456789/customers/cst_8wmqcHMN4U\",\n" +
                "            \"type\": \"text/html\"\n" +
                "        },\n" +
                "        \"documentation\": {\n" +
                "            \"href\": \"https://docs.mollie.com/reference/v2/customers-api/create-customer\",\n" +
                "            \"type\": \"text/html\"\n" +
                "        }\n" +
                "    }\n" +
                "}");

        Customer customer = new Customer();
        customer.setName("foo");

        MollieApiClient mollieApiClient = new MollieApiClient(mollieHttpClient);
        Customer result = mollieApiClient.customers().create(customer);
        Assertions.assertNotNull(result);
        Assertions.assertEquals("cst_8wmqcHMN4U", result.getId());
    }

    @Test
    void updateCustomer() throws MollieException {
        MollieHttpClient mollieHttpClient = mock(MollieHttpClient.class);
        when(mollieHttpClient.patch(anyString(), anyString())).thenReturn("{\n" +
                "    \"resource\": \"customer\",\n" +
                "    \"id\": \"cst_8wmqcHMN4U\",\n" +
                "    \"mode\": \"test\",\n" +
                "    \"name\": \"Updated Customer A\",\n" +
                "    \"email\": \"updated-customer@example.org\",\n" +
                "    \"locale\": \"nl_NL\",\n" +
                "    \"metadata\": null,\n" +
                "    \"createdAt\": \"2018-04-06T13:23:21.0Z\",\n" +
                "    \"_links\": {\n" +
                "        \"self\": {\n" +
                "            \"href\": \"https://api.mollie.com/v2/customers/cst_8wmqcHMN4U\",\n" +
                "            \"type\": \"application/hal+json\"\n" +
                "        },\n" +
                "        \"dashboard\": {\n" +
                "            \"href\": \"https://www.mollie.com/dashboard/org_123456789/customers/cst_8wmqcHMN4U\",\n" +
                "            \"type\": \"text/html\"\n" +
                "        },\n" +
                "        \"documentation\": {\n" +
                "            \"href\": \"https://docs.mollie.com/reference/v2/customers-api/get-customer\",\n" +
                "            \"type\": \"text/html\"\n" +
                "        }\n" +
                "    }\n" +
                "}");

        Customer customer = new Customer();
        customer.setName("foo");

        MollieApiClient mollieApiClient = new MollieApiClient(mollieHttpClient);
        Customer result = mollieApiClient.customers().update("foo", customer);
        Assertions.assertNotNull(result);
        Assertions.assertEquals("cst_8wmqcHMN4U", result.getId());
    }

    @Test
    void revokeCustomer() throws MollieException {
        MollieHttpClient mollieHttpClient = mock(MollieHttpClient.class);
        when(mollieHttpClient.delete(anyString())).thenReturn("");

        MollieApiClient mollieApiClient = new MollieApiClient(mollieHttpClient);
        mollieApiClient.customers().delete("bar");
    }

    @Test
    void allCustomers() throws MollieException {
        MollieHttpClient mollieHttpClient = mock(MollieHttpClient.class);
        when(mollieHttpClient.get(anyString())).thenReturn("{\n" +
                "    \"count\": 3,\n" +
                "    \"_embedded\": {\n" +
                "        \"customers\": [\n" +
                "            {\n" +
                "                \"resource\": \"customer\",\n" +
                "                \"id\": \"cst_kEn1PlbGa\",\n" +
                "                \"mode\": \"test\",\n" +
                "                \"name\": \"Customer A\",\n" +
                "                \"email\": \"customer@example.org\",\n" +
                "                \"locale\": \"nl_NL\",\n" +
                "                \"metadata\": null,\n" +
                "                \"createdAt\": \"2018-04-06T13:23:21.0Z\",\n" +
                "                \"_links\": {\n" +
                "                    \"self\": {\n" +
                "                        \"href\": \"https://api.mollie.com/v2/customers/cst_kEn1PlbGa\",\n" +
                "                        \"type\": \"application/hal+json\"\n" +
                "                    },\n" +
                "                    \"dashboard\": {\n" +
                "                        \"href\": \"https://www.mollie.com/dashboard/org_123456789/customers/cst_kEn1PlbGa\",\n" +
                "                        \"type\": \"text/html\"\n" +
                "                    },\n" +
                "                    \"documentation\": {\n" +
                "                        \"href\": \"https://docs.mollie.com/reference/v2/customers-api/get-customer\",\n" +
                "                        \"type\": \"text/html\"\n" +
                "                    }\n" +
                "                }\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"_links\": {\n" +
                "        \"self\": {\n" +
                "            \"href\": \"https://api.mollie.com/v2/customers\",\n" +
                "            \"type\": \"application/hal+json\"\n" +
                "        },\n" +
                "        \"previous\": null,\n" +
                "        \"next\": {\n" +
                "            \"href\": \"https://api.mollie.com/v2/customers?from=cst_stTC2WHAuS\",\n" +
                "            \"type\": \"application/hal+json\"\n" +
                "        },\n" +
                "        \"documentation\": {\n" +
                "            \"href\": \"https://docs.mollie.com/reference/v2/customers-api/list-customers\",\n" +
                "            \"type\": \"text/html\"\n" +
                "        }\n" +
                "    }\n" +
                "}");

        MollieApiClient mollieApiClient = new MollieApiClient(mollieHttpClient);
        Page<Customer> page = mollieApiClient.customers().all();
        Assertions.assertEquals(3, page.getCount());
        assertEquals(Customer.class, page.getItems().get(0).getClass());
    }
}
