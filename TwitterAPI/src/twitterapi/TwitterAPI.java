/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twitterapi;

import twitter4j.*;

/**
 *
 * @author Roy van den Heuvel
 */
public class TwitterAPI {

    public static void timeline() throws TwitterException {
        Twitter twitter = TwitterFactory.getSingleton();
        Query query = new Query("ssRotterdam");
        query.setCount(100);
        QueryResult result = twitter.search(query);
        for (Status status : result.getTweets()) {
            System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
        }
    }

    public static void main(String[] args) throws TwitterException{
        timeline();
    }
}
