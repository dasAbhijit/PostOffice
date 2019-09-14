public class PostOffice implements PostStorage {
    Address address;

    public PostOffice(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public void addPost(Post post) {
        posts.add(post);
    }

    public void printAllPosts(Printer printer) {
        for (Post post : posts) {
            printer.addPost(post);
        }
    }
}
