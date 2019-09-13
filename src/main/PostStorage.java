package main;

import java.util.ArrayList;
import java.util.List;

public interface PostStorage {
    List<Post> posts=new ArrayList<Post>();

    public void addPost(Post post);
}
