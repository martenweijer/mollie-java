package com.electronics.mollie.endpoints;

import com.electronics.mollie.MollieApiClient;
import com.electronics.mollie.exceptions.MollieException;
import com.electronics.mollie.http.MollieHttpClient;
import com.electronics.mollie.resources.Issuer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IssuerEndpointTest {
    @Test
    void enableGiftcard() throws MollieException {
        MollieHttpClient mollieHttpClient = mock(MollieHttpClient.class);
        when(mollieHttpClient.post(anyString())).thenReturn("{\n" +
                "     \"resource\": \"issuer\",\n" +
                "     \"id\": \"festivalcadeau\",\n" +
                "     \"description\": \"FestivalCadeau Giftcard\",\n" +
                "     \"status\": \"pending-issuer\",\n" +
                "     \"_links\": {\n" +
                "         \"self\": {\n" +
                "             \"href\": \"https://api.mollie.com/v2/issuers/festivalcadeau\",\n" +
                "             \"type\": \"application/hal+json\"\n" +
                "         },\n" +
                "         \"documentation\": {\n" +
                "             \"href\": \"https://docs.mollie.com/reference/v2/profiles-api/enable-giftcard-issuer\",\n" +
                "             \"type\": \"text/html\"\n" +
                "         }\n" +
                "     }\n" +
                " }");

        MollieApiClient mollieApiClient = new MollieApiClient(mollieHttpClient);
        Issuer issuer = mollieApiClient.issuer().enableGiftcard("pofileId", "issuerId");
        assertNotNull(issuer);
        assertEquals("festivalcadeau", issuer.getId());
    }

    @Test
    void disableGiftcard() throws MollieException {
        MollieHttpClient mollieHttpClient = mock(MollieHttpClient.class);
        when(mollieHttpClient.delete(anyString())).thenReturn("");

        MollieApiClient mollieApiClient = new MollieApiClient(mollieHttpClient);
        mollieApiClient.issuer().disableGiftcard("pofileId", "issuerId");
    }

    @Test
    void enableVoucher() throws MollieException {
        MollieHttpClient mollieHttpClient = mock(MollieHttpClient.class);
        when(mollieHttpClient.post(anyString())).thenReturn("{\n" +
                "     \"resource\": \"issuer\",\n" +
                "     \"id\": \"appetiz\",\n" +
                "     \"description\": \"Appetiz\",\n" +
                "     \"status\": \"pending-issuer\",\n" +
                "     \"contractor\": {\n" +
                "         \"id\": \"Conecs\",\n" +
                "         \"name\": \"Conecs\",\n" +
                "         \"contractId\": \"abc123\"\n" +
                "     },\n" +
                "     \"image\": {\n" +
                "         \"size1x\": \"https://www.mollie.com/external/icons/voucher-issuers/apetiz.png\",\n" +
                "         \"size2x\": \"https://www.mollie.com/external/icons/voucher-issuers/apetiz%402x.png\",\n" +
                "         \"svg\": \"https://www.mollie.com/external/icons/voucher-issuers/apetiz.svg\"\n" +
                "     },\n" +
                "     \"_links\": {\n" +
                "         \"self\": {\n" +
                "             \"href\": \"https://api.mollie.com/v2/issuers/appetiz\",\n" +
                "             \"type\": \"application/hal+json\"\n" +
                "         },\n" +
                "         \"documentation\": {\n" +
                "             \"href\": \"https://docs.mollie.com/reference/v2/profiles-api/enable-voucher-issuer\",\n" +
                "             \"type\": \"text/html\"\n" +
                "         }\n" +
                "     }\n" +
                " }");

        MollieApiClient mollieApiClient = new MollieApiClient(mollieHttpClient);
        Issuer issuer = mollieApiClient.issuer().enableVoucher("pofileId", "issuerId");
        assertNotNull(issuer);
        assertEquals("appetiz", issuer.getId());
    }

    @Test
    void disableVoucher() throws MollieException {
        MollieHttpClient mollieHttpClient = mock(MollieHttpClient.class);
        when(mollieHttpClient.delete(anyString())).thenReturn("");

        MollieApiClient mollieApiClient = new MollieApiClient(mollieHttpClient);
        mollieApiClient.issuer().disableVoucher("pofileId", "issuerId");
    }
}
