package com.electronics.mollie.endpoints;

import com.electronics.mollie.MollieApiClient;
import com.electronics.mollie.exceptions.MollieException;
import com.electronics.mollie.exceptions.MollieResponseStatusCodeException;
import com.electronics.mollie.http.MollieHttpClient;
import com.electronics.mollie.resources.Chargeback;
import com.electronics.mollie.resources.Page;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ChargebackEndpointTest {
    @Test
    void getChargeback() throws MollieException {
        MollieHttpClient mollieHttpClient = mock(MollieHttpClient.class);
        when(mollieHttpClient.get(anyString())).thenReturn("{\n" +
                "    \"resource\": \"chargeback\",\n" +
                "    \"id\": \"chb_n9z0tp\",\n" +
                "    \"amount\": {\n" +
                "        \"currency\": \"USD\",\n" +
                "        \"value\": \"43.38\"\n" +
                "    },\n" +
                "    \"settlementAmount\": {\n" +
                "        \"currency\": \"EUR\",\n" +
                "        \"value\": \"-35.07\"\n" +
                "    },\n" +
                "    \"createdAt\": \"2018-03-14T17:00:52.0Z\",\n" +
                "     \"reason\": {\n" +
                "       \"code\": \"AC01\",\n" +
                "       \"description\": \"Account identifier incorrect (i.e. invalid IBAN)\"\n" +
                "     },\n" +
                "    \"reversedAt\": null,\n" +
                "    \"paymentId\": \"tr_WDqYK6vllg\",\n" +
                "    \"_links\": {\n" +
                "        \"self\": {\n" +
                "            \"href\": \"https://api.mollie.com/v2/payments/tr_WDqYK6vllg/chargebacks/chb_n9z0tp\",\n" +
                "            \"type\": \"application/hal+json\"\n" +
                "        },\n" +
                "        \"payment\": {\n" +
                "            \"href\": \"https://api.mollie.com/v2/payments/tr_WDqYK6vllg\",\n" +
                "            \"type\": \"application/hal+json\"\n" +
                "        },\n" +
                "        \"documentation\": {\n" +
                "            \"href\": \"https://docs.mollie.com/reference/v2/chargebacks-api/get-chargeback\",\n" +
                "            \"type\": \"text/html\"\n" +
                "        }\n" +
                "    }\n" +
                "}");

        MollieApiClient mollieApiClient = new MollieApiClient(mollieHttpClient);
        Chargeback chargeback = mollieApiClient.chargebacks().get("foo", "123");
        assertNotNull(chargeback);
        assertEquals("chb_n9z0tp", chargeback.getId());
    }

    @Test
    void getChargebackException() throws MollieException {
        MollieHttpClient mollieHttpClient = mock(MollieHttpClient.class);
        when(mollieHttpClient.get(anyString())).thenThrow(new MollieResponseStatusCodeException(404, "{\"status\":404,\"title\":\"Not Found\",\"detail\":\"No chargeback exists with token 123\",\"_links\":{\"documentation\":{\"href\":\"https://docs.mollie.com/guides/handling-errors\",\"type\":\"text/html\"}}}"));

        MollieApiClient mollieApiClient = new MollieApiClient(mollieHttpClient);
        assertThrows(MollieException.class, () -> mollieApiClient.chargebacks().get("foo", "123"));
    }

    @Test
    void allChargebacks() throws MollieException {
        MollieHttpClient mollieHttpClient = mock(MollieHttpClient.class);
        when(mollieHttpClient.get(anyString())).thenReturn("{\n" +
                "    \"count\": 3,\n" +
                "    \"_embedded\": {\n" +
                "        \"chargebacks\": [\n" +
                "            {\n" +
                "                \"resource\": \"chargeback\",\n" +
                "                \"id\": \"chb_n9z0tp\",\n" +
                "                \"amount\": {\n" +
                "                    \"currency\": \"USD\",\n" +
                "                    \"value\": \"43.38\"\n" +
                "                },\n" +
                "                \"settlementAmount\": {\n" +
                "                    \"currency\": \"EUR\",\n" +
                "                    \"value\": \"-35.07\"\n" +
                "                },\n" +
                "                \"createdAt\": \"2018-03-14T17:00:52.0Z\",\n" +
                "                \"reversedAt\": null,\n" +
                "                \"paymentId\": \"tr_WDqYK6vllg\",\n" +
                "                \"_links\": {\n" +
                "                    \"self\": {\n" +
                "                        \"href\": \"https://api.mollie.com/v2/payments/tr_WDqYK6vllg/chargebacks/chb_n9z0tp\",\n" +
                "                        \"type\": \"application/hal+json\"\n" +
                "                    },\n" +
                "                    \"payment\": {\n" +
                "                        \"href\": \"https://api.mollie.com/v2/payments/tr_WDqYK6vllg\",\n" +
                "                        \"type\": \"application/hal+json\"\n" +
                "                    },\n" +
                "                    \"documentation\": {\n" +
                "                        \"href\": \"https://docs.mollie.com/reference/v2/chargebacks-api/get-chargeback\",\n" +
                "                        \"type\": \"text/html\"\n" +
                "                    }\n" +
                "                }\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"_links\": {\n" +
                "        \"self\": {\n" +
                "            \"href\": \"https://api.mollie.com/v2/payments/tr_7UhSN1zuXS/chargebacks\",\n" +
                "            \"type\": \"application/hal+json\"\n" +
                "        },\n" +
                "        \"documentation\": {\n" +
                "            \"href\": \"https://docs.mollie.com/reference/v2/chargebacks-api/list-chargebacks\",\n" +
                "            \"type\": \"text/html\"\n" +
                "        }\n" +
                "    }\n" +
                "}");

        MollieApiClient mollieApiClient = new MollieApiClient(mollieHttpClient);
        Page<Chargeback> chargebacks = mollieApiClient.chargebacks().all("foo");
        assertEquals(3, chargebacks.getCount());
        assertEquals(Chargeback.class, chargebacks.getItems().get(0).getClass());
    }

    @Test
    void allChargebacksException() throws MollieException {
        MollieHttpClient mollieHttpClient = mock(MollieHttpClient.class);
        when(mollieHttpClient.get(anyString())).thenThrow(new MollieResponseStatusCodeException(400, "{\"status\":400,\"title\":\"Bad Request\",\"detail\":\"Invalid cursor value\",\"field\":\"from\",\"_links\":{\"documentation\":{\"href\":\"https://docs.mollie.com/guides/pagination\",\"type\":\"text/html\"}}}"));

        MollieApiClient mollieApiClient = new MollieApiClient(mollieHttpClient);
        assertThrows(MollieException.class, () -> mollieApiClient.chargebacks().all("foo"));
    }

    @Test
    void bySettlement() throws MollieException {
        MollieHttpClient mollieHttpClient = mock(MollieHttpClient.class);
        when(mollieHttpClient.get(anyString())).thenReturn("{\n" +
                "    \"count\": 3,\n" +
                "    \"_embedded\": {\n" +
                "        \"chargebacks\": [\n" +
                "            {\n" +
                "                \"resource\": \"chargeback\",\n" +
                "                \"id\": \"chb_n9z0tp\",\n" +
                "                \"amount\": {\n" +
                "                    \"value\": \"43.38\",\n" +
                "                    \"currency\": \"USD\"\n" +
                "                },\n" +
                "                \"settlementAmount\": {\n" +
                "                    \"value\": \"-37.14\",\n" +
                "                    \"currency\": \"EUR\"\n" +
                "                },\n" +
                "                \"createdAt\": \"2018-03-14T17:00:52.0Z\",\n" +
                "                \"reversedAt\": null\n," +
                "                \"paymentId\": \"tr_WDqYK6vllg\",\n" +
                "                \"settlementId\": \"stl_jDk30akdN\",\n" +
                "                \"_links\": {\n" +
                "                     \"self\": {\n" +
                "                        \"href\": \"https://api.mollie.com/v2/payments/tr_WDqYK6vllg/chargebacks/chb_n9z0tp\",\n" +
                "                        \"type\": \"application/hal+json\"\n" +
                "                     },\n" +
                "                     \"payment\": {\n" +
                "                        \"href\": \"https://api.mollie.com/v2/payments/tr_WDqYK6vllg\",\n" +
                "                        \"type\": \"application/hal+json\"\n" +
                "                     },\n" +
                "                     \"settlement\": {\n" +
                "                         \"href\": \"https://api.mollie.com/v2/settlements/stl_jDk30akdN\",\n" +
                "                         \"type\": \"application/hal+json\"\n" +
                "                     }\n" +
                "                }\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"_links\": {\n" +
                "         \"documentation\": {\n" +
                "            \"href\": \"https://docs.mollie.com/reference/v2/settlements-api/list-settlement-chargebacks\",\n" +
                "            \"type\": \"text/html\"\n" +
                "         },\n" +
                "         \"self\": {\n" +
                "            \"href\": \"https://api.mollie.com/v2/settlements/stl_jDk30akdN/chargebacks\",\n" +
                "            \"type\": \"application/hal+json\"\n" +
                "         },\n" +
                "         \"previous\": null,\n" +
                "         \"next\": null\n" +
                "    }\n" +
                "}");

        MollieApiClient mollieApiClient = new MollieApiClient(mollieHttpClient);
        Page<Chargeback> chargebacks = mollieApiClient.chargebacks().bySettlement("settlementId");
        assertEquals(3, chargebacks.getCount());
        assertEquals(Chargeback.class, chargebacks.getItems().get(0).getClass());
    }
}
