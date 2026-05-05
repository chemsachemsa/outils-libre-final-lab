public class PricingEngine {

    public double calculate(double[] prices, int[] quantities, String customerType, String discountCode) {

        double subtotal = calculateSubtotal(prices, quantities);
        double discount = calculateDiscount(subtotal, customerType, discountCode);
        double tax = calculateTax(subtotal - discount);

        return subtotal - discount + tax;
    }

    private double calculateSubtotal(double[] prices, int[] quantities) {
        double total = 0;
        for (int i = 0; i < prices.length; i++) {
            total += prices[i] * quantities[i];
        }
        return total;
    }

    private double calculateDiscount(double subtotal, String customerType, String discountCode) {
        double discount = 0;

        if (discountCode.equals("SAVE10")) {
            discount = subtotal * 0.1;
        } else if (discountCode.equals("SAVE20")) {
            discount = subtotal * 0.2;
        }

        if (customerType.equals("VIP")) {
            discount += subtotal * 0.05;
        }

        return discount;
    }

    private double calculateTax(double amount) {
        return amount * 0.19;
    }
}