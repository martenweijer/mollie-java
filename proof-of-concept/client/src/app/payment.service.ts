import { Injectable } from '@angular/core';
import { Payment } from './payment';
import { Observable, of, throwError as observableThrowError } from 'rxjs';
import {HttpClient, HttpErrorResponse} from '@angular/common/http';
import { catchError, map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class PaymentService {

  constructor(private http: HttpClient) { }

  getPayments(): Observable<Payment[]> {
    return this.http.get<Payment[]>('payments')
  }

  getPayment(id: string): Observable<Payment> {
    return this.http.get<Payment>('payments/'+ id)
  }

  createPayment(payment: Payment) {
    const headers = new Headers({
      'Content-Type': 'application/json'
    });

    return this.http
      .post<Payment>('payments', payment)
      .pipe(catchError(this.handleError))
  }

  private handleError(res: HttpErrorResponse | any) {
    console.error(res);
    return observableThrowError(res.error || 'Server error');
  }
}
