package com.electronics.mollie.endpoints;

import com.electronics.mollie.MollieApiClient;
import com.electronics.mollie.exceptions.MollieException;
import com.electronics.mollie.exceptions.MollieResponseStatusCodeException;
import com.electronics.mollie.http.MollieHttpClient;
import com.electronics.mollie.resources.Invoice;
import com.electronics.mollie.resources.Page;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class InvoiceEndpointTest {
    @Test
    void getInvoice() throws MollieException {
        MollieHttpClient mollieHttpClient = mock(MollieHttpClient.class);
        when(mollieHttpClient.get(anyString())).thenReturn("{\n" +
                "    \"resource\": \"invoice\",\n" +
                "    \"id\": \"inv_xBEbP9rvAq\",\n" +
                "    \"reference\": \"2016.10000\",\n" +
                "    \"vatNumber\": \"NL001234567B01\",\n" +
                "    \"status\": \"open\",\n" +
                "    \"issuedAt\": \"2016-08-31\",\n" +
                "    \"dueAt\": \"2016-09-14\",\n" +
                "    \"netAmount\": {\n" +
                "        \"value\": \"45.00\",\n" +
                "        \"currency\": \"EUR\"\n" +
                "    },\n" +
                "    \"vatAmount\": {\n" +
                "        \"value\": \"9.45\",\n" +
                "        \"currency\": \"EUR\"\n" +
                "    },\n" +
                "    \"grossAmount\": {\n" +
                "        \"value\": \"54.45\",\n" +
                "        \"currency\": \"EUR\"\n" +
                "    },\n" +
                "    \"lines\":[\n" +
                "        {\n" +
                "            \"period\": \"2016-09\",\n" +
                "            \"description\": \"iDEAL transactiekosten\",\n" +
                "            \"count\": 100,\n" +
                "            \"vatPercentage\": 21,\n" +
                "            \"amount\": {\n" +
                "                \"value\": \"45.00\",\n" +
                "                \"currency\": \"EUR\"\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"_links\": {\n" +
                "        \"self\": {\n" +
                "             \"href\": \"https://api.mollie.com/v2/invoices/inv_xBEbP9rvAq\",\n" +
                "             \"type\": \"application/hal+json\"\n" +
                "        },\n" +
                "        \"pdf\": {\n" +
                "             \"href\": \"https://www.mollie.com/merchant/download/invoice/xBEbP9rvAq/2ab44d60b35b1d06090bba955fa2c602\",\n" +
                "             \"type\": \"application/pdf\",\n" +
                "             \"expiresAt\": \"2018-11-09T14:10:36+00:00\"\n" +
                "        }\n" +
                "    }\n" +
                "}");

        MollieApiClient mollieApiClient = new MollieApiClient(mollieHttpClient);
        Invoice invoice = mollieApiClient.invoices().get("foo");
        assertNotNull(invoice);
        assertEquals("inv_xBEbP9rvAq", invoice.getId());
    }

    @Test
    void getInvoiceException() throws MollieException {
        MollieHttpClient mollieHttpClient = mock(MollieHttpClient.class);
        when(mollieHttpClient.get(anyString())).thenThrow(new MollieResponseStatusCodeException(404, "{\"status\":404,\"title\":\"Not Found\",\"detail\":\"No invoice exists with the id \\\"foo\\\".\",\"_links\":{\"documentation\":{\"href\":\"https://docs.mollie.com/reference/v2/invoices-api/get-invoice\",\"type\":\"text/html\"}}}"));

        MollieApiClient mollieApiClient = new MollieApiClient(mollieHttpClient);
        assertThrows(MollieException.class, () -> mollieApiClient.invoices().get("foo"));
    }

    @Test
    void pageInvoices() throws MollieException {
        MollieHttpClient mollieHttpClient = mock(MollieHttpClient.class);
        when(mollieHttpClient.get(anyString())).thenReturn("{\n" +
                "    \"count\": 5,\n" +
                "    \"_embedded\": {\n" +
                "        \"invoices\": [\n" +
                "            {\n" +
                "                \"resource\": \"invoice\",\n" +
                "                \"id\": \"inv_xBEbP9rvAq\",\n" +
                "                \"reference\": \"2016.10000\",\n" +
                "                \"vatNumber\": \"NL001234567B01\",\n" +
                "                \"status\": \"open\",\n" +
                "                \"issuedAt\": \"2016-08-31\",\n" +
                "                \"dueAt\": \"2016-09-14\",\n" +
                "                \"netAmount\": {\n" +
                "                    \"value\": \"45.00\",\n" +
                "                    \"currency\": \"EUR\"\n" +
                "                },\n" +
                "                \"vatAmount\": {\n" +
                "                    \"value\": \"9.45\",\n" +
                "                    \"currency\": \"EUR\"\n" +
                "                },\n" +
                "                \"grossAmount\": {\n" +
                "                    \"value\": \"54.45\",\n" +
                "                    \"currency\": \"EUR\"\n" +
                "                },\n" +
                "                \"lines\":[\n" +
                "                    {\n" +
                "                        \"period\": \"2016-09\",\n" +
                "                        \"description\": \"iDEAL transactiekosten\",\n" +
                "                        \"count\": 100,\n" +
                "                        \"vatPercentage\": 21,\n" +
                "                        \"amount\": {\n" +
                "                            \"value\": \"45.00\",\n" +
                "                            \"currency\": \"EUR\"\n" +
                "                        }\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"_links\": {\n" +
                "                    \"self\": {\n" +
                "                         \"href\": \"https://api.mollie.com/v2/invoices/inv_xBEbP9rvAq\",\n" +
                "                         \"type\": \"application/hal+json\"\n" +
                "                    },\n" +
                "                    \"pdf\": {\n" +
                "                         \"href\": \"https://www.mollie.com/merchant/download/invoice/xBEbP9rvAq/2ab44d60b35955fa2c602\",\n" +
                "                         \"type\": \"application/pdf\",\n" +
                "                         \"expiresAt\": \"2018-11-09T14:10:36+00:00\"\n" +
                "                    }\n" +
                "                }\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"_links\": {\n" +
                "        \"self\": {\n" +
                "            \"href\": \"https://api.mollie.nl/v2/invoices?limit=5\",\n" +
                "            \"type\": \"application/hal+json\"\n" +
                "        },\n" +
                "        \"previous\": null,\n" +
                "        \"next\": {\n" +
                "            \"href\": \"https://api.mollie.nl/v2/invoices?from=inv_xBEbP9rvAq&limit=5\",\n" +
                "            \"type\": \"application/hal+json\"\n" +
                "        },\n" +
                "        \"documentation\": {\n" +
                "            \"href\": \"https://docs.mollie.com/reference/v2/invoices-api/list-invoices\",\n" +
                "            \"type\": \"text/html\"\n" +
                "        }\n" +
                "    }\n" +
                "}");

        MollieApiClient mollieApiClient = new MollieApiClient(mollieHttpClient);
        Page<Invoice> invoices = mollieApiClient.invoices().page();
        assertEquals(5, invoices.getCount());
        assertEquals(Invoice.class, invoices.getItems().get(0).getClass());
    }

    @Test
    void pageInvoicesException() throws MollieException {
        MollieHttpClient mollieHttpClient = mock(MollieHttpClient.class);
        when(mollieHttpClient.get(anyString())).thenThrow(new MollieResponseStatusCodeException(400, "{\"status\":400,\"title\":\"Bad Request\",\"detail\":\"Invalid cursor value\",\"field\":\"from\",\"_links\":{\"documentation\":{\"href\":\"https://docs.mollie.com/guides/pagination\",\"type\":\"text/html\"}}}"));

        MollieApiClient mollieApiClient = new MollieApiClient(mollieHttpClient);
        assertThrows(MollieException.class, () -> mollieApiClient.invoices().page());
    }
}
