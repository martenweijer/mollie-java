import { Component, OnInit } from '@angular/core';
import {PaymentService} from "../payment.service";
import {Payment} from "../payment";
import {ActivatedRoute, Params} from "@angular/router";

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.sass']
})
export class PaymentComponent implements OnInit {

  payment: Payment;
  payment_json: string;

  constructor(private paymentService: PaymentService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.route.params.forEach((params: Params) => {
      if (params['id'] !== undefined) {
        const id = params['id'];
        this.paymentService.getPayment(id).subscribe(payment => {
          this.payment = payment;
          this.payment_json = JSON.stringify(this.payment);
        });
      } else {
        this.payment = new Payment();
      }
    })
  }

}
