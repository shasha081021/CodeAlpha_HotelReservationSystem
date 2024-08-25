package com.hotel.utils;

public class PaymentProcessor {
    public boolean processPayment(double amount, String paymentMethod) {
        // Simulate payment processing
        System.out.println("Processing payment of $" + amount + " via " + paymentMethod);
        return true; // Assuming payment is always successful for simplicity
    }
}
