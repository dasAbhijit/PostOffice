public class Printer extends PostStorage {

    public void printPosts(Post post) {
        System.out.print(post);
    }

    public void printPostById(int id) {
        System.out.print(getPostById(id));
    }

    public void printAllPosts() {
        for (Post post : posts) {
            System.out.print(post);
        }
    }
}
