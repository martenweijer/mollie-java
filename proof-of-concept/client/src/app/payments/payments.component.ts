import { Component, OnInit } from '@angular/core';
import { PaymentService } from "../payment.service";

@Component({
  selector: 'app-payments',
  templateUrl: './payments.component.html',
  styleUrls: ['./payments.component.sass']
})
export class PaymentsComponent implements OnInit {

  payments = [];

  constructor(private paymentService: PaymentService) { }

  ngOnInit(): void {
    this.paymentService.getPayments()
      .subscribe(payments => this.payments = payments)
  }

}
