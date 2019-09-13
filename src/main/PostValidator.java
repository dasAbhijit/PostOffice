package main;

import java.util.List;

public class PostValidator {
    public boolean isEligibleToSendPost(Post post, List<PostOffice> postOfficeList) {
        if (isPostBlank(post)) {
            return false;
        }
        if (isToPostOfficePresentInPost(post)) {
            if (isToPostOfficeExisting(post, postOfficeList)) {
                return true;
            }
        }
        return false;
    }

    //check if the To Post Office address exists
    private boolean isToPostOfficeExisting(Post post, List<PostOffice> postOfficeList) {
        for (PostOffice postOffice : postOfficeList) {
            if (post.getToPostOfficeAddress().equals(postOffice.getAddress())) {
                return true;
            }
        }
        return false;
    }

    //check if the To Post Office address is present in Mail
    private boolean isToPostOfficePresentInPost(Post post) {
        return post.getToPostOfficeAddress() != null ? true : false;
    }

    //check if the mail is blank
    private boolean isPostBlank(Post post) {
        return (post.getBody() == "" && post.getSubject() == "") ? true : false;
    }

}
