import java.util.ArrayList;
import java.util.List;

public class PostStorage {
    List<Post> posts = new ArrayList<Post>();

    public void addPost(Post post) {
        posts.add(post);
    }

    public Post getPostById(int id) {
        for (Post post :
                posts) {
            if (post.getId() == id) {
                return post;
            }
        }
        return null;
    }

}
