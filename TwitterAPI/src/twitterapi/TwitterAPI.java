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
    
    //variabelen
    static String cityVar;
    static String countryVar;
    static String screenName;
    static String post;
    static Date date;
    

    public static void timeline() throws TwitterException, SQLException {
        Twitter twitter = TwitterFactory.getSingleton();      
        Query query = new Query("ssrotterdam");
        query.setCount(100);
        /**
         ** setSince kan alleen tot 7 dagen terug worden gebruikt***
         */

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
                countryVar = "N/A";
                cityVar = "N/A";
                locationCity = "N/A";
                locationCountry = "N/A";
            }
            //System.out.println("@" + status.getUser().getScreenName() + ": " + status.getText() + " : Favorites: " + status.getFavoriteCount() + " : Retweets: " + status.getRetweetCount() + " : Gepost vanuit: " + locationCity);         
            // Converteert de datum vanuit de twitter API naar een datum object dat SQL kan gebruiken.
            java.util.Date utilDate = status.getCreatedAt();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            
            date = sqlDate;
            post = status.getText();
            screenName = status.getUser().getScreenName();
            try{
                ImportIntoSQL.TwitterImport();
            }
            catch(SQLException e){
                //e.printStackTrace();
            }
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
            System.err.println("Er kon geen database-connectie worden gemaakt.");
        }
        return conn;
    }
    
    public static String getCityVar(){
        return cityVar;
    }
    
    public static String getCountryVar(){
        return countryVar;
    }
    
    public static String getScreenName(){
        return screenName;
    }
    
    public static String getPost(){
        return post;
    }
    
    public static Date getDate(){
        return date;
    }

    public static void main(String[] args) throws TwitterException, SQLException {
        timeline();
    }
}
