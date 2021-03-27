package com.electronics.mollie.endpoints;

import com.electronics.mollie.MollieApiClient;
import com.electronics.mollie.exceptions.MollieException;
import com.electronics.mollie.http.MollieHttpClient;
import com.electronics.mollie.resources.Page;
import com.electronics.mollie.resources.Shipment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ShipmentEndpointTest {
    @Test
    void getShipment() throws MollieException {
        MollieHttpClient mollieHttpClient = mock(MollieHttpClient.class);
        when(mollieHttpClient.get(anyString())).thenReturn("{\n" +
                "     \"resource\": \"shipment\",\n" +
                "     \"id\": \"shp_3wmsgCJN4U\",\n" +
                "     \"orderId\": \"ord_kEn1PlbGa\",\n" +
                "     \"createdAt\": \"2018-08-09T14:33:54+00:00\",\n" +
                "     \"tracking\": {\n" +
                "         \"carrier\": \"PostNL\",\n" +
                "         \"code\": \"3SKABA000000000\",\n" +
                "         \"url\": \"http://postnl.nl/tracktrace/?B=3SKABA000000000&P=1015CW&D=NL&T=C\"\n" +
                "     },\n" +
                "     \"lines\": [\n" +
                "         {\n" +
                "             \"resource\": \"orderline\",\n" +
                "             \"id\": \"odl_dgtxyl\",\n" +
                "             \"orderId\": \"ord_pbjz8x\",\n" +
                "             \"name\": \"LEGO 42083 Bugatti Chiron\",\n" +
                "             \"sku\": \"5702016116977\",\n" +
                "             \"type\": \"physical\",\n" +
                "             \"status\": \"shipping\",\n" +
                "             \"metadata\": null,\n" +
                "             \"isCancelable\": true,\n" +
                "             \"quantity\": 1,\n" +
                "             \"unitPrice\": {\n" +
                "                 \"value\": \"399.00\",\n" +
                "                 \"currency\": \"EUR\"\n" +
                "             },\n" +
                "             \"vatRate\": \"21.00\",\n" +
                "             \"vatAmount\": {\n" +
                "                 \"value\": \"51.89\",\n" +
                "                 \"currency\": \"EUR\"\n" +
                "             },\n" +
                "             \"discountAmount\": {\n" +
                "                 \"value\": \"100.00\",\n" +
                "                 \"currency\": \"EUR\"\n" +
                "             },\n" +
                "             \"totalAmount\": {\n" +
                "                 \"value\": \"299.00\",\n" +
                "                 \"currency\": \"EUR\"\n" +
                "             },\n" +
                "             \"createdAt\": \"2018-08-02T09:29:56+00:00\",\n" +
                "             \"_links\": {\n" +
                "                 \"productUrl\": {\n" +
                "                     \"href\": \"https://shop.lego.com/nl-NL/Bugatti-Chiron-42083\",\n" +
                "                     \"type\": \"text/html\"\n" +
                "                 },\n" +
                "                 \"imageUrl\": {\n" +
                "                     \"href\": \"https://sh-s7-live-s.legocdn.com/is/image//LEGO/42083_alt1?$main$\",\n" +
                "                     \"type\": \"text/html\"\n" +
                "                 }\n" +
                "             }\n" +
                "         },\n" +
                "         {\n" +
                "             \"resource\": \"orderline\",\n" +
                "             \"id\": \"odl_jp31jz\",\n" +
                "             \"orderId\": \"ord_pbjz8x\",\n" +
                "             \"name\": \"LEGO 42056 Porsche 911 GT3 RS\",\n" +
                "             \"sku\": \"5702015594028\",\n" +
                "             \"type\": \"physical\",\n" +
                "             \"status\": \"completed\",\n" +
                "             \"metadata\": null,\n" +
                "             \"isCancelable\": false,\n" +
                "             \"quantity\": 1,\n" +
                "             \"unitPrice\": {\n" +
                "                 \"value\": \"329.99\",\n" +
                "                 \"currency\": \"EUR\"\n" +
                "             },\n" +
                "             \"vatRate\": \"21.00\",\n" +
                "             \"vatAmount\": {\n" +
                "                 \"value\": \"57.27\",\n" +
                "                 \"currency\": \"EUR\"\n" +
                "             },\n" +
                "             \"totalAmount\": {\n" +
                "                 \"value\": \"329.99\",\n" +
                "                 \"currency\": \"EUR\"\n" +
                "             },\n" +
                "             \"createdAt\": \"2018-08-02T09:29:56+00:00\",\n" +
                "             \"_links\": {\n" +
                "                 \"productUrl\": {\n" +
                "                     \"href\": \"https://shop.lego.com/nl-NL/Porsche-911-GT3-RS-42056\",\n" +
                "                     \"type\": \"text/html\"\n" +
                "                 },\n" +
                "                 \"imageUrl\": {\n" +
                "                     \"href\": \"https://sh-s7-live-s.legocdn.com/is/image/LEGO/42056?$PDPDefault$\",\n" +
                "                     \"type\": \"text/html\"\n" +
                "                 }\n" +
                "             }\n" +
                "         }\n" +
                "     ],\n" +
                "     \"_links\": {\n" +
                "         \"self\": {\n" +
                "             \"href\": \"https://api.mollie.com/v2/order/ord_kEn1PlbGa/shipments/shp_3wmsgCJN4U\",\n" +
                "             \"type\": \"application/hal+json\"\n" +
                "         },\n" +
                "         \"order\": {\n" +
                "             \"href\": \"https://api.mollie.com/v2/orders/ord_kEn1PlbGa\",\n" +
                "             \"type\": \"application/hal+json\"\n" +
                "         },\n" +
                "         \"documentation\": {\n" +
                "             \"href\": \"https://docs.mollie.com/reference/v2/shipments-api/get-shipment\",\n" +
                "             \"type\": \"text/html\"\n" +
                "         }\n" +
                "     }\n" +
                " }");

        MollieApiClient mollieApiClient = new MollieApiClient(mollieHttpClient);
        Shipment shipment = mollieApiClient.shipments().get("foo", "bar");
        Assertions.assertNotNull(shipment);
        Assertions.assertEquals("shp_3wmsgCJN4U", shipment.getId());
    }

    @Test
    void createShipment() throws MollieException {
        MollieHttpClient mollieHttpClient = mock(MollieHttpClient.class);
        when(mollieHttpClient.post(anyString(), anyString())).thenReturn("{\n" +
                "     \"resource\": \"shipment\",\n" +
                "     \"id\": \"shp_3wmsgCJN4U\",\n" +
                "     \"orderId\": \"ord_kEn1PlbGa\",\n" +
                "     \"createdAt\": \"2018-08-09T14:33:54+00:00\",\n" +
                "     \"tracking\": {\n" +
                "         \"carrier\": \"PostNL\",\n" +
                "         \"code\": \"3SKABA000000000\",\n" +
                "         \"url\": \"http://postnl.nl/tracktrace/?B=3SKABA000000000&P=1015CW&D=NL&T=C\"\n" +
                "     },\n" +
                "     \"lines\": [\n" +
                "         {\n" +
                "             \"resource\": \"orderline\",\n" +
                "             \"id\": \"odl_dgtxyl\",\n" +
                "             \"orderId\": \"ord_pbjz8x\",\n" +
                "             \"name\": \"LEGO 42083 Bugatti Chiron\",\n" +
                "             \"sku\": \"5702016116977\",\n" +
                "             \"type\": \"physical\",\n" +
                "             \"status\": \"shipping\",\n" +
                "             \"metadata\": null,\n" +
                "             \"isCancelable\": true,\n" +
                "             \"quantity\": 1,\n" +
                "             \"unitPrice\": {\n" +
                "                 \"value\": \"399.00\",\n" +
                "                 \"currency\": \"EUR\"\n" +
                "             },\n" +
                "             \"vatRate\": \"21.00\",\n" +
                "             \"vatAmount\": {\n" +
                "                 \"value\": \"51.89\",\n" +
                "                 \"currency\": \"EUR\"\n" +
                "             },\n" +
                "             \"discountAmount\": {\n" +
                "                 \"value\": \"100.00\",\n" +
                "                 \"currency\": \"EUR\"\n" +
                "             },\n" +
                "             \"totalAmount\": {\n" +
                "                 \"value\": \"299.00\",\n" +
                "                 \"currency\": \"EUR\"\n" +
                "             },\n" +
                "             \"createdAt\": \"2018-08-02T09:29:56+00:00\",\n" +
                "             \"_links\": {\n" +
                "                 \"productUrl\": {\n" +
                "                     \"href\": \"https://shop.lego.com/nl-NL/Bugatti-Chiron-42083\",\n" +
                "                     \"type\": \"text/html\"\n" +
                "                 },\n" +
                "                 \"imageUrl\": {\n" +
                "                     \"href\": \"https://sh-s7-live-s.legocdn.com/is/image//LEGO/42083_alt1?$main$\",\n" +
                "                     \"type\": \"text/html\"\n" +
                "                 }\n" +
                "             }\n" +
                "         },\n" +
                "         {\n" +
                "             \"resource\": \"orderline\",\n" +
                "             \"id\": \"odl_jp31jz\",\n" +
                "             \"orderId\": \"ord_pbjz8x\",\n" +
                "             \"name\": \"LEGO 42056 Porsche 911 GT3 RS\",\n" +
                "             \"sku\": \"5702015594028\",\n" +
                "             \"type\": \"physical\",\n" +
                "             \"status\": \"completed\",\n" +
                "             \"metadata\": null,\n" +
                "             \"isCancelable\": false,\n" +
                "             \"quantity\": 1,\n" +
                "             \"unitPrice\": {\n" +
                "                 \"value\": \"329.99\",\n" +
                "                 \"currency\": \"EUR\"\n" +
                "             },\n" +
                "             \"vatRate\": \"21.00\",\n" +
                "             \"vatAmount\": {\n" +
                "                 \"value\": \"57.27\",\n" +
                "                 \"currency\": \"EUR\"\n" +
                "             },\n" +
                "             \"totalAmount\": {\n" +
                "                 \"value\": \"329.99\",\n" +
                "                 \"currency\": \"EUR\"\n" +
                "             },\n" +
                "             \"createdAt\": \"2018-08-02T09:29:56+00:00\",\n" +
                "             \"_links\": {\n" +
                "                 \"productUrl\": {\n" +
                "                     \"href\": \"https://shop.lego.com/nl-NL/Porsche-911-GT3-RS-42056\",\n" +
                "                     \"type\": \"text/html\"\n" +
                "                 },\n" +
                "                 \"imageUrl\": {\n" +
                "                     \"href\": \"https://sh-s7-live-s.legocdn.com/is/image/LEGO/42056?$PDPDefault$\",\n" +
                "                     \"type\": \"text/html\"\n" +
                "                 }\n" +
                "             }\n" +
                "         }\n" +
                "     ],\n" +
                "     \"_links\": {\n" +
                "         \"self\": {\n" +
                "             \"href\": \"https://api.mollie.com/v2/order/ord_kEn1PlbGa/shipments/shp_3wmsgCJN4U\",\n" +
                "             \"type\": \"application/hal+json\"\n" +
                "         },\n" +
                "         \"order\": {\n" +
                "             \"href\": \"https://api.mollie.com/v2/orders/ord_kEn1PlbGa\",\n" +
                "             \"type\": \"application/hal+json\"\n" +
                "         },\n" +
                "         \"documentation\": {\n" +
                "             \"href\": \"https://docs.mollie.com/reference/v2/shipments-api/get-shipment\",\n" +
                "             \"type\": \"text/html\"\n" +
                "         }\n" +
                "     }\n" +
                " }");

        Shipment shipment = new Shipment();

        MollieApiClient mollieApiClient = new MollieApiClient(mollieHttpClient);
        Shipment result = mollieApiClient.shipments().create("foo", shipment);
        Assertions.assertNotNull(result);
        Assertions.assertEquals("shp_3wmsgCJN4U", result.getId());
    }

    @Test
    void updateShipment() throws MollieException {
        MollieHttpClient mollieHttpClient = mock(MollieHttpClient.class);
        when(mollieHttpClient.patch(anyString(), anyString())).thenReturn("{\n" +
                "     \"resource\": \"shipment\",\n" +
                "     \"id\": \"shp_3wmsgCJN4U\",\n" +
                "     \"orderId\": \"ord_kEn1PlbGa\",\n" +
                "     \"createdAt\": \"2018-08-09T14:33:54+00:00\",\n" +
                "     \"tracking\": {\n" +
                "         \"carrier\": \"PostNL\",\n" +
                "         \"code\": \"3SKABA000000000\",\n" +
                "         \"url\": \"http://postnl.nl/tracktrace/?B=3SKABA000000000&P=1015CW&D=NL&T=C\"\n" +
                "     },\n" +
                "     \"lines\": [\n" +
                "         {\n" +
                "             \"resource\": \"orderline\",\n" +
                "             \"id\": \"odl_dgtxyl\",\n" +
                "             \"orderId\": \"ord_pbjz8x\",\n" +
                "             \"name\": \"LEGO 42083 Bugatti Chiron\",\n" +
                "             \"sku\": \"5702016116977\",\n" +
                "             \"type\": \"physical\",\n" +
                "             \"status\": \"shipping\",\n" +
                "             \"metadata\": null,\n" +
                "             \"isCancelable\": true,\n" +
                "             \"quantity\": 1,\n" +
                "             \"unitPrice\": {\n" +
                "                 \"value\": \"399.00\",\n" +
                "                 \"currency\": \"EUR\"\n" +
                "             },\n" +
                "             \"vatRate\": \"21.00\",\n" +
                "             \"vatAmount\": {\n" +
                "                 \"value\": \"51.89\",\n" +
                "                 \"currency\": \"EUR\"\n" +
                "             },\n" +
                "             \"discountAmount\": {\n" +
                "                 \"value\": \"100.00\",\n" +
                "                 \"currency\": \"EUR\"\n" +
                "             },\n" +
                "             \"totalAmount\": {\n" +
                "                 \"value\": \"299.00\",\n" +
                "                 \"currency\": \"EUR\"\n" +
                "             },\n" +
                "             \"createdAt\": \"2018-08-02T09:29:56+00:00\",\n" +
                "             \"_links\": {\n" +
                "                 \"productUrl\": {\n" +
                "                     \"href\": \"https://shop.lego.com/nl-NL/Bugatti-Chiron-42083\",\n" +
                "                     \"type\": \"text/html\"\n" +
                "                 },\n" +
                "                 \"imageUrl\": {\n" +
                "                     \"href\": \"https://sh-s7-live-s.legocdn.com/is/image//LEGO/42083_alt1?$main$\",\n" +
                "                     \"type\": \"text/html\"\n" +
                "                 }\n" +
                "             }\n" +
                "         },\n" +
                "         {\n" +
                "             \"resource\": \"orderline\",\n" +
                "             \"id\": \"odl_jp31jz\",\n" +
                "             \"orderId\": \"ord_pbjz8x\",\n" +
                "             \"name\": \"LEGO 42056 Porsche 911 GT3 RS\",\n" +
                "             \"sku\": \"5702015594028\",\n" +
                "             \"type\": \"physical\",\n" +
                "             \"status\": \"completed\",\n" +
                "             \"metadata\": null,\n" +
                "             \"isCancelable\": false,\n" +
                "             \"quantity\": 1,\n" +
                "             \"unitPrice\": {\n" +
                "                 \"value\": \"329.99\",\n" +
                "                 \"currency\": \"EUR\"\n" +
                "             },\n" +
                "             \"vatRate\": \"21.00\",\n" +
                "             \"vatAmount\": {\n" +
                "                 \"value\": \"57.27\",\n" +
                "                 \"currency\": \"EUR\"\n" +
                "             },\n" +
                "             \"totalAmount\": {\n" +
                "                 \"value\": \"329.99\",\n" +
                "                 \"currency\": \"EUR\"\n" +
                "             },\n" +
                "             \"createdAt\": \"2018-08-02T09:29:56+00:00\",\n" +
                "             \"_links\": {\n" +
                "                 \"productUrl\": {\n" +
                "                     \"href\": \"https://shop.lego.com/nl-NL/Porsche-911-GT3-RS-42056\",\n" +
                "                     \"type\": \"text/html\"\n" +
                "                 },\n" +
                "                 \"imageUrl\": {\n" +
                "                     \"href\": \"https://sh-s7-live-s.legocdn.com/is/image/LEGO/42056?$PDPDefault$\",\n" +
                "                     \"type\": \"text/html\"\n" +
                "                 }\n" +
                "             }\n" +
                "         }\n" +
                "     ],\n" +
                "     \"_links\": {\n" +
                "         \"self\": {\n" +
                "             \"href\": \"https://api.mollie.com/v2/order/ord_kEn1PlbGa/shipments/shp_3wmsgCJN4U\",\n" +
                "             \"type\": \"application/hal+json\"\n" +
                "         },\n" +
                "         \"order\": {\n" +
                "             \"href\": \"https://api.mollie.com/v2/orders/ord_kEn1PlbGa\",\n" +
                "             \"type\": \"application/hal+json\"\n" +
                "         },\n" +
                "         \"documentation\": {\n" +
                "             \"href\": \"https://docs.mollie.com/reference/v2/shipments-api/get-shipment\",\n" +
                "             \"type\": \"text/html\"\n" +
                "         }\n" +
                "     }\n" +
                " }");

        Shipment shipment = new Shipment();

        MollieApiClient mollieApiClient = new MollieApiClient(mollieHttpClient);
        Shipment result = mollieApiClient.shipments().update("foo", shipment);
        Assertions.assertNotNull(result);
        Assertions.assertEquals("shp_3wmsgCJN4U", result.getId());
    }

    @Test
    void allShipments() throws MollieException {
        MollieHttpClient mollieHttpClient = mock(MollieHttpClient.class);
        when(mollieHttpClient.get(anyString())).thenReturn("{\n" +
                "    \"count\": 2,\n" +
                "    \"_embedded\": {\n" +
                "        \"shipments\": [\n" +
                "            {\n" +
                "                \"resource\": \"shipment\",\n" +
                "                \"id\": \"shp_3wmsgCJN4U\",\n" +
                "                \"orderId\": \"ord_kEn1PlbGa\",\n" +
                "                \"createdAt\": \"2018-08-09T14:33:54+00:00\",\n" +
                "                \"tracking\": {\n" +
                "                    \"carrier\": \"PostNL\",\n" +
                "                    \"code\": \"3SKABA000000000\",\n" +
                "                    \"url\": \"http://postnl.nl/tracktrace/?B=3SKABA000000000&P=1015CW&D=NL&T=C\"\n" +
                "                },\n" +
                "                \"lines\": [\n" +
                "                    {\n" +
                "                        \"resource\": \"orderline\",\n" +
                "                        \"id\": \"odl_dgtxyl\",\n" +
                "                        \"orderId\": \"ord_pbjz8x\",\n" +
                "                        \"name\": \"LEGO 42083 Bugatti Chiron\",\n" +
                "                        \"sku\": \"5702016116977\",\n" +
                "                        \"type\": \"physical\",\n" +
                "                        \"status\": \"shipping\",\n" +
                "                        \"metadata\": null,\n" +
                "                        \"isCancelable\": true,\n" +
                "                        \"quantity\": 1,\n" +
                "                        \"unitPrice\": {\n" +
                "                            \"value\": \"399.00\",\n" +
                "                            \"currency\": \"EUR\"\n" +
                "                        },\n" +
                "                        \"vatRate\": \"21.00\",\n" +
                "                        \"vatAmount\": {\n" +
                "                            \"value\": \"51.89\",\n" +
                "                            \"currency\": \"EUR\"\n" +
                "                        },\n" +
                "                        \"discountAmount\": {\n" +
                "                            \"value\": \"100.00\",\n" +
                "                            \"currency\": \"EUR\"\n" +
                "                        },\n" +
                "                        \"totalAmount\": {\n" +
                "                            \"value\": \"299.00\",\n" +
                "                            \"currency\": \"EUR\"\n" +
                "                        },\n" +
                "                        \"createdAt\": \"2018-08-02T09:29:56+00:00\",\n" +
                "                        \"_links\": {\n" +
                "                            \"productUrl\": {\n" +
                "                                \"href\": \"https://shop.lego.com/nl-NL/Bugatti-Chiron-42083\",\n" +
                "                                \"type\": \"text/html\"\n" +
                "                            },\n" +
                "                            \"imageUrl\": {\n" +
                "                                \"href\": \"https://sh-s7-live-s.legocdn.com/is/image//LEGO/42083_alt1?$main$\",\n" +
                "                                \"type\": \"text/html\"\n" +
                "                            }\n" +
                "                        }\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"_links\": {\n" +
                "                    \"self\": {\n" +
                "                        \"href\": \"https://api.mollie.com/v2/order/ord_kEn1PlbGa/shipments/shp_3wmsgCJN4U\",\n" +
                "                        \"type\": \"application/hal+json\"\n" +
                "                    },\n" +
                "                    \"order\": {\n" +
                "                        \"href\": \"https://api.mollie.com/v2/orders/ord_kEn1PlbGa\",\n" +
                "                        \"type\": \"application/hal+json\"\n" +
                "                    },\n" +
                "                    \"documentation\": {\n" +
                "                        \"href\": \"https://docs.mollie.com/reference/v2/shipments-api/get-shipment\",\n" +
                "                        \"type\": \"text/html\"\n" +
                "                    }\n" +
                "                }\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"_links\": {\n" +
                "        \"self\": {\n" +
                "            \"href\": \"https://api.mollie.com/v2/order/ord_kEn1PlbGa/shipments\",\n" +
                "            \"type\": \"application/hal+json\"\n" +
                "        },\n" +
                "        \"documentation\": {\n" +
                "            \"href\": \"https://docs.mollie.com/reference/v2/shipments-api/list-shipments\",\n" +
                "            \"type\": \"text/html\"\n" +
                "        }\n" +
                "    }\n" +
                "}");

        MollieApiClient mollieApiClient = new MollieApiClient(mollieHttpClient);
        Page<Shipment> page = mollieApiClient.shipments().all("foo");
        Assertions.assertEquals(2, page.getCount());
        assertEquals(Shipment.class, page.getItems().get(0).getClass());
    }
}
