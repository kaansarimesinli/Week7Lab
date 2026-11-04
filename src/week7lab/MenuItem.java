package week7lab;

import week7lab.Exceptions.InvalidQuantityException;

public class MenuItem {
    
    private String name;
    private double price;
    private int quantity;

    public MenuItem(String name, double price, int quantity) {
        this.name = name;
        this.quantity = quantity;
        if(price <= 0) {
            System.out.println("Price must be positive!");
        }else {
            this.price = price;
        }
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        try{
            if(quantity <= 0) {
                throw new InvalidQuantityException("Quantity must be positive!");
            }
            this.quantity = quantity;
        }catch(InvalidQuantityException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public double getTotalPrice() {
        return price * quantity;
    }
    
    @Override
    public String toString() {
        return String.format("Item Name: %s, Price: %.1f $, Quantity: %d (Total Price: %.1f x %d - %.1f $)", name, price, quantity, price, quantity, getTotalPrice());
    }
}
