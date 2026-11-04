package week7lab;

public class Address {
    
    private String street;
    private String district;
    private String city;

    public Address(String street, String district, String city) {
        this.street = street;
        this.district = district;
        this.city = city;
    }

    @Override
    public String toString() {
        return String.format("Street: %s, District: %s, City: %s%n", street, district, city);
    }
    
    
}
