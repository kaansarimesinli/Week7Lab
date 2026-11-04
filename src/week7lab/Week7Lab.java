package week7lab;

public class Week7Lab {

    public static void main(String[] args) {
        Customer c1 = new Customer("Kaan", "05555555555", "Talas Bulvari", "Talas", "Kayseri");
        Customer c2 = new Customer("Betul", "05555555555", "Cumhuriyet Meydani", "Melikgazi", "Kayseri");
        
        MenuItem m1 = new MenuItem("Hamburger", 150, 1);
        MenuItem m2 = new MenuItem("Pizza", 250, 1);
        
        Order o1 = new Order(c1);
        Order o2 = new Order(c2);
        
        Coupon coupon1 = new Coupon(0.2, 250);
        
        o1.addItem(m2);
        o1.applyCoupon(coupon1);
        
        
        o2.addItem(m2);
        o2.addItem(m1);
        o1.chckout();
        System.out.println("");
        o2.chckout();
        
        System.out.println("");
        
        System.out.println("Completed Orders: " + Order.getCompletedOrders());
        System.out.println("Total Revenue: " + Order.getTotalRevenue());
    }

}
