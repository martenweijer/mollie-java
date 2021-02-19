package com.electronics.services;

import com.electronics.Mollie;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MollieFactory {
    @Value("${mollie_api_key}")
    private String apiKey;

    private Mollie mollie;

    public Mollie getMollie() {
        if (mollie == null) {
            mollie = Mollie.create(apiKey);
        }

        return mollie;
    }
}
