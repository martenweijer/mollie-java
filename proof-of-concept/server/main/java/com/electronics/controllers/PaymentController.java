package com.electronics.controllers;

import com.electronics.exceptions.MollieException;
import com.electronics.models.Payment;
import com.electronics.services.MollieFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PaymentController {
    private final MollieFactory mollieFactory;

    public PaymentController(MollieFactory mollieFactory) {
        this.mollieFactory = mollieFactory;
    }

    @GetMapping("/payments")
    List<Payment> all() throws MollieException {
        return this.mollieFactory.getMollie().getPayments();
    }
}
