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
        /**
         * ** setSince kan alleen tot 7 dagen terug worden gebruikt***
         */

        String post;

        QueryResult result = twitter.search(query);
        for (Status status : result.getTweets()) {
            String locationCity = null;
            String locationCountry = null;
            if (status.getPlace() != null) {
                locationCity = status.getPlace().getName();
                locationCountry = status.getPlace().getCountry();
            } else {
                locationCity = "Niet beschikbaar";
                locationCountry = "Niet beschikbaar";
            }
            System.out.println("@" + status.getUser().getScreenName() + ": " + status.getText() + " : Favorites: " + status.getFavoriteCount() + " : Retweets: " + status.getRetweetCount() + " : Gepost vanuit: " + locationCity);
            Connection conn = getConn();
            /*
             String SQLQueryPost = "INSERT INTO posts (DID, AID, Post)"
             + " VALUES(?, ?, ?)";
             String SQLQueryPersoon = "INSERT INTO persoon (Name, Leeftijd, Geslacht, LID)"
             + " VALUES(?, ?, ?, ?)";
             String SQLQueryLocatie = "INSERT INTO locatie (Provincie, Land)"
             + " VALUES(?, ?)";
             String SQLCheckLocatie = "SELECT COUNT(*) FROM locatie WHERE provincie = ?";
             PreparedStatement preparedStmnt1 = conn.prepareStatement(SQLQueryPost);
             PreparedStatement preparedStmnt2 = conn.prepareStatement(SQLQueryPersoon);
             PreparedStatement prepareCheckLocatie = conn.prepareStatement(SQLCheckLocatie);
             PreparedStatement preparedStmnt3 = conn.prepareStatement(SQLQueryLocatie);
             */

            Statement stmnt = conn.createStatement();
            
            ResultSet RSLocatie = stmnt.executeQuery("SELECT COUNT(*) AS count FROM locatie WHERE provincie = " + locationCountry + ")");

            if (RSLocatie.getInt("count") >= 1) {
                stmnt.executeQuery("INSERT INTO locatie(Land, Stad) VALUES('"+ locationCountry +"', '"+ locationCity +"');");
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
            System.err.println("Got an exception!");
        }
        return conn;
    }

    public static void main(String[] args) throws TwitterException, SQLException {
        timeline();
    }
}
