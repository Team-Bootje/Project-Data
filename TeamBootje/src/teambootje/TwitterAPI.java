/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teambootje;

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
    
    // Deze method haalt de tweets op, gebaseerd op de onderstaand instellingen.
    public static void timeline() throws TwitterException, SQLException {
        Twitter twitter = TwitterFactory.getSingleton();
        
        //Hiernaar zoekt de API.
        Query query = new Query("ssrotterdam");
        query.setCount(100);
     
        //For-loop om alle tweets op te halen en te printen.
        QueryResult result = twitter.search(query);
        for (Status status : result.getTweets()) {
            if (status.getPlace() != null) {
                cityVar = status.getPlace().getName();
                countryVar = status.getPlace().getCountry();
            } else {
                countryVar = null;
                cityVar = null;
            }
            
            java.util.Date utilDate = status.getCreatedAt();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

            date = sqlDate;
            post = status.getText();
            screenName = status.getUser().getScreenName();
            try {
                ImportIntoSQL.TwitterImport();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //Method om verbinding te maken met de database.
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

    //Deze methode laat het resultaat zien in TwitterGui().
    public static String getTweets() {
    return screenName + post + date + cityVar + countryVar ;
    }
    
    //Getters voor de database.
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
