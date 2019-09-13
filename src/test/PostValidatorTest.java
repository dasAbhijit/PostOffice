package test;

import main.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PostValidatorTest {
    Address firstAddress;
    Address secondAddress;
    Address thirdAddress;
    List<PostOffice> postOfficeDatabase;
    Stamp stamp;
    Post post;
    PostValidator postValidator;
    PostOffice firstPostOffice;
    PostOffice secondPostOffice;

    @Before
    public void setUp() throws Exception {
        firstAddress = new Address(1, "Address Line 1", "West Bengal", "Kolkata", 700032);
        secondAddress = new Address(2, "Address Line 2", "Rajasthan", "Jaipur", 302005);
        thirdAddress = new Address(3, "Address Line 3", "Karnataka", "Bangalore", 560095);
        postOfficeDatabase = new ArrayList<PostOffice>();
        firstPostOffice = new PostOffice(firstAddress);
        secondPostOffice = new PostOffice(secondAddress);
        postOfficeDatabase.add(firstPostOffice);
        postOfficeDatabase.add(secondPostOffice);
        stamp = new Stamp(1, Type.NATIONAL, 5);
        postValidator = new PostValidator();
    }

    @Test
    public void shouldNotBeEligibleToSendPostWhenThereIsNoContent() {
        post = new Post(1, firstAddress, secondAddress, "", "", stamp, firstAddress, secondAddress);
        Assert.assertFalse(postValidator.isEligibleToSendPost(post, postOfficeDatabase));
    }

    @Test
    public void shouldNotBeAbleToSendPostWhenToPostOfficeDoesNotExistInDatabase() {
        post = new Post(1, firstAddress, secondAddress, "Hi", "Hello, how are you?", stamp, firstAddress, thirdAddress);
        Assert.assertFalse(postValidator.isEligibleToSendPost(post, postOfficeDatabase));
    }

    @Test
    public void shouldNotBeAbleToSendPostWhenToPostOfficeDoesNotIsNotPresent() {
        post = new Post(1, firstAddress, secondAddress, "Hi", "Hello, how are you?", stamp, firstAddress, null);
        Assert.assertFalse(postValidator.isEligibleToSendPost(post, postOfficeDatabase));
    }
}
