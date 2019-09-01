package org.soyphea.songalbum;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient

public class SongApplication  implements CommandLineRunner {

    Logger logger = LoggerFactory.getLogger(SongApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SongApplication.class,args);
    }

    @Value("${favorite.songalbum:default-songalbum}")
    String favoriteSong;

    @Override
    public void run(String... args) throws Exception {
        logger.info("Favorite songalbum fetched from configure-server:{}",favoriteSong);
    }
}
