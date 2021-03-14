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

public class PaymentEndpointTest {
    @Test
    void getPayment() throws MollieException {
        MollieApiClient mollieApiClient = new MollieApiClient(new MollieHttpClient() {
            @Override
            public String get(String url) throws MollieHttpException {
                return "{\"id\":\"foo\"}";
            }

            @Override
            public String post(String url, String json) throws MollieHttpException {
                return null;
            }

            @Override
            public String delete(String url) throws MollieHttpException {
                return null;
            }
        });
        Payment payment = mollieApiClient.payments().get("tr_mj4K2RGf9V");
        Assertions.assertNotNull(payment);
        Assertions.assertEquals("foo", payment.getId());
    }

    @Test
    void getPaymentException() {
        MollieApiClient mollieApiClient = new MollieApiClient(new MollieHttpClient() {
            @Override
            public String get(String url) throws MollieHttpException {
                throw new MollieResponseStatusCodeException(404, "{\"status\":404,\"title\":\"Not Found\",\"detail\":\"No payment exists with token foo.\",\"_links\":{\"documentation\":{\"href\":\"https://docs.mollie.com/guides/handling-errors\",\"type\":\"text/html\"}}}");
            }

            @Override
            public String post(String url, String json) throws MollieHttpException {
                return null;
            }

            @Override
            public String delete(String url) throws MollieHttpException {
                return null;
            }
        });

        Assertions.assertThrows(MollieException.class, () -> mollieApiClient.payments().get("foo"));
    }

    @Test
    void createPayment() throws MollieException {
        Payment payment = new Payment();
        payment.setDescription("foo");
        payment.setRedirectUrl("foo");
        payment.setAmount(new Amount("100.00", "EUR"));
        MollieApiClient mollieApiClient = new MollieApiClient(new MollieHttpClient() {
            @Override
            public String get(String url) throws MollieHttpException {
                return null;
            }

            @Override
            public String post(String url, String json) throws MollieHttpException {
                return "{\"id\":\"foo\",\"description\":\"foo\",\"amount\":{\"value\":\"100.00\",\"currency\":\"EUR\"},\"redirectUrl\":\"foo\"}";
            }

            @Override
            public String delete(String url) throws MollieHttpException {
                return null;
            }
        });
        Payment result = mollieApiClient.payments().create(payment);
        Assertions.assertNotNull(result);
        Assertions.assertEquals("foo", result.getId());
        Assertions.assertEquals("foo", result.getDescription());
    }

    @Test
    void createPaymentException() {
        Payment payment = new Payment();
        payment.setDescription("foo");
        payment.setRedirectUrl("foo");
        payment.setAmount(new Amount("100.00", "EUR"));
        MollieApiClient mollieApiClient = new MollieApiClient(new MollieHttpClient() {
            @Override
            public String get(String url) throws MollieHttpException {
                return null;
            }

            @Override
            public String post(String url, String json) throws MollieHttpException {
                throw new MollieResponseStatusCodeException(422, "{\"status\":422,\"title\":\"Unprocessable Entity\",\"detail\":\"The amount contains an invalid value\",\"field\":\"amount.value\",\"_links\":{\"documentation\":{\"href\":\"https://docs.mollie.com/guides/handling-errors\",\"type\":\"text/html\"}}}");
            }

            @Override
            public String delete(String url) throws MollieHttpException {
                return null;
            }
        });

        Assertions.assertThrows(MollieException.class, () -> mollieApiClient.payments().create(payment));
    }

    @Test
    void cancelPayment() throws MollieException {
        MollieApiClient mollieApiClient = new MollieApiClient(new MollieHttpClient() {
            @Override
            public String get(String url) throws MollieHttpException {
                return null;
            }

            @Override
            public String post(String url, String json) throws MollieHttpException {
                return null;
            }

            @Override
            public String delete(String url) throws MollieHttpException {
                return "{\"id\":\"foo\",\"status\":\"canceled\",\"canceledAt\":\"2018-03-19T10:19:15+00:00\"}";
            }
        });
        Payment payment = mollieApiClient.payments().cancel("foo");
        Assertions.assertNotNull(payment);
        Assertions.assertEquals("foo", payment.getId());
        Assertions.assertEquals("canceled", payment.getStatus());
        Assertions.assertNotNull(payment.getCanceledAt());
        Assertions.assertEquals("Mon Mar 19 11:19:15 CET 2018", payment.getCanceledAt().toString());
    }

    @Test
    void cancelPaymentException() {
        MollieApiClient mollieApiClient = new MollieApiClient(new MollieHttpClient() {
            @Override
            public String get(String url) throws MollieHttpException {
                return null;
            }

            @Override
            public String post(String url, String json) throws MollieHttpException {
                return null;
            }

            @Override
            public String delete(String url) throws MollieHttpException {
                throw new MollieResponseStatusCodeException(422, "{\"status\":422,\"title\":\"Unprocessable Entity\",\"detail\":\"The payment cannot be cancelled\",\"_links\":{\"documentation\":{\"href\":\"https://docs.mollie.com/guides/handling-errors\",\"type\":\"text/html\"}}}");
            }
        });

        Assertions.assertThrows(MollieException.class, () -> mollieApiClient.payments().cancel("foo"));
    }

    @Test
    void pagePayments() throws MollieException {
        MollieApiClient mollieApiClient = new MollieApiClient(new MollieHttpClient() {
            @Override
            public String get(String url) throws MollieHttpException {
                return "{\n" +
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
                        "}";
            }

            @Override
            public String post(String url, String json) throws MollieHttpException {
                return null;
            }

            @Override
            public String delete(String url) throws MollieHttpException {
                return null;
            }
        });
        Page<Payment> page = mollieApiClient.payments().page();
        Assertions.assertEquals(50, page.getCount());
        Assertions.assertEquals("tr_foo", page.getItems().get(0).getId());
    }

    @Test
    void pagePaymentsException() {
        MollieApiClient mollieApiClient = new MollieApiClient(new MollieHttpClient() {
            @Override
            public String get(String url) throws MollieHttpException {
                return "{\"status\":400,\"title\":\"Bad Request\",\"detail\":\"Invalid cursor value\",\"field\":\"from\",\"_links\":{\"documentation\":{\"href\":\"https://docs.mollie.com/guides/pagination\",\"type\":\"text/html\"}}}";
            }

            @Override
            public String post(String url, String json) throws MollieHttpException {
                return null;
            }

            @Override
            public String delete(String url) throws MollieHttpException {
                return null;
            }
        });
        QueryMap queryMap = new QueryMap();
        queryMap.put("from", "foo");
        Assertions.assertThrows(MollieException.class, () -> mollieApiClient.payments().page(queryMap));
    }
}
