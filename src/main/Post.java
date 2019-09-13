package main;

public class Post {
    private int id;
    private Address fromAddress;
    private Address toAddress;
    private String subject;
    private String body;
    private Stamp stamp;
    private Address fromPostOfficeAddress;
    private Address toPostOfficeAddress;

    public Post(int id, Address fromAddress, Address toAddress, String subject, String body, Stamp stamp, Address fromPostOfficeAddress, Address toPostOfficeAddress) {
        this.id = id;
        this.fromAddress = fromAddress;
        this.toAddress = toAddress;
        this.subject = subject;
        this.body = body;
        this.stamp = stamp;
        this.fromPostOfficeAddress = fromPostOfficeAddress;
        this.toPostOfficeAddress = toPostOfficeAddress;
    }

    public int getId() {
        return id;
    }

    public Address getFromAddress() {
        return fromAddress;
    }

    public Address getToAddress() {
        return toAddress;
    }

    public String getSubject() {
        return subject;
    }

    public String getBody() {
        return body;
    }

    public Stamp getStamp() {
        return stamp;
    }

    public Address getFromPostOfficeAddress() {
        return fromPostOfficeAddress;
    }

    public Address getToPostOfficeAddress() {
        return toPostOfficeAddress;
    }
}
