package com.electronics.mollie.endpoints;

import com.electronics.mollie.MollieApiClient;
import com.electronics.mollie.exceptions.MollieException;
import com.electronics.mollie.http.MollieHttpClient;
import com.electronics.mollie.resources.Capture;
import com.electronics.mollie.resources.Page;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CaptureEndpointTest {
    @Test
    void getCapture() throws MollieException {
        MollieHttpClient mollieHttpClient = mock(MollieHttpClient.class);
        when(mollieHttpClient.get(anyString())).thenReturn("{\n" +
                "    \"resource\": \"capture\",\n" +
                "    \"id\": \"cpt_4qqhO89gsT\",\n" +
                "    \"mode\": \"live\",\n" +
                "    \"amount\": {\n" +
                "        \"value\": \"1027.99\",\n" +
                "        \"currency\": \"EUR\"\n" +
                "    },\n" +
                "    \"settlementAmount\": {\n" +
                "        \"value\": \"1027.99\",\n" +
                "        \"currency\": \"EUR\"\n" +
                "    },\n" +
                "    \"paymentId\": \"tr_WDqYK6vllg\",\n" +
                "    \"shipmentId\": \"shp_3wmsgCJN4U\",\n" +
                "    \"settlementId\": \"stl_jDk30akdN\",\n" +
                "    \"createdAt\": \"2018-08-02T09:29:56+00:00\",\n" +
                "    \"_links\": {\n" +
                "        \"self\": {\n" +
                "            \"href\": \"https://api.mollie.com/v2/payments/tr_WDqYK6vllg/captures/cpt_4qqhO89gsT\",\n" +
                "            \"type\": \"application/hal+json\"\n" +
                "        },\n" +
                "        \"payment\": {\n" +
                "            \"href\": \"https://api.mollie.com/v2/payments/tr_WDqYK6vllg\",\n" +
                "            \"type\": \"application/hal+json\"\n" +
                "        },\n" +
                "        \"shipment\": {\n" +
                "            \"href\": \"https://api.mollie.com/v2/orders/ord_8wmqcHMN4U/shipments/shp_3wmsgCJN4U\",\n" +
                "            \"type\": \"application/hal+json\"\n" +
                "        },\n" +
                "        \"settlement\": {\n" +
                "            \"href\": \"https://api.mollie.com/v2/settlements/stl_jDk30akdN\",\n" +
                "            \"type\": \"application/hal+json\"\n" +
                "        },\n" +
                "        \"documentation\": {\n" +
                "            \"href\": \"https://docs.mollie.com/reference/v2/captures-api/get-capture\",\n" +
                "            \"type\": \"text/html\"\n" +
                "        }\n" +
                "    }\n" +
                "}");

        MollieApiClient mollieApiClient = new MollieApiClient(mollieHttpClient);
        Capture capture = mollieApiClient.captures().get("foo", "bar");
        assertEquals("cpt_4qqhO89gsT", capture.getId());
    }

    @Test
    void allCapture() throws MollieException {
        MollieHttpClient mollieHttpClient = mock(MollieHttpClient.class);
        when(mollieHttpClient.get(anyString())).thenReturn("{\n" +
                "    \"_embedded\": {\n" +
                "        \"captures\": [\n" +
                "            {\n" +
                "                \"resource\": \"capture\",\n" +
                "                \"id\": \"cpt_4qqhO89gsT\",\n" +
                "                \"mode\": \"live\",\n" +
                "                \"amount\": {\n" +
                "                    \"value\": \"1027.99\",\n" +
                "                    \"currency\": \"EUR\"\n" +
                "                },\n" +
                "                \"settlementAmount\": {\n" +
                "                    \"value\": \"399.00\",\n" +
                "                    \"currency\": \"EUR\"\n" +
                "                },\n" +
                "                \"paymentId\": \"tr_WDqYK6vllg\",\n" +
                "                \"shipmentId\": \"shp_3wmsgCJN4U\",\n" +
                "                \"settlementId\": \"stl_jDk30akdN\",\n" +
                "                \"createdAt\": \"2018-08-02T09:29:56+00:00\",\n" +
                "                \"_links\": {\n" +
                "                    \"self\": {\n" +
                "                        \"href\": \"https://api.mollie.com/v2/payments/tr_WDqYK6vllg/captures/cpt_4qqhO89gsT\",\n" +
                "                        \"type\": \"application/hal+json\"\n" +
                "                    },\n" +
                "                    \"payment\": {\n" +
                "                        \"href\": \"https://api.mollie.com/v2/payments/tr_WDqYK6vllg\",\n" +
                "                        \"type\": \"application/hal+json\"\n" +
                "                    },\n" +
                "                    \"shipment\": {\n" +
                "                        \"href\": \"https://api.mollie.com/v2/orders/ord_8wmqcHMN4U/shipments/shp_3wmsgCJN4U\",\n" +
                "                        \"type\": \"application/hal+json\"\n" +
                "                    },\n" +
                "                    \"settlement\": {\n" +
                "                        \"href\": \"https://api.mollie.com/v2/settlements/stl_jDk30akdN\",\n" +
                "                        \"type\": \"application/hal+json\"\n" +
                "                    },\n" +
                "                    \"documentation\": {\n" +
                "                        \"href\": \"https://docs.mollie.com/reference/v2/captures-api/get-capture\",\n" +
                "                        \"type\": \"text/html\"\n" +
                "                    }\n" +
                "                }\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"count\": 1,\n" +
                "    \"_links\": {\n" +
                "        \"documentation\": {\n" +
                "            \"href\": \"https://docs.mollie.com/reference/v2/captures-api/list-captures\",\n" +
                "            \"type\": \"text/html\"\n" +
                "        },\n" +
                "        \"self\": {\n" +
                "            \"href\": \"https://api.mollie.com/v2/payments/tr_WDqYK6vllg/captures?limit=50\",\n" +
                "            \"type\": \"application/hal+json\"\n" +
                "        },\n" +
                "        \"previous\": null,\n" +
                "        \"next\": null\n" +
                "    }\n" +
                "}");

        MollieApiClient mollieApiClient = new MollieApiClient(mollieHttpClient);
        Page<Capture> captures = mollieApiClient.captures().all("foo");
        assertEquals(1, captures.getCount());
        assertEquals(Capture.class, captures.getItems().get(0).getClass());
    }

    @Test
    void bySettlement() throws MollieException {
        MollieHttpClient mollieHttpClient = mock(MollieHttpClient.class);
        when(mollieHttpClient.get(anyString())).thenReturn("{\n" +
                "    \"_embedded\": {\n" +
                "        \"captures\": [\n" +
                "            {\n" +
                "                \"resource\": \"capture\",\n" +
                "                \"id\": \"cpt_4qqhO89gsT\",\n" +
                "                \"mode\": \"live\",\n" +
                "                \"amount\": {\n" +
                "                    \"value\": \"1027.99\",\n" +
                "                    \"currency\": \"EUR\"\n" +
                "                },\n" +
                "                \"settlementAmount\": {\n" +
                "                    \"value\": \"399.00\",\n" +
                "                    \"currency\": \"EUR\"\n" +
                "                },\n" +
                "                \"paymentId\": \"tr_WDqYK6vllg\",\n" +
                "                \"shipmentId\": \"shp_3wmsgCJN4U\",\n" +
                "                \"settlementId\": \"stl_jDk30akdN\",\n" +
                "                \"createdAt\": \"2018-08-02T09:29:56+00:00\",\n" +
                "                \"_links\": {\n" +
                "                    \"self\": {\n" +
                "                        \"href\": \"https://api.mollie.com/v2/payments/tr_WDqYK6vllg/captures/cpt_4qqhO89gsT\",\n" +
                "                        \"type\": \"application/hal+json\"\n" +
                "                    },\n" +
                "                    \"payment\": {\n" +
                "                        \"href\": \"https://api.mollie.com/v2/payments/tr_WDqYK6vllg\",\n" +
                "                        \"type\": \"application/hal+json\"\n" +
                "                    },\n" +
                "                    \"shipment\": {\n" +
                "                        \"href\": \"https://api.mollie.com/v2/orders/ord_8wmqcHMN4U/shipments/shp_3wmsgCJN4U\",\n" +
                "                        \"type\": \"application/hal+json\"\n" +
                "                    },\n" +
                "                    \"settlement\": {\n" +
                "                        \"href\": \"https://api.mollie.com/v2/settlements/stl_jDk30akdN\",\n" +
                "                        \"type\": \"application/hal+json\"\n" +
                "                    },\n" +
                "                    \"documentation\": {\n" +
                "                        \"href\": \"https://docs.mollie.com/reference/v2/captures-api/get-capture\",\n" +
                "                        \"type\": \"text/html\"\n" +
                "                    }\n" +
                "                }\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"count\": 1,\n" +
                "    \"_links\": {\n" +
                "        \"documentation\": {\n" +
                "            \"href\": \"https://docs.mollie.com/reference/v2/settlements-api/list-settlement-captures\",\n" +
                "            \"type\": \"text/html\"\n" +
                "        },\n" +
                "        \"self\": {\n" +
                "            \"href\": \"https://api.mollie.com/v2/settlements/stl_jDk30akdN/captures?limit=50\",\n" +
                "            \"type\": \"application/hal+json\"\n" +
                "        },\n" +
                "        \"previous\": null,\n" +
                "        \"next\": null\n" +
                "    }\n" +
                "}");

        MollieApiClient mollieApiClient = new MollieApiClient(mollieHttpClient);
        Page<Capture> captures = mollieApiClient.captures().bySettlement("settlementId");
        assertEquals(1, captures.getCount());
        assertEquals(Capture.class, captures.getItems().get(0).getClass());
    }
}
