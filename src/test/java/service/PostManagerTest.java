package service;

import model.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PostManagerTest {
    PostOffice postOffice;
    Post post;
    PostManager postManager;
    @Mock
    Address address;
    Stamp stamp;
    @Mock
    Address addressDiff;
    @Mock
    PostValidator postValidator;
    List<PostOffice> postOfficeList;
    @Mock
    Printer printer;

    @Before
    public void setUp() {
        postManager = new PostManager(postValidator, printer);
        post = new Post(1, address, address, "Hi", "Body", stamp, address, address);
        postOffice = new PostOffice(address);
        postOfficeList = new ArrayList<PostOffice>();
        postOfficeList.add(postOffice);
    }

    @Test
    public void ShouldBeAbleToFindDestinationPostOffice() {
        when(postValidator.isEligibleToSendPost(post, postOfficeList)).thenReturn(true);
        Assert.assertEquals(postOffice, postManager.findDestinationPostOffice(post, postOfficeList));
    }

    @Test
    public void ShouldBeAbleToThrowNullWhenDestinationPostOfficeIsNotFound() {
        post = new Post(2, addressDiff, addressDiff, "Hi", "Body", stamp, addressDiff, addressDiff);
        when(postValidator.isEligibleToSendPost(post, postOfficeList)).thenReturn(true);
        Assert.assertNull(postManager.findDestinationPostOffice(post, postOfficeList));
        verify(postValidator, times(1)).isEligibleToSendPost(post, postOfficeList);
    }

    @Test
    public void shouldBeAbleToSendPost() {
        postOffice = mock(PostOffice.class);
        postManager.sendPost(post, postOffice);
        verify(postOffice, times(1)).addPost(post);
    }

    @Test
    public void shouldBeAbleToPrintPost() {
        postManager.printPost(post);
        verify(printer, times(1)).printPosts(post);
    }
}