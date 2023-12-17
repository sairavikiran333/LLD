/*
follow(1, 3)
getFollowers(1) // return [3]
getFollowings(3) // return [1]
follow(2, 3)
getFollowings(3) // return [1,2]
unfollow(1, 3)
getFollowings(3) // return [2]*/

package com.test;
import java.util.*;

public class FriendshipService { 

    private Map<Integer, Set<Integer>> followers, followings;

    public FriendshipService() {
        this.followers = new HashMap<Integer, Set<Integer>>();
        this.followings = new HashMap<Integer, Set<Integer>>();
    }

    public List<Integer> getFollowers(int user) {
        if (!followers.containsKey(user))
            return new ArrayList<Integer>();

        return new ArrayList<Integer>(followers.get(user));
    }

    public List<Integer>  getFollowings(int user) {
        if (!followings.containsKey(user))
            return new ArrayList<Integer>();

        return new ArrayList<Integer>(followings.get(user));
    }

    public void follow(int to_user, int from_user) {
        if (!followers.containsKey(to_user))
            followers.put(to_user, new TreeSet<Integer>());

        followers.get(to_user).add(from_user);

        if (!followings.containsKey(from_user))
            followings.put(from_user, new TreeSet<Integer>());

        followings.get(from_user).add(to_user);
    }

    public void unfollow(int to_user, int from_user) {
        if (followers.containsKey(to_user))
            followers.get(to_user).remove(from_user);

        if (followings.containsKey(from_user))
            followings.get(from_user).remove(to_user);
    }
    
    public static void main(String[] args) {
        FriendshipService friendshipService = new FriendshipService();

        friendshipService.follow(1, 3);
        System.out.println("Followers of 1: " + friendshipService.getFollowers(1)); // [3]
        System.out.println("Followings of 3: " + friendshipService.getFollowings(3)); // [1]

        friendshipService.follow(2, 3);
        System.out.println("Followings of 3: " + friendshipService.getFollowings(3)); // [1, 2]

        friendshipService.unfollow(1, 3);
        System.out.println("Followings of 3: " + friendshipService.getFollowings(3)); // [2]
    }
}