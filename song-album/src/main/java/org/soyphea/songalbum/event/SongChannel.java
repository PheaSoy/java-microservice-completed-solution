package org.soyphea.songalbum.event;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface SongChannel {

    String SEND = "send";

    @Output(SEND)
    MessageChannel send();
}
