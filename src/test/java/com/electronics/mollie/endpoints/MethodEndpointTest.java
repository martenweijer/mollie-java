package com.electronics.mollie.endpoints;

import com.electronics.mollie.MollieApiClient;
import com.electronics.mollie.exceptions.MollieException;
import com.electronics.mollie.exceptions.MollieResponseStatusCodeException;
import com.electronics.mollie.http.MollieHttpClient;
import com.electronics.mollie.resources.Method;
import com.electronics.mollie.resources.Page;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class MethodEndpointTest {
    @Test
    void getMethod() throws MollieException {
        MollieHttpClient mollieHttpClient = mock(MollieHttpClient.class);
        when(mollieHttpClient.get(anyString())).thenReturn("{\"resource\":\"method\",\"id\":\"ideal\",\"description\":\"iDEAL\",\"minimumAmount\":{\"value\":\"0.01\",\"currency\":\"EUR\"},\"maximumAmount\":{\"value\":\"50000.00\",\"currency\":\"EUR\"},\"image\":{\"size1x\":\"https://www.mollie.com/external/icons/payment-methods/ideal.png\",\"size2x\":\"https://www.mollie.com/external/icons/payment-methods/ideal%402x.png\",\"svg\":\"https://www.mollie.com/external/icons/payment-methods/ideal.svg\"},\"status\":\"pending-boarding\",\"_links\":{\"self\":{\"href\":\"https://api.mollie.com/v2/methods/ideal\",\"type\":\"application/hal+json\"},\"documentation\":{\"href\":\"https://docs.mollie.com/reference/v2/methods-api/get-method\",\"type\":\"text/html\"}}}");

        MollieApiClient mollieApiClient = new MollieApiClient(mollieHttpClient);
        Method method = mollieApiClient.methods().get("ideal");
        assertEquals("ideal", method.getId());
    }

    @Test
    void getMethodException() throws MollieException {
        MollieHttpClient mollieHttpClient = mock(MollieHttpClient.class);
        when(mollieHttpClient.get(anyString())).thenThrow(new MollieResponseStatusCodeException(404, "{\"status\":404,\"title\":\"Not Found\",\"detail\":\"The payment method is invalid\",\"field\":\"method\",\"_links\":{\"documentation\":{\"href\":\"https://docs.mollie.com/guides/handling-errors\",\"type\":\"text/html\"}}}"));

        MollieApiClient mollieApiClient = new MollieApiClient(mollieHttpClient);
        assertThrows(MollieException.class, () -> mollieApiClient.methods().get("foo"));
    }

    @Test
    void allMethod() throws MollieException {
        MollieHttpClient mollieHttpClient = mock(MollieHttpClient.class);
        when(mollieHttpClient.get(anyString())).thenReturn("{\"_embedded\":{\"methods\":[{\"resource\":\"method\",\"id\":\"ideal\",\"description\":\"iDEAL\",\"minimumAmount\":{\"value\":\"0.01\",\"currency\":\"EUR\"},\"maximumAmount\":{\"value\":\"50000.00\",\"currency\":\"EUR\"},\"image\":{\"size1x\":\"https://www.mollie.com/external/icons/payment-methods/ideal.png\",\"size2x\":\"https://www.mollie.com/external/icons/payment-methods/ideal%402x.png\",\"svg\":\"https://www.mollie.com/external/icons/payment-methods/ideal.svg\"},\"status\":\"pending-boarding\",\"_links\":{\"self\":{\"href\":\"https://api.mollie.com/v2/methods/ideal\",\"type\":\"application/hal+json\"}}},{\"resource\":\"method\",\"id\":\"creditcard\",\"description\":\"Credit card\",\"minimumAmount\":{\"value\":\"0.01\",\"currency\":\"EUR\"},\"maximumAmount\":{\"value\":\"2000.00\",\"currency\":\"EUR\"},\"image\":{\"size1x\":\"https://www.mollie.com/external/icons/payment-methods/creditcard.png\",\"size2x\":\"https://www.mollie.com/external/icons/payment-methods/creditcard%402x.png\",\"svg\":\"https://www.mollie.com/external/icons/payment-methods/creditcard.svg\"},\"status\":\"pending-boarding\",\"_links\":{\"self\":{\"href\":\"https://api.mollie.com/v2/methods/creditcard\",\"type\":\"application/hal+json\"}}},{\"resource\":\"method\",\"id\":\"paypal\",\"description\":\"PayPal\",\"minimumAmount\":{\"value\":\"0.01\",\"currency\":\"EUR\"},\"maximumAmount\":null,\"image\":{\"size1x\":\"https://www.mollie.com/external/icons/payment-methods/paypal.png\",\"size2x\":\"https://www.mollie.com/external/icons/payment-methods/paypal%402x.png\",\"svg\":\"https://www.mollie.com/external/icons/payment-methods/paypal.svg\"},\"status\":\"pending-boarding\",\"_links\":{\"self\":{\"href\":\"https://api.mollie.com/v2/methods/paypal\",\"type\":\"application/hal+json\"}}},{\"resource\":\"method\",\"id\":\"banktransfer\",\"description\":\"Bank transfer\",\"minimumAmount\":{\"value\":\"0.01\",\"currency\":\"EUR\"},\"maximumAmount\":{\"value\":\"1000000.00\",\"currency\":\"EUR\"},\"image\":{\"size1x\":\"https://www.mollie.com/external/icons/payment-methods/banktransfer.png\",\"size2x\":\"https://www.mollie.com/external/icons/payment-methods/banktransfer%402x.png\",\"svg\":\"https://www.mollie.com/external/icons/payment-methods/banktransfer.svg\"},\"status\":\"pending-boarding\",\"_links\":{\"self\":{\"href\":\"https://api.mollie.com/v2/methods/banktransfer\",\"type\":\"application/hal+json\"}}},{\"resource\":\"method\",\"id\":\"sofort\",\"description\":\"SOFORT Banking\",\"minimumAmount\":{\"value\":\"0.10\",\"currency\":\"EUR\"},\"maximumAmount\":{\"value\":\"50000.00\",\"currency\":\"EUR\"},\"image\":{\"size1x\":\"https://www.mollie.com/external/icons/payment-methods/sofort.png\",\"size2x\":\"https://www.mollie.com/external/icons/payment-methods/sofort%402x.png\",\"svg\":\"https://www.mollie.com/external/icons/payment-methods/sofort.svg\"},\"status\":\"pending-boarding\",\"_links\":{\"self\":{\"href\":\"https://api.mollie.com/v2/methods/sofort\",\"type\":\"application/hal+json\"}}},{\"resource\":\"method\",\"id\":\"bancontact\",\"description\":\"Bancontact\",\"minimumAmount\":{\"value\":\"0.02\",\"currency\":\"EUR\"},\"maximumAmount\":{\"value\":\"50000.00\",\"currency\":\"EUR\"},\"image\":{\"size1x\":\"https://www.mollie.com/external/icons/payment-methods/bancontact.png\",\"size2x\":\"https://www.mollie.com/external/icons/payment-methods/bancontact%402x.png\",\"svg\":\"https://www.mollie.com/external/icons/payment-methods/bancontact.svg\"},\"status\":\"pending-boarding\",\"_links\":{\"self\":{\"href\":\"https://api.mollie.com/v2/methods/bancontact\",\"type\":\"application/hal+json\"}}},{\"resource\":\"method\",\"id\":\"eps\",\"description\":\"eps\",\"minimumAmount\":{\"value\":\"1.00\",\"currency\":\"EUR\"},\"maximumAmount\":{\"value\":\"50000.00\",\"currency\":\"EUR\"},\"image\":{\"size1x\":\"https://www.mollie.com/external/icons/payment-methods/eps.png\",\"size2x\":\"https://www.mollie.com/external/icons/payment-methods/eps%402x.png\",\"svg\":\"https://www.mollie.com/external/icons/payment-methods/eps.svg\"},\"status\":\"pending-boarding\",\"_links\":{\"self\":{\"href\":\"https://api.mollie.com/v2/methods/eps\",\"type\":\"application/hal+json\"}}},{\"resource\":\"method\",\"id\":\"giropay\",\"description\":\"Giropay\",\"minimumAmount\":{\"value\":\"1.00\",\"currency\":\"EUR\"},\"maximumAmount\":{\"value\":\"10000.00\",\"currency\":\"EUR\"},\"image\":{\"size1x\":\"https://www.mollie.com/external/icons/payment-methods/giropay.png\",\"size2x\":\"https://www.mollie.com/external/icons/payment-methods/giropay%402x.png\",\"svg\":\"https://www.mollie.com/external/icons/payment-methods/giropay.svg\"},\"status\":\"pending-boarding\",\"_links\":{\"self\":{\"href\":\"https://api.mollie.com/v2/methods/giropay\",\"type\":\"application/hal+json\"}}},{\"resource\":\"method\",\"id\":\"przelewy24\",\"description\":\"Przelewy24\",\"minimumAmount\":{\"value\":\"0.01\",\"currency\":\"EUR\"},\"maximumAmount\":{\"value\":\"12815.00\",\"currency\":\"EUR\"},\"image\":{\"size1x\":\"https://www.mollie.com/external/icons/payment-methods/przelewy24.png\",\"size2x\":\"https://www.mollie.com/external/icons/payment-methods/przelewy24%402x.png\",\"svg\":\"https://www.mollie.com/external/icons/payment-methods/przelewy24.svg\"},\"status\":\"pending-boarding\",\"_links\":{\"self\":{\"href\":\"https://api.mollie.com/v2/methods/przelewy24\",\"type\":\"application/hal+json\"}}},{\"resource\":\"method\",\"id\":\"kbc\",\"description\":\"KBC/CBC Payment Button\",\"minimumAmount\":{\"value\":\"0.01\",\"currency\":\"EUR\"},\"maximumAmount\":{\"value\":\"50000.00\",\"currency\":\"EUR\"},\"image\":{\"size1x\":\"https://www.mollie.com/external/icons/payment-methods/kbc.png\",\"size2x\":\"https://www.mollie.com/external/icons/payment-methods/kbc%402x.png\",\"svg\":\"https://www.mollie.com/external/icons/payment-methods/kbc.svg\"},\"status\":\"pending-boarding\",\"_links\":{\"self\":{\"href\":\"https://api.mollie.com/v2/methods/kbc\",\"type\":\"application/hal+json\"}}},{\"resource\":\"method\",\"id\":\"belfius\",\"description\":\"Belfius Pay Button\",\"minimumAmount\":{\"value\":\"0.01\",\"currency\":\"EUR\"},\"maximumAmount\":{\"value\":\"50000.00\",\"currency\":\"EUR\"},\"image\":{\"size1x\":\"https://www.mollie.com/external/icons/payment-methods/belfius.png\",\"size2x\":\"https://www.mollie.com/external/icons/payment-methods/belfius%402x.png\",\"svg\":\"https://www.mollie.com/external/icons/payment-methods/belfius.svg\"},\"status\":\"pending-boarding\",\"_links\":{\"self\":{\"href\":\"https://api.mollie.com/v2/methods/belfius\",\"type\":\"application/hal+json\"}}}]},\"count\":11,\"_links\":{\"documentation\":{\"href\":\"https://docs.mollie.com/reference/v2/methods-api/list-methods\",\"type\":\"text/html\"},\"self\":{\"href\":\"https://api.mollie.com/v2/methods\",\"type\":\"application/hal+json\"}}}");

        MollieApiClient mollieApiClient = new MollieApiClient(mollieHttpClient);
        Page<Method> methods = mollieApiClient.methods().all();
        assertEquals(11, methods.getCount());
        assertEquals(Method.class, methods.getItems().get(0).getClass());
    }

    @Test
    void allMethodException() throws MollieException {
        MollieHttpClient mollieHttpClient = mock(MollieHttpClient.class);
        when(mollieHttpClient.get(anyString())).thenThrow(new MollieResponseStatusCodeException(422, "{\"status\":422,\"title\":\"Unprocessable Entity\",\"detail\":\"Non-existent query parameter \\\"from\\\" for this API call. Did you mean: \\\"locale\\\"?\",\"field\":\"from\",\"_links\":{\"documentation\":{\"href\":\"https://docs.mollie.com/guides/handling-errors\",\"type\":\"text/html\"}}}"));

        MollieApiClient mollieApiClient = new MollieApiClient(mollieHttpClient);
        assertThrows(MollieException.class, () -> mollieApiClient.methods().all());
    }
}
