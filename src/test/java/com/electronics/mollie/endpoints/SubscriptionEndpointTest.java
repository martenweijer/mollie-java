package com.electronics.mollie.endpoints;

import com.electronics.mollie.MollieApiClient;
import com.electronics.mollie.exceptions.MollieException;
import com.electronics.mollie.http.MollieHttpClient;
import com.electronics.mollie.resources.Subscription;
import com.electronics.mollie.resources.Page;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SubscriptionEndpointTest {
    @Test
    void getSubscription() throws MollieException {
        MollieHttpClient mollieHttpClient = mock(MollieHttpClient.class);
        when(mollieHttpClient.get(anyString())).thenReturn("{\n" +
                "    \"resource\": \"subscription\",\n" +
                "    \"id\": \"sub_rVKGtNd6s3\",\n" +
                "    \"mode\": \"live\",\n" +
                "    \"createdAt\": \"2016-06-01T12:23:34+00:00\",\n" +
                "    \"status\": \"active\",\n" +
                "    \"amount\": {\n" +
                "        \"value\": \"25.00\",\n" +
                "        \"currency\": \"EUR\"\n" +
                "    },\n" +
                "    \"times\": 4,\n" +
                "    \"timesRemaining\": 4,\n" +
                "    \"interval\": \"3 months\",\n" +
                "    \"startDate\": \"2016-06-01\",\n" +
                "    \"nextPaymentDate\": \"2016-09-01\",\n" +
                "    \"description\": \"Quarterly payment\",\n" +
                "    \"method\": null,\n" +
                "    \"mandateId\": \"mdt_38HS4fsS\",\n" +
                "    \"webhookUrl\": \"https://webshop.example.org/payments/webhook\",\n" +
                "    \"metadata\": {\n" +
                "        \"plan\": \"small\"\n" +
                "    },\n" +
                "    \"_links\": {\n" +
                "        \"self\": {\n" +
                "            \"href\": \"https://api.mollie.com/v2/customers/cst_stTC2WHAuS/subscriptions/sub_rVKGtNd6s3\",\n" +
                "            \"type\": \"application/hal+json\"\n" +
                "        },\n" +
                "        \"customer\": {\n" +
                "            \"href\": \"https://api.mollie.com/v2/customers/cst_stTC2WHAuS\",\n" +
                "            \"type\": \"application/hal+json\"\n" +
                "        },\n" +
                "        \"profile\": {\n" +
                "            \"href\": \"https://api.mollie.com/v2/profiles/pfl_URR55HPMGx\",\n" +
                "            \"type\": \"application/hal+json\"\n" +
                "        },\n" +
                "       \"payments\": {\n" +
                "            \"href\": \"https://api.mollie.com/v2/customers/cst_stTC2WHAuS/subscriptions/sub_rVKGtNd6s3/payments\",\n" +
                "            \"type\": \"application/hal+json\"\n" +
                "        },\n" +
                "        \"documentation\": {\n" +
                "            \"href\": \"https://docs.mollie.com/reference/v2/subscriptions-api/get-subscription\",\n" +
                "            \"type\": \"text/html\"\n" +
                "        }\n" +
                "    }\n" +
                "}");

        MollieApiClient mollieApiClient = new MollieApiClient(mollieHttpClient);
        Subscription subscription = mollieApiClient.subscriptions().get("foo", "bar");
        Assertions.assertNotNull(subscription);
        Assertions.assertEquals("sub_rVKGtNd6s3", subscription.getId());
    }

    @Test
    void createSubscription() throws MollieException {
        MollieHttpClient mollieHttpClient = mock(MollieHttpClient.class);
        when(mollieHttpClient.post(anyString(), anyString())).thenReturn("{\n" +
                "    \"resource\": \"subscription\",\n" +
                "    \"id\": \"sub_rVKGtNd6s3\",\n" +
                "    \"mode\": \"live\",\n" +
                "    \"createdAt\": \"2018-06-01T12:23:34+00:00\",\n" +
                "    \"status\": \"active\",\n" +
                "    \"amount\": {\n" +
                "        \"value\": \"25.00\",\n" +
                "        \"currency\": \"EUR\"\n" +
                "    },\n" +
                "    \"times\": 4,\n" +
                "    \"timesRemaining\": 4,\n" +
                "    \"interval\": \"3 months\",\n" +
                "    \"description\": \"Quarterly payment\",\n" +
                "    \"startDate\": \"2018-06-01\",\n" +
                "    \"nextPaymentDate\": \"2018-09-01\",\n" +
                "    \"method\": null,\n" +
                "    \"webhookUrl\": \"https://webshop.example.org/subscriptions/webhook/\",\n" +
                "    \"_links\": {\n" +
                "        \"self\": {\n" +
                "            \"href\": \"https://api.mollie.com/v2/customers/cst_stTC2WHAuS/subscriptions/sub_rVKGtNd6s3\",\n" +
                "            \"type\": \"application/hal+json\"\n" +
                "        },\n" +
                "        \"customer\": {\n" +
                "            \"href\": \"https://api.mollie.com/v2/customers/cst_stTC2WHAuS\",\n" +
                "            \"type\": \"application/hal+json\"\n" +
                "        },\n" +
                "        \"profile\": {\n" +
                "            \"href\": \"https://api.mollie.com/v2/profiles/pfl_URR55HPMGx\",\n" +
                "            \"type\": \"application/hal+json\"\n" +
                "        },\n" +
                "        \"documentation\": {\n" +
                "            \"href\": \"https://docs.mollie.com/reference/v2/subscriptions-api/create-subscription\",\n" +
                "            \"type\": \"text/html\"\n" +
                "        }\n" +
                "    }\n" +
                "}");

        Subscription subscription = new Subscription();

        MollieApiClient mollieApiClient = new MollieApiClient(mollieHttpClient);
        Subscription result = mollieApiClient.subscriptions().create("foo", subscription);
        Assertions.assertNotNull(result);
        Assertions.assertEquals("sub_rVKGtNd6s3", result.getId());
    }

    @Test
    void cancelSubscription() throws MollieException {
        MollieHttpClient mollieHttpClient = mock(MollieHttpClient.class);
        when(mollieHttpClient.delete(anyString())).thenReturn("{\n" +
                "    \"resource\": \"subscription\",\n" +
                "    \"id\": \"sub_rVKGtNd6s3\",\n" +
                "    \"mode\": \"live\",\n" +
                "    \"createdAt\": \"2018-06-01T12:23:34+00:00\",\n" +
                "    \"status\": \"canceled\",\n" +
                "    \"amount\": {\n" +
                "        \"value\": \"25.00\",\n" +
                "        \"currency\": \"EUR\"\n" +
                "    },\n" +
                "    \"times\": 4,\n" +
                "    \"interval\": \"3 months\",\n" +
                "    \"nextPaymentDate\": null,\n" +
                "    \"description\": \"Quarterly payment\",\n" +
                "    \"method\": null,\n" +
                "    \"startDate\": \"2016-06-01\",\n" +
                "    \"webhookUrl\": \"https://webshop.example.org/payments/webhook\",\n" +
                "    \"canceledAt\": \"2018-08-01T11:04:21+00:00\",\n" +
                "    \"_links\": {\n" +
                "        \"self\": {\n" +
                "            \"href\": \"https://api.mollie.com/v2/customers/cst_stTC2WHAuS/subscriptions/sub_rVKGtNd6s3\",\n" +
                "            \"type\": \"application/hal+json\"\n" +
                "        },\n" +
                "        \"customer\": {\n" +
                "            \"href\": \"https://api.mollie.com/v2/customers/cst_stTC2WHAuS\",\n" +
                "            \"type\": \"application/hal+json\"\n" +
                "        },\n" +
                "        \"documentation\": {\n" +
                "            \"href\": \"https://docs.mollie.com/reference/v2/subscriptions-api/cancel-subscription\",\n" +
                "            \"type\": \"text/html\"\n" +
                "        }\n" +
                "    }\n" +
                "}");

        MollieApiClient mollieApiClient = new MollieApiClient(mollieHttpClient);
        mollieApiClient.subscriptions().cancel("foo", "bar");
    }

    @Test
    void allSubscriptions() throws MollieException {
        MollieHttpClient mollieHttpClient = mock(MollieHttpClient.class);
        when(mollieHttpClient.get(anyString())).thenReturn("{\n" +
                "    \"count\": 3,\n" +
                "    \"_embedded\": {\n" +
                "        \"subscriptions\": [\n" +
                "            {\n" +
                "                \"resource\": \"subscription\",\n" +
                "                \"id\": \"sub_rVKGtNd6s3\",\n" +
                "                \"mode\": \"live\",\n" +
                "                \"createdAt\": \"2018-06-01T12:23:34+00:00\",\n" +
                "                \"status\": \"active\",\n" +
                "                \"amount\": {\n" +
                "                    \"value\": \"25.00\",\n" +
                "                    \"currency\": \"EUR\"\n" +
                "                },\n" +
                "                \"times\": 4,\n" +
                "                \"timesRemaining\": 3,\n" +
                "                \"interval\": \"3 months\",\n" +
                "                \"startDate\": \"2016-06-01\",\n" +
                "                \"nextPaymentDate\": \"2016-09-01\",\n" +
                "                \"description\": \"Quarterly payment\",\n" +
                "                \"method\": null,\n" +
                "                \"webhookUrl\": \"https://webshop.example.org/subscriptions/webhook\",\n" +
                "                \"_links\": {\n" +
                "                    \"self\": {\n" +
                "                        \"href\": \"https://api.mollie.com/v2/customers/cst_stTC2WHAuS/subscriptions/sub_rVKGtNd6s3\",\n" +
                "                        \"type\": \"application/hal+json\"\n" +
                "                    },\n" +
                "                    \"profile\": {\n" +
                "                        \"href\": \"https://api.mollie.com/v2/profiles/pfl_URR55HPMGx\",\n" +
                "                        \"type\": \"application/hal+json\"\n" +
                "                    },\n" +
                "                    \"customer\": {\n" +
                "                        \"href\": \"https://api.mollie.com/v2/customers/cst_stTC2WHAuS\",\n" +
                "                        \"type\": \"application/hal+json\"\n" +
                "                    }\n" +
                "                }\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"_links\": {\n" +
                "        \"self\": {\n" +
                "            \"href\": \"https://api.mollie.com/v2/customers/cst_stTC2WHAuS/subscriptions\",\n" +
                "            \"type\": \"application/hal+json\"\n" +
                "        },\n" +
                "        \"previous\": null,\n" +
                "        \"next\": {\n" +
                "            \"href\": \"https://api.mollie.com/v2/customers/cst_stTC2WHAuS/subscriptions?from=sub_mnfbwhMfvo\",\n" +
                "            \"type\": \"application/hal+json\"\n" +
                "        },\n" +
                "        \"documentation\": {\n" +
                "            \"href\": \"https://docs.mollie.com/reference/v2/subscriptions-api/list-subscriptions\",\n" +
                "            \"type\": \"text/html\"\n" +
                "        }\n" +
                "    }\n" +
                "}");

        MollieApiClient mollieApiClient = new MollieApiClient(mollieHttpClient);
        Page<Subscription> page = mollieApiClient.subscriptions().all("foo");
        Assertions.assertEquals(3, page.getCount());
        assertEquals(Subscription.class, page.getItems().get(0).getClass());
    }
}
