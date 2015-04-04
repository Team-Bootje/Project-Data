/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teambootje;

import facebook4j.conf.ConfigurationBuilder;
import java.sql.*;
import teambootje.*;
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
    static Boolean off;

    public static String timeline() throws TwitterException, SQLException {
        Twitter twitter = TwitterFactory.getSingleton();
        Query query = new Query("ssrotterdam");
        //query.setSince("2015-03-30");
       // query.setUntil("2015-04-04");
        query.setCount(100);
        

        QueryResult result = twitter.search(query);
        for (Status status : result.getTweets()) {
            String locationCity = null;
            String locationCountry = null;
            if (status.getPlace() != null) {
                cityVar = status.getPlace().getName();
                countryVar = status.getPlace().getCountry();
                locationCity = status.getPlace().getName();
                locationCountry = status.getPlace().getCountry();
            } else {
                countryVar = null;
                cityVar = null;
                locationCity = null;
                locationCountry = null;
            }

             post = status.getText();
            screenName = status.getUser().getScreenName();
//            ImportIntoSQL.TwitterImport();
        }
        
        return screenName + ": " + post;
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

    public static String getCityVar() {
        return cityVar;
    }

    public static String getCountryVar() {
        return countryVar;
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

    public static void main(String[] args) throws TwitterException, SQLException {
        timeline();
    }
}
