import { Component, OnInit } from '@angular/core';
import {PaymentService} from "../payment.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Location} from "@angular/common";
import {Payment} from "../payment";

@Component({
  selector: 'app-create-payment',
  templateUrl: './create-payment.component.html',
  styleUrls: ['./create-payment.component.sass']
})
export class CreatePaymentComponent implements OnInit {
  payment: Payment;

  constructor(
    private paymentService: PaymentService,
    private route: ActivatedRoute,
    private location: Location,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.payment = new Payment();
    this.payment.redirectUrl = window.location.href.replace('create_payment', 'payments');
  }

  save(): void {
    this.paymentService.createPayment(this.payment)
      .subscribe(payment => {
        this.router.navigate(['/payments', payment.id]);
      })
  }

}
