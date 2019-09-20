package com.blogofyogi.twittertechtrends.commandlinerunner;

import com.blogofyogi.twittertechtrends.twitter.TweetStatusListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import twitter4j.FilterQuery;
import twitter4j.StatusListener;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;

import java.util.List;


@Component
@Slf4j
public class TwitterStreamCommandLineRunner implements CommandLineRunner {

    @Value("#{'${techwords}'.split(',')}")
    private List<String> techWords;


    @Override
    public void run(String... args) throws Exception {

        TwitterStream twitterStream = new TwitterStreamFactory().getInstance();

        // Adding Listener to consume tweets
        StatusListener listener = new TweetStatusListener();
        twitterStream.addListener(listener);




        log.info("TechWords : {}",techWords);



        FilterQuery filterQuery = new FilterQuery();filterQuery.track(techWords.toArray(new String[techWords.size()]));

        // applying the filter
        twitterStream.filter(filterQuery);


    }
}
