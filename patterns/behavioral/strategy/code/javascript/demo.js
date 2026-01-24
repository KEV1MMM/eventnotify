class CreditCardPayment {
  pay(amount) {
    console.log("Paying $" + amount + " with Credit Card");
  }
}

class PayPalPayment {
  pay(amount) {
    console.log("Paying $" + amount + " with PayPal");
  }
}

// Demo
const card = new CreditCardPayment();
const paypal = new PayPalPayment();

card.pay(100);
paypal.pay(50);

