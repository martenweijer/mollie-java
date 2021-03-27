package com.electronics.mollie.endpoints;

import com.electronics.mollie.MollieApiClient;
import com.electronics.mollie.exceptions.MollieException;
import com.electronics.mollie.http.MollieHttpClient;
import com.electronics.mollie.resources.Mandate;
import com.electronics.mollie.resources.Page;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MandateEndpointTest {
    @Test
    void getMandate() throws MollieException {
        MollieHttpClient mollieHttpClient = mock(MollieHttpClient.class);
        when(mollieHttpClient.get(anyString())).thenReturn("{\n" +
                "    \"resource\": \"mandate\",\n" +
                "    \"id\": \"mdt_h3gAaD5zP\",\n" +
                "    \"mode\": \"test\",\n" +
                "    \"status\": \"valid\",\n" +
                "    \"method\": \"directdebit\",\n" +
                "    \"details\": {\n" +
                "        \"consumerName\": \"John Doe\",\n" +
                "        \"consumerAccount\": \"NL55INGB0000000000\",\n" +
                "        \"consumerBic\": \"INGBNL2A\"\n" +
                "    },\n" +
                "    \"mandateReference\": \"YOUR-COMPANY-MD1380\",\n" +
                "    \"signatureDate\": \"2018-05-07\",\n" +
                "    \"createdAt\": \"2018-05-07T10:49:08+00:00\",\n" +
                "    \"_links\": {\n" +
                "        \"self\": {\n" +
                "            \"href\": \"https://api.mollie.com/v2/customers/cst_4qqhO89gsT/mandates/mdt_h3gAaD5zP\",\n" +
                "            \"type\": \"application/hal+json\"\n" +
                "        },\n" +
                "        \"customer\": {\n" +
                "            \"href\": \"https://api.mollie.com/v2/customers/cst_4qqhO89gsT\",\n" +
                "            \"type\": \"application/hal+json\"\n" +
                "        },\n" +
                "        \"documentation\": {\n" +
                "            \"href\": \"https://docs.mollie.com/reference/v2/mandates-api/get-mandate\",\n" +
                "            \"type\": \"text/html\"\n" +
                "        }\n" +
                "    }\n" +
                "}");

        MollieApiClient mollieApiClient = new MollieApiClient(mollieHttpClient);
        Mandate mandate = mollieApiClient.mandates().get("foo", "bar");
        Assertions.assertNotNull(mandate);
        Assertions.assertEquals("mdt_h3gAaD5zP", mandate.getId());
    }

    @Test
    void createMandate() throws MollieException {
        MollieHttpClient mollieHttpClient = mock(MollieHttpClient.class);
        when(mollieHttpClient.post(anyString(), anyString())).thenReturn("{\n" +
                "    \"resource\": \"mandate\",\n" +
                "    \"id\": \"mdt_h3gAaD5zP\",\n" +
                "    \"mode\": \"test\",\n" +
                "    \"status\": \"valid\",\n" +
                "    \"method\": \"directdebit\",\n" +
                "    \"details\": {\n" +
                "        \"consumerName\": \"John Doe\",\n" +
                "        \"consumerAccount\": \"NL55INGB0000000000\",\n" +
                "        \"consumerBic\": \"INGBNL2A\"\n" +
                "    },\n" +
                "    \"mandateReference\": \"YOUR-COMPANY-MD13804\",\n" +
                "    \"signatureDate\": \"2018-05-07\",\n" +
                "    \"createdAt\": \"2018-05-07T10:49:08+00:00\",\n" +
                "    \"_links\": {\n" +
                "        \"self\": {\n" +
                "            \"href\": \"https://api.mollie.com/v2/customers/cst_4qqhO89gsT/mandates/mdt_h3gAaD5zP\",\n" +
                "            \"type\": \"application/hal+json\"\n" +
                "        },\n" +
                "        \"customer\": {\n" +
                "            \"href\": \"https://api.mollie.com/v2/customers/cst_4qqhO89gsT\",\n" +
                "            \"type\": \"application/hal+json\"\n" +
                "        },\n" +
                "        \"documentation\": {\n" +
                "            \"href\": \"https://docs.mollie.com/reference/v2/mandates-api/create-mandate\",\n" +
                "            \"type\": \"text/html\"\n" +
                "        }\n" +
                "    }\n" +
                "}");

        Mandate mandate = new Mandate();
        mandate.setMethod("directdebit");

        MollieApiClient mollieApiClient = new MollieApiClient(mollieHttpClient);
        Mandate result = mollieApiClient.mandates().create(mandate, "foo");
        Assertions.assertNotNull(result);
        Assertions.assertEquals("mdt_h3gAaD5zP", result.getId());
    }

    @Test
    void revokeMandate() throws MollieException {
        MollieHttpClient mollieHttpClient = mock(MollieHttpClient.class);
        when(mollieHttpClient.delete(anyString())).thenReturn("");

        MollieApiClient mollieApiClient = new MollieApiClient(mollieHttpClient);
        mollieApiClient.mandates().revoke("foo", "bar");
    }

    @Test
    void allMandates() throws MollieException {
        MollieHttpClient mollieHttpClient = mock(MollieHttpClient.class);
        when(mollieHttpClient.get(anyString())).thenReturn("{\n" +
                "    \"count\": 5,\n" +
                "    \"_embedded\": {\n" +
                "        \"mandates\": [\n" +
                "            {\n" +
                "                \"resource\": \"mandate\",\n" +
                "                \"id\": \"mdt_AcQl5fdL4h\",\n" +
                "                \"mode\": \"test\",\n" +
                "                \"status\": \"valid\",\n" +
                "                \"method\": \"directdebit\",\n" +
                "                \"details\": {\n" +
                "                    \"consumerName\": \"John Doe\",\n" +
                "                    \"consumerAccount\": \"NL55INGB0000000000\",\n" +
                "                    \"consumerBic\": \"INGBNL2A\"\n" +
                "                },\n" +
                "                \"mandateReference\": null,\n" +
                "                \"signatureDate\": \"2018-05-07\",\n" +
                "                \"createdAt\": \"2018-05-07T10:49:08+00:00\",\n" +
                "                \"_links\": {\n" +
                "                    \"self\": {\n" +
                "                        \"href\": \"https://api.mollie.com/v2/customers/cst_8wmqcHMN4U/mandates/mdt_AcQl5fdL4h\",\n" +
                "                        \"type\": \"application/hal+json\"\n" +
                "                    },\n" +
                "                    \"customer\": {\n" +
                "                        \"href\": \"https://api.mollie.com/v2/customers/cst_8wmqcHMN4U\",\n" +
                "                        \"type\": \"application/hal+json\"\n" +
                "                    },\n" +
                "                    \"documentation\": {\n" +
                "                        \"href\": \"https://mollie.com/en/docs/reference/customers/create-mandate\",\n" +
                "                        \"type\": \"text/html\"\n" +
                "                    }\n" +
                "                }\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"_links\": {\n" +
                "        \"self\": {\n" +
                "            \"href\": \"https://api.mollie.com/v2/customers/cst_8wmqcHMN4U/mandates?limit=5\",\n" +
                "            \"type\": \"application/hal+json\"\n" +
                "        },\n" +
                "        \"previous\": null,\n" +
                "        \"next\": {\n" +
                "            \"href\": \"https://api.mollie.com/v2/customers/cst_8wmqcHMN4U/mandates?from=mdt_AcQl5fdL4h&limit=5\",\n" +
                "            \"type\": \"application/hal+json\"\n" +
                "        },\n" +
                "        \"documentation\": {\n" +
                "            \"href\": \"https://docs.mollie.com/reference/v2/mandates-api/revoke-mandate\",\n" +
                "            \"type\": \"text/html\"\n" +
                "        }\n" +
                "    }\n" +
                "}");

        MollieApiClient mollieApiClient = new MollieApiClient(mollieHttpClient);
        Page<Mandate> page = mollieApiClient.mandates().all("foo");
        Assertions.assertEquals(5, page.getCount());
        assertEquals(Mandate.class, page.getItems().get(0).getClass());
    }
}
