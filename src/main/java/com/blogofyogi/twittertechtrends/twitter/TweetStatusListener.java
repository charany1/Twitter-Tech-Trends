package com.blogofyogi.twittertechtrends.twitter;

import com.blogofyogi.twittertechtrends.kafka.KafkaPublisher;
import lombok.extern.slf4j.Slf4j;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;

@Slf4j
public class TweetStatusListener implements StatusListener {
    @Override
    public void onStatus(Status status) {
        String tweet = status.getText().toLowerCase();
        String userId = status.getUser().getScreenName();

        KafkaPublisher.send(userId, tweet);

    }

    @Override
    public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {

    }

    @Override
    public void onTrackLimitationNotice(int i) {

    }

    @Override
    public void onScrubGeo(long l, long l1) {

    }

    @Override
    public void onStallWarning(StallWarning stallWarning) {

    }

    @Override
    public void onException(Exception e) {

    }
}
