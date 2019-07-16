package org.soyphea.song.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soyphea.song.domain.User;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CompletableFuture;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    private final RestTemplate restTemplate;

    public UserService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Async
    public CompletableFuture<User> getUser(String userName) throws Exception {
        logger.info("Looking up " + userName);
        String url = String.format("https://api.github.com/users/%s", userName);
        //User resultUser = restTemplate.getForObject(url, User.class);
        CompletableFuture<User> completableFuture = CompletableFuture.supplyAsync(() -> {
            User resultUser = restTemplate.getForObject(url, User.class);
            return resultUser;
        }).exceptionally( throwable -> errorHandle(throwable));

        // Artificial delay of 1s for demonstration purposes
        Thread.sleep(3000);
        //return CompletableFuture.completedFuture(resultUser);
        return  completableFuture;
    }

    @Async
    public CompletableFuture<User> upperCaseUserName(String userName) throws Exception {
        logger.info("Convert to Upper case sample.");
        Thread.sleep(3000);
        CompletableFuture<User> completableFuture = getUser(userName).thenApplyAsync(user -> {
            User user1 = new User();
            user1.setName(user.getName().toUpperCase());
            user1.setBlog(user.getBlog().toUpperCase());
            return user1;
        });
        return completableFuture;
    }

    private static User errorHandle(Throwable  e){
        if (e != null) {

            logger.error("error occured :{}  " + e.getMessage());
        }
        return new User();
    }

}
