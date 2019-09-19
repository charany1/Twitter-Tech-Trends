package com.blogofyogi.twittertechtrends.commandlinerunner;

import com.blogofyogi.twittertechtrends.twitter.TweetStatusListener;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import twitter4j.FilterQuery;
import twitter4j.StatusListener;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;


@Component
public class TwitterStreamCommandLineRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {

        TwitterStream twitterStream = new TwitterStreamFactory().getInstance();

        // Adding Listener to consume tweets
        StatusListener listener = new TweetStatusListener();
        twitterStream.addListener(listener);

        // filtering tweets that has content "android" or "iphone"
        FilterQuery filterQuery = new FilterQuery();
        filterQuery.track("android","ios","blackberry","windows");

        // applying the filter
        twitterStream.filter(filterQuery);


    }
}
