package designQuestions.twitter;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * Created by Akshay on 6/12/2016.
 */
public class TwitterTest {
    @Before
    public void setUp() throws Exception {
        Twitter.addUser(new Twitter.User(1));
        Twitter.addUser(new Twitter.User(2));
        Twitter.addUser(new Twitter.User(3));
        Twitter.addUser(new Twitter.User(4));
        Twitter.follow(1, 2);
        Twitter.follow(1, 3);
        Twitter.follow(1, 4);
        Twitter.follow(2, 1);
        Twitter.follow(3, 2);
        Twitter.follow(3, 4);
        Twitter.postTweet(1, "I am user 1");
        Twitter.postTweet(2, "I am user 2");
        Twitter.postTweet(3, "I am user 3");
        Twitter.postTweet(4, "I am user 4");
        TimeUnit.MICROSECONDS.sleep(250);
        Twitter.postTweet(1, "I am user 1 and this is my second tweet");
        Twitter.postTweet(2, "I am user 2 and this is my second tweet");
    }

    @Test
    public void getNewsFeed() throws Exception {

        assertTrue(Twitter.getNewsFeed(1).size()==4);
        assertTrue(Twitter.getNewsFeed(2).size()==2);
        assertTrue(Twitter.getNewsFeed(3).size()==3);
        assertTrue(Twitter.getNewsFeed(4).size()==0);

    }

}