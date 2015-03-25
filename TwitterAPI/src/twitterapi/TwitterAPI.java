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

    // Database URL
    static final String DB_URL = "jdbc:mysql://localhost/teambootje";

    // Database inloggegevens
    static final String USER = "root";
    static final String PASS = "";

    public static void timeline() throws TwitterException, SQLException {
        Twitter twitter = TwitterFactory.getSingleton();
        Query query = new Query("ssrotterdam");
        query.setCount(100);
        //setSince kan alleen tot 7 dagen terug worden gebruikt
        query.setSince("");
     
        String post;
        
        QueryResult result = twitter.search(query);
        for (Status status : result.getTweets()) {
            String location = null;
            if (status.getPlace() != null) {
                location = status.getPlace().getName();
            } else {
                location = "Niet beschikbaar";
            }
            System.out.println("@" + status.getUser().getScreenName() + ": " + status.getText() + " : Favorites: " + status.getFavoriteCount() + " : Retweets: " + status.getRetweetCount() + " : Gepost vanuit: " + location);
            Connection conn = getConn();
            String SQLQuery = " insert into posts (PID, DID, AID, Post)"
                    + " values(?, ?, ?, ?)";
            PreparedStatement preparedStmnt = conn.prepareStatement(SQLQuery);

            post = status.getText();
            preparedStmnt.setInt(1, 1);
            preparedStmnt.setInt(2, 2);
            preparedStmnt.setInt(3, 3);
            preparedStmnt.setString(4, post);     
            preparedStmnt.execute();
        }
    }
    
    public static Connection getConn() {
        Connection conn = null;
        try {          
            // Step 1: Load the JDBC driver. 
            Class.forName("com.mysql.jdbc.Driver");
            // Step 2: Establish the connection to the database. 
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (Exception e) {
            System.err.println("Got an exception!");
        }
        return conn;
    }

    public static void main(String[] args) throws TwitterException, SQLException {
        timeline();
    }
}
