package com.electronics.mollie.endpoints;

import com.electronics.mollie.MollieApiClient;
import com.electronics.mollie.exceptions.MollieException;
import com.electronics.mollie.http.MollieHttpClient;
import com.electronics.mollie.resources.Order;
import com.electronics.mollie.resources.OrderLine;
import com.electronics.mollie.resources.Page;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class OrderEndpointTest {
    @Test
    void getOrder() throws MollieException {
        MollieHttpClient mollieHttpClient = mock(MollieHttpClient.class);
        when(mollieHttpClient.get(anyString())).thenReturn("{\n" +
                "     \"resource\": \"order\",\n" +
                "     \"id\": \"ord_kEn1PlbGa\",\n" +
                "     \"profileId\": \"pfl_URR55HPMGx\",\n" +
                "     \"method\": \"ideal\",\n" +
                "     \"amount\": {\n" +
                "         \"value\": \"1027.99\",\n" +
                "         \"currency\": \"EUR\"\n" +
                "     },\n" +
                "     \"status\": \"created\",\n" +
                "     \"isCancelable\": true,\n" +
                "     \"metadata\": null,\n" +
                "     \"createdAt\": \"2018-08-02T09:29:56+00:00\",\n" +
                "     \"expiresAt\": \"2018-08-30T09:29:56+00:00\",\n" +
                "     \"mode\": \"live\",\n" +
                "     \"locale\": \"nl_NL\",\n" +
                "     \"billingAddress\": {\n" +
                "         \"organizationName\": \"Mollie B.V.\",\n" +
                "         \"streetAndNumber\": \"Keizersgracht 126\",\n" +
                "         \"postalCode\": \"1015 CW\",\n" +
                "         \"city\": \"Amsterdam\",\n" +
                "         \"country\": \"nl\",\n" +
                "         \"givenName\": \"Luke\",\n" +
                "         \"familyName\": \"Skywalker\",\n" +
                "         \"email\": \"luke@skywalker.com\"\n" +
                "     },\n" +
                "     \"shopperCountryMustMatchBillingCountry\": false,\n" +
                "     \"consumerDateOfBirth\": \"1993-10-21\",\n" +
                "     \"orderNumber\": \"18475\",\n" +
                "     \"shippingAddress\": {\n" +
                "         \"organizationName\": \"Mollie B.V.\",\n" +
                "         \"streetAndNumber\": \"Keizersgracht 126\",\n" +
                "         \"postalCode\": \"1015 CW\",\n" +
                "         \"city\": \"Amsterdam\",\n" +
                "         \"country\": \"nl\",\n" +
                "         \"givenName\": \"Luke\",\n" +
                "         \"familyName\": \"Skywalker\",\n" +
                "         \"email\": \"luke@skywalker.com\"\n" +
                "     },\n" +
                "     \"redirectUrl\": \"https://example.org/redirect\",\n" +
                "     \"lines\": [\n" +
                "         {\n" +
                "             \"resource\": \"orderline\",\n" +
                "             \"id\": \"odl_dgtxyl\",\n" +
                "             \"orderId\": \"ord_pbjz8x\",\n" +
                "             \"name\": \"LEGO 42083 Bugatti Chiron\",\n" +
                "             \"sku\": \"5702016116977\",\n" +
                "             \"type\": \"physical\",\n" +
                "             \"status\": \"created\",\n" +
                "             \"metadata\": null,\n" +
                "             \"isCancelable\": false,\n" +
                "             \"quantity\": 2,\n" +
                "             \"quantityShipped\": 0,\n" +
                "             \"amountShipped\": {\n" +
                "                 \"value\": \"0.00\",\n" +
                "                 \"currency\": \"EUR\"\n" +
                "             },\n" +
                "             \"quantityRefunded\": 0,\n" +
                "             \"amountRefunded\": {\n" +
                "                 \"value\": \"0.00\",\n" +
                "                 \"currency\": \"EUR\"\n" +
                "             },\n" +
                "             \"quantityCanceled\": 0,\n" +
                "             \"amountCanceled\": {\n" +
                "                 \"value\": \"0.00\",\n" +
                "                 \"currency\": \"EUR\"\n" +
                "             },\n" +
                "             \"shippableQuantity\": 0,\n" +
                "             \"refundableQuantity\": 0,\n" +
                "             \"cancelableQuantity\": 0,\n" +
                "             \"unitPrice\": {\n" +
                "                 \"value\": \"399.00\",\n" +
                "                 \"currency\": \"EUR\"\n" +
                "             },\n" +
                "             \"vatRate\": \"21.00\",\n" +
                "             \"vatAmount\": {\n" +
                "                 \"value\": \"121.14\",\n" +
                "                 \"currency\": \"EUR\"\n" +
                "             },\n" +
                "             \"discountAmount\": {\n" +
                "                 \"value\": \"100.00\",\n" +
                "                 \"currency\": \"EUR\"\n" +
                "             },\n" +
                "             \"totalAmount\": {\n" +
                "                 \"value\": \"698.00\",\n" +
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
                "             \"status\": \"created\",\n" +
                "             \"metadata\": null,\n" +
                "             \"isCancelable\": false,\n" +
                "             \"quantity\": 1,\n" +
                "             \"quantityShipped\": 0,\n" +
                "             \"amountShipped\": {\n" +
                "                 \"value\": \"0.00\",\n" +
                "                 \"currency\": \"EUR\"\n" +
                "             },\n" +
                "             \"quantityRefunded\": 0,\n" +
                "             \"amountRefunded\": {\n" +
                "                 \"value\": \"0.00\",\n" +
                "                 \"currency\": \"EUR\"\n" +
                "             },\n" +
                "             \"quantityCanceled\": 0,\n" +
                "             \"amountCanceled\": {\n" +
                "                 \"value\": \"0.00\",\n" +
                "                 \"currency\": \"EUR\"\n" +
                "             },\n" +
                "             \"shippableQuantity\": 0,\n" +
                "             \"refundableQuantity\": 0,\n" +
                "             \"cancelableQuantity\": 0,\n" +
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
                "     \"_embedded\": {\n" +
                "         \"payments\": [\n" +
                "             {\n" +
                "                 \"resource\": \"payment\",\n" +
                "                 \"id\": \"tr_ncaPcAhuUV\",\n" +
                "                 \"mode\": \"live\",\n" +
                "                 \"createdAt\": \"2018-09-07T12:00:05+00:00\",\n" +
                "                 \"amount\": {\n" +
                "                     \"value\": \"1027.99\",\n" +
                "                     \"currency\": \"EUR\"\n" +
                "                 },\n" +
                "                 \"description\": \"Order #1337 (Lego cars)\",\n" +
                "                 \"method\": null,\n" +
                "                 \"metadata\": null,\n" +
                "                 \"status\": \"open\",\n" +
                "                 \"isCancelable\": false,\n" +
                "                 \"locale\": \"nl_NL\",\n" +
                "                 \"profileId\": \"pfl_URR55HPMGx\",\n" +
                "                 \"orderId\": \"ord_kEn1PlbGa\",\n" +
                "                 \"sequenceType\": \"oneoff\",\n" +
                "                 \"redirectUrl\": \"https://example.org/redirect\",\n" +
                "                 \"_links\": {\n" +
                "                     \"self\": {\n" +
                "                         \"href\": \"https://api.mollie.com/v2/payments/tr_ncaPcAhuUV\",\n" +
                "                         \"type\": \"application/hal+json\"\n" +
                "                     },\n" +
                "                     \"checkout\": {\n" +
                "                         \"href\": \"https://www.mollie.com/payscreen/select-method/ncaPcAhuUV\",\n" +
                "                         \"type\": \"text/html\"\n" +
                "                     },\n" +
                "                     \"dashboard\": {\n" +
                "                         \"href\": \"https://www.mollie.com/dashboard/org_123456789/payments/tr_ncaPcAhuUV\",\n" +
                "                         \"type\": \"text/html\"\n" +
                "                     },\n" +
                "                     \"order\": {\n" +
                "                         \"href\": \"https://api.mollie.com/v2/orders/ord_kEn1PlbGa\",\n" +
                "                         \"type\": \"application/hal+json\"\n" +
                "                     }\n" +
                "                 }\n" +
                "             }\n" +
                "         ],\n" +
                "         \"refunds\": [\n" +
                "             {\n" +
                "                 \"resource\": \"refund\",\n" +
                "                 \"id\": \"re_vD3Jm32wQt\",\n" +
                "                 \"amount\": {\n" +
                "                     \"value\": \"329.99\",\n" +
                "                     \"currency\": \"EUR\"\n" +
                "                 },\n" +
                "                 \"status\": \"pending\",\n" +
                "                 \"createdAt\": \"2019-01-15T15:41:21+00:00\",\n" +
                "                 \"description\": \"Required quantity not in stock, refunding one photo book.\",\n" +
                "                 \"orderId\": \"ord_kEn1PlbGa\",\n" +
                "                 \"paymentId\": \"tr_mjvPwykz3x\",\n" +
                "                 \"settlementAmount\": {\n" +
                "                     \"value\": \"-329.99\",\n" +
                "                     \"currency\": \"EUR\"\n" +
                "                 },\n" +
                "                 \"lines\": [\n" +
                "                     {\n" +
                "                         \"resource\": \"orderline\",\n" +
                "                         \"id\": \"odl_dgtxyl\",\n" +
                "                         \"orderId\": \"ord_kEn1PlbGa\",\n" +
                "                         \"name\": \"LEGO 42056 Porsche 911 GT3 RS\",\n" +
                "                         \"sku\": \"5702015594028\",\n" +
                "                         \"type\": \"physical\",\n" +
                "                         \"status\": \"completed\",\n" +
                "                         \"isCancelable\": false,\n" +
                "                         \"quantity\": 1,\n" +
                "                         \"unitPrice\": {\n" +
                "                             \"value\": \"329.99\",\n" +
                "                             \"currency\": \"EUR\"\n" +
                "                         },\n" +
                "                         \"vatRate\": \"21.00\",\n" +
                "                         \"vatAmount\": {\n" +
                "                             \"value\": \"57.27\",\n" +
                "                             \"currency\": \"EUR\"\n" +
                "                         },\n" +
                "                         \"totalAmount\": {\n" +
                "                             \"value\": \"329.99\",\n" +
                "                             \"currency\": \"EUR\"\n" +
                "                         },\n" +
                "                         \"createdAt\": \"2019-01-15T15:22:45+00:00\",\n" +
                "                         \"_links\": {\n" +
                "                             \"productUrl\": {\n" +
                "                                 \"href\": \"https://shop.lego.com/nl-NL/Porsche-911-GT3-RS-42056\",\n" +
                "                                 \"type\": \"text/html\"\n" +
                "                             },\n" +
                "                             \"imageUrl\": {\n" +
                "                                 \"href\": \"https://sh-s7-live-s.legocdn.com/is/image/LEGO/42056?$PDPDefault$\",\n" +
                "                                 \"type\": \"text/html\"\n" +
                "                             }\n" +
                "                         }\n" +
                "                     }\n" +
                "                 ],\n" +
                "                 \"_links\": {\n" +
                "                     \"self\": {\n" +
                "                         \"href\": \"https://api.mollie.com/v2/payments/tr_mjvPwykz3x/refunds/re_vD3Jm32wQt\",\n" +
                "                         \"type\": \"application/hal+json\"\n" +
                "                     },\n" +
                "                     \"payment\": {\n" +
                "                         \"href\": \"https://api.mollie.com/v2/payments/tr_mjvPwykz3x\",\n" +
                "                         \"type\": \"application/hal+json\"\n" +
                "                     },\n" +
                "                     \"order\": {\n" +
                "                         \"href\": \"https://api.mollie.com/v2/orders/ord_kEn1PlbGa\",\n" +
                "                         \"type\": \"application/hal+json\"\n" +
                "                     }\n" +
                "                 }\n" +
                "             }\n" +
                "         ]\n" +
                "     },\n" +
                "     \"_links\": {\n" +
                "         \"self\": {\n" +
                "             \"href\": \"https://api.mollie.com/v2/orders/ord_pbjz8x\",\n" +
                "             \"type\": \"application/hal+json\"\n" +
                "         },\n" +
                "         \"checkout\": {\n" +
                "             \"href\": \"https://www.mollie.com/payscreen/order/checkout/pbjz8x\",\n" +
                "             \"type\": \"text/html\"\n" +
                "         },\n" +
                "        \"dashboard\": {\n" +
                "            \"href\": \"https://www.mollie.com/dashboard/org_123456789/orders/ord_pbjz8x\",\n" +
                "            \"type\": \"text/html\"\n" +
                "        },\n" +
                "         \"documentation\": {\n" +
                "             \"href\": \"https://docs.mollie.com/reference/v2/orders-api/get-order\",\n" +
                "             \"type\": \"text/html\"\n" +
                "         }\n" +
                "     }\n" +
                " }");

        MollieApiClient mollieApiClient = new MollieApiClient(mollieHttpClient);
        Order order = mollieApiClient.orders().get("foo");
        Assertions.assertNotNull(order);
        Assertions.assertEquals("ord_kEn1PlbGa", order.getId());
    }

    @Test
    void createOrder() throws MollieException {
        MollieHttpClient mollieHttpClient = mock(MollieHttpClient.class);
        when(mollieHttpClient.post(anyString(), anyString())).thenReturn("{\n" +
                "    \"resource\": \"order\",\n" +
                "    \"id\": \"ord_pbjz8x\",\n" +
                "    \"profileId\": \"pfl_URR55HPMGx\",\n" +
                "    \"method\": \"klarnapaylater\",\n" +
                "    \"amount\": {\n" +
                "        \"value\": \"1027.99\",\n" +
                "        \"currency\": \"EUR\"\n" +
                "    },\n" +
                "    \"status\": \"created\",\n" +
                "    \"isCancelable\": true,\n" +
                "    \"metadata\": {\n" +
                "        \"order_id\": \"1337\",\n" +
                "        \"description\": \"Lego cars\"\n" +
                "    },\n" +
                "    \"createdAt\": \"2018-08-02T09:29:56+00:00\",\n" +
                "    \"expiresAt\": \"2018-08-30T09:29:56+00:00\",\n" +
                "    \"mode\": \"test\",\n" +
                "    \"locale\": \"nl_NL\",\n" +
                "    \"billingAddress\": {\n" +
                "        \"organizationName\": \"Mollie B.V.\",\n" +
                "        \"streetAndNumber\": \"Keizersgracht 126\",\n" +
                "        \"city\": \"Amsterdam\",\n" +
                "        \"region\": \"Noord-Holland\",\n" +
                "        \"postalCode\": \"1234AB\",\n" +
                "        \"country\": \"NL\",\n" +
                "        \"title\": \"Dhr.\",\n" +
                "        \"givenName\": \"Piet\",\n" +
                "        \"familyName\": \"Mondriaan\",\n" +
                "        \"email\": \"piet@mondriaan.com\",\n" +
                "        \"phone\": \"+31309202070\"\n" +
                "    },\n" +
                "    \"consumerDateOfBirth\": \"1958-01-31\",\n" +
                "    \"orderNumber\": \"1337\",\n" +
                "    \"shippingAddress\": {\n" +
                "        \"organizationName\": \"Mollie B.V.\",\n" +
                "        \"streetAndNumber\": \"Keizersgracht 126\",\n" +
                "        \"streetAdditional\": \"4th floor\",\n" +
                "        \"city\": \"Haarlem\",\n" +
                "        \"region\": \"Noord-Holland\",\n" +
                "        \"postalCode\": \"5678AB\",\n" +
                "        \"country\": \"NL\",\n" +
                "        \"title\": \"Mr.\",\n" +
                "        \"givenName\": \"Chuck\",\n" +
                "        \"familyName\": \"Norris\",\n" +
                "        \"email\": \"norris@chucknorrisfacts.net\"\n" +
                "    },\n" +
                "    \"redirectUrl\": \"https://example.org/redirect\",\n" +
                "    \"webhookUrl\": \"https://example.org/webhook\",\n" +
                "    \"lines\": [\n" +
                "        {\n" +
                "            \"resource\": \"orderline\",\n" +
                "            \"id\": \"odl_dgtxyl\",\n" +
                "            \"orderId\": \"ord_pbjz8x\",\n" +
                "            \"name\": \"LEGO 42083 Bugatti Chiron\",\n" +
                "            \"sku\": \"5702016116977\",\n" +
                "            \"type\": \"physical\",\n" +
                "            \"category\": \"gift\",\n" +
                "            \"status\": \"created\",\n" +
                "            \"metadata\": {\n" +
                "               \"order_id\": \"1337\",\n" +
                "               \"description\": \"Bugatti Chiron\"\n" +
                "            },\n" +
                "            \"isCancelable\": false,\n" +
                "            \"quantity\": 2,\n" +
                "            \"quantityShipped\": 0,\n" +
                "            \"amountShipped\": {\n" +
                "                \"value\": \"0.00\",\n" +
                "                \"currency\": \"EUR\"\n" +
                "            },\n" +
                "            \"quantityRefunded\": 0,\n" +
                "            \"amountRefunded\": {\n" +
                "                \"value\": \"0.00\",\n" +
                "                \"currency\": \"EUR\"\n" +
                "            },\n" +
                "            \"quantityCanceled\": 0,\n" +
                "            \"amountCanceled\": {\n" +
                "                \"value\": \"0.00\",\n" +
                "                \"currency\": \"EUR\"\n" +
                "            },\n" +
                "            \"shippableQuantity\": 0,\n" +
                "            \"refundableQuantity\": 0,\n" +
                "            \"cancelableQuantity\": 0,\n" +
                "            \"unitPrice\": {\n" +
                "                \"value\": \"399.00\",\n" +
                "                \"currency\": \"EUR\"\n" +
                "            },\n" +
                "            \"vatRate\": \"21.00\",\n" +
                "            \"vatAmount\": {\n" +
                "                \"value\": \"121.14\",\n" +
                "                \"currency\": \"EUR\"\n" +
                "            },\n" +
                "            \"discountAmount\": {\n" +
                "                \"value\": \"100.00\",\n" +
                "                \"currency\": \"EUR\"\n" +
                "            },\n" +
                "            \"totalAmount\": {\n" +
                "                \"value\": \"698.00\",\n" +
                "                \"currency\": \"EUR\"\n" +
                "            },\n" +
                "            \"createdAt\": \"2018-08-02T09:29:56+00:00\",\n" +
                "            \"_links\": {\n" +
                "                \"productUrl\": {\n" +
                "                    \"href\": \"https://shop.lego.com/nl-NL/Bugatti-Chiron-42083\",\n" +
                "                    \"type\": \"text/html\"\n" +
                "                },\n" +
                "                \"imageUrl\": {\n" +
                "                    \"href\": \"https://sh-s7-live-s.legocdn.com/is/image//LEGO/42083_alt1?$main$\",\n" +
                "                    \"type\": \"text/html\"\n" +
                "                }\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"resource\": \"orderline\",\n" +
                "            \"id\": \"odl_jp31jz\",\n" +
                "            \"orderId\": \"ord_pbjz8x\",\n" +
                "            \"name\": \"LEGO 42056 Porsche 911 GT3 RS\",\n" +
                "            \"sku\": \"5702015594028\",\n" +
                "            \"type\": \"physical\",\n" +
                "            \"category\": \"gift\",\n" +
                "            \"status\": \"created\",\n" +
                "            \"metadata\": null,\n" +
                "            \"isCancelable\": false,\n" +
                "            \"quantity\": 1,\n" +
                "            \"quantityShipped\": 0,\n" +
                "            \"amountShipped\": {\n" +
                "                \"value\": \"0.00\",\n" +
                "                \"currency\": \"EUR\"\n" +
                "            },\n" +
                "            \"quantityRefunded\": 0,\n" +
                "            \"amountRefunded\": {\n" +
                "                \"value\": \"0.00\",\n" +
                "                \"currency\": \"EUR\"\n" +
                "            },\n" +
                "            \"quantityCanceled\": 0,\n" +
                "            \"amountCanceled\": {\n" +
                "                \"value\": \"0.00\",\n" +
                "                \"currency\": \"EUR\"\n" +
                "            },\n" +
                "            \"shippableQuantity\": 0,\n" +
                "            \"refundableQuantity\": 0,\n" +
                "            \"cancelableQuantity\": 0,\n" +
                "            \"unitPrice\": {\n" +
                "                \"value\": \"329.99\",\n" +
                "                \"currency\": \"EUR\"\n" +
                "            },\n" +
                "            \"vatRate\": \"21.00\",\n" +
                "            \"vatAmount\": {\n" +
                "                \"value\": \"57.27\",\n" +
                "                \"currency\": \"EUR\"\n" +
                "            },\n" +
                "            \"totalAmount\": {\n" +
                "                \"value\": \"329.99\",\n" +
                "                \"currency\": \"EUR\"\n" +
                "            },\n" +
                "            \"createdAt\": \"2018-08-02T09:29:56+00:00\",\n" +
                "            \"_links\": {\n" +
                "                \"productUrl\": {\n" +
                "                    \"href\": \"https://shop.lego.com/nl-NL/Porsche-911-GT3-RS-42056\",\n" +
                "                    \"type\": \"text/html\"\n" +
                "                },\n" +
                "                \"imageUrl\": {\n" +
                "                    \"href\": \"https://sh-s7-live-s.legocdn.com/is/image/LEGO/42056?$PDPDefault$\",\n" +
                "                    \"type\": \"text/html\"\n" +
                "                }\n" +
                "            }\n" +
                "        }\n" +
                "    ],\n" +
                "    \"_links\": {\n" +
                "        \"self\": {\n" +
                "            \"href\": \"https://api.mollie.com/v2/orders/ord_pbjz8x\",\n" +
                "            \"type\": \"application/hal+json\"\n" +
                "        },\n" +
                "        \"checkout\": {\n" +
                "            \"href\": \"https://www.mollie.com/payscreen/order/checkout/pbjz8x\",\n" +
                "            \"type\": \"text/html\"\n" +
                "        },\n" +
                "        \"dashboard\": {\n" +
                "            \"href\": \"https://www.mollie.com/dashboard/org_123456789/orders/ord_pbjz8x\",\n" +
                "            \"type\": \"text/html\"\n" +
                "        },\n" +
                "        \"documentation\": {\n" +
                "            \"href\": \"https://docs.mollie.com/reference/v2/orders-api/get-order\",\n" +
                "            \"type\": \"text/html\"\n" +
                "        }\n" +
                "    }\n" +
                "}");

        Order order = new Order();

        MollieApiClient mollieApiClient = new MollieApiClient(mollieHttpClient);
        Order result = mollieApiClient.orders().create(order);
        Assertions.assertNotNull(result);
        Assertions.assertEquals("ord_pbjz8x", result.getId());
    }

    @Test
    void updateOrder() throws MollieException {
        MollieHttpClient mollieHttpClient = mock(MollieHttpClient.class);
        when(mollieHttpClient.patch(anyString(), anyString())).thenReturn("{\n" +
                "     \"resource\": \"order\",\n" +
                "     \"id\": \"ord_kEn1PlbGa\",\n" +
                "     \"profileId\": \"pfl_URR55HPMGx\",\n" +
                "     \"method\": \"ideal\",\n" +
                "     \"amount\": {\n" +
                "         \"value\": \"1027.99\",\n" +
                "         \"currency\": \"EUR\"\n" +
                "     },\n" +
                "     \"status\": \"created\",\n" +
                "     \"isCancelable\": true,\n" +
                "     \"metadata\": null,\n" +
                "     \"createdAt\": \"2018-08-02T09:29:56+00:00\",\n" +
                "     \"expiresAt\": \"2018-08-30T09:29:56+00:00\",\n" +
                "     \"mode\": \"live\",\n" +
                "     \"locale\": \"nl_NL\",\n" +
                "     \"billingAddress\": {\n" +
                "         \"organizationName\": \"Mollie B.V.\",\n" +
                "         \"streetAndNumber\": \"Keizersgracht 126\",\n" +
                "         \"city\": \"Amsterdam\",\n" +
                "         \"region\": \"Noord-Holland\",\n" +
                "         \"postalCode\": \"1234AB\",\n" +
                "         \"country\": \"NL\",\n" +
                "         \"title\": \"Dhr\",\n" +
                "         \"givenName\": \"Piet\",\n" +
                "         \"familyName\": \"Mondriaan\",\n" +
                "         \"email\": \"piet@mondriaan.com\",\n" +
                "         \"phone\": \"+31208202070\"\n" +
                "     },\n" +
                "     \"orderNumber\": \"18475\",\n" +
                "     \"shippingAddress\": {\n" +
                "         \"organizationName\": \"Mollie B.V.\",\n" +
                "         \"streetAndNumber\": \"Keizersgracht 126\",\n" +
                "         \"postalCode\": \"1015 CW\",\n" +
                "         \"city\": \"Amsterdam\",\n" +
                "         \"country\": \"nl\",\n" +
                "         \"givenName\": \"Luke\",\n" +
                "         \"familyName\": \"Skywalker\",\n" +
                "         \"email\": \"luke@skywalker.com\"\n" +
                "     },\n" +
                "    \"redirectUrl\": \"https://example.org/redirect\",\n" +
                "     \"lines\": [\n" +
                "         {\n" +
                "             \"resource\": \"orderline\",\n" +
                "             \"id\": \"odl_dgtxyl\",\n" +
                "             \"orderId\": \"ord_pbjz8x\",\n" +
                "             \"name\": \"LEGO 42083 Bugatti Chiron\",\n" +
                "             \"sku\": \"5702016116977\",\n" +
                "             \"type\": \"physical\",\n" +
                "             \"status\": \"created\",\n" +
                "             \"metadata\": null,\n" +
                "             \"isCancelable\": false,\n" +
                "             \"quantity\": 2,\n" +
                "             \"quantityShipped\": 0,\n" +
                "             \"amountShipped\": {\n" +
                "                 \"value\": \"0.00\",\n" +
                "                 \"currency\": \"EUR\"\n" +
                "             },\n" +
                "             \"quantityRefunded\": 0,\n" +
                "             \"amountRefunded\": {\n" +
                "                 \"value\": \"0.00\",\n" +
                "                 \"currency\": \"EUR\"\n" +
                "             },\n" +
                "             \"quantityCanceled\": 0,\n" +
                "             \"amountCanceled\": {\n" +
                "                 \"value\": \"0.00\",\n" +
                "                 \"currency\": \"EUR\"\n" +
                "             },\n" +
                "            \"shippableQuantity\": 0,\n" +
                "            \"refundableQuantity\": 0,\n" +
                "            \"cancelableQuantity\": 0,\n" +
                "             \"unitPrice\": {\n" +
                "                 \"value\": \"399.00\",\n" +
                "                 \"currency\": \"EUR\"\n" +
                "             },\n" +
                "             \"vatRate\": \"21.00\",\n" +
                "             \"vatAmount\": {\n" +
                "                 \"value\": \"121.14\",\n" +
                "                 \"currency\": \"EUR\"\n" +
                "             },\n" +
                "             \"discountAmount\": {\n" +
                "                 \"value\": \"100.00\",\n" +
                "                 \"currency\": \"EUR\"\n" +
                "             },\n" +
                "             \"totalAmount\": {\n" +
                "                 \"value\": \"698.00\",\n" +
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
                "             \"status\": \"created\",\n" +
                "             \"metadata\": null,\n" +
                "             \"isCancelable\": false,\n" +
                "             \"quantity\": 1,\n" +
                "             \"quantityShipped\": 0,\n" +
                "             \"amountShipped\": {\n" +
                "                 \"value\": \"0.00\",\n" +
                "                 \"currency\": \"EUR\"\n" +
                "             },\n" +
                "             \"quantityRefunded\": 0,\n" +
                "             \"amountRefunded\": {\n" +
                "                 \"value\": \"0.00\",\n" +
                "                 \"currency\": \"EUR\"\n" +
                "             },\n" +
                "             \"quantityCanceled\": 0,\n" +
                "             \"amountCanceled\": {\n" +
                "                 \"value\": \"0.00\",\n" +
                "                 \"currency\": \"EUR\"\n" +
                "             },\n" +
                "            \"shippableQuantity\": 0,\n" +
                "            \"refundableQuantity\": 0,\n" +
                "            \"cancelableQuantity\": 0,\n" +
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
                "             \"href\": \"https://api.mollie.com/v2/orders/ord_pbjz8x\",\n" +
                "             \"type\": \"application/hal+json\"\n" +
                "         },\n" +
                "         \"checkout\": {\n" +
                "             \"href\": \"https://www.mollie.com/payscreen/order/checkout/pbjz8x\",\n" +
                "             \"type\": \"text/html\"\n" +
                "         },\n" +
                "         \"dashboard\": {\n" +
                "             \"href\": \"https://www.mollie.com/dashboard/org_123456789/orders/ord_pbjz8x\",\n" +
                "             \"type\": \"text/html\"\n" +
                "         },\n" +
                "         \"documentation\": {\n" +
                "             \"href\": \"https://docs.mollie.com/reference/v2/orders-api/get-order\",\n" +
                "             \"type\": \"text/html\"\n" +
                "         }\n" +
                "     }\n" +
                "}");

        Order order = new Order();

        MollieApiClient mollieApiClient = new MollieApiClient(mollieHttpClient);
        Order result = mollieApiClient.orders().update("foo", order);
        Assertions.assertNotNull(result);
        Assertions.assertEquals("ord_kEn1PlbGa", result.getId());
    }

    @Test
    void cancelOrder() throws MollieException {
        MollieHttpClient mollieHttpClient = mock(MollieHttpClient.class);
        when(mollieHttpClient.delete(anyString())).thenReturn("{\n" +
                "     \"resource\": \"order\",\n" +
                "     \"id\": \"ord_8wmqcHMN4U\",\n" +
                "     \"profileId\": \"pfl_URR55HPMGx\",\n" +
                "     \"amount\": {\n" +
                "         \"value\": \"1027.99\",\n" +
                "         \"currency\": \"EUR\"\n" +
                "     },\n" +
                "     \"status\": \"canceled\",\n" +
                "     \"isCancelable\": false,\n" +
                "     \"metadata\": null,\n" +
                "     \"createdAt\": \"2018-08-02T09:29:56+00:00\",\n" +
                "     \"mode\": \"live\",\n" +
                "     \"locale\": \"nl_NL\",\n" +
                "     \"billingAddress\": {\n" +
                "         \"organizationName\": \"Mollie B.V.\",\n" +
                "         \"streetAndNumber\": \"Keizersgracht 126\",\n" +
                "         \"postalCode\": \"1015 CW\",\n" +
                "         \"city\": \"Amsterdam\",\n" +
                "         \"country\": \"nl\",\n" +
                "         \"givenName\": \"Luke\",\n" +
                "         \"familyName\": \"Skywalker\",\n" +
                "         \"email\": \"luke@skywalker.com\"\n" +
                "     },\n" +
                "     \"orderNumber\": \"18475\",\n" +
                "     \"shippingAddress\": {\n" +
                "         \"organizationName\": \"Mollie B.V.\",\n" +
                "         \"streetAndNumber\": \"Keizersgracht 126\",\n" +
                "         \"postalCode\": \"1015 CW\",\n" +
                "         \"city\": \"Amsterdam\",\n" +
                "         \"country\": \"nl\",\n" +
                "         \"givenName\": \"Luke\",\n" +
                "         \"familyName\": \"Skywalker\",\n" +
                "         \"email\": \"luke@skywalker.com\"\n" +
                "     },\n" +
                "     \"canceledAt\": \"2018-08-03T09:29:56+00:00\",\n" +
                "     \"redirectUrl\": \"https://example.org/redirect\",\n" +
                "     \"lines\": [\n" +
                "         {\n" +
                "             \"resource\": \"orderline\",\n" +
                "             \"id\": \"odl_dgtxyl\",\n" +
                "             \"orderId\": \"ord_pbjz8x\",\n" +
                "             \"name\": \"LEGO 42083 Bugatti Chiron\",\n" +
                "             \"sku\": \"5702016116977\",\n" +
                "             \"type\": \"physical\",\n" +
                "             \"status\": \"canceled\",\n" +
                "             \"metadata\": null,\n" +
                "             \"isCancelable\": false,\n" +
                "             \"quantity\": 2,\n" +
                "             \"quantityShipped\": 0,\n" +
                "             \"amountShipped\": {\n" +
                "                 \"value\": \"0.00\",\n" +
                "                 \"currency\": \"EUR\"\n" +
                "             },\n" +
                "             \"quantityRefunded\": 0,\n" +
                "             \"amountRefunded\": {\n" +
                "                 \"value\": \"0.00\",\n" +
                "                 \"currency\": \"EUR\"\n" +
                "             },\n" +
                "             \"quantityCanceled\": 2,\n" +
                "             \"amountCanceled\": {\n" +
                "                 \"value\": \"698.00\",\n" +
                "                 \"currency\": \"EUR\"\n" +
                "             },\n" +
                "             \"shippableQuantity\": 0,\n" +
                "             \"refundableQuantity\": 0,\n" +
                "             \"cancelableQuantity\": 0,\n" +
                "             \"unitPrice\": {\n" +
                "                 \"value\": \"399.00\",\n" +
                "                 \"currency\": \"EUR\"\n" +
                "             },\n" +
                "             \"vatRate\": \"21.00\",\n" +
                "             \"vatAmount\": {\n" +
                "                 \"value\": \"121.14\",\n" +
                "                 \"currency\": \"EUR\"\n" +
                "             },\n" +
                "             \"discountAmount\": {\n" +
                "                 \"value\": \"100.00\",\n" +
                "                 \"currency\": \"EUR\"\n" +
                "             },\n" +
                "             \"totalAmount\": {\n" +
                "                 \"value\": \"698.00\",\n" +
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
                "             \"status\": \"canceled\",\n" +
                "             \"metadata\": null,\n" +
                "             \"isCancelable\": false,\n" +
                "             \"quantity\": 1,\n" +
                "             \"quantityShipped\": 0,\n" +
                "             \"amountShipped\": {\n" +
                "                 \"value\": \"0.00\",\n" +
                "                 \"currency\": \"EUR\"\n" +
                "             },\n" +
                "             \"quantityRefunded\": 0,\n" +
                "             \"amountRefunded\": {\n" +
                "                 \"value\": \"0.00\",\n" +
                "                 \"currency\": \"EUR\"\n" +
                "             },\n" +
                "             \"quantityCanceled\": 1,\n" +
                "             \"amountCanceled\": {\n" +
                "                 \"value\": \"329.99\",\n" +
                "                 \"currency\": \"EUR\"\n" +
                "             },\n" +
                "             \"shippableQuantity\": 0,\n" +
                "             \"refundableQuantity\": 0,\n" +
                "             \"cancelableQuantity\": 0,\n" +
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
                "             \"href\": \"https://api.mollie.com/v2/orders/ord_pbjz8x\",\n" +
                "             \"type\": \"application/hal+json\"\n" +
                "         },\n" +
                "         \"checkout\": {\n" +
                "             \"href\": \"https://www.mollie.com/payscreen/order/checkout/pbjz8x\",\n" +
                "             \"type\": \"text/html\"\n" +
                "         },\n" +
                "         \"dashboard\": {\n" +
                "             \"href\": \"https://www.mollie.com/dashboard/org_123456789/orders/ord_pbjz8x\",\n" +
                "             \"type\": \"text/html\"\n" +
                "         },\n" +
                "         \"documentation\": {\n" +
                "             \"href\": \"https://docs.mollie.com/reference/v2/orders-api/get-order\",\n" +
                "             \"type\": \"text/html\"\n" +
                "         }\n" +
                "     }\n" +
                " }");

        MollieApiClient mollieApiClient = new MollieApiClient(mollieHttpClient);
        Order result = mollieApiClient.orders().cancel("bar");
        Assertions.assertNotNull(result);
        Assertions.assertEquals("ord_8wmqcHMN4U", result.getId());
    }

    @Test
    void allOrders() throws MollieException {
        MollieHttpClient mollieHttpClient = mock(MollieHttpClient.class);
        when(mollieHttpClient.get(anyString())).thenReturn("{\n" +
                "    \"count\": 3,\n" +
                "    \"_embedded\": {\n" +
                "        \"orders\": [\n" +
                "            {\n" +
                "                \"resource\": \"order\",\n" +
                "                \"id\": \"ord_kEn1PlbGa\"\n" +
                "            }\n" +
                "        ]\n" +
                "    },\n" +
                "    \"_links\": {\n" +
                "        \"self\": {\n" +
                "            \"href\": \"https://api.mollie.com/v2/orders\",\n" +
                "            \"type\": \"application/hal+json\"\n" +
                "        },\n" +
                "        \"previous\": null,\n" +
                "        \"next\": {\n" +
                "            \"href\": \"https://api.mollie.com/v2/orders?from=ord_stTC2WHAuS\",\n" +
                "            \"type\": \"application/hal+json\"\n" +
                "        },\n" +
                "        \"documentation\": {\n" +
                "            \"href\": \"https://docs.mollie.com/reference/v2/orders-api/list-orders\",\n" +
                "            \"type\": \"text/html\"\n" +
                "        }\n" +
                "    }\n" +
                "}");

        MollieApiClient mollieApiClient = new MollieApiClient(mollieHttpClient);
        Page<Order> page = mollieApiClient.orders().all();
        Assertions.assertEquals(3, page.getCount());
        assertEquals(Order.class, page.getItems().get(0).getClass());
    }

    @Test
    void cancelLines() throws MollieException {
        MollieHttpClient mollieHttpClient = mock(MollieHttpClient.class);
        when(mollieHttpClient.delete(anyString())).thenReturn("");

        MollieApiClient mollieApiClient = new MollieApiClient(mollieHttpClient);

        Order order = new Order();
        List<OrderLine> lines = new ArrayList<>();
        OrderLine line1 = new OrderLine();
        line1.setId("foo");
        lines.add(line1);
        OrderLine line2 = new OrderLine();
        line2.setId("bar");
        lines.add(line2);
        order.setLines(lines);

        mollieApiClient.orders().cancelLines("orderId", order);
    }
}
