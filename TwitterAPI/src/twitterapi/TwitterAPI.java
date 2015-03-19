/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twitterapi;

import twitter4j.*;


/**
 * @author Roy van den Heuvel
 */
public class TwitterAPI {

    public static void timeline() throws TwitterException {
        Twitter twitter = TwitterFactory.getSingleton();
        Query query = new Query("ssrotterdam");
        query.setCount(100);
        query.setUntil("2015-03-19");
        
        QueryResult result = twitter.search(query);
        for (Status status : result.getTweets()) {
            String location = null;
            if(status.getPlace() != null) {
                location = status.getPlace().getName();
            }            
            System.out.println("@" + status.getUser().getScreenName() + ": " + status.getText() + " : Favorites: " + status.getFavoriteCount() + " : Retweets: " + status.getRetweetCount() + " : Gepost vanuit: " + location);
            
        }
    }

    public static void main(String[] args) throws TwitterException {
        timeline();
    }
}
