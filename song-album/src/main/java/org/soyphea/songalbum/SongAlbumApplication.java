package org.soyphea.songalbum;

import org.soyphea.songalbum.event.SongChannel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableDiscoveryClient
@EnableBinding(SongChannel.class)
public class SongAlbumApplication {

    public static void main(String[] args) {
        SpringApplication.run(SongAlbumApplication.class, args);
    }

}
