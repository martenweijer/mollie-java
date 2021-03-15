package com.electronics.mollie.resources;

import java.util.Date;

public class Link {
    private String href;
    private String type;
    private Date expiresAt;

    public String getHref() {
        return href;
    }

    public String getType() {
        return type;
    }

    public Date getExpiresAt() {
        return expiresAt;
    }
}
