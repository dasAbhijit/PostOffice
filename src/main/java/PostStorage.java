import java.util.ArrayList;
import java.util.List;

public interface PostStorage {
    List<Post> posts=new ArrayList<Post>();

    void addPost(Post post);
}
