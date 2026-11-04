package week7lab;

import java.util.ArrayList;
import week7lab.Exceptions.ItemNotFoundException;
import week7lab.Exceptions.MinimumOrderException;

public class Order {
    private Customer customer;
    private ArrayList<MenuItem> items = new ArrayList<>();
    private static int nextOrderNumber = 1001;
    private static final int MIN_ORDER = 100;
    private static final int DELIVERY_FEE = 20;
    private static int completedOrders = 0;
    private static double totalRevenue = 0; 
    private Coupon coupon;

    public Order(Customer customer) {
        this.customer = customer;
        nextOrderNumber++;
    }
    
    public void addItem(MenuItem item) {
        boolean isFound = false;
        for(MenuItem i : items) {
            if(i.getName().equals(item.getName())) {
                int index = items.indexOf(i);
                items.get(index).setQuantity(items.get(index).getQuantity() + item.getQuantity());
                isFound = true;
            }
        }
        if(!isFound) {
            items.add(item);
        }
    }
    
    public void updateQuantity(String name, int quantity) {
        boolean isFound = false;
        for(MenuItem i : items) {
            if(i.getName().equals(name)) {
                int index = items.indexOf(i);
                items.get(index).setQuantity(quantity);
                isFound = true;
            }
        }
        try {
            if(!isFound) {
                throw new ItemNotFoundException("Item not found!");
            }
        }catch(ItemNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void removeItem(String name) {
        boolean isFound = false;
        for(MenuItem i : items) {
            if(i.getName().equals(name)) {
                int index = items.indexOf(i);
                items.remove(index);
                isFound = true;
            }
        }
        try {
            if(!isFound) {
                throw new ItemNotFoundException("Item not found!");
            }
        }catch(ItemNotFoundException ex) {
            System.out.println(ex.getMessage());
        } 
    }

    public ArrayList<MenuItem> getItems() {
        return items;
    }
    
    public double getSubTotal() {
        double tempTotal = 0;
        for(MenuItem i : items) {
            tempTotal += i.getTotalPrice();
        }
        return tempTotal;
    }

    public static int getCompletedOrders() {
        return completedOrders;
    }

    public static double getTotalRevenue() {
        return totalRevenue;
    }
    
    public boolean applyCoupon(Coupon coupon) {
        if(getSubTotal() >= coupon.getMinSubTotal()) {
            this.coupon = coupon;
            return true;
        }
        return false;
    }
    
    
    public void chckout() {
        double total = 0;
        try{
            if(getSubTotal() < MIN_ORDER) {
                throw new MinimumOrderException("Order must be more than 100 $!");
            }
            System.out.println("------- ORDER -------");
            System.out.println("");
            System.out.println(customer);
            for(MenuItem i : items) {
                System.out.println(i);
            }
            System.out.println("Total without coupon: " + getSubTotal());
            if(coupon == null) {
                total = getSubTotal() + DELIVERY_FEE;
                System.out.println("Coupon wasn't applied!");
                System.out.println("Total: " + total + " (20$ Delivery Fee)");
            }else {
                System.out.printf("Coupon was applied! (%.2f)%n", coupon.getDiscountRate());
                total = getSubTotal() - (getSubTotal() * coupon.getDiscountRate()) + DELIVERY_FEE;
                System.out.println("Total: " + total + " (20$ Delivery Fee)");
            }
            totalRevenue += total;
            completedOrders++;
            
        }catch (MinimumOrderException ex) {
            System.out.println(ex.getMessage());
        }

    }
    
}
