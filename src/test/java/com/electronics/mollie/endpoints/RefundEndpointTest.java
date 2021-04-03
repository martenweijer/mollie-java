package com.electronics.mollie.endpoints;

import com.electronics.mollie.MollieApiClient;
import com.electronics.mollie.exceptions.MollieException;
import com.electronics.mollie.http.MollieHttpClient;
import com.electronics.mollie.resources.Refund;
import com.electronics.mollie.resources.Page;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RefundEndpointTest {
    @Test
    void getRefund() throws MollieException {
        MollieHttpClient mollieHttpClient = mock(MollieHttpClient.class);
        when(mollieHttpClient.get(anyString())).thenReturn("{\n" +
                "    \"resource\": \"refund\",\n" +
                "    \"id\": \"cst_8wmqcHMN4U\",\n" +
                "    \"mode\": \"test\",\n" +
                "    \"name\": \"Updated Refund A\",\n" +
                "    \"email\": \"updated-refund@example.org\",\n" +
                "    \"locale\": \"nl_NL\",\n" +
                "    \"metadata\": null,\n" +
                "    \"createdAt\": \"2018-04-06T13:23:21.0Z\",\n" +
                "    \"_links\": {\n" +
                "        \"self\": {\n" +
                "            \"href\": \"https://api.mollie.com/v2/refunds/cst_8wmqcHMN4U\",\n" +
                "            \"type\": \"application/hal+json\"\n" +
                "        },\n" +
                "        \"dashboard\": {\n" +
                "            \"href\": \"https://www.mollie.com/dashboard/org_123456789/refunds/cst_8wmqcHMN4U\",\n" +
                "            \"type\": \"text/html\"\n" +
                "        },\n" +
                "        \"documentation\": {\n" +
                "            \"href\": \"https://docs.mollie.com/reference/v2/refunds-api/get-refund\",\n" +
                "            \"type\": \"text/html\"\n" +
                "        }\n" +
                "    }\n" +
                "}");

        MollieApiClient mollieApiClient = new MollieApiClient(mollieHttpClient);
        Refund refund = mollieApiClient.refunds().get("foo", "bar");
        Assertions.assertNotNull(refund);
        Assertions.assertEquals("cst_8wmqcHMN4U", refund.getId());
    }

    @Test
    void createRefund() throws MollieException {
        MollieHttpClient mollieHttpClient = mock(MollieHttpClient.class);
        when(mollieHttpClient.post(anyString(), anyString())).thenReturn("{\n" +
                "    \"resource\": \"refund\",\n" +
                "    \"id\": \"re_4qqhO89gsT\",\n" +
                "    \"amount\": {\n" +
                "        \"currency\": \"EUR\",\n" +
                "        \"value\": \"5.95\"\n" +
                "    },\n" +
                "    \"status\": \"pending\",\n" +
                "    \"createdAt\": \"2018-03-14T17:09:02.0Z\",\n" +
                "    \"description\": \"Order #33\",\n" +
                "    \"metadata\": {\n" +
                "         \"bookkeeping_id\": 12345\n" +
                "    },\n" +
                "    \"paymentId\": \"tr_WDqYK6vllg\",\n" +
                "    \"_links\": {\n" +
                "        \"self\": {\n" +
                "            \"href\": \"https://api.mollie.com/v2/payments/tr_WDqYK6vllg/refunds/re_4qqhO89gsT\",\n" +
                "            \"type\": \"application/hal+json\"\n" +
                "        },\n" +
                "        \"payment\": {\n" +
                "            \"href\": \"https://api.mollie.com/v2/payments/tr_WDqYK6vllg\",\n" +
                "            \"type\": \"application/hal+json\"\n" +
                "        },\n" +
                "        \"documentation\": {\n" +
                "            \"href\": \"https://docs.mollie.com/reference/v2/refunds-api/create-refund\",\n" +
                "            \"type\": \"text/html\"\n" +
                "        }\n" +
                "    }\n" +
                "}");

        Refund refund = new Refund();

        MollieApiClient mollieApiClient = new MollieApiClient(mollieHttpClient);
        Refund result = mollieApiClient.refunds().create("foo", refund);
        Assertions.assertNotNull(result);
        Assertions.assertEquals("re_4qqhO89gsT", result.getId());
    }

    @Test
    void createByOrder() throws MollieException {
        MollieHttpClient mollieHttpClient = mock(MollieHttpClient.class);
        when(mollieHttpClient.post(anyString(), anyString())).thenReturn("{\n" +
                "    \"resource\": \"refund\",\n" +
                "    \"id\": \"re_4qqhO89gsT\",\n" +
                "    \"amount\": {\n" +
                "        \"currency\": \"EUR\",\n" +
                "        \"value\": \"698.00\"\n" +
                "    },\n" +
                "    \"status\": \"pending\",\n" +
                "    \"createdAt\": \"2018-03-14T17:09:02.0Z\",\n" +
                "    \"description\": \"Required quantity not in stock, refunding one photo book.\",\n" +
                "    \"metadata\": {\n" +
                "         \"bookkeeping_id\": 12345\n" +
                "    },\n" +
                "    \"paymentId\": \"tr_WDqYK6vllg\",\n" +
                "    \"orderId\": \"ord_stTC2WHAuS\",\n" +
                "    \"lines\": [\n" +
                "        {\n" +
                "            \"resource\": \"orderline\",\n" +
                "            \"id\": \"odl_dgtxyl\",\n" +
                "            \"orderId\": \"ord_stTC2WHAuS\",\n" +
                "            \"name\": \"LEGO 42083 Bugatti Chiron\",\n" +
                "            \"sku\": \"5702016116977\",\n" +
                "            \"type\": \"physical\",\n" +
                "            \"status\": \"paid\",\n" +
                "            \"metadata\": null,\n" +
                "            \"quantity\": 1,\n" +
                "            \"unitPrice\": {\n" +
                "                \"value\": \"399.00\",\n" +
                "                \"currency\": \"EUR\"\n" +
                "            },\n" +
                "            \"vatRate\": \"21.00\",\n" +
                "            \"vatAmount\": {\n" +
                "                \"value\": \"51.89\",\n" +
                "                \"currency\": \"EUR\"\n" +
                "            },\n" +
                "            \"discountAmount\": {\n" +
                "                \"value\": \"100.00\",\n" +
                "                \"currency\": \"EUR\"\n" +
                "            },\n" +
                "            \"totalAmount\": {\n" +
                "                \"value\": \"299.00\",\n" +
                "                \"currency\": \"EUR\"\n" +
                "            },\n" +
                "            \"createdAt\": \"2018-08-02T09:29:56+00:00\",\n" +
                "            \"_links\": {\n" +
                "                \"productUrl\": {\n" +
                "                    \"href\": \"https://shop.lego.com/nl-NL/Bugatti-Chiron-42083\",\n" +
                "                    \"type\": \"text/html\"\n" +
                "                },\n" +
                "                \"imageUrl\": {\n" +
                "                    \"href\": \"https://sh-s7-live-s.legocdn.com/is/image//LEGO/42083_alt1?$main$\",\n" +
                "                    \"type\": \"text/html\"\n" +
                "                }\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"_links\": {\n" +
                "        \"self\": {\n" +
                "            \"href\": \"https://api.mollie.com/v2/payments/tr_WDqYK6vllg/refunds/re_4qqhO89gsT\",\n" +
                "            \"type\": \"application/hal+json\"\n" +
                "        },\n" +
                "        \"payment\": {\n" +
                "            \"href\": \"https://api.mollie.com/v2/payments/tr_WDqYK6vllg\",\n" +
                "            \"type\": \"application/hal+json\"\n" +
                "        },\n" +
                "        \"order\": {\n" +
                "            \"href\": \"https://api.mollie.com/v2/orders/ord_stTC2WHAuS\",\n" +
                "            \"type\": \"application/hal+json\"\n" +
                "        },\n" +
                "        \"documentation\": {\n" +
                "            \"href\": \"https://docs.mollie.com/reference/v2/orders-api/create-order-refund\",\n" +
                "            \"type\": \"text/html\"\n" +
                "        }\n" +
                "    }\n" +
                "}");

        Refund refund = new Refund();

        MollieApiClient mollieApiClient = new MollieApiClient(mollieHttpClient);
        Refund result = mollieApiClient.refunds().createByOrder("orderId", refund);
        Assertions.assertNotNull(result);
        Assertions.assertEquals("re_4qqhO89gsT", result.getId());
    }

    @Test
    void cancelRefund() throws MollieException {
        MollieHttpClient mollieHttpClient = mock(MollieHttpClient.class);
        when(mollieHttpClient.delete(anyString())).thenReturn("");

        MollieApiClient mollieApiClient = new MollieApiClient(mollieHttpClient);
        mollieApiClient.refunds().cancel("foo", "bar");
    }

    @Test
    void allRefunds() throws MollieException {
        MollieHttpClient mollieHttpClient = mock(MollieHttpClient.class);
        when(mollieHttpClient.get(anyString())).thenReturn("{\n" +
                "    \"count\": 5,\n" +
                "    \"_embedded\": {\n" +
                "        \"refunds\": [\n" +
                "            {\n" +
                "                \"resource\": \"refund\",\n" +
                "                \"id\": \"re_4qqhO89gsT\",\n" +
                "                \"amount\": {\n" +
                "                    \"currency\": \"EUR\",\n" +
                "                    \"value\": \"5.95\"\n" +
                "                },\n" +
                "                \"status\": \"pending\",\n" +
                "                \"createdAt\": \"2018-03-14T17:09:02.0Z\",\n" +
                "                \"description\": \"Order\",\n" +
                "                \"metadata\": {\n" +
                "                     \"bookkeeping_id\": 12345\n" +
                "                },\n" +
                "                \"paymentId\": \"tr_WDqYK6vllg\",\n" +
                "                \"_links\": {\n" +
                "                    \"self\": {\n" +
                "                        \"href\": \"https://api.mollie.com/v2/payments/tr_WDqYK6vllg/refunds/re_4qqhO89gsT\",\n" +
                "                        \"type\": \"application/hal+json\"\n" +
                "                    },\n" +
                "                    \"payment\": {\n" +
                "                        \"href\": \"https://api.mollie.com/v2/payments/tr_WDqYK6vllg\",\n" +
                "                        \"type\": \"application/hal+json\"\n" +
                "                    },\n" +
                "                    \"documentation\": {\n" +
                "                        \"href\": \"https://docs.mollie.com/reference/v2/refunds-api/get-refund\",\n" +
                "                        \"type\": \"text/html\"\n" +
                "                    }\n" +
                "                }\n" +
                "            },\n" +
                "            { },\n" +
                "            { }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"_links\": {\n" +
                "        \"self\": {\n" +
                "            \"href\": \"https://api.mollie.com/v2/payments/tr_7UhSN1zuXS/refunds?limit=5\",\n" +
                "            \"type\": \"application/hal+json\"\n" +
                "        },\n" +
                "        \"previous\": null,\n" +
                "        \"next\": {\n" +
                "            \"href\": \"https://api.mollie.com/v2/payments/tr_7UhSN1zuXS/refunds?from=re_APBiGPH2vV&limit=5\",\n" +
                "            \"type\": \"application/hal+json\"\n" +
                "        },\n" +
                "        \"documentation\": {\n" +
                "            \"href\": \"https://docs.mollie.com/reference/v2/refunds-api/list-refunds\",\n" +
                "            \"type\": \"text/html\"\n" +
                "        }\n" +
                "    }\n" +
                "}");

        MollieApiClient mollieApiClient = new MollieApiClient(mollieHttpClient);
        Page<Refund> page = mollieApiClient.refunds().all();
        Assertions.assertEquals(5, page.getCount());
        assertEquals(Refund.class, page.getItems().get(0).getClass());
    }

    @Test
    void bySettlement() throws MollieException {
        MollieHttpClient mollieHttpClient = mock(MollieHttpClient.class);
        when(mollieHttpClient.get(anyString())).thenReturn("{\n" +
                "    \"_embedded\": {\n" +
                "        \"refunds\": [\n" +
                "            {\n" +
                "                \"resource\": \"refund\",\n" +
                "                \"id\": \"re_3aKhkUNigy\",\n" +
                "                \"amount\": {\n" +
                "                    \"value\": \"10.00\",\n" +
                "                    \"currency\": \"EUR\"\n" +
                "                },\n" +
                "                \"status\": \"refunded\",\n" +
                "                \"createdAt\": \"2018-08-30T07:59:02+00:00\",\n" +
                "                \"description\": \"Order #33\",\n" +
                "                \"paymentId\": \"tr_maJaG2j8OM\",\n" +
                "                \"settlementAmount\": {\n" +
                "                    \"value\": \"-10.00\",\n" +
                "                    \"currency\": \"EUR\"\n" +
                "                },\n" +
                "                \"settlementId\": \"stl_jDk30akdN\",\n" +
                "                \"_links\": {\n" +
                "                    \"self\": {\n" +
                "                        \"href\": \"https://api.mollie.com/v2/payments/tr_maJaG2j8OM/refunds/re_3aKhkUNigy\",\n" +
                "                        \"type\": \"application/hal+json\"\n" +
                "                    },\n" +
                "                    \"payment\": {\n" +
                "                        \"href\": \"https://api.mollie.com/v2/payments/tr_maJaG2j8OM\",\n" +
                "                        \"type\": \"application/hal+json\"\n" +
                "                    },\n" +
                "                    \"settlement\": {\n" +
                "                        \"href\": \"https://api.mollie.com/v2/settlements/stl_jDk30akdN\",\n" +
                "                        \"type\": \"application/hal+json\"\n" +
                "                    }\n" +
                "                }\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"count\": 1,\n" +
                "    \"_links\": {\n" +
                "        \"documentation\": {\n" +
                "            \"href\": \"https://docs.mollie.com/reference/v2/settlements-api/list-settlement-refunds\",\n" +
                "            \"type\": \"text/html\"\n" +
                "        },\n" +
                "        \"self\": {\n" +
                "            \"href\": \"https://api.mollie.com/v2/settlements/stl_jDk30akdN/refunds?limit=50\",\n" +
                "            \"type\": \"application/hal+json\"\n" +
                "        },\n" +
                "        \"previous\": null,\n" +
                "        \"next\": null\n" +
                "    }\n" +
                "}");

        MollieApiClient mollieApiClient = new MollieApiClient(mollieHttpClient);
        Page<Refund> page = mollieApiClient.refunds().bySettlement("settlementId");
        Assertions.assertEquals(1, page.getCount());
        assertEquals(Refund.class, page.getItems().get(0).getClass());
    }

    @Test
    void byPayment() throws MollieException {
        MollieHttpClient mollieHttpClient = mock(MollieHttpClient.class);
        when(mollieHttpClient.get(anyString())).thenReturn("{\n" +
                "    \"count\": 5,\n" +
                "    \"_embedded\": {\n" +
                "        \"refunds\": [\n" +
                "            {\n" +
                "                \"resource\": \"refund\",\n" +
                "                \"id\": \"re_4qqhO89gsT\",\n" +
                "                \"amount\": {\n" +
                "                    \"currency\": \"EUR\",\n" +
                "                    \"value\": \"5.95\"\n" +
                "                },\n" +
                "                \"status\": \"pending\",\n" +
                "                \"createdAt\": \"2018-03-14T17:09:02.0Z\",\n" +
                "                \"description\": \"Order\",\n" +
                "                \"metadata\": {\n" +
                "                     \"bookkeeping_id\": 12345\n" +
                "                },\n" +
                "                \"paymentId\": \"tr_WDqYK6vllg\",\n" +
                "                \"_links\": {\n" +
                "                    \"self\": {\n" +
                "                        \"href\": \"https://api.mollie.com/v2/payments/tr_WDqYK6vllg/refunds/re_4qqhO89gsT\",\n" +
                "                        \"type\": \"application/hal+json\"\n" +
                "                    },\n" +
                "                    \"payment\": {\n" +
                "                        \"href\": \"https://api.mollie.com/v2/payments/tr_WDqYK6vllg\",\n" +
                "                        \"type\": \"application/hal+json\"\n" +
                "                    },\n" +
                "                    \"documentation\": {\n" +
                "                        \"href\": \"https://docs.mollie.com/reference/v2/refunds-api/get-refund\",\n" +
                "                        \"type\": \"text/html\"\n" +
                "                    }\n" +
                "                }\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"_links\": {\n" +
                "        \"self\": {\n" +
                "            \"href\": \"https://api.mollie.com/v2/payments/tr_7UhSN1zuXS/refunds?limit=5\",\n" +
                "            \"type\": \"application/hal+json\"\n" +
                "        },\n" +
                "        \"previous\": null,\n" +
                "        \"next\": {\n" +
                "            \"href\": \"https://api.mollie.com/v2/payments/tr_7UhSN1zuXS/refunds?from=re_APBiGPH2vV&limit=5\",\n" +
                "            \"type\": \"application/hal+json\"\n" +
                "        },\n" +
                "        \"documentation\": {\n" +
                "            \"href\": \"https://docs.mollie.com/reference/v2/refunds-api/list-refunds\",\n" +
                "            \"type\": \"text/html\"\n" +
                "        }\n" +
                "    }\n" +
                "}");

        MollieApiClient mollieApiClient = new MollieApiClient(mollieHttpClient);
        Page<Refund> page = mollieApiClient.refunds().byPayment("paymentId");
        Assertions.assertEquals(5, page.getCount());
        assertEquals(Refund.class, page.getItems().get(0).getClass());
    }

    @Test
    void byOrder() throws MollieException {
        MollieHttpClient mollieHttpClient = mock(MollieHttpClient.class);
        when(mollieHttpClient.get(anyString())).thenReturn("{\n" +
                "    \"count\": 5,\n" +
                "    \"_embedded\": {\n" +
                "        \"refunds\": [\n" +
                "            {\n" +
                "                \"resource\": \"refund\",\n" +
                "                \"id\": \"re_4qqhO89gsT\",\n" +
                "                \"amount\": {\n" +
                "                    \"currency\": \"EUR\",\n" +
                "                    \"value\": \"5.95\"\n" +
                "                },\n" +
                "                \"status\": \"pending\",\n" +
                "                \"createdAt\": \"2018-03-14T17:09:02.0Z\",\n" +
                "                \"description\": \"Order\",\n" +
                "                \"metadata\": {\n" +
                "                     \"bookkeeping_id\": 12345\n" +
                "                },\n" +
                "                \"paymentId\": \"tr_WDqYK6vllg\",\n" +
                "                \"_links\": {\n" +
                "                    \"self\": {\n" +
                "                        \"href\": \"https://api.mollie.com/v2/payments/tr_WDqYK6vllg/refunds/re_4qqhO89gsT\",\n" +
                "                        \"type\": \"application/hal+json\"\n" +
                "                    },\n" +
                "                    \"payment\": {\n" +
                "                        \"href\": \"https://api.mollie.com/v2/payments/tr_WDqYK6vllg\",\n" +
                "                        \"type\": \"application/hal+json\"\n" +
                "                    },\n" +
                "                    \"documentation\": {\n" +
                "                        \"href\": \"https://docs.mollie.com/reference/v2/refunds-api/get-refund\",\n" +
                "                        \"type\": \"text/html\"\n" +
                "                    }\n" +
                "                }\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"_links\": {\n" +
                "        \"self\": {\n" +
                "            \"href\": \"https://api.mollie.com/v2/payments/tr_7UhSN1zuXS/refunds?limit=5\",\n" +
                "            \"type\": \"application/hal+json\"\n" +
                "        },\n" +
                "        \"previous\": null,\n" +
                "        \"next\": {\n" +
                "            \"href\": \"https://api.mollie.com/v2/payments/tr_7UhSN1zuXS/refunds?from=re_APBiGPH2vV&limit=5\",\n" +
                "            \"type\": \"application/hal+json\"\n" +
                "        },\n" +
                "        \"documentation\": {\n" +
                "            \"href\": \"https://docs.mollie.com/reference/v2/refunds-api/list-refunds\",\n" +
                "            \"type\": \"text/html\"\n" +
                "        }\n" +
                "    }\n" +
                "}");

        MollieApiClient mollieApiClient = new MollieApiClient(mollieHttpClient);
        Page<Refund> page = mollieApiClient.refunds().byOrder("orderId");
        Assertions.assertEquals(5, page.getCount());
        assertEquals(Refund.class, page.getItems().get(0).getClass());
    }
}
