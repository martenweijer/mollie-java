package com.electronics.controllers;

import com.electronics.exceptions.MollieException;
import com.electronics.models.CreatePayment;
import com.electronics.models.Payment;
import com.electronics.services.MollieFactory;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/payments/{id}")
    Payment find(@PathVariable String id) throws MollieException {
        return this.mollieFactory.getMollie().findPayment(id);
    }

    @PostMapping("/payments")
    Payment create(@RequestBody CreatePayment createPayment) throws MollieException {
        return this.mollieFactory.getMollie().createPayment(createPayment);
    }
}
