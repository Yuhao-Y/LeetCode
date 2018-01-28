import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class DesignTwitter{
    HashMap<Integer, Set<Integer>> relation;
    HashMap<Integer, List<Tweet>> userTweets;
    int tweetsCount = 0;
    
    /** Initialize your data structure here. */
    public DesignTwitter() {
        relation = new HashMap<Integer, Set<Integer>>();
        userTweets = new HashMap<Integer, List<Tweet>>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if(!relation.containsKey( userId)) relation.put( userId, new HashSet<Integer>()); //follow self that user can get news from myself
        relation.get( userId ).add( userId );
        
        if( !userTweets.containsKey(userId) ) userTweets.put( userId, new ArrayList<Tweet>());
        userTweets.get(userId).add( new Tweet( userId, tweetId,tweetsCount++));
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> result = new ArrayList<Integer>();
        
        PriorityQueue<Tweet> queue = new PriorityQueue<Tweet>(1, new Comparator<Tweet>(){
            @Override
            public int compare( Tweet t1, Tweet t2){
                if( t2.index>t1.index) return 1;
                else return -1;
            }
        });
        
        if(relation.get(userId)!=null)
            for( Integer i: relation.get(userId)){
                if( userTweets.get(i) !=null)
                    queue.addAll(  userTweets.get( i ) );
                    //for( Tweet tweet: userTweets.get(i)){
                    //    queue.add(tweet);
                    //}
            }
        
        while(!queue.isEmpty()){
            result.add(queue.poll().tweetId);
            if( result.size()==10) break;
        }
        
        return result;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        //if( followerId == followeeId) return;
        if(!relation.containsKey( followerId)) relation.put( followerId, new HashSet<Integer>());
        relation.get( followerId ).add( followeeId );
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(relation.containsKey( followerId)&&followerId!=followeeId) 
            relation.get( followerId ).remove( followeeId );
    }
}

class Tweet{
    
    int userId;
    int tweetId;
    int index;
    
    public Tweet( int userId, int tweetId, int index){
        this.userId = userId;
        this.tweetId = tweetId;
        this.index = index;
    }
}

