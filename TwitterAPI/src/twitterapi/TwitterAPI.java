/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twitterapi;

import twitter4j.*;
import java.util.*;
import java.text.*;

/**
 * @author Roy van den Heuvel
 */
public class TwitterAPI {

    static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    static Date date = new Date();
    static String datePostFormat = dateFormat.format(date);

    public static void timeline() throws TwitterException {
        Twitter twitter = TwitterFactory.getSingleton();
        Query query = new Query("ssrotterdam");
        query.setCount(100);
        query.setSince("2010-01-01");
        query.setUntil(datePostFormat);
        QueryResult result = twitter.search(query);
        for (Status status : result.getTweets()) {
            System.out.println("@" + status.getUser().getScreenName() + ":" + status.getText());
        }
    }

    public static void main(String[] args) throws TwitterException {
        timeline();
    }
}
