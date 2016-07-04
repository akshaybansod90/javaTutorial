package designQuestions.twitter;

import javafx.collections.transformation.SortedList;

import java.util.*;

/**
 * Created by Akshay on 6/12/2016.
 * <p>
 * Design a simplified version of Twitter where users can post tweets, follow/unfollow another user and is able to see the 10 most recent tweets in the user's news feed. Your design should support the following methods:
 * <p>
 * postTweet(userId, tweetId): Compose a new tweet.
 * getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
 * follow(followerId, followeeId): Follower follows a followee.
 * unfollow(followerId, followeeId): Follower unfollows a followee.
 */
public class Twitter {
    private static HashMap<Integer, User> userMap = new HashMap<>();
    private static HashMap<Integer, Tweet> tweetHashMap = new HashMap<>();

    public static class User {
        private Integer userId;
        private Set<User> follower = new HashSet<>();
        private Set<User> following = new HashSet<>();
        private List<Tweet> tweets = new ArrayList<>();

        public User(Integer userId) {
            this.userId = userId;
        }

        public List<User> getFollowers() {
            return follower == null ? null : new ArrayList<>(follower);
        }

        public List<User> getFollowings() {
            return following == null ? null : new ArrayList<>(following);
        }

        public boolean postTweet(String tweet) {
            Tweet tweetObj = new Tweet(tweet);
            tweetHashMap.put(tweetObj.tweetId, tweetObj);
            tweets.add(tweetObj);
            return true;
        }

        public boolean follow(User followee) {
            this.following.add(followee);
            followee.follower.add(this);
            return true;
        }

        public boolean unfollow(User followee) {
            this.following.remove(followee);
            followee.follower.remove(this);
            return true;
        }
    }

    public static class Tweet {
        int tweetId;
        String tweet;
        Date createDateTime;

        public Tweet(String tweet) {
            this.tweet = tweet;
            this.tweetId = UUID.randomUUID().hashCode();
            this.createDateTime = new Date();
        }
    }

    public static boolean addUser(User user) {
        if (userMap.containsKey(user.userId))
            return false;
        userMap.put(user.userId, user);
        return true;
    }

    public static boolean postTweet(Integer userId, String tweet) {
        User user = userMap.get(userId);
        return user == null ? false : user.postTweet(tweet);
    }

    public static boolean follow(Integer followerId, Integer followeeId) {
        User follower = userMap.get(followerId);
        User followee = userMap.get(followeeId);
        if (followee == null || follower == null) {
            return false;
        }
        return follower.follow(followee);
    }

    public static boolean unfollow(Integer followerId, Integer followeeId) {
        User follower = userMap.get(followerId);
        User followee = userMap.get(followeeId);
        if (followee == null || follower == null) {
            return false;
        }
        return follower.unfollow(followee);
    }

    public static List<Tweet> getNewsFeed(int userId) {
        User user = userMap.get(userId);
        if (user == null) return null;
        List<Tweet> feeds = new ArrayList<>();

        for (User followingUser : user.following) {
            feeds.addAll(followingUser.tweets);
        }
        Collections.sort(feeds, new Comparator<Tweet>() {
            @Override
            public int compare(Tweet o1, Tweet o2) {
                return o1.createDateTime.compareTo(o2.createDateTime);
            }
        });
        return feeds;
    }

}
