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
* [Customers](#customers)
* [Shipments](#shipments)
* [Orders](#orders)
* [Refunds](#refunds)
* [Subscriptions](#subscriptions)

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
```

----

### Customers
https://docs.mollie.com/reference/v2/customers-api/create-customer
```java
CustomerEndpoint customers = mollieApiClient.customers();
```

#### Create a new customer
```java
Customer customer = new Customer();
customer.setName("customer");

Customer result = mollieApiClient.customers().create(customer);
result.getId();
```

#### Get a customer
```java
Customer customer = mollieApiClient.customers().get("customerId");
customer.getMode();
```

#### Update a customer
```java
Customer customer = new Customer();
customer.setName("update customer");

mollieApiClient.customers().update("customerId", customer);
```

#### Delete a customer
```java
mollieApiClient.customers().delete("customerId");
```

#### List customers
```java
Page<Customer> page = mollieApiClient.customers().all();
List<Customer> customers = page.getItems();
```

----

### Shipments
https://docs.mollie.com/reference/v2/shipments-api/create-shipment
```java
ShipmentEndpoint shipments = mollieApiClient.shipments();
```

#### Create a new shipment
```java
Shipment shipment = new Shipment();

Shipment result = mollieApiClient.shipments().create("orderId", shipment);
result.getId();
```

#### Get a shipment
```java
Shipment shipment = mollieApiClient.shipments().get("customerId");
shipment.getId();
```

#### Update a shipment
```java
Shipment shipment = new Shipment();

mollieApiClient.shipments().update("orderId", shipment);
```

#### List shipments
```java
Page<Shipment> page = mollieApiClient.shipments().all();
List<Shipment> shipments = page.getItems();
```

----

### Orders
https://docs.mollie.com/reference/v2/orders-api/create-order
```java
OrderEndpoint orders = mollieApiClient.orders();
```

#### Create a new order
```java
Order order = new Order();

Order result = mollieApiClient.orders().create(order);
result.getId();
```

#### Get an order
```java
Order order = mollieApiClient.orders().get("orderId");
order.getId();
```

#### Update an order
```java
Order order = new Order();

mollieApiClient.orders().update("orderId", order);
```

#### Delete an order
```java
mollieApiClient.orders().delete("orderId");
```

#### List orders
```java
Page<Order> page = mollieApiClient.orders().all();
List<Order> orders = page.getItems();
```

----

### Refunds
https://docs.mollie.com/reference/v2/refunds-api/create-refund
```java
RefundEndpoint refunds = mollieApiClient.refunds();
```

#### Create a new refund
```java
Refund refund = new Refund();

Refund result = mollieApiClient.refunds().create("paymentId", refund);
result.getId();
```

#### Get a refund
```java
Refund refund = mollieApiClient.refunds().get("paymentId", "refundId");
refund.getId();
```

#### Delete a refund
```java
mollieApiClient.refunds().cancel("paymentId", "refundId");
```

#### List refunds
```java
Page<Refund> page = mollieApiClient.refunds().all();
List<Refund> orders = page.getItems();
```

----

### Subscriptions
https://docs.mollie.com/reference/v2/subscriptions-api/create-subscription
```java
SubscriptionEndpoint subscriptions = mollieApiClient.subscriptions();
```

#### Create a new subscription
```java
Subscription subscription = new Subscription();

Subscription result = mollieApiClient.subscriptions().create("customerId", subscription);
result.getId();
```

#### Get a subscription
```java
Subscription subscription = mollieApiClient.subscriptions().get("customerId", "refundId");
subscription.getId();
```

#### Delete a subscription
```java
mollieApiClient.subscriptions().cancel("customerId", "subscriptionId");
```

#### List subscriptions
```java
Page<Subscription> page = mollieApiClient.subscriptions().all("customerId");
List<Subscription> orders = page.getItems();
```
