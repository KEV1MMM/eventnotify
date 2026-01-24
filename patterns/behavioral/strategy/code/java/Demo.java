package patterns.behavioral.strategy.code.java;
public class Demo {
    public static void main(String[] args) {
        PaymentStrategy card = new CreditCardPayment();
        PaymentStrategy paypal = new PayPalPayment();

        card.pay(100);
        paypal.pay(50);
    }
}

