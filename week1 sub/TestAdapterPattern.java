package deepskilling;

public class TestAdapterPattern {

    public interface PaymentProcessor {
        void processPayment(double amount);
    }

    public static class PayPal {
        public void makePayment(double amount) {
            System.out.println("Processing payment of $" + amount + " through PayPal.");
        }
    }

    public static class Stripe {
        public void charge(double amount) {
            System.out.println("Charging $" + amount + " through Stripe.");
        }
    }

    public static class PayPalAdapter implements PaymentProcessor {
        private PayPal payPal;

        public PayPalAdapter(PayPal payPal) {
            this.payPal = payPal;
        }

        @Override
        public void processPayment(double amount) {
            payPal.makePayment(amount);
        }
    }

    public static class StripeAdapter implements PaymentProcessor {
        private Stripe stripe;

        public StripeAdapter(Stripe stripe) {
            this.stripe = stripe;
        }

        @Override
        public void processPayment(double amount) {
            stripe.charge(amount);
        }
    }

    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        System.out.println("Enter the amount to be processed:");
        double amount = scanner.nextDouble();

        PaymentProcessor payPalProcessor = new PayPalAdapter(new PayPal());
        PaymentProcessor stripeProcessor = new StripeAdapter(new Stripe());

        System.out.println("Processing payment with PayPal:");
        payPalProcessor.processPayment(amount);

        System.out.println("Processing payment with Stripe:");
        stripeProcessor.processPayment(amount);

        scanner.close();
    }
}
