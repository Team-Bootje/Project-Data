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
import facebook4j.conf.Configuration;
import facebook4j.conf.ConfigurationBuilder;

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
    configurationBuilder.setOAuthPermissions("email, publish_stream, id, name, first_name, last_name, read_stream , generic"); 
    configurationBuilder.setUseSSL(true); 
    configurationBuilder.setJSONStoreEnabled(true); 
// Create configuration and get Facebook instance 
    Configuration configuration = configurationBuilder.build();
    FacebookFactory ff = new FacebookFactory(configuration);
    Facebook Facebook = ff.getInstance(); 
     String searchPost = "ssRotterdam";
    String results = getFacebookPostes(Facebook, searchPost);
    
    }
    
    
    public static String getFacebookPostes(Facebook Facebook, String searchPost) throws FacebookException { 
        String searchResult = "Item : " + searchPost + "\n";
        StringBuilder searchMessage = new StringBuilder();
  
        ResponseList<Post> results = Facebook.getPosts(searchPost);
        for (Post post : results) { 
          //  System.out.println(post.getMessage());
          //  System.out.println(post.getCreatedTime());
            searchMessage.append(post.getMessage() + "\n"); for (int j = 0; j < post.getComments().size(); j++) { 
            searchMessage.append(post.getComments().get(j).getFrom() .getName() + ", ");
            searchMessage.append(post.getComments().get(j).getMessage() + ", ");
            searchMessage.append(post.getComments().get(j).getCreatedTime() + ", ");
            searchMessage.append(post.getComments().get(j).getLikeCount() + "\n"); } } 
        String feedString = getFacebookFeed(Facebook, searchPost);
        searchResult = searchResult + searchMessage.toString();
        searchResult = searchResult + feedString; 
        return searchResult; }


public static String getFacebookFeed(Facebook Facebook, String searchPost) throws FacebookException { 
    String searchResult = "";
    StringBuilder searchMessage = new StringBuilder();
    ResponseList<Post> results = Facebook.getFeed(searchPost);
    for (Post post : results) { 
        searchMessage.append("\n");
        searchMessage.append(post.getFrom().getName() + ": ");
        searchMessage.append(post.getMessage() + ". ");
        searchMessage.append(post.getCreatedTime()); 
        searchMessage.append("\n");}
    searchResult = searchResult + searchMessage.toString();
    return searchResult; }

}
