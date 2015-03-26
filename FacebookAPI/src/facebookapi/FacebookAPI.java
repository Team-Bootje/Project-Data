/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facebookapi;

import facebook4j.Facebook; 
import facebook4j.FacebookException; 
import facebook4j.FacebookFactory;
import facebook4j.Post; 
import facebook4j.ResponseList; 
import facebook4j.conf.Configuration;
import facebook4j.conf.ConfigurationBuilder;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author Johan
 */
public class FacebookAPI {

    public static void main(String[] args) throws FacebookException {
 
    ConfigurationBuilder configurationBuilder = new ConfigurationBuilder(); 
    configurationBuilder.setDebugEnabled(true); 
    configurationBuilder.setOAuthAppId("476059649213785"); 
    configurationBuilder.setOAuthAppSecret("88eacd3eec295028a3f56ca4b7cc69ef"); 
    configurationBuilder.setOAuthAccessToken("CAAGwZBUZAIhVkBAKTrnvgZConGF4l1ZAABE1AhC7e245J9s8LcbIdGmQzZAO4PcRgvkt2uHzW2hRdSp4UVQN6xDIz4wI32UsQbtBicQD2lD9PNEZBlgZBE9f0VwPtZAsumz1KwNOcoZCF2R7jc2wCPG1JRRyZCjzuQeQhQ4jlEeXh0LQI53jh24ZCvj5PVGPPpbKQYZD"); 
    configurationBuilder .setOAuthPermissions("email, publish_stream, id, name, first_name, last_name, read_stream , generic"); 
    configurationBuilder.setUseSSL(true); 
    configurationBuilder.setJSONStoreEnabled(true); 
// Create configuration and get Facebook instance 
    Configuration configuration = configurationBuilder.build();
    FacebookFactory ff = new FacebookFactory(configuration);
    Facebook Facebook = ff.getInstance(); 
    try { // Set search string and get results 
        String searchPost = "ssRotterdam";
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat( "dd_MM_yyyy_hh_mm");
        String fileName = searchPost + "_" + simpleDateFormat.format(date) + ".txt";
        String results = getFacebookPostes(Facebook, searchPost);
        File file = new File(fileName);
        if (!file.exists()) { file.createNewFile(); FileWriter fw = new FileWriter(file.getAbsoluteFile()); 
        BufferedWriter bw = new BufferedWriter(fw); bw.write(results); bw.close(); System.out.println("Completed");
        } } catch (IOException e) { e.printStackTrace(); }

    
    
    
    
    
    }
    
    public static String getFacebookPostes(Facebook Facebook, String searchPost) throws FacebookException { 
        String searchResult = "Item : " + searchPost + "\n";
        StringBuilder searchMessage = new StringBuilder();
        ResponseList<Post> results = Facebook.getPosts(searchPost);
        for (Post post : results) { System.out.println(post.getMessage());
        searchMessage.append(post.getMessage() + "\n"); for (int j = 0; j < post.getComments().size(); j++) { 
            searchMessage.append(post.getComments().get(j).getFrom() .getName() + ", ");
            searchMessage.append(post.getComments().get(j).getMessage() + ", ");
            searchMessage.append(post.getComments().get(j).getCreatedTime() + ", ");
            searchMessage.append(post.getComments().get(j).getLikeCount() + "\n"); } } 
        String feedString = getFacebookFeed(Facebook, searchPost);
        searchResult = searchResult + searchMessage.toString();
        searchResult = searchResult + feedString; return searchResult; }


public static String getFacebookFeed(Facebook Facebook, String searchPost) throws FacebookException { 
    String searchResult = "";
    StringBuilder searchMessage = new StringBuilder();
    ResponseList<Post> results = Facebook.getFeed(searchPost);
    for (Post post : results) { System.out.println(post.getMessage());
    searchMessage.append(post.getFrom().getName() + ", "); searchMessage.append(post.getMessage() + ", ");
    searchMessage.append(post.getCreatedTime() + "\n"); }
    searchResult = searchResult + searchMessage.toString();
    return searchResult; } // This method is used to create JSON object from data string public static String stringToJson(String data) { JsonConfig cfg = new JsonConfig(); try { JSONObject jsonObject = JSONObject.fromObject(data, cfg); System.out.println("JSON = " + jsonObject.toString()); } catch (Exception e) { e.printStackTrace(); } return "JSON Created"; } } - See more at: http://www.devx.com/Java/how-to-integrate-facebook-and-twitter-with-java-applications.html#sthash.j7rhjhmF.dpuf

}
