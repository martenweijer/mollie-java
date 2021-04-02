package com.electronics.mollie.endpoints;

import com.electronics.mollie.MollieApiClient;
import com.electronics.mollie.exceptions.MollieException;
import com.electronics.mollie.http.MollieHttpClient;
import com.electronics.mollie.resources.Settlement;
import com.electronics.mollie.resources.Page;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SettlementEndpointTest {
    @Test
    void getSettlement() throws MollieException {
        MollieHttpClient mollieHttpClient = mock(MollieHttpClient.class);
        when(mollieHttpClient.get(anyString())).thenReturn("{\n" +
                "    \"resource\": \"settlement\",\n" +
                "    \"id\": \"stl_jDk30akdN\",\n" +
                "    \"reference\": \"1234567.1804.03\",\n" +
                "    \"createdAt\": \"2018-04-06T06:00:01.0Z\",\n" +
                "    \"settledAt\": \"2018-04-06T09:41:44.0Z\",\n" +
                "    \"status\": \"paidout\",\n" +
                "    \"amount\": {\n" +
                "        \"value\": \"39.75\",\n" +
                "        \"currency\": \"EUR\"\n" +
                "    },\n" +
                "    \"periods\": {\n" +
                "        \"2018\": {\n" +
                "            \"04\": {\n" +
                "                \"revenue\": [\n" +
                "                    {\n" +
                "                        \"description\": \"iDEAL\",\n" +
                "                        \"method\": \"ideal\",\n" +
                "                        \"count\": 6,\n" +
                "                        \"amountNet\": {\n" +
                "                            \"value\": \"86.1000\",\n" +
                "                            \"currency\": \"EUR\"\n" +
                "                        },\n" +
                "                        \"amountVat\": null,\n" +
                "                        \"amountGross\": {\n" +
                "                            \"value\": \"86.1000\",\n" +
                "                            \"currency\": \"EUR\"\n" +
                "                        }\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"description\": \"Refunds iDEAL\",\n" +
                "                        \"method\": \"refund\",\n" +
                "                        \"count\": 2,\n" +
                "                        \"amountNet\": {\n" +
                "                            \"value\": \"-43.2000\",\n" +
                "                            \"currency\": \"EUR\"\n" +
                "                        },\n" +
                "                        \"amountVat\": null,\n" +
                "                        \"amountGross\": {\n" +
                "                            \"value\": \"43.2000\",\n" +
                "                            \"currency\": \"EUR\"\n" +
                "                        }\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"costs\": [\n" +
                "                    {\n" +
                "                        \"description\": \"iDEAL\",\n" +
                "                        \"method\": \"ideal\",\n" +
                "                        \"count\": 6,\n" +
                "                        \"rate\": {\n" +
                "                            \"fixed\": {\n" +
                "                                \"value\": \"0.3500\",\n" +
                "                                \"currency\": \"EUR\"\n" +
                "                            },\n" +
                "                            \"percentage\": null\n" +
                "                        },\n" +
                "                        \"amountNet\": {\n" +
                "                            \"value\": \"2.1000\",\n" +
                "                            \"currency\": \"EUR\"\n" +
                "                        },\n" +
                "                        \"amountVat\": {\n" +
                "                            \"value\": \"0.4410\",\n" +
                "                            \"currency\": \"EUR\"\n" +
                "                        },\n" +
                "                        \"amountGross\": {\n" +
                "                            \"value\": \"2.5410\",\n" +
                "                            \"currency\": \"EUR\"\n" +
                "                        }\n" +
                "                    },\n" +
                "                    {\n" +
                "                        \"description\": \"Refunds iDEAL\",\n" +
                "                        \"method\": \"refund\",\n" +
                "                        \"count\": 2,\n" +
                "                        \"rate\": {\n" +
                "                            \"fixed\": {\n" +
                "                                \"value\": \"0.2500\",\n" +
                "                                \"currency\": \"EUR\"\n" +
                "                            },\n" +
                "                            \"percentage\": null\n" +
                "                        },\n" +
                "                        \"amountNet\": {\n" +
                "                            \"value\": \"0.5000\",\n" +
                "                            \"currency\": \"EUR\"\n" +
                "                        },\n" +
                "                        \"amountVat\": {\n" +
                "                            \"value\": \"0.1050\",\n" +
                "                            \"currency\": \"EUR\"\n" +
                "                        },\n" +
                "                        \"amountGross\": {\n" +
                "                            \"value\": \"0.6050\",\n" +
                "                            \"currency\": \"EUR\"\n" +
                "                        }\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"invoiceId\": \"inv_FrvewDA3Pr\"\n" +
                "            }\n" +
                "        }\n" +
                "    },\n" +
                "    \"invoiceId\": \"inv_FrvewDA3Pr\",\n" +
                "    \"_links\": {\n" +
                "        \"self\": {\n" +
                "            \"href\": \"https://api.mollie.com/v2/settlements/stl_jDk30akdN\",\n" +
                "            \"type\": \"application/hal+json\"\n" +
                "        },\n" +
                "        \"invoice\": {\n" +
                "             \"href\": \"https://api.mollie.com/v2/invoices/inv_FrvewDA3Pr\",\n" +
                "             \"type\": \"application/hal+json\"\n" +
                "        },\n" +
                "        \"payments\": {\n" +
                "            \"href\": \"https://api.mollie.com/v2/settlements/stl_jDk30akdN/payments\",\n" +
                "            \"type\": \"application/hal+json\"\n" +
                "        },\n" +
                "        \"refunds\": {\n" +
                "            \"href\": \"https://api.mollie.com/v2/settlements/stl_jDk30akdN/refunds\",\n" +
                "            \"type\": \"application/hal+json\"\n" +
                "        },\n" +
                "        \"chargebacks\": {\n" +
                "            \"href\": \"https://api.mollie.com/v2/settlements/stl_jDk30akdN/chargebacks\",\n" +
                "            \"type\": \"application/hal+json\"\n" +
                "        },\n" +
                "        \"captures\": {\n" +
                "            \"href\": \"https://api.mollie.com/v2/settlements/stl_jDk30akdN/captures\",\n" +
                "            \"type\": \"application/hal+json\"\n" +
                "        },\n" +
                "        \"documentation\": {\n" +
                "            \"href\": \"https://docs.mollie.com/reference/v2/settlements-api/get-settlement\",\n" +
                "            \"type\": \"text/html\"\n" +
                "        }\n" +
                "    }\n" +
                "}");

        MollieApiClient mollieApiClient = new MollieApiClient(mollieHttpClient);
        Settlement settlement = mollieApiClient.settlements().get("foo");
        Assertions.assertNotNull(settlement);
        Assertions.assertEquals("stl_jDk30akdN", settlement.getId());
    }

    @Test
    void allSettlements() throws MollieException {
        MollieHttpClient mollieHttpClient = mock(MollieHttpClient.class);
        when(mollieHttpClient.get(anyString())).thenReturn("{\n" +
                "     \"_embedded\": {\n" +
                "         \"settlements\": [\n" +
                "             {\n" +
                "                 \"resource\": \"settlement\",\n" +
                "                 \"id\": \"stl_77zGEcWNhg\",\n" +
                "                 \"reference\": \"3331641.1911.01\",\n" +
                "                 \"createdAt\": \"2019-11-21T05:02:00+00:00\",\n" +
                "                 \"settledAt\": \"2019-11-20T23:00:00+00:00\",\n" +
                "                 \"status\": \"paidout\",\n" +
                "                 \"amount\": {\n" +
                "                     \"value\": \"9200.34\",\n" +
                "                     \"currency\": \"EUR\"\n" +
                "                 },\n" +
                "                 \"periods\": {\n" +
                "                     \"2019\": {\n" +
                "                         \"11\": {\n" +
                "                             \"revenue\": [],\n" +
                "                             \"costs\": []\n" +
                "                         }\n" +
                "                     }\n" +
                "                 },\n" +
                "                 \"_links\": {\n" +
                "                     \"self\": {\n" +
                "                         \"href\": \"https://api.mollie.com/v2/settlements/stl_77zGEcWNhg\",\n" +
                "                         \"type\": \"application/hal+json\"\n" +
                "                     },\n" +
                "                     \"payments\": {\n" +
                "                         \"href\": \"https://api.mollie.com/v2/settlements/stl_77zGEcWNhg/payments\",\n" +
                "                         \"type\": \"application/hal+json\"\n" +
                "                     },\n" +
                "                     \"refunds\": {\n" +
                "                         \"href\": \"https://api.mollie.com/v2/settlements/stl_77zGEcWNhg/refunds\",\n" +
                "                         \"type\": \"application/hal+json\"\n" +
                "                     },\n" +
                "                     \"chargebacks\": {\n" +
                "                         \"href\": \"https://api.mollie.com/v2/settlements/stl_77zGEcWNhg/chargebacks\",\n" +
                "                         \"type\": \"application/hal+json\"\n" +
                "                     },\n" +
                "                     \"captures\": {\n" +
                "                       \"href\": \"https://api.mollie.com/v2/settlements/stl_77zGEcWNhg/captures\",\n" +
                "                       \"type\": \"application/hal+json\"\n" +
                "                     }\n" +
                "                 }\n" +
                "             },\n" +
                "             {\n" +
                "                 \"resource\": \"settlement\",\n" +
                "                 \"id\": \"stl_r8FVT3rxGx\",\n" +
                "                 \"reference\": \"6551641.1911.01\",\n" +
                "                 \"createdAt\": \"2019-10-21T05:02:00+00:00\",\n" +
                "                 \"settledAt\": \"2019-10-20T23:00:00+00:00\",\n" +
                "                 \"status\": \"paidout\",\n" +
                "                 \"amount\": {\n" +
                "                     \"value\": \"10200.99\",\n" +
                "                     \"currency\": \"EUR\"\n" +
                "                 },\n" +
                "                 \"periods\": {\n" +
                "                     \"2019\": {\n" +
                "                         \"10\": {\n" +
                "                             \"revenue\": [\n" +
                "                                 {\n" +
                "                                     \"description\": \"SEPA-incasso\",\n" +
                "                                     \"method\": \"directdebit\",\n" +
                "                                     \"count\": 459,\n" +
                "                                     \"amountNet\": {\n" +
                "                                         \"value\": \"10312.50\",\n" +
                "                                         \"currency\": \"EUR\"\n" +
                "                                     },\n" +
                "                                     \"amountVat\": null,\n" +
                "                                     \"amountGross\": {\n" +
                "                                         \"value\": \"10312.50\",\n" +
                "                                         \"currency\": \"EUR\"\n" +
                "                                     }\n" +
                "                                 },\n" +
                "                                 {\n" +
                "                                     \"description\": \"SEPA-incasso weigeringen\",\n" +
                "                                     \"method\": \"directdebit\",\n" +
                "                                     \"count\": 5,\n" +
                "                                     \"amountNet\": {\n" +
                "                                         \"value\": \"-111.50\",\n" +
                "                                         \"currency\": \"EUR\"\n" +
                "                                     },\n" +
                "                                     \"amountVat\": null,\n" +
                "                                     \"amountGross\": {\n" +
                "                                         \"value\": \"-111.50\",\n" +
                "                                         \"currency\": \"EUR\"\n" +
                "                                     }\n" +
                "                                 }\n" +
                "                             ],\n" +
                "                             \"costs\": [\n" +
                "                                 {\n" +
                "                                     \"description\": \"SEPA-incasso storneringen\",\n" +
                "                                     \"method\": null,\n" +
                "                                     \"count\": 12,\n" +
                "                                     \"rate\": {\n" +
                "                                         \"fixed\": {\n" +
                "                                             \"value\": \"0.45\",\n" +
                "                                             \"currency\": \"EUR\"\n" +
                "                                         },\n" +
                "                                         \"percentage\": \"0\"\n" +
                "                                     },\n" +
                "                                     \"amountNet\": {\n" +
                "                                         \"value\": \"5.40\",\n" +
                "                                         \"currency\": \"EUR\"\n" +
                "                                     },\n" +
                "                                     \"amountVat\": {\n" +
                "                                         \"value\": \"1.134\",\n" +
                "                                         \"currency\": \"EUR\"\n" +
                "                                     },\n" +
                "                                     \"amountGross\": {\n" +
                "                                         \"value\": \"6.534\",\n" +
                "                                         \"currency\": \"EUR\"\n" +
                "                                     }\n" +
                "                                 }\n" +
                "                             ],\n" +
                "                             \"invoiceId\": \"inv_M8Sa6n5mf3\"\n" +
                "                         }\n" +
                "                     }\n" +
                "                 },\n" +
                "                 \"invoiceId\": \"inv_M8Sa6n5mf3\",\n" +
                "                 \"_links\": {\n" +
                "                     \"self\": {\n" +
                "                         \"href\": \"https://api.mollie.com/v2/settlements/stl_r8FVT3rxGx\",\n" +
                "                         \"type\": \"application/hal+json\"\n" +
                "                     },\n" +
                "                     \"invoice\": {\n" +
                "                         \"href\": \"https://api.mollie.com/v2/invoices/inv_M8Sa6n5mf3\",\n" +
                "                         \"type\": \"application/hal+json\"\n" +
                "                     },\n" +
                "                     \"payments\": {\n" +
                "                         \"href\": \"https://api.mollie.com/v2/settlements/stl_r8FVT3rxGx/payments\",\n" +
                "                         \"type\": \"application/hal+json\"\n" +
                "                     },\n" +
                "                     \"refunds\": {\n" +
                "                         \"href\": \"https://api.mollie.com/v2/settlements/stl_r8FVT3rxGx/refunds\",\n" +
                "                         \"type\": \"application/hal+json\"\n" +
                "                     },\n" +
                "                     \"chargebacks\": {\n" +
                "                         \"href\": \"https://api.mollie.com/v2/settlements/stl_r8FVT3rxGx/chargebacks\",\n" +
                "                         \"type\": \"application/hal+json\"\n" +
                "                     },\n" +
                "                     \"captures\": {\n" +
                "                         \"href\": \"https://api.mollie.com/v2/settlements/stl_r8FVT3rxGx/captures\",\n" +
                "                         \"type\": \"application/hal+json\"\n" +
                "                     }\n" +
                "                 }\n" +
                "             }\n" +
                "         ]\n" +
                "     },\n" +
                "     \"count\": 3,\n" +
                "     \"_links\": {\n" +
                "         \"documentation\": {\n" +
                "             \"href\": \"https://docs.mollie.com/reference/v2/settlements-api/list-settlements\",\n" +
                "             \"type\": \"text/html\"\n" +
                "         },\n" +
                "         \"self\": {\n" +
                "             \"href\": \"https://api.mollie.com/v2/settlements?limit=50\",\n" +
                "             \"type\": \"application/hal+json\"\n" +
                "         },\n" +
                "         \"previous\": null,\n" +
                "         \"next\": null\n" +
                "     }\n" +
                " }");

        MollieApiClient mollieApiClient = new MollieApiClient(mollieHttpClient);
        Page<Settlement> page = mollieApiClient.settlements().all();
        Assertions.assertEquals(3, page.getCount());
        assertEquals(Settlement.class, page.getItems().get(0).getClass());
    }
}
