package main;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PostOfficeTest {
    PostOffice postOffice;
    Address address;
    Post post1;
    Post post2;
    Stamp stamp;
    Printer printer;


    @Before
    public void setUp() {
        address = new Address(1, "Line One", "WestBengal", "Kolkata", 700032);
        postOffice = new PostOffice(address);
        stamp = new Stamp(1, Type.NATIONAL, 5);
        post1 = new Post(1, address, address, "Hi", "Hello", stamp, address, address);
        post2 = new Post(1, address, address, "Hello", "Hey", stamp, address, address);
        postOffice.addPost(post1);
        postOffice.addPost(post2);
        printer = new Printer();
    }

    @Test
    public void allThePostShouldBePrinted() {
        postOffice.printAllPosts(printer);
    }
}