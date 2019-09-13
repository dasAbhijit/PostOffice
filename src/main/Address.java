package main;

public class Address {
    private int id;
    private String lineOne;
    private String state;
    private String city;
    private int postalCode;

    public Address(int id, String lineOne, String state, String city, int postalCode) {
        this.id = id;
        this.lineOne = lineOne;
        this.state = state;
        this.city = city;
        this.postalCode = postalCode;
    }
}
