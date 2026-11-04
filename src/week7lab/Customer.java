package week7lab;

public class Customer {
    private String name;
    private String phone;
    private Address address;

    public Customer(String name, String phone, String street, String district, String city) {
        this.name = name;
        this.phone = phone;
        this.address = new Address(street, district, city);
    }
    
    @Override
    public String toString() {
        return "Name: " + name + ", Phone: " + phone + ", " + address;
    }
}
