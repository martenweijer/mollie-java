package com.electronics.mollie.endpoints;

import com.electronics.mollie.MollieApiClient;
import com.electronics.mollie.exceptions.MollieException;
import com.electronics.mollie.http.MollieHttpClient;
import com.electronics.mollie.resources.Organization;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class OrganizationEndpointTest {
    @Test
    void getPermission() throws MollieException {
        MollieHttpClient mollieHttpClient = mock(MollieHttpClient.class);
        when(mollieHttpClient.get(anyString())).thenReturn("{\n" +
                "     \"resource\": \"organization\",\n" +
                "     \"id\": \"org_12345678\",\n" +
                "     \"name\": \"Mollie B.V.\",\n" +
                "     \"email\": \"info@mollie.com\",\n" +
                "     \"address\": {\n" +
                "        \"streetAndNumber\" : \"Keizersgracht 126\",\n" +
                "        \"postalCode\": \"1015 CW\",\n" +
                "         \"city\": \"Amsterdam\",\n" +
                "         \"country\": \"NL\"\n" +
                "     },\n" +
                "     \"registrationNumber\": \"30204462\",\n" +
                "     \"vatNumber\": \"NL815839091B01\",\n" +
                "     \"_links\": {\n" +
                "         \"self\": {\n" +
                "             \"href\": \"https://api.mollie.com/v2/organizations/me\",\n" +
                "             \"type\": \"application/hal+json\"\n" +
                "         },\n" +
                "         \"chargebacks\": {\n" +
                "             \"href\": \"https://api.mollie.com/v2/chargebacks\",\n" +
                "             \"type\": \"application/hal+json\"\n" +
                "         },\n" +
                "         \"customers\": {\n" +
                "             \"href\": \"https://api.mollie.com/v2/customers\",\n" +
                "             \"type\": \"application/hal+json\"\n" +
                "         },\n" +
                "         \"invoices\": {\n" +
                "             \"href\": \"https://api.mollie.com/v2/invoices\",\n" +
                "             \"type\": \"application/hal+json\"\n" +
                "         },\n" +
                "         \"payments\": {\n" +
                "             \"href\": \"https://api.mollie.com/v2/payments\",\n" +
                "             \"type\": \"application/hal+json\"\n" +
                "         },\n" +
                "         \"profiles\": {\n" +
                "             \"href\": \"https://api.mollie.com/v2/profiles\",\n" +
                "             \"type\": \"application/hal+json\"\n" +
                "         },\n" +
                "         \"refunds\": {\n" +
                "             \"href\": \"https://api.mollie.com/v2/refunds\",\n" +
                "             \"type\": \"application/hal+json\"\n" +
                "         },\n" +
                "         \"settlements\": {\n" +
                "             \"href\": \"https://api.mollie.com/v2/settlements\",\n" +
                "             \"type\": \"application/hal+json\"\n" +
                "         },\n" +
                "         \"dashboard\": {\n" +
                "             \"href\": \"https://mollie.com/dashboard/org_12345678\",\n" +
                "             \"type\": \"text/html\"\n" +
                "         },\n" +
                "         \"documentation\": {\n" +
                "             \"href\": \"https://docs.mollie.com/reference/v2/organizations-api/current-organization\",\n" +
                "             \"type\": \"text/html\"\n" +
                "         }\n" +
                "     }\n" +
                " }");

        MollieApiClient mollieApiClient = new MollieApiClient(mollieHttpClient);
        Organization organization = mollieApiClient.organizations().get("me");
        assertNotNull(organization);
        assertEquals("org_12345678", organization.getId());
    }
}
