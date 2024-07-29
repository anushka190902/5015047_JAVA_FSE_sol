package com.example.adapterpattern;

interface PaymentProcessor {
    void processPayment(double amount);
}

// PayPal payment gateway class
class PayPal {
    public void makePayment(double amount) {
        System.out.println("Processing payment of $" + amount + " through PayPal.");
    }
}

// Stripe payment gateway class
class Stripe {
    public void executePayment(double amount) {
        System.out.println("Processing payment of $" + amount + " through Stripe.");
    }
}

// Square payment gateway class
 class Square {
    public void processTransaction(double amount) {
        System.out.println("Processing payment of $" + amount + " through Square.");
    }
}

// PayPal Adapter class
class PayPalAdapter implements PaymentProcessor {
    private PayPal payPal;

    public PayPalAdapter(PayPal payPal) {
        this.payPal = payPal;
    }

    @Override
    public void processPayment(double amount) {
        payPal.makePayment(amount);
    }
}

// Stripe Adapter class
class StripeAdapter implements PaymentProcessor {
    private Stripe stripe;

    public StripeAdapter(Stripe stripe) {
        this.stripe = stripe;
    }

    @Override
    public void processPayment(double amount) {
        stripe.executePayment(amount);
    }
}

// Square Adapter class
class SquareAdapter implements PaymentProcessor {
    private Square square;

    public SquareAdapter(Square square) {
        this.square = square;
    }

    @Override
    public void processPayment(double amount) {
        square.processTransaction(amount);
    }
}


public class AdapterPatternTest {
    public static void main(String[] args) {
        // Create instances of the payment gateways
        PayPal payPal = new PayPal();
        Stripe stripe = new Stripe();
        Square square = new Square();

        // Create adapter instances
        PaymentProcessor payPalAdapter = new PayPalAdapter(payPal);
        PaymentProcessor stripeAdapter = new StripeAdapter(stripe);
        PaymentProcessor squareAdapter = new SquareAdapter(square);

        // Process payments using the adapters
        payPalAdapter.processPayment(100.00);
        stripeAdapter.processPayment(200.00);
        squareAdapter.processPayment(300.00);
    }
}
