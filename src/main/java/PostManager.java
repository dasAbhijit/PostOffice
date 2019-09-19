import java.util.List;

public class PostManager {
    PostValidator postValidator;

    public PostManager(PostValidator postValidator) {
        this.postValidator = postValidator;
    }

    public PostOffice findDestinationPostOffice(Post post, List<PostOffice> postOfficeList) {
        if (postValidator.isEligibleToSendPost(post, postOfficeList)) {
            for (PostOffice postOffice :
                    postOfficeList) {
                if (post.getToPostOfficeAddress().equals(postOffice.getAddress())) {
                    return postOffice;
                }
            }
        }
        return null;
    }

    public void sendPost(Post post, PostOffice postOffice) {
        postOffice.addPost(post);
    }
}
