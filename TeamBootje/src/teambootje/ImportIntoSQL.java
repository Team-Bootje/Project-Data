package teambootje;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import static teambootje.TwitterAPI.getConn;

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

        // Check of locatie al bestaat, indien niet, insert locatie
        String select_lid_from_locatie_where_land___and_ = "select lid from locatie where land = ? and stad = ?";
        PreparedStatement locatiePrep = conn.prepareStatement(select_lid_from_locatie_where_land___and_);
        locatiePrep.setString(1, locationCountry);
        locatiePrep.setString(2, locationCity);
        Integer locatieId = getIdOrNull(locatiePrep);
        if (locatieId == null) {
            // doe een insert
            if (locationCountry != null && !locationCountry.isEmpty()) {
                PreparedStatement locatieStmnt = conn.prepareStatement("INSERT INTO locatie(Land, Stad) VALUES(?, ?);");

                String tweedeColom = locationCity != null && !locationCity.isEmpty()
                        ? locationCity
                        : null;

                locatieStmnt.setString(2, locationCity);

                locatieStmnt.setString(1, locationCountry);
                locatieStmnt.execute();
            }

            locatieId = getIdOrNull(locatiePrep);
        }

        // Check of persoon al bestaat, indien niet, insert persoon
        String persoonSelect = "select aid from persoon where name = ?";
        PreparedStatement persoonPrep = conn.prepareStatement(persoonSelect);
        persoonPrep.setString(1, screenName);
        Integer persoonId = getIdOrNull(persoonPrep);
        if (persoonId == null) {
            // doe een insert
            PreparedStatement locatieStmnt = conn.prepareStatement("INSERT INTO persoon(name, lid) VALUES(?, ?);");
            locatieStmnt.setString(1, screenName);
            locatieStmnt.setObject(2, locatieId);
            locatieStmnt.execute();

            persoonId = getIdOrNull(persoonPrep);
        }

        // POSTS
        PreparedStatement postStmnt = conn.prepareStatement("INSERT INTO posts(AID, Post, Datum) VALUES(?, ?, ?);");

        postStmnt.setInt(1, persoonId);
        postStmnt.setString(2, post);
        postStmnt.setDate(3, date);
        postStmnt.execute();
    }

    private static Integer getIdOrNull(PreparedStatement locatiePrep) throws SQLException {
        ResultSet locatieResultSet = locatiePrep.executeQuery();
        if (locatieResultSet.next()) {
            return locatieResultSet.getInt(1);
        }
        return null;
    }
}
