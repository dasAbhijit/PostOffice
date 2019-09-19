import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PostManagerTest {
    PostOffice postOffice;
    Post post;
    PostManager postManager;
    Address address;
    Stamp stamp;
    PostValidator postValidator;
    List<PostOffice> postOfficeList;
    Address address2;

    @Before
    public void testSetUp() {
        postValidator = new PostValidator();
        postManager = new PostManager(postValidator);
        address = new Address(1, "line one", "West Bengal", "kolkata", 700032);
        post = new Post(1, address, address, "hi", "body", stamp, address, address);
        postOffice = new PostOffice(address);
        postOfficeList = new ArrayList<PostOffice>();
        postOfficeList.add(postOffice);
        address2 = new Address(1, "line one", "West Bengal", "kolkata", 700032);
    }

    @Test
    public void ShouldBeAbleToFindDestinationPostOffice() {
        Assert.assertEquals(postOffice, postManager.findDestinationPostOffice(post, postOfficeList));
    }

    @Test
    public void ShouldBeAbleToThrowNullWhenDestinationPostOfficeIsNotFound() {
        post = new Post(2, address2, address2, "Hi", "Body", stamp, address2, address2);
        Assert.assertNull(postManager.findDestinationPostOffice(post, postOfficeList));
    }

    @Test
    public void shouldBeAbleToSendPost() {
        Assert.assertNull(postOffice.getPostById(1));
        postManager.sendPost(post, postOffice);
        Assert.assertEquals(post, postOffice.getPostById(1));
    }
}