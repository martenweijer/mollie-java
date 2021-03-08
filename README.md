Mollie Payment Library
======
[![Latest Version](https://img.shields.io/github/tag/martenweijer/mollie-java.svg?style=flat-square)](https://github.com/martenweijer/mollie-java/tags)

A library made for the payments functionality of Mollie build in Java.

## Usage
```java
import Mollie;

Mollie mollie = Mollie.create("MOLLIE_API_KEY");

List<Payment> payments = mollie.getPayments();
```

#### List all payments
```java
List<Payment> payments = mollie.getPayments();
```

#### Create a new payment
```java
Payment payment = mollie.createPayment(
    new CreatePayment("description", new Amount("EUR", "100.00"), "redirectUrl")
);
```

#### Find a payment
```java
Payment payment = mollie.findPayment("mollie_payment_id");
```

### Run the PoC application
- Start the server `./gradlew bootRun`
- Run the client `npm run start`