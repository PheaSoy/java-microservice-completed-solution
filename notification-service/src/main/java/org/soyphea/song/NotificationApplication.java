package org.soyphea.song;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.SubscribableChannel;

@SpringBootApplication
@EnableBinding(SMSChannel.class)
public class NotificationApplication {

    private Logger logger = LoggerFactory.getLogger(NotificationApplication.class);

    public static void main(String args[]){

        SpringApplication.run(NotificationApplication.class);

    }

    @StreamListener(target = SMSChannel.SEND)
    public void receivedSMS(String sms) {
        logger.info("Got a message:{}",sms);
    }
}

interface SMSChannel{

    String SEND ="send";
    @Input(SEND)
    SubscribableChannel send();
}

