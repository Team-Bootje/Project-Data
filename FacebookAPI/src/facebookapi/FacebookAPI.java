package facebookapi;

import facebook4j.Facebook; 
import facebook4j.FacebookException; 
import facebook4j.FacebookFactory;
import facebook4j.Post; 
import facebook4j.ResponseList; 
import facebook4j.conf.Configuration;
import facebook4j.conf.ConfigurationBuilder;


public class FacebookAPI {

    public static void main(String[] args) throws FacebookException {
 
    // De configuratie variabelen om de tokens op te slaan    
    ConfigurationBuilder configurationBuilder = new ConfigurationBuilder(); 
    configurationBuilder.setDebugEnabled(true); 
    configurationBuilder.setOAuthAppId("450968085058420"); 
    configurationBuilder.setOAuthAppSecret("4f1cb5c92bf70a13d26efd5cc4a62055"); 
    configurationBuilder.setOAuthAccessToken("CAAAAKvQdWksBAKjZC2iz0Hg3yxuDYSyduZBYcVWe3bs7OXpxgR1lNngRivB7CL6FgcKDo4SZC7eCKBFpEriGbML7lnsTyZA9ntYjMjs5kGuLiUMSNXCXnYXKZB1JAeAF5SWcYwlamUBta5JGTn70h1ZCIYpMEx9M7gv2O1XndGotcmYF7nkXOwopjdFHt9wbi8ridFCHk3KJcTKQMbP1PNTakD4fKnJAoZD"); 
    configurationBuilder.setOAuthPermissions("email, publish_stream, id, name, first_name, last_name, gender, age_range,  read_stream , generic"); 
    configurationBuilder.setUseSSL(true); 
    configurationBuilder.setJSONStoreEnabled(true);
    
    // Maakt configuratie en de Facebook.get instance;
    Configuration configuration = configurationBuilder.build();
    FacebookFactory ff = new FacebookFactory(configuration);
    Facebook Facebook = ff.getInstance(); 
    /*
    try { 
        String searchPost = "";
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat( "dd_MM_yyyy_hh_mm");
        String fileName = searchPost + "_" + simpleDateFormat.format(date) + ".txt";
        String results = getFacebookPostes(Facebook, searchPost);
        File file = new File(fileName);
        if (!file.exists()) { file.createNewFile(); FileWriter fw = new FileWriter(file.getAbsoluteFile()); 
        BufferedWriter bw = new BufferedWriter(fw); bw.write(results); bw.close(); System.out.println("Completed");
        } } catch (IOException e) { e.printStackTrace(); }*/

    }
    
    
    // Deze methode haalt Facebook post op met het zoekwoord in de try hierboven;
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


    // Deze methode haalt Facebook feeds op met het onderstaande zoekword;
    public static String getFacebookFeed(Facebook Facebook, String searchPost) throws FacebookException { 
        String searchResult = "ssRotterdam";
        StringBuilder searchMessage = new StringBuilder();
        ResponseList<Post> results = Facebook.getFeed(searchPost);
        for (Post post : results) { System.out.println(post.getMessage());
        searchMessage.append(post.getFrom().getName() + ", "); searchMessage.append(post.getMessage() + ", ");
        searchMessage.append(post.getCreatedTime() + "\n"); }
        searchResult = searchResult + searchMessage.toString();
        return searchResult; } 

    private static void setExtendedAccessToken() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
