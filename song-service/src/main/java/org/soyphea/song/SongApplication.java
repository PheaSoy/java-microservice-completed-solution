package org.soyphea.song;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient

public class SongApplication  implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SongApplication.class,args);
    }

    @Value("${favorite.song}")
    @Override
    public void run(String... args) throws Exception {

    }
}
