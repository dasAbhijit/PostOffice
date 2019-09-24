package model;

import service.PostManager;

public class PostOffice extends PostStorage {
    private Address address;
    private PostManager postManager;
    private Printer printer;


    public PostOffice(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

}
