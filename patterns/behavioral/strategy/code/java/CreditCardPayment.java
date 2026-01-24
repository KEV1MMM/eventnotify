package patterns.behavioral.strategy.code.java;
public class CreditCardPayment implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Paying $" + amount + " with Credit Card");
    }
}

