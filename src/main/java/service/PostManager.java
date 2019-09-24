package service;

import model.Post;
import model.PostOffice;
import model.Printer;

import java.util.List;

public class PostManager {
    PostValidator postValidator;
    Printer printer;

    public PostManager(PostValidator postValidator, Printer printer) {
        this.postValidator = postValidator;
        this.printer = printer;
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

    public void printPost(Post post) {
        printer.printPosts(post);
    }
}
