import {Amount} from "./amount";

export class Payment {
  id: string;
  description: string;
  amount: Amount;
  redirectUrl: string;

  constructor() {
    this.amount = new Amount();
  }

}
