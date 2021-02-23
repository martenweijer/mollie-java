import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { PaymentsComponent } from "./payments/payments.component";
import { PaymentComponent } from "./payment/payment.component";
import { CreatePaymentComponent } from "./create-payment/create-payment.component";

const routes: Routes = [
  { path: '', redirectTo: '/payments', pathMatch: 'full' },
  { path: 'payments', component: PaymentsComponent },
  { path: 'payments/:id', component: PaymentComponent },
  { path: 'create_payment', component: CreatePaymentComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
