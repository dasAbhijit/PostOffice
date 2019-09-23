public class Printer extends PostStorage {

    public void printPosts(Post post) {
        System.out.print(post);
    }


    public void printAllPosts() {
        for (Post post : posts) {
            System.out.print(post);
        }
    }
}
