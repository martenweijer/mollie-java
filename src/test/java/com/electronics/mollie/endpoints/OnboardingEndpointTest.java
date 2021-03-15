package com.electronics.mollie.endpoints;

import com.electronics.mollie.MollieApiClient;
import com.electronics.mollie.exceptions.MollieException;
import com.electronics.mollie.exceptions.MollieResponseStatusCodeException;
import com.electronics.mollie.http.MollieHttpClient;
import com.electronics.mollie.resources.Onboarding;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class OnboardingEndpointTest {
    @Test
    void getOnboarding() throws MollieException {
        MollieHttpClient mollieHttpClient = mock(MollieHttpClient.class);
        when(mollieHttpClient.get(anyString())).thenReturn("{\n" +
                "    \"resource\": \"onboarding\",\n" +
                "    \"name\": \"Mollie B.V.\",\n" +
                "    \"signedUpAt\": \"2018-12-20T10:49:08+00:00\",\n" +
                "    \"status\": \"completed\",\n" +
                "    \"canReceivePayments\": true,\n" +
                "    \"canReceiveSettlements\": true,\n" +
                "    \"_links\": {\n" +
                "        \"self\": {\n" +
                "            \"href\": \"https://api.mollie.com/v2/onboarding/me\",\n" +
                "            \"type\": \"application/hal+json\"\n" +
                "        },\n" +
                "        \"dashboard\": {\n" +
                "            \"href\": \"https://www.mollie.com/dashboard/onboarding\",\n" +
                "            \"type\": \"text/html\"\n" +
                "        },\n" +
                "        \"organization\": {\n" +
                "            \"href\": \"https://api.mollie.com/v2/organization/org_12345\",\n" +
                "            \"type\": \"application/hal+json\"\n" +
                "        },\n" +
                "        \"documentation\": {\n" +
                "            \"href\": \"https://docs.mollie.com/reference/v2/onboarding-api/get-onboarding-status\",\n" +
                "            \"type\": \"text/html\"\n" +
                "        }\n" +
                "    }\n" +
                "}");

        MollieApiClient mollieApiClient = new MollieApiClient(mollieHttpClient);
        Onboarding onboarding = mollieApiClient.onboarding().get();
        assertNotNull(onboarding);
        assertEquals("Mollie B.V.", onboarding.getName());
    }

    @Test
    void getOnboardingException() throws MollieException {
        MollieHttpClient mollieHttpClient = mock(MollieHttpClient.class);
        when(mollieHttpClient.get(anyString())).thenThrow(new MollieResponseStatusCodeException(401, "{\"status\":401,\"title\":\"Unauthorized Request\",\"detail\":\"Missing authentication, or failed to authenticate\",\"_links\":{\"documentation\":{\"href\":\"https://docs.mollie.com/guides/authentication\",\"type\":\"text/html\"}}}"));

        MollieApiClient mollieApiClient = new MollieApiClient(mollieHttpClient);
        assertThrows(MollieException.class, () -> mollieApiClient.onboarding().get());
    }
}
