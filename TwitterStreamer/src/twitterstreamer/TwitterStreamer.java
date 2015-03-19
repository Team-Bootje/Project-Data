package twitterstreamer;

import twitter4j.*;
import twitter4j.conf.*;

public final class TwitterStreamer {

    public static void main(String[] args) throws TwitterException {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true);
        cb.setOAuthConsumerKey("TMoLusb1KCZ2KNWHREQj1dN7s");
        cb.setOAuthConsumerSecret("nVbHmDf1T1u7T8Wh8XVhffnlA8CbS4zsh8pa02qjHcHv3fLO4W");
        cb.setOAuthAccessToken("356841347-O1uAf3mdaNQtTXbXDFecnERdoAtvZhXdbpUw5IRc");
        cb.setOAuthAccessTokenSecret("9YHVKXTAoFjVS5vMfX4ZvlRUoVTDFgP7neDklWSTTNZ9e");
        TwitterStream twitterStream = new TwitterStreamFactory(cb.build()).getInstance();
     
        StatusListener listener = new StatusListener() {
            @Override
            public void onStatus(Status status) {
                System.out.println("@" + status.getUser().getScreenName() + " - " + status.getText());
            }

            @Override
            public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {
                System.out.println("Got a status deletion notice id:" + statusDeletionNotice.getStatusId());
            }

            @Override
            public void onTrackLimitationNotice(int numberOfLimitedStatuses) {
                System.out.println("Got track limitation notice:" + numberOfLimitedStatuses);
            }

            @Override
            public void onScrubGeo(long userId, long upToStatusId) {
                System.out.println("Got scrub_geo event userId:" + userId + " upToStatusId:" + upToStatusId);
            }

            @Override
            public void onStallWarning(StallWarning warning) {
                System.out.println("Got stall warning:" + warning);
            }

            @Override
            public void onException(Exception ex) {
                ex.printStackTrace();
            }
        };

        FilterQuery fq = new FilterQuery();

        String keywords[] = {"Rotterdam"};

        fq.track(keywords);

        twitterStream.addListener(listener);
        twitterStream.filter(fq);
    }
}
