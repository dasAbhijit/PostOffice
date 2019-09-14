import java.util.List;

public class PostSender {
    public void send(Post post, List<PostOffice> postOfficeList) {
        //ask Post Validator if Eligible to send the post
        PostValidator postValidator = new PostValidator();

        if (postValidator.isEligibleToSendPost(post, postOfficeList)) {
            PostOffice destinationPostOffice = findDestinationPostOffice(post, postOfficeList);
                storePostInPostOffice(post,destinationPostOffice);
        }


    }

    //find the post office where to send the post
    private PostOffice findDestinationPostOffice(Post post, List<PostOffice> postOfficeList) {
        Address destinationPostOffice = post.getToPostOfficeAddress();
        for (PostOffice postOffice : postOfficeList) {
            if (destinationPostOffice.equals(postOffice.getAddress())) {
                return postOffice;
            }
        }
        return null;
    }

    //store the post in destination post office
    private void storePostInPostOffice(Post post,PostOffice postOffice){
        postOffice.addPost(post);
    }
}
