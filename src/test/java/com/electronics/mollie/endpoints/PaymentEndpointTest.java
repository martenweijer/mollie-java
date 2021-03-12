package com.electronics.mollie.endpoints;

import com.electronics.mollie.MollieApiClient;
import com.electronics.mollie.exceptions.MollieException;
import com.electronics.mollie.exceptions.MollieHttpException;
import com.electronics.mollie.exceptions.MollieResponseStatusCodeException;
import com.electronics.mollie.http.MollieHttpClient;
import com.electronics.mollie.resources.Amount;
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
}
