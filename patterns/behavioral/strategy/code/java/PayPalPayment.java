package patterns.behavioral.strategy.code.java;
public class PayPalPayment implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Paying $" + amount + " with PayPal");
    }
}

