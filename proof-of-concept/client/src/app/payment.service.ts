import { Injectable } from '@angular/core';
import { Payment } from './payment';
import { Observable, of } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PaymentService {

  constructor(private http: HttpClient) { }

  getPayments(): Observable<Payment[]> {
    return this.http.get<Payment[]>('http://localhost:8080/payments')
  }
}
