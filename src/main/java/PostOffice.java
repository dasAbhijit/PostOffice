public class PostOffice extends PostStorage {
    Address address;
    PostManager postManager;
    Printer printer;


    public PostOffice(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

}
