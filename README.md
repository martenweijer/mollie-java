Mollie Payment Library
======
[![Latest Version](https://img.shields.io/github/tag/martenweijer/mollie-java.svg?style=flat-square)](https://github.com/martenweijer/mollie-java/tags)

API library for the functionalities of Mollie, made with Java.

## Usage
```java
MollieApiClient mollieApiClient = new MollieApiClient("MOLLIE_API_KEY");
```

## Table of Contents

* [Payments](#payments)
* [Payment methods](#payment-methods)
* [Invoices](#invoices)
* [Onboarding](#onboarding)
* [Chargebacks](#chargebacks)
* [Permissions](#permissions)
* [Organizations](#organizations)
* [Mandates](#mandates)

### Payments
https://docs.mollie.com/reference/v2/payments-api/create-payment
```java
PaymentEndpoint payments = mollieApiClient.payments();
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

#### List payments
```java
QueryMap queryMap = new QueryMap();
queryMap.put("from", "tr_MOLLIE_ID");
queryMap.put("limit", "10");
Page<Payment> payments = mollieApiClient.payments().page(queryMap);
List<Payment> items = payments.getItems();
```

----

### Payment Methods
https://docs.mollie.com/reference/v2/methods-api/get-method
```java
MethodEndpoint methods = mollieApiClient.methods();
```

#### Get a payment method
```java
Method method = mollieApiClient.methods().get("ideal");
method.getDescription();
method.getStatus();
```

#### Get all payment methods
```java
Page<Method> methods = mollieApiClient.methods().all();
List<Method> items = methods.getItems();
```

----

### Invoices
https://docs.mollie.com/reference/v2/invoices-api/get-invoice
```java
InvoiceEndpoint invoices = mollieApiClient.invoices();
```

#### Get an invoice
```java
Invoice invoice = mollieApiClient.invoices().get("inv_xBEbP9rvAq");
invoice.getVatNumber();
invoice.getStatus();
```

#### List invoices
```java
Page<Invoice> invoices = mollieApiClient.invoices().page();
List<Invoice> items = invoices.getItems();
```

----

### Onboarding
https://docs.mollie.com/reference/v2/onboarding-api/get-onboarding-status
```java
OnboardingEndpoint onboarding = mollieApiClient.onboarding();
```

#### Get onboarding status
```java
Onboarding onboarding = mollieApiClient.onboarding().get();
onboarding.getName();
onboarding.getStatus();
```

#### Submit onboarding status
```java
Organization organization = new Organization();
organization.setName("foo");
Onboarding onboarding = new Onboarding();
onboarding.setOrganization(organization);
mollieApiClient.onboarding().submit(onboarding);
```

----

### Chargebacks
https://docs.mollie.com/reference/v2/chargebacks-api/get-chargeback
```java
ChargebackEndpoint chargebacks = mollieApiClient.chargebacks();
```

#### Get a chargeback
```java
Chargeback chargeback = mollieApiClient.chargebacks().get("paymentId", "chargebackId");
chargeback.getId();
chargeback.getAmount();
```

#### List chargebacks
```java
Page<Chargeback> chargebacks = mollieApiClient.chargebacks().all("paymentId");
List<Chargeback> items = chargebacks.getItems();
```

----

### Permissions
https://docs.mollie.com/reference/v2/permissions-api/get-permission
```java
PermissionEndpoint permissions = mollieApiClient.permissions();
```

#### Get a permission
```java
Permission permission = mollieApiClient.permissions().get("permissionId");
permission.getId();
permission.getDescription();
```

#### List permissions
```java
Page<Permission> permissions = mollieApiClient.permissions().all();
List<Permission> items = permissions.getItems();
```

----

### Organizations
https://docs.mollie.com/reference/v2/organizations-api/current-organization
```java
OrganizationEndpoint organizations = mollieApiClient.organizations();
```

#### Get the current organization
```java
Organization organization = mollieApiClient.organizations().get("me");
organization.getId();
```

----

### Mandates
https://docs.mollie.com/reference/v2/mandates-api/create-mandate
```java
MandateEndpoint mandates = mollieApiClient.mandates();
```

#### Create a new mandate
```java
Mandate mandate = new Mandate();
mandate.setMethod("directdebit");
mandate.setConsumerName("consumerName");

Mandate result = mollieApiClient.mandates().create(mandate, "customerId");
result.getId();
```

#### Get a mandate
```java
Mandate mandate = mollieApiClient.mandates().get("customerId", "mandateId");
mandate.getMode();
```

#### Revoke a mandate
```java
mollieApiClient.mandates().revoke("customerId", "mandateId");
```

#### List mandates
```java
Page<Mandate> page = mollieApiClient.mandates().all("customerId");
List<Mandate> mandates = page.getItems();
