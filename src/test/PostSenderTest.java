package test;

import main.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PostSenderTest {

    Post post;
    Address firstAddress;
    Stamp stamp;
    PostSender postSender;
    List<PostOffice> postOffices;

    @Before
    public void setUp() throws Exception {
        firstAddress = new Address(1, "first Line","WestBengal","Kolkata",700032);
        stamp= new Stamp(1,Type.NATIONAL,5);
        post = new Post(1,firstAddress,firstAddress,"Hi","How are you?",stamp,firstAddress,firstAddress);
        postSender = new PostSender();
        postOffices = new ArrayList<PostOffice>();
        postOffices.add(new PostOffice(firstAddress));
    }

    @Test
    public void shouldBeAbleToSendPost() {
        postSender.send(post,postOffices);
    }
}