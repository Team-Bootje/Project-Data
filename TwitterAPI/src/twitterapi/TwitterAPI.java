/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package twitterapi;

import java.sql.*;
import twitter4j.*;


/**
 * @author Roy van den Heuvel
 */
public class TwitterAPI {

    public static void timeline() throws TwitterException {
        Twitter twitter = TwitterFactory.getSingleton();
        Query query = new Query("ssrotterdam");
        query.setCount(100);
        /**** setSince kan alleen tot 7 dagen terug worden gebruikt****/
        query.setSince("2015-03-12");
        query.setUntil("2015-03-13");
        
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
        try {
            Connection conn = null;
            // Step 1: Load the JDBC driver. 
            Class.forName("org.gjt.mm.mysql.Driver");
            // Step 2: Establish the connection to the database. 
            String url = "jdbc:mysql://145.24.235.14/teambootje";
            String user = "root";
            String password = "";
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.err.println("Got an exception!");
        }
        timeline();
    }
}
