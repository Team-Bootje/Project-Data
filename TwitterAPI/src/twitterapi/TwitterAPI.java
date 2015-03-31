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
         ** setSince kan alleen tot 7 dagen terug worden gebruikt***
         */

        QueryResult result = twitter.search(query);
        for (Status status : result.getTweets()) {
            String locationCity = null;
            String locationCountry = null;
            if (status.getPlace() != null) {
                locationCity = status.getPlace().getName();
                locationCountry = status.getPlace().getCountry();
            } else {
                locationCity = "Niet_beschikbaar";
                locationCountry = "Niet_beschikbaar";
            }
            System.out.println("@" + status.getUser().getScreenName() + ": " + status.getText() + " : Favorites: " + status.getFavoriteCount() + " : Retweets: " + status.getRetweetCount() + " : Gepost vanuit: " + locationCity);
            Connection conn = getConn();
            
            // LOCATIE
            PreparedStatement locatieStmnt = conn.prepareStatement("INSERT INTO locatie(Land, Stad) VALUES(?, ?);");
            
            locatieStmnt.setString(1, locationCountry);
            locatieStmnt.setString(2, locationCity);
            
            if(locatieStmnt.execute()){
                
            }
            
            // PERSOON
            PreparedStatement persoonStmnt = conn.prepareStatement("INSERT INTO persoon(Name, LID) VALUES(?, ?);");
            PreparedStatement checkLID = conn.prepareStatement("SELECT LID FROM locatie WHERE stad = ?");
            
            //haalt LID van persoon op
            checkLID.setString(1, locationCity);
            checkLID.execute();
            ResultSet RSCheckLID = checkLID.executeQuery();
            while (RSCheckLID.next()) {
                int LID = RSCheckLID.getInt(1);
                persoonStmnt.setString(1, status.getUser().getScreenName());
                persoonStmnt.setInt(2, LID);
                persoonStmnt.execute();
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
