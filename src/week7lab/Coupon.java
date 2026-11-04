package week7lab;

public class Coupon {
    private double discountRate;
    private double minSubTotal;

    public Coupon(double discountRate, double minSubTotal) {
        this.minSubTotal = minSubTotal;
        if(discountRate < 0 || discountRate > 0.5) {
            System.out.println("Discount Rate must be at most %50!");
        }else {
            this.discountRate = discountRate;
        }
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public double getMinSubTotal() {
        return minSubTotal;
    }
    
    
    
}
