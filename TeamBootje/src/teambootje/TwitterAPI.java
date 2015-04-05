/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teambootje;

import java.sql.*;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

/**
 * @author Roy van den Heuvel
 */
public class TwitterAPI {

    // Database URL
    static final String DB_URL = "jdbc:mysql://localhost/teambootje";

    // Database inloggegevens
    static final String USER = "root";
    static final String PASS = "";

    //variabelen
    static String cityVar;
    static String countryVar;
    static String screenName;
    static String post;
    static Date date;

    public static String timeline() throws TwitterException, SQLException {
        Twitter twitter = TwitterFactory.getSingleton();
        Query query = new Query("#ssRotterdam");
        query.setSince("2015-03-30");
        query.setUntil("2015-04-04");
        query.setCount(100);
        

        QueryResult result = twitter.search(query);
        for (Status status : result.getTweets()) {
            {System.out.println(status.getUser().getName() + ": " + status.getText() + ". ");}
            screenName = status.getUser().getName();
            post = status.getText();
            date = (Date) status.getCreatedAt();
        }
        return screenName + ": " + post + ". " + " " + date;
    }

    public static Connection getConn() {
        Connection conn = null;
        try {
            // Step 1: Load the JDBC driver. 
            Class.forName("com.mysql.jdbc.Driver");
            // Step 2: Establish the connection to the database. 
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (Exception e) {
            System.err.println("Er kon geen database-connectie worden gemaakt.");
        }
        return conn;
    }
    
    public static String getScreenName() {
        return screenName;
    }
    
    public static String getPost() {
        return post;
    }
    
    public static Date getDate() {
        return date;
    }

    public static String getCityVar() {
        return cityVar;
    }

    public static String getCountryVar() {
        return countryVar;
    }

    public static void main(String[] args) throws TwitterException, SQLException {
        timeline();
    }
}
