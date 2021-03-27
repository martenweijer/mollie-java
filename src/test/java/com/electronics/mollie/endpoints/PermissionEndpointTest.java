package com.electronics.mollie.endpoints;

import com.electronics.mollie.MollieApiClient;
import com.electronics.mollie.exceptions.MollieException;
import com.electronics.mollie.http.MollieHttpClient;
import com.electronics.mollie.resources.Page;
import com.electronics.mollie.resources.Permission;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PermissionEndpointTest {
    @Test
    void getPermission() throws MollieException {
        MollieHttpClient mollieHttpClient = mock(MollieHttpClient.class);
        when(mollieHttpClient.get(anyString())).thenReturn("{\n" +
                "    \"resource\": \"permission\",\n" +
                "    \"id\": \"payments.read\",\n" +
                "    \"description\": \"View your payments\",\n" +
                "    \"granted\": true,\n" +
                "    \"_links\": {\n" +
                "        \"self\": {\n" +
                "            \"href\": \"https://api.mollie.com/v2/permissions/payments.read\",\n" +
                "            \"type\": \"application/hal+json\"\n" +
                "        },\n" +
                "        \"documentation\": {\n" +
                "            \"href\": \"https://docs.mollie.com/reference/v2/permissions-api/get-permission\",\n" +
                "            \"type\": \"text/html\"\n" +
                "        }\n" +
                "    }\n" +
                "}");

        MollieApiClient mollieApiClient = new MollieApiClient(mollieHttpClient);
        Permission permission = mollieApiClient.permissions().get("foo");
        assertNotNull(permission);
        assertEquals("payments.read", permission.getId());
    }

    @Test
    void allPermissions() throws MollieException {
        MollieHttpClient mollieHttpClient = mock(MollieHttpClient.class);
        when(mollieHttpClient.get(anyString())).thenReturn("{\n" +
                "    \"_embedded\": {\n" +
                "        \"permissions\": [\n" +
                "            {\n" +
                "                \"resource\": \"permission\",\n" +
                "                \"id\": \"payments.write\",\n" +
                "                \"description\": \"Create new payments\",\n" +
                "                \"granted\": false,\n" +
                "                \"_links\": {\n" +
                "                    \"self\": {\n" +
                "                        \"href\": \"https://api.mollie.com/v2/permissions/payments.write\",\n" +
                "                        \"type\": \"application/hal+json\"\n" +
                "                    }\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"resource\": \"permission\",\n" +
                "                \"id\": \"payments.read\",\n" +
                "                \"description\": \"View your payments\",\n" +
                "                \"granted\": true,\n" +
                "                \"_links\": {\n" +
                "                    \"self\": {\n" +
                "                        \"href\": \"https://api.mollie.com/v2/permissions/payments.read\",\n" +
                "                        \"type\": \"application/hal+json\"\n" +
                "                    }\n" +
                "                }\n" +
                "            }\n" +
                "       ]\n" +
                "    },\n" +
                "    \"count\": 15,\n" +
                "    \"_links\": {\n" +
                "        \"documentation\": {\n" +
                "            \"href\": \"https://docs.mollie.com/reference/v2/permissions-api/list-permissions\",\n" +
                "            \"type\": \"text/html\"\n" +
                "        },\n" +
                "        \"self\": {\n" +
                "            \"href\": \"https://api.mollie.com/v2/permissions\",\n" +
                "            \"type\": \"application/hal+json\"\n" +
                "        }\n" +
                "    }\n" +
                "}");

        MollieApiClient mollieApiClient = new MollieApiClient(mollieHttpClient);
        Page<Permission> permissions = mollieApiClient.permissions().all();
        assertEquals(15, permissions.getCount());
        assertEquals(Permission.class, permissions.getItems().get(0).getClass());
    }
}
