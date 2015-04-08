/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teambootje;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.Post;
import facebook4j.ResponseList;
import facebook4j.User;
import facebook4j.conf.Configuration;
import facebook4j.conf.ConfigurationBuilder;
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Johan
 */
public class FacebookAPI {

    private static String facebookPost;
    private static String screenName;
    private static String locationCity;
    private static String locationCountry;
    private static Date date;

    public static void main(String[] args) throws FacebookException {

        ConfigurationBuilder configurationBuilder = new ConfigurationBuilder();
        configurationBuilder.setDebugEnabled(true);
        configurationBuilder.setOAuthAppId("476059649213785");
        configurationBuilder.setOAuthAppSecret("88eacd3eec295028a3f56ca4b7cc69ef");
        configurationBuilder.setOAuthAccessToken("CAAGwZBUZAIhVkBAKTrnvgZConGF4l1ZAABE1AhC7e245J9s8LcbIdGmQzZAO4PcRgvkt2uHzW2hRdSp4UVQN6xDIz4wI32UsQbtBicQD2lD9PNEZBlgZBE9f0VwPtZAsumz1KwNOcoZCF2R7jc2wCPG1JRRyZCjzuQeQhQ4jlEeXh0LQI53jh24ZCvj5PVGPPpbKQYZD");
        configurationBuilder.setOAuthPermissions("email, publish_stream, id, name, first_name, last_name, read_stream , generic, user_birthday,user_location,user_hometown");
        configurationBuilder.setUseSSL(true);
        configurationBuilder.setJSONStoreEnabled(true);
// Create configuration and get Facebook instance 
        Configuration configuration = configurationBuilder.build();
        FacebookFactory ff = new FacebookFactory(configuration);
        Facebook Facebook = ff.getInstance();
        String searchPost = "ssRotterdam";
        String results = getFacebookPosts(Facebook, searchPost);

    }

    public static String getFacebookPosts(Facebook Facebook, String searchPost) throws FacebookException {
        String searchResult = "\n";
        StringBuilder searchMessage = new StringBuilder();

        ResponseList<Post> results = Facebook.getPosts(searchPost);
        for (Post post : results) {
            facebookPost = post.getMessage();
            screenName = post.getFrom().getName();
            if (post.getPlace() != null) {
                locationCity = post.getPlace().getLocation().getCity();
                locationCountry = post.getPlace().getLocation().getCountry();
            } else {
                locationCity = null;
                locationCountry = null;
            }
            java.util.Date utilDate = post.getCreatedTime();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

            date = sqlDate;

            try {
                ImportIntoSQL.FacebookImport();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            searchMessage.append("\n");
            searchMessage.append(post.getFrom().getName() + ": " + "\n");
            searchMessage.append(post.getMessage() + ". " + "\n");
            searchMessage.append(post.getCreatedTime() + ", ");
            searchMessage.append("\n");
        }

        String feedString = getFacebookFeed(Facebook, searchPost);
        searchResult = searchResult + searchMessage.toString();
        searchResult = searchResult + feedString;
        return searchResult;
    }

    public static String getFacebookFeed(Facebook Facebook, String searchPost) throws FacebookException {
        String searchResult = "";
        StringBuilder searchMessage = new StringBuilder();
        ResponseList<Post> results = Facebook.getFeed(searchPost);
        for (Post post : results) {
            searchMessage.append("\n");
            searchMessage.append(post.getFrom().getName() + ": ");
            searchMessage.append(post.getMessage() + ". ");
            searchMessage.append(post.getCreatedTime());
            searchMessage.append("\n");
        }
        searchResult = searchResult + searchMessage.toString();
        return searchResult;
    }

    public static String getCountryVar() {
        return locationCountry;
    }

    public static String getPost() {
        return facebookPost;
    }

    public static String getScreenName() {
        return screenName;
    }

    public static String getCityVar() {
        return locationCity;
    }

    public static Date getDate() {
        return date;
    }
}
