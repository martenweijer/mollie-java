package com.electronics.mollie.endpoints;

import com.electronics.mollie.MollieApiClient;
import com.electronics.mollie.QueryMap;
import com.electronics.mollie.exceptions.MollieException;
import com.electronics.mollie.exceptions.MollieHttpException;
import com.electronics.mollie.exceptions.MollieResponseStatusCodeException;
import com.electronics.mollie.http.MollieHttpClient;
import com.electronics.mollie.resources.Amount;
import com.electronics.mollie.resources.Page;
import com.electronics.mollie.resources.Payment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PaymentEndpointTest {
    @Test
    void getPayment() throws MollieException {
        MollieHttpClient mollieHttpClient = mock(MollieHttpClient.class);
        when(mollieHttpClient.get(anyString())).thenReturn("{\"id\":\"foo\"}");

        MollieApiClient mollieApiClient = new MollieApiClient(mollieHttpClient);
        Payment payment = mollieApiClient.payments().get("tr_mj4K2RGf9V");
        Assertions.assertNotNull(payment);
        Assertions.assertEquals("foo", payment.getId());
    }

    @Test
    void getPaymentException() throws MollieException {
        MollieHttpClient mollieHttpClient = mock(MollieHttpClient.class);
        when(mollieHttpClient.get(anyString())).thenThrow(new MollieResponseStatusCodeException(404, "{\"status\":404,\"title\":\"Not Found\",\"detail\":\"No payment exists with token foo.\",\"_links\":{\"documentation\":{\"href\":\"https://docs.mollie.com/guides/handling-errors\",\"type\":\"text/html\"}}}"));

        MollieApiClient mollieApiClient = new MollieApiClient(mollieHttpClient);

        Assertions.assertThrows(MollieException.class, () -> mollieApiClient.payments().get("foo"));
    }

    @Test
    void createPayment() throws MollieException {
        MollieHttpClient mollieHttpClient = mock(MollieHttpClient.class);
        when(mollieHttpClient.post(anyString(), anyString())).thenReturn("{\"id\":\"foo\",\"description\":\"foo\",\"amount\":{\"value\":\"100.00\",\"currency\":\"EUR\"},\"redirectUrl\":\"foo\"}");

        Payment payment = new Payment();
        payment.setDescription("foo");
        payment.setRedirectUrl("foo");
        payment.setAmount(new Amount("100.00", "EUR"));

        MollieApiClient mollieApiClient = new MollieApiClient(mollieHttpClient);
        Payment result = mollieApiClient.payments().create(payment);
        Assertions.assertNotNull(result);
        Assertions.assertEquals("foo", result.getId());
        Assertions.assertEquals("foo", result.getDescription());
    }

    @Test
    void createByOrder() throws MollieException {
        MollieHttpClient mollieHttpClient = mock(MollieHttpClient.class);
        when(mollieHttpClient.post(anyString(), anyString())).thenReturn("{\n" +
                "    \"resource\": \"payment\",\n" +
                "    \"id\": \"tr_WDqYK6vllg\",\n" +
                "    \"mode\": \"test\",\n" +
                "    \"amount\": {\n" +
                "        \"currency\": \"EUR\",\n" +
                "        \"value\": \"698.00\"\n" +
                "    },\n" +
                "    \"status\": \"open\",\n" +
                "    \"description\": \"Order #1337 (Lego cars)\",\n" +
                "    \"createdAt\": \"2018-12-01T17:09:02+00:00\",\n" +
                "    \"method\": \"banktransfer\",\n" +
                "    \"metadata\": null,\n" +
                "    \"orderId\": \"ord_stTC2WHAuS\",\n" +
                "    \"isCancelable\": true,\n" +
                "    \"locale\": \"nl_NL\",\n" +
                "    \"profileId\": \"pfl_URR55HPMGx\",\n" +
                "    \"sequenceType\": \"oneoff\",\n" +
                "    \"settlementAmount\": {\n" +
                "        \"value\": \"698.00\",\n" +
                "        \"currency\": \"EUR\"\n" +
                "    },\n" +
                "    \"_links\": {\n" +
                "        \"self\": {\n" +
                "            \"href\": \"https://api.mollie.com/v2/payments/tr_WDqYK6vllg\",\n" +
                "            \"type\": \"application/hal+json\"\n" +
                "        },\n" +
                "        \"order\": {\n" +
                "            \"href\": \"https://api.mollie.com/v2/orders/ord_stTC2WHAuS\",\n" +
                "            \"type\": \"application/hal+json\"\n" +
                "        },\n" +
                "        \"checkout\": {\n" +
                "            \"href\": \"https://www.mollie.com/paymentscreen/testmode/?method=banktransfer&token=fgnwdh\",\n" +
                "            \"type\": \"text/html\"\n" +
                "        },\n" +
                "        \"dashboard\": {\n" +
                "            \"href\": \"https://www.mollie.com/dashboard/org_123456789/payments/tr_WDqYK6vllg\",\n" +
                "            \"type\": \"text/html\"\n" +
                "        },\n" +
                "        \"status\": {\n" +
                "            \"href\": \"https://www.mollie.com/paymentscreen/banktransfer/status/fgnwdh\",\n" +
                "            \"type\": \"text/html\"\n" +
                "        },\n" +
                "        \"payOnline\": {\n" +
                "            \"href\": \"https://www.mollie.com/paymentscreen/banktransfer/pay-online/fgnwdh\",\n" +
                "            \"type\": \"text/html\"\n" +
                "        },\n" +
                "        \"documentation\": {\n" +
                "            \"href\": \"https://docs.mollie.com/reference/v2/orders-api/create-order-payment\",\n" +
                "            \"type\": \"text/html\"\n" +
                "        }\n" +
                "    }\n" +
                "}");

        Payment payment = new Payment();
        payment.setDescription("foo");
        payment.setRedirectUrl("foo");
        payment.setAmount(new Amount("100.00", "EUR"));

        MollieApiClient mollieApiClient = new MollieApiClient(mollieHttpClient);
        Payment result = mollieApiClient.payments().createByOrder("orderId", payment);
        Assertions.assertNotNull(result);
        Assertions.assertEquals("tr_WDqYK6vllg", result.getId());
    }

    @Test
    void createByCustomer() throws MollieException {
        MollieHttpClient mollieHttpClient = mock(MollieHttpClient.class);
        when(mollieHttpClient.post(anyString(), anyString())).thenReturn("{\n" +
                "    \"resource\": \"payment\",\n" +
                "    \"id\": \"tr_7UhSN1zuXS\",\n" +
                "    \"mode\": \"test\",\n" +
                "    \"createdAt\": \"2018-03-20T09:13:37+00:00\",\n" +
                "    \"amount\": {\n" +
                "        \"value\": \"10.00\",\n" +
                "        \"currency\": \"EUR\"\n" +
                "    },\n" +
                "    \"description\": \"Order #12345\",\n" +
                "    \"method\": null,\n" +
                "    \"metadata\": {\n" +
                "        \"order_id\": \"12345\"\n" +
                "    },\n" +
                "    \"status\": \"open\",\n" +
                "    \"isCancelable\": false,\n" +
                "    \"expiresAt\": \"2018-03-20T09:28:37+00:00\",\n" +
                "    \"details\": null,\n" +
                "    \"profileId\": \"pfl_QkEhN94Ba\",\n" +
                "    \"customerId\": \"cst_8wmqcHMN4U\",\n" +
                "    \"sequenceType\": \"first\",\n" +
                "    \"redirectUrl\": \"https://webshop.example.org/order/12345/\",\n" +
                "    \"webhookUrl\": \"https://webshop.example.org/payments/webhook/\",\n" +
                "    \"_links\": {\n" +
                "        \"self\": {\n" +
                "            \"href\": \"https://api.mollie.com/v2/payments/tr_7UhSN1zuXS\",\n" +
                "            \"type\": \"application/json\"\n" +
                "        },\n" +
                "        \"checkout\": {\n" +
                "            \"href\": \"https://www.mollie.com/payscreen/select-method/7UhSN1zuXS\",\n" +
                "            \"type\": \"text/html\"\n" +
                "        },\n" +
                "        \"dashboard\": {\n" +
                "            \"href\": \"https://www.mollie.com/dashboard/org_12345678/payments/tr_7UhSN1zuXS\",\n" +
                "            \"type\": \"application/json\"\n" +
                "        },\n" +
                "        \"documentation\": {\n" +
                "            \"href\": \"https://docs.mollie.com/reference/v2/payments-api/create-payment\",\n" +
                "            \"type\": \"text/html\"\n" +
                "        }\n" +
                "    }\n" +
                "}");

        Payment payment = new Payment();
        payment.setDescription("foo");
        payment.setRedirectUrl("foo");
        payment.setAmount(new Amount("100.00", "EUR"));

        MollieApiClient mollieApiClient = new MollieApiClient(mollieHttpClient);
        Payment result = mollieApiClient.payments().createByCustomer("customerId", payment);
        Assertions.assertNotNull(result);
        Assertions.assertEquals("tr_7UhSN1zuXS", result.getId());
    }

    @Test
    void updatePayment() throws MollieException {
        MollieHttpClient mollieHttpClient = mock(MollieHttpClient.class);
        when(mollieHttpClient.patch(anyString(), anyString())).thenReturn("{\n" +
                "    \"resource\": \"payment\",\n" +
                "    \"id\": \"tr_7UhSN1zuXS\",\n" +
                "    \"mode\": \"test\",\n" +
                "    \"createdAt\": \"2018-03-20T09:13:37+00:00\",\n" +
                "    \"amount\": {\n" +
                "        \"value\": \"10.00\",\n" +
                "        \"currency\": \"EUR\"\n" +
                "    },\n" +
                "    \"description\": \"Order #98765\",\n" +
                "    \"method\": null,\n" +
                "    \"metadata\": {\n" +
                "        \"order_id\": \"98765\"\n" +
                "    },\n" +
                "    \"status\": \"open\",\n" +
                "    \"isCancelable\": false,\n" +
                "    \"expiresAt\": \"2018-03-20T09:28:37+00:00\",\n" +
                "    \"details\": null,\n" +
                "    \"profileId\": \"pfl_QkEhN94Ba\",\n" +
                "    \"sequenceType\": \"oneoff\",\n" +
                "    \"redirectUrl\": \"https://example.org/webshop/order/98765/\",\n" +
                "    \"webhookUrl\": \"https://example.org/webshop/payments/webhook/\",\n" +
                "    \"_links\": {\n" +
                "        \"self\": {\n" +
                "            \"href\": \"https://api.mollie.com/v2/payments/tr_7UhSN1zuXS\",\n" +
                "            \"type\": \"application/json\"\n" +
                "        },\n" +
                "        \"checkout\": {\n" +
                "            \"href\": \"https://www.mollie.com/payscreen/select-method/7UhSN1zuXS\",\n" +
                "            \"type\": \"text/html\"\n" +
                "        },\n" +
                "        \"dashboard\": {\n" +
                "            \"href\": \"https://www.mollie.com/dashboard/org_12345678/payments/tr_7UhSN1zuXS\",\n" +
                "            \"type\": \"application/json\"\n" +
                "        },\n" +
                "        \"documentation\": {\n" +
                "            \"href\": \"https://docs.mollie.com/reference/v2/payments-api/update-payment\",\n" +
                "            \"type\": \"text/html\"\n" +
                "        }\n" +
                "    }\n" +
                "}");

        Payment payment = new Payment();
        payment.setDescription("foo");
        payment.setRedirectUrl("foo");
        payment.setAmount(new Amount("100.00", "EUR"));

        MollieApiClient mollieApiClient = new MollieApiClient(mollieHttpClient);
        Payment result = mollieApiClient.payments().update("paymentId", payment);
        Assertions.assertNotNull(result);
        Assertions.assertEquals("tr_7UhSN1zuXS", result.getId());
    }

    @Test
    void createPaymentException() throws MollieException {
        MollieHttpClient mollieHttpClient = mock(MollieHttpClient.class);
        when(mollieHttpClient.post(anyString(), anyString())).thenThrow(new MollieResponseStatusCodeException(422, "{\"status\":422,\"title\":\"Unprocessable Entity\",\"detail\":\"The amount contains an invalid value\",\"field\":\"amount.value\",\"_links\":{\"documentation\":{\"href\":\"https://docs.mollie.com/guides/handling-errors\",\"type\":\"text/html\"}}}"));

        MollieApiClient mollieApiClient = new MollieApiClient(mollieHttpClient);
        Payment payment = new Payment();
        payment.setDescription("foo");
        payment.setRedirectUrl("foo");
        payment.setAmount(new Amount("100.00", "EUR"));

        Assertions.assertThrows(MollieException.class, () -> mollieApiClient.payments().create(payment));
    }

    @Test
    void cancelPayment() throws MollieException {
        MollieHttpClient mollieHttpClient = mock(MollieHttpClient.class);
        when(mollieHttpClient.delete(anyString())).thenReturn("{\"id\":\"foo\",\"status\":\"canceled\",\"canceledAt\":\"2018-03-19T10:19:15+00:00\"}");

        MollieApiClient mollieApiClient = new MollieApiClient(mollieHttpClient);
        Payment payment = mollieApiClient.payments().cancel("foo");
        Assertions.assertNotNull(payment);
        Assertions.assertEquals("foo", payment.getId());
        Assertions.assertEquals("canceled", payment.getStatus());
        Assertions.assertNotNull(payment.getCanceledAt());
        Assertions.assertEquals("Mon Mar 19 11:19:15 CET 2018", payment.getCanceledAt().toString());
    }

    @Test
    void cancelPaymentException() throws MollieException {
        MollieHttpClient mollieHttpClient = mock(MollieHttpClient.class);
        when(mollieHttpClient.delete(anyString())).thenThrow(new MollieResponseStatusCodeException(422, "{\"status\":422,\"title\":\"Unprocessable Entity\",\"detail\":\"The payment cannot be cancelled\",\"_links\":{\"documentation\":{\"href\":\"https://docs.mollie.com/guides/handling-errors\",\"type\":\"text/html\"}}}"));

        MollieApiClient mollieApiClient = new MollieApiClient(mollieHttpClient);
        Assertions.assertThrows(MollieException.class, () -> mollieApiClient.payments().cancel("foo"));
    }

    @Test
    void pagePayments() throws MollieException {
        MollieHttpClient mollieHttpClient = mock(MollieHttpClient.class);
        when(mollieHttpClient.get(anyString())).thenReturn("{\n" +
                "  \"_embedded\": {\n" +
                "    \"payments\": [\n" +
                "      {\n" +
                "        \"resource\": \"payment\",\n" +
                "        \"id\": \"tr_foo\"\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  \"count\": 50,\n" +
                "  \"_links\": {\n" +
                "    \"documentation\": {\n" +
                "      \"href\": \"https://docs.mollie.com/reference/v2/payments-api/list-payments\",\n" +
                "      \"type\": \"text/html\"\n" +
                "    },\n" +
                "    \"self\": {\n" +
                "      \"href\": \"https://api.mollie.com/v2/payments?limit=50\",\n" +
                "      \"type\": \"application/hal+json\"\n" +
                "    },\n" +
                "    \"previous\": null,\n" +
                "    \"next\": {\n" +
                "      \"href\": \"https://api.mollie.com/v2/payments?from=tr_foo\\u0026limit=50\",\n" +
                "      \"type\": \"application/hal+json\"\n" +
                "    }\n" +
                "  }\n" +
                "}");

        MollieApiClient mollieApiClient = new MollieApiClient(mollieHttpClient);
        Page<Payment> page = mollieApiClient.payments().page();
        Assertions.assertEquals(50, page.getCount());
        Assertions.assertEquals("tr_foo", page.getItems().get(0).getId());
    }

    @Test
    void pagePaymentsException() throws MollieException {
        MollieHttpClient mollieHttpClient = mock(MollieHttpClient.class);
        when(mollieHttpClient.get(anyString())).thenThrow(new MollieResponseStatusCodeException(400, "{\"status\":400,\"title\":\"Bad Request\",\"detail\":\"Invalid cursor value\",\"field\":\"from\",\"_links\":{\"documentation\":{\"href\":\"https://docs.mollie.com/guides/pagination\",\"type\":\"text/html\"}}}"));

        MollieApiClient mollieApiClient = new MollieApiClient(mollieHttpClient);
        QueryMap queryMap = new QueryMap();
        queryMap.put("from", "foo");
        Assertions.assertThrows(MollieException.class, () -> mollieApiClient.payments().page(queryMap));
    }

    @Test
    void bySettlement() throws MollieException {
        MollieHttpClient mollieHttpClient = mock(MollieHttpClient.class);
        when(mollieHttpClient.get(anyString())).thenReturn("{\n" +
                "    \"count\": 5,\n" +
                "    \"_embedded\": {\n" +
                "        \"payments\": [\n" +
                "            {\n" +
                "                \"resource\": \"payment\",\n" +
                "                \"id\": \"tr_7UhSN1zuXS\",\n" +
                "                \"mode\": \"test\",\n" +
                "                \"createdAt\": \"2018-02-12T11:58:35.0Z\",\n" +
                "                \"expiresAt\": \"2018-02-12T12:13:35.0Z\",\n" +
                "                \"status\": \"open\",\n" +
                "                \"isCancelable\": false,\n" +
                "                \"amount\": {\n" +
                "                    \"value\": \"75.00\",\n" +
                "                    \"currency\": \"GBP\"\n" +
                "                },\n" +
                "                \"description\": \"Order #12345\",\n" +
                "                \"method\": \"ideal\",\n" +
                "                \"metadata\": null,\n" +
                "                \"details\": null,\n" +
                "                \"profileId\": \"pfl_QkEhN94Ba\",\n" +
                "                \"settlementId\": \"stl_jDk30akdN\",\n" +
                "                \"redirectUrl\": \"https://webshop.example.org/order/12345/\",\n" +
                "                \"_links\": {\n" +
                "                     \"self\": {\n" +
                "                         \"href\": \"https://api.mollie.com/v2/payments/tr_7UhSN1zuXS\",\n" +
                "                         \"type\": \"application/hal+json\"\n" +
                "                     },\n" +
                "                     \"settlement\": {\n" +
                "                         \"href\": \"https://api.mollie.com/v2/settlements/stl_jDk30akdN\",\n" +
                "                         \"type\": \"application/hal+json\"\n" +
                "                     }\n" +
                "                 }\n" +
                "             }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"_links\": {\n" +
                "        \"self\": {\n" +
                "            \"href\": \"https://api.mollie.com/v2/settlements/stl_jDk30akdN/payments?limit=5\",\n" +
                "            \"type\": \"application/hal+json\"\n" +
                "        },\n" +
                "        \"previous\": null,\n" +
                "        \"next\": {\n" +
                "            \"href\": \"https://api.mollie.com/v2/settlements/stl_jDk30akdN/payments?from=tr_SDkzMggpvx&limit=5\",\n" +
                "            \"type\": \"application/hal+json\"\n" +
                "        },\n" +
                "        \"documentation\": {\n" +
                "            \"href\": \"https://docs.mollie.com/reference/v2/settlements-api/list-settlement-payments\",\n" +
                "            \"type\": \"text/html\"\n" +
                "        }\n" +
                "    }\n" +
                "}");

        MollieApiClient mollieApiClient = new MollieApiClient(mollieHttpClient);
        Page<Payment> page = mollieApiClient.payments().bySettlement("settlementId");
        Assertions.assertEquals(5, page.getCount());
        Assertions.assertEquals("tr_7UhSN1zuXS", page.getItems().get(0).getId());
    }

    @Test
    void byCustomer() throws MollieException {
        MollieHttpClient mollieHttpClient = mock(MollieHttpClient.class);
        when(mollieHttpClient.get(anyString())).thenReturn("{\n" +
                "    \"count\": 5,\n" +
                "    \"_embedded\": {\n" +
                "        \"payments\": [\n" +
                "            {\n" +
                "                \"resource\": \"payment\",\n" +
                "                \"id\": \"tr_7UhSN1zuXS\",\n" +
                "                \"mode\": \"test\",\n" +
                "                \"createdAt\": \"2018-02-12T11:58:35.0Z\",\n" +
                "                \"expiresAt\": \"2018-02-12T12:13:35.0Z\",\n" +
                "                \"status\": \"open\",\n" +
                "                \"isCancelable\": false,\n" +
                "                \"amount\": {\n" +
                "                    \"value\": \"75.00\",\n" +
                "                    \"currency\": \"GBP\"\n" +
                "                },\n" +
                "                \"description\": \"test\",\n" +
                "                \"method\": \"ideal\",\n" +
                "                \"metadata\": null,\n" +
                "                \"details\": null,\n" +
                "                \"profileId\": \"pfl_QkEhN94Ba\",\n" +
                "                \"customerId\": \"cst_kEn1PlbGa\",\n" +
                "                \"redirectUrl\": \"https://webshop.example.org/order/12345/\",\n" +
                "                \"_links\": {\n" +
                "                    \"checkout\": {\n" +
                "                        \"href\": \"https://www.mollie.com/paymentscreen/issuer/select/ideal/7UhSN1zuXS\",\n" +
                "                        \"type\": \"text/html\"\n" +
                "                    },\n" +
                "                    \"dashboard\": {\n" +
                "                        \"href\": \"https://www.mollie.com/dashboard/org_123456789/payments/tr_7UhSN1zuXS\",\n" +
                "                        \"type\": \"text/html\"\n" +
                "                    },\n" +
                "                    \"self\": {\n" +
                "                        \"href\": \"https://api.mollie.com/v2/payments/tr_7UhSN1zuXS\",\n" +
                "                        \"type\": \"application/hal+json\"\n" +
                "                    }\n" +
                "                }\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"_links\": {\n" +
                "        \"self\": {\n" +
                "            \"href\": \"https://api.mollie.com/v2/customers/cst_8wmqcHMN4U/payments?limit=5\",\n" +
                "            \"type\": \"application/hal+json\"\n" +
                "        },\n" +
                "        \"previous\": null,\n" +
                "        \"next\": {\n" +
                "            \"href\": \"https://api.mollie.com/v2/customers/cst_8wmqcHMN4U/payments?from=tr_SDkzMggpvx&limit=5\",\n" +
                "            \"type\": \"application/hal+json\"\n" +
                "        },\n" +
                "        \"documentation\": {\n" +
                "            \"href\": \"https://docs.mollie.com/reference/v2/customers-api/list-customers\",\n" +
                "            \"type\": \"text/html\"\n" +
                "        }\n" +
                "    }\n" +
                "}");

        MollieApiClient mollieApiClient = new MollieApiClient(mollieHttpClient);
        Page<Payment> page = mollieApiClient.payments().byCustomer("customerId");
        Assertions.assertEquals(5, page.getCount());
        Assertions.assertEquals("tr_7UhSN1zuXS", page.getItems().get(0).getId());
    }

    @Test
    void bySubscription() throws MollieException {
        MollieHttpClient mollieHttpClient = mock(MollieHttpClient.class);
        when(mollieHttpClient.get(anyString())).thenReturn("{\n" +
                "     \"_embedded\": {\n" +
                "         \"payments\": [\n" +
                "             {\n" +
                "                 \"resource\": \"payment\",\n" +
                "                 \"id\": \"tr_DtKxVP2AgW\",\n" +
                "                 \"mode\": \"live\",\n" +
                "                 \"createdAt\": \"2018-09-19T12:49:52+00:00\",\n" +
                "                 \"amount\": {\n" +
                "                     \"value\": \"10.00\",\n" +
                "                     \"currency\": \"EUR\"\n" +
                "                 },\n" +
                "                 \"description\": \"Some subscription 19 sep. 2018\",\n" +
                "                 \"method\": \"directdebit\",\n" +
                "                 \"metadata\": null,\n" +
                "                 \"status\": \"pending\",\n" +
                "                 \"isCancelable\": true,\n" +
                "                 \"expiresAt\": \"2019-09-19T12:49:52+00:00\",\n" +
                "                 \"locale\": \"nl_NL\",\n" +
                "                 \"profileId\": \"pfl_rH9rQtedgS\",\n" +
                "                 \"customerId\": \"cst_8wmqcHMN4U\",\n" +
                "                 \"mandateId\": \"mdt_aGQNkteF6w\",\n" +
                "                 \"subscriptionId\": \"sub_8JfGzs6v3K\",\n" +
                "                 \"sequenceType\": \"recurring\",\n" +
                "                 \"redirectUrl\": null,\n" +
                "                 \"webhookUrl\": \"https://example.org/webhook\",\n" +
                "                 \"settlementAmount\": {\n" +
                "                     \"value\": \"10.00\",\n" +
                "                     \"currency\": \"EUR\"\n" +
                "                 },\n" +
                "                 \"details\": {\n" +
                "                     \"transferReference\": \"SD67-6850-2204-6029\",\n" +
                "                     \"creditorIdentifier\": \"NL08ZZZ502057730000\",\n" +
                "                     \"consumerName\": \"Customer A\",\n" +
                "                     \"consumerAccount\": \"NL50INGB0006588912\",\n" +
                "                     \"consumerBic\": \"INGBNL2A\",\n" +
                "                     \"dueDate\": \"2018-09-21\",\n" +
                "                     \"signatureDate\": \"2018-09-19\"\n" +
                "                 },\n" +
                "                 \"_links\": {\n" +
                "                     \"self\": {\n" +
                "                         \"href\": \"https://api.mollie.com/v2/payments/tr_DtKxVP2AgW\",\n" +
                "                         \"type\": \"application/hal+json\"\n" +
                "                     },\n" +
                "                     \"checkout\": null,\n" +
                "                     \"customer\": {\n" +
                "                         \"href\": \"https://api.mollie.com/v2/customers/cst_8wmqcHMN4U\",\n" +
                "                         \"type\": \"application/hal+json\"\n" +
                "                     },\n" +
                "                     \"mandate\": {\n" +
                "                         \"href\": \"https://api.mollie.com/v2/customers/cst_8wmqcHMN4U/mandates/mdt_aGQNkteF6w\",\n" +
                "                         \"type\": \"application/hal+json\"\n" +
                "                     },\n" +
                "                     \"subscription\": {\n" +
                "                         \"href\": \"https://api.mollie.com/v2/customers/cst_8wmqcHMN4U/subscriptions/sub_8JfGzs6v3K\",\n" +
                "                         \"type\": \"application/hal+json\"\n" +
                "                     }\n" +
                "                 }\n" +
                "             }\n" +
                "         ]\n" +
                "     },\n" +
                "     \"count\": 4,\n" +
                "     \"_links\": {\n" +
                "         \"documentation\": {\n" +
                "             \"href\": \"https://docs.mollie.com/reference/v2/subscriptions-api/list-subscriptions-payments\",\n" +
                "             \"type\": \"text/html\"\n" +
                "         },\n" +
                "         \"self\": {\n" +
                "             \"href\": \"https://api.mollie.com/v2/customers/cst_8wmqcHMN4U/subscriptions/sub_8JfGzs6v3K/payments?limit=50\",\n" +
                "             \"type\": \"application/hal+json\"\n" +
                "         },\n" +
                "         \"previous\": null,\n" +
                "         \"next\": null\n" +
                "     }\n" +
                " }");

        MollieApiClient mollieApiClient = new MollieApiClient(mollieHttpClient);
        Page<Payment> page = mollieApiClient.payments().bySubscription("customerId", "subscriptionId");
        Assertions.assertEquals(4, page.getCount());
        Assertions.assertEquals("tr_DtKxVP2AgW", page.getItems().get(0).getId());
    }
}
