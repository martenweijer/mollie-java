Mollie Payment Library
======
[![Latest Version](https://img.shields.io/github/tag/martenweijer/mollie-java.svg?style=flat-square)](https://github.com/martenweijer/mollie-java/tags)

A library made for the payments functionality of Mollie, made with Java.

## Payments
https://docs.mollie.com/reference/v2/payments-api/create-payment
```java
MollieApiClient mollieApiClient = new MollieApiClient("MOLLIE_API_KEY");
```

#### Create a new payment
```java
Payment payment = new Payment();
payment.setDescription("description");
payment.setRedirectUrl("http://");
payment.setAmount(new Amount("100.00", "EUR"));

Payment result = mollieApiClient.payments().create(payment);
result.getId();
```

#### Get a payment
```java
Payment payment = mollieApiClient.payments().get("tr_MOLLIE_ID");
payment.getDescription();
payment.getRedirectUrl();
```

#### Cancel a payment
```java
Payment payment = mollieApiClient.payments().cancel("tr_MOLLIE_ID");
payment.getStatus();
```
