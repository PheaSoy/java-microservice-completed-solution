package org.soyphea.songalbum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient

public class SongAlbumApplication {

    //private Logger logger = LoggerFactory.getLogger(SongAlbumApplication.class);


    public static void main(String[] args) {
        SpringApplication.run(SongAlbumApplication.class, args);

    }

}
