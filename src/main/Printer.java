package main;

public class Printer implements PostStorage{
    @Override
    public void addPost(Post post) {
        posts.add(post);
    }
}
