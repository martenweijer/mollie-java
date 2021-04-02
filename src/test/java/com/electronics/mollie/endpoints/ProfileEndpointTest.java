package com.electronics.mollie.endpoints;

import com.electronics.mollie.MollieApiClient;
import com.electronics.mollie.exceptions.MollieException;
import com.electronics.mollie.http.MollieHttpClient;
import com.electronics.mollie.resources.Profile;
import com.electronics.mollie.resources.Page;
import com.electronics.mollie.resources.Profile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ProfileEndpointTest {
    @Test
    void getProfile() throws MollieException {
        MollieHttpClient mollieHttpClient = mock(MollieHttpClient.class);
        when(mollieHttpClient.get(anyString())).thenReturn("{\n" +
                "    \"resource\": \"profile\",\n" +
                "    \"id\": \"pfl_v9hTwCvYqw\",\n" +
                "    \"mode\": \"live\",\n" +
                "    \"name\": \"My website name\",\n" +
                "    \"website\": \"https://www.mywebsite.com\",\n" +
                "    \"email\": \"info@mywebsite.com\",\n" +
                "    \"phone\": \"+31208202070\",\n" +
                "    \"categoryCode\": 5399,\n" +
                "    \"status\": \"verified\",\n" +
                "    \"review\": {\n" +
                "        \"status\": \"pending\"\n" +
                "    },\n" +
                "    \"createdAt\": \"2018-03-20T09:28:37+00:00\",\n" +
                "    \"_links\": {\n" +
                "        \"self\": {\n" +
                "            \"href\": \"https://api.mollie.com/v2/profiles/pfl_v9hTwCvYqw\",\n" +
                "            \"type\": \"application/hal+json\"\n" +
                "        },\n" +
                "        \"dashboard\": {\n" +
                "            \"href\": \"https://www.mollie.com/dashboard/org_123456789/settings/profiles/pfl_v9hTwCvYqw\",\n" +
                "            \"type\": \"text/html\"\n" +
                "        },\n" +
                "        \"chargebacks\": {\n" +
                "            \"href\": \"https://api.mollie.com/v2/chargebacks?profileId=pfl_v9hTwCvYqw\",\n" +
                "            \"type\": \"application/hal+json\"\n" +
                "        },\n" +
                "        \"methods\": {\n" +
                "            \"href\": \"https://api.mollie.com/v2/methods?profileId=pfl_v9hTwCvYqw\",\n" +
                "            \"type\": \"application/hal+json\"\n" +
                "        },\n" +
                "        \"payments\": {\n" +
                "            \"href\": \"https://api.mollie.com/v2/payments?profileId=pfl_v9hTwCvYqw\",\n" +
                "            \"type\": \"application/hal+json\"\n" +
                "        },\n" +
                "        \"refunds\": {\n" +
                "            \"href\": \"https://api.mollie.com/v2/refunds?profileId=pfl_v9hTwCvYqw\",\n" +
                "            \"type\": \"application/hal+json\"\n" +
                "        },\n" +
                "        \"checkoutPreviewUrl\": {\n" +
                "            \"href\": \"https://www.mollie.com/payscreen/preview/pfl_v9hTwCvYqw\",\n" +
                "            \"type\": \"text/html\"\n" +
                "        },\n" +
                "        \"documentation\": {\n" +
                "            \"href\": \"https://docs.mollie.com/reference/v2/profiles-api/create-profile\",\n" +
                "            \"type\": \"text/html\"\n" +
                "        }\n" +
                "    }\n" +
                "}");

        MollieApiClient mollieApiClient = new MollieApiClient(mollieHttpClient);
        Profile profile = mollieApiClient.profiles().get("foo");
        Assertions.assertNotNull(profile);
        Assertions.assertEquals("pfl_v9hTwCvYqw", profile.getId());
    }

    @Test
    void createProfile() throws MollieException {
        MollieHttpClient mollieHttpClient = mock(MollieHttpClient.class);
        when(mollieHttpClient.post(anyString(), anyString())).thenReturn("{\n" +
                "    \"resource\": \"profile\",\n" +
                "    \"id\": \"pfl_v9hTwCvYqw\",\n" +
                "    \"mode\": \"live\",\n" +
                "    \"name\": \"My website name\",\n" +
                "    \"website\": \"https://www.mywebsite.com\",\n" +
                "    \"email\": \"info@mywebsite.com\",\n" +
                "    \"phone\": \"+31208202070\",\n" +
                "    \"categoryCode\": 5399,\n" +
                "    \"status\": \"unverified\",\n" +
                "    \"createdAt\": \"2018-03-20T09:28:37+00:00\",\n" +
                "    \"_links\": {\n" +
                "        \"self\": {\n" +
                "            \"href\": \"https://api.mollie.com/v2/profiles/pfl_v9hTwCvYqw\",\n" +
                "            \"type\": \"application/hal+json\"\n" +
                "        },\n" +
                "        \"dashboard\": {\n" +
                "            \"href\": \"https://www.mollie.com/dashboard/org_123456789/settings/profiles/pfl_v9hTwCvYqw\",\n" +
                "            \"type\": \"text/html\"\n" +
                "        },\n" +
                "        \"chargebacks\": {\n" +
                "            \"href\": \"https://api.mollie.com/v2/chargebacks?profileId=pfl_v9hTwCvYqw\",\n" +
                "            \"type\": \"application/hal+json\"\n" +
                "        },\n" +
                "        \"methods\": {\n" +
                "            \"href\": \"https://api.mollie.com/v2/methods?profileId=pfl_v9hTwCvYqw\",\n" +
                "            \"type\": \"application/hal+json\"\n" +
                "        },\n" +
                "        \"payments\": {\n" +
                "            \"href\": \"https://api.mollie.com/v2/payments?profileId=pfl_v9hTwCvYqw\",\n" +
                "            \"type\": \"application/hal+json\"\n" +
                "        },\n" +
                "        \"refunds\": {\n" +
                "            \"href\": \"https://api.mollie.com/v2/refunds?profileId=pfl_v9hTwCvYqw\",\n" +
                "            \"type\": \"application/hal+json\"\n" +
                "        },\n" +
                "        \"checkoutPreviewUrl\": {\n" +
                "            \"href\": \"https://www.mollie.com/payscreen/preview/pfl_v9hTwCvYqw\",\n" +
                "            \"type\": \"text/html\"\n" +
                "        },\n" +
                "        \"documentation\": {\n" +
                "            \"href\": \"https://docs.mollie.com/reference/v2/profiles-api/create-profile\",\n" +
                "            \"type\": \"text/html\"\n" +
                "        }\n" +
                "    }\n" +
                "}");

        Profile profile = new Profile();
        profile.setName("foo");

        MollieApiClient mollieApiClient = new MollieApiClient(mollieHttpClient);
        Profile result = mollieApiClient.profiles().create(profile);
        Assertions.assertNotNull(result);
        Assertions.assertEquals("pfl_v9hTwCvYqw", result.getId());
    }

    @Test
    void updateProfile() throws MollieException {
        MollieHttpClient mollieHttpClient = mock(MollieHttpClient.class);
        when(mollieHttpClient.patch(anyString(), anyString())).thenReturn("{\n" +
                "    \"resource\": \"profile\",\n" +
                "    \"id\": \"pfl_v9hTwCvYqw\",\n" +
                "    \"mode\": \"live\",\n" +
                "    \"name\": \"My website name - Update 1\",\n" +
                "    \"website\": \"https://www.mywebsite2.com\",\n" +
                "    \"email\": \"info@mywebsite2.com\",\n" +
                "    \"phone\": \"+31208202070\",\n" +
                "    \"categoryCode\": 5399,\n" +
                "    \"status\": \"verified\",\n" +
                "    \"review\": {\n" +
                "        \"status\": \"pending\"\n" +
                "    },\n" +
                "    \"createdAt\": \"2018-03-20T09:28:37+00:00\",\n" +
                "    \"_links\": {\n" +
                "        \"self\": {\n" +
                "            \"href\": \"https://api.mollie.com/v2/profiles/pfl_v9hTwCvYqw\",\n" +
                "            \"type\": \"application/hal+json\"\n" +
                "        },\n" +
                "        \"dashboard\": {\n" +
                "            \"href\": \"https://www.mollie.com/dashboard/org_123456789/settings/profiles/pfl_v9hTwCvYqw\",\n" +
                "            \"type\": \"text/html\"\n" +
                "        },\n" +
                "        \"chargebacks\": {\n" +
                "            \"href\": \"https://api.mollie.com/v2/chargebacks?profileId=pfl_v9hTwCvYqw\",\n" +
                "            \"type\": \"application/hal+json\"\n" +
                "        },\n" +
                "        \"methods\": {\n" +
                "            \"href\": \"https://api.mollie.com/v2/methods?profileId=pfl_v9hTwCvYqw\",\n" +
                "            \"type\": \"application/hal+json\"\n" +
                "        },\n" +
                "        \"payments\": {\n" +
                "            \"href\": \"https://api.mollie.com/v2/payments?profileId=pfl_v9hTwCvYqw\",\n" +
                "            \"type\": \"application/hal+json\"\n" +
                "        },\n" +
                "        \"refunds\": {\n" +
                "            \"href\": \"https://api.mollie.com/v2/refunds?profileId=pfl_v9hTwCvYqw\",\n" +
                "            \"type\": \"application/hal+json\"\n" +
                "        },\n" +
                "        \"checkoutPreviewUrl\": {\n" +
                "            \"href\": \"https://www.mollie.com/payscreen/preview/pfl_v9hTwCvYqw\",\n" +
                "            \"type\": \"text/html\"\n" +
                "        },\n" +
                "        \"documentation\": {\n" +
                "            \"href\": \"https://docs.mollie.com/reference/v2/profiles-api/create-profile\",\n" +
                "            \"type\": \"text/html\"\n" +
                "        }\n" +
                "    }\n" +
                "}");

        Profile profile = new Profile();
        profile.setName("foo");

        MollieApiClient mollieApiClient = new MollieApiClient(mollieHttpClient);
        Profile result = mollieApiClient.profiles().update("foo", profile);
        Assertions.assertNotNull(result);
        Assertions.assertEquals("pfl_v9hTwCvYqw", result.getId());
    }

    @Test
    void revokeProfile() throws MollieException {
        MollieHttpClient mollieHttpClient = mock(MollieHttpClient.class);
        when(mollieHttpClient.delete(anyString())).thenReturn("");

        MollieApiClient mollieApiClient = new MollieApiClient(mollieHttpClient);
        mollieApiClient.profiles().delete("bar");
    }

    @Test
    void allProfiles() throws MollieException {
        MollieHttpClient mollieHttpClient = mock(MollieHttpClient.class);
        when(mollieHttpClient.get(anyString())).thenReturn("{\n" +
                "    \"_embedded\": {\n" +
                "        \"profiles\": [\n" +
                "            {\n" +
                "                \"resource\": \"profiles\",\n" +
                "                \"id\": \"pfl_v9hTwCvYqw\",\n" +
                "                \"mode\": \"live\",\n" +
                "                \"name\": \"My website name\",\n" +
                "                \"website\": \"https://www.mywebsite.com\",\n" +
                "                \"email\": \"info@mywebsite.com\",\n" +
                "                \"phone\": \"+31208202070\",\n" +
                "                \"categoryCode\": 5399,\n" +
                "                \"status\": \"verified\",\n" +
                "                \"review\": {\n" +
                "                    \"status\": \"pending\"\n" +
                "                },\n" +
                "                \"createdAt\": \"2018-03-20T09:28:37+00:00\",\n" +
                "                \"_links\": {\n" +
                "                    \"self\": {\n" +
                "                        \"href\": \"https://api.mollie.com/v2/profiles/pfl_v9hTwCvYqw\",\n" +
                "                        \"type\": \"application/hal+json\"\n" +
                "                    },\n" +
                "                    \"dashboard\": {\n" +
                "                        \"href\": \"https://www.mollie.com/dashboard/org_123456789/settings/profiles/pfl_v9hTwCvYqw\",\n" +
                "                        \"type\": \"text/html\"\n" +
                "                    },\n" +
                "                    \"chargebacks\": {\n" +
                "                        \"href\": \"https://api.mollie.com/v2/chargebacks?profileId=pfl_v9hTwCvYqw\",\n" +
                "                        \"type\": \"application/hal+json\"\n" +
                "                    },\n" +
                "                    \"methods\": {\n" +
                "                        \"href\": \"https://api.mollie.com/v2/methods?profileId=pfl_v9hTwCvYqw\",\n" +
                "                        \"type\": \"application/hal+json\"\n" +
                "                    },\n" +
                "                    \"payments\": {\n" +
                "                        \"href\": \"https://api.mollie.com/v2/payments?profileId=pfl_v9hTwCvYqw\",\n" +
                "                        \"type\": \"application/hal+json\"\n" +
                "                    },\n" +
                "                    \"refunds\": {\n" +
                "                        \"href\": \"https://api.mollie.com/v2/refunds?profileId=pfl_v9hTwCvYqw\",\n" +
                "                        \"type\": \"application/hal+json\"\n" +
                "                    },\n" +
                "                    \"checkoutPreviewUrl\": {\n" +
                "                        \"href\": \"https://www.mollie.com/payscreen/preview/pfl_v9hTwCvYqw\",\n" +
                "                        \"type\": \"text/html\"\n" +
                "                    },\n" +
                "                    \"documentation\": {\n" +
                "                        \"href\": \"https://docs.mollie.com/reference/v2/profiles-api/create-profile\",\n" +
                "                        \"type\": \"text/html\"\n" +
                "                    }\n" +
                "                }\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"count\": 5,\n" +
                "    \"_links\": {\n" +
                "        \"documentation\": {\n" +
                "            \"href\": \"https://docs.mollie.com/reference/v2/profiles-api/list-profiles\",\n" +
                "            \"type\": \"text/html\"\n" +
                "        },\n" +
                "        \"self\": {\n" +
                "            \"href\": \"https://api.mollie.com/v2/profiles?limit=5\",\n" +
                "            \"type\": \"application/hal+json\"\n" +
                "        },\n" +
                "        \"previous\": null,\n" +
                "        \"next\": {\n" +
                "            \"href\": \"https://api.mollie.com/v2/profiles?from=pfl_3RkSN1zuPE&limit=5\",\n" +
                "            \"type\": \"application/hal+json\"\n" +
                "        }\n" +
                "    }\n" +
                "}");

        MollieApiClient mollieApiClient = new MollieApiClient(mollieHttpClient);
        Page<Profile> page = mollieApiClient.profiles().all();
        Assertions.assertEquals(5, page.getCount());
        assertEquals(Profile.class, page.getItems().get(0).getClass());
    }
}
