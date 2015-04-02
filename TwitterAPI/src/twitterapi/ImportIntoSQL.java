package twitterapi;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static twitterapi.TwitterAPI.getConn;

/**
 * @author Roy van den Heuvel
 */
public class ImportIntoSQL {

    public static void TwitterImport() throws SQLException {
        Connection conn = getConn();
        String locationCountry = TwitterAPI.getCountryVar();
        String locationCity = TwitterAPI.getCityVar();
        String screenName = TwitterAPI.getScreenName();
        String post = TwitterAPI.getPost();
        Date date = TwitterAPI.getDate();

        // LOCATIE
        if (locationCountry != null && !locationCity.isEmpty()) {
            PreparedStatement locatieStmnt = conn.prepareStatement("INSERT INTO locatie(Land, Stad) VALUES(?, ?);");

            if (locationCity != null && !locationCity.isEmpty()) {
                locatieStmnt.setString(2, locationCity);
            }
            locatieStmnt.setString(1, locationCountry);
            locatieStmnt.execute();
        }

        // PERSOON
        PreparedStatement persoonStmnt = conn.prepareStatement("INSERT INTO persoon(Name, LID) VALUES(?, ?);");
        PreparedStatement checkLID = conn.prepareStatement("SELECT LID FROM locatie WHERE stad = ?");

        // Haalt LID van persoon op.
        checkLID.setString(1, locationCity);
        ResultSet RSCheckLID = checkLID.executeQuery();

        while (RSCheckLID.next()) {
            int LID = RSCheckLID.getInt(1);
            System.out.println("==========" + LID + "==========");

            // Maakt de query af en voert de query uit.
            persoonStmnt.setString(1, screenName);
            persoonStmnt.setInt(2, LID);
            persoonStmnt.execute();

        }

        // POSTS
        PreparedStatement postStmnt = conn.prepareStatement("INSERT INTO posts(Post, Datum) VALUES(?, ?);");
        //postStmnt.setInt(1, x);
        postStmnt.setString(1, post);
        postStmnt.setDate(2, date);
        postStmnt.execute();
    }
}