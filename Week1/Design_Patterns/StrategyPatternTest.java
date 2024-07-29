package com.example.strategypattern;

interface PaymentStrategy {
    void pay(double amount);
}
class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String cardHolderName;

    public CreditCardPayment(String cardNumber, String cardHolderName) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Credit Card. Card Number: " + cardNumber);
    }
}

//package com.example.strategypattern;

class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using PayPal. Email: " + email);
    }
}
//package com.example.strategypattern;

class PaymentContext {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void pay(double amount) {
        paymentStrategy.pay(amount);
    }
}
//package com.example.strategypattern;

public class StrategyPatternTest {
    public static void main(String[] args) {
        // Create a PaymentContext instance
        PaymentContext context = new PaymentContext();

        // Set CreditCardPayment strategy and pay
        PaymentStrategy creditCardPayment = new CreditCardPayment("1234-5678-9012-3456", "John Doe");
        context.setPaymentStrategy(creditCardPayment);
        context.pay(100.00);

        // Set PayPalPayment strategy and pay
        PaymentStrategy payPalPayment = new PayPalPayment("john.doe@example.com");
        context.setPaymentStrategy(payPalPayment);
        context.pay(200.00);
    }
}
