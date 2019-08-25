package org.soyphea.gateway.config;

import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soyphea.gateway.auth.AuthServerClient;
import org.soyphea.gateway.http.GateWayResponse;
import org.soyphea.gateway.model.ApiResponse;
import org.soyphea.gateway.model.ApiStatus;
import org.soyphea.gateway.validation.AuthorizationHeaderValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;

import java.util.UUID;

@Configuration
public class MyGlobalFilter {

    private Logger logger = LoggerFactory.getLogger(MyGlobalFilter.class);

    @Autowired
    private AuthServerClient authServerClient;

    @Bean
    @Order(-1)
    public GlobalFilter tokenFilter() {
        return (exchange, chain) -> {

            logger.info("Token filter applied.");

            ServerHttpRequest request = exchange.getRequest();

            if (!request.getHeaders().containsKey("Authorization")) {

                return GateWayResponse.onError(exchange, ApiResponse.from(ApiStatus.FAILE,
                        "No authorization given"), HttpStatus.BAD_REQUEST);
            };

            String authorizationHeader = request.getHeaders().get("Authorization").get(0);
            if (!AuthorizationHeaderValidation.isAuthorizationValid(authorizationHeader)) {
                return GateWayResponse.onError(exchange,ApiResponse.from(ApiStatus.FAILE,
                        "Invalid authorization"), HttpStatus.UNAUTHORIZED);
            }
            logger.info("Authorization:"+authorizationHeader);

            String requestPath = request.getPath().toString();

            logger.info("Request Path:{}",requestPath);

            if(requestPath.contains("/oauth/token")){
                logger.info("Token endpoint allow to access without check token.");
            } else {
                try{
                    ResponseEntity<String> responseEntity= authServerClient.checkToken(authorizationHeader);
                    logger.info("Response auth-server:{}",responseEntity);

                }catch (Exception ex){
                    return GateWayResponse.onError(exchange,ApiResponse.from(ApiStatus.FAILE,
                            "Invalid access token"), HttpStatus.BAD_REQUEST);
                }
            }

            ServerHttpRequest modifiedRequest = exchange.getRequest().mutate().
                    header("UUID-GW", UUID.randomUUID().toString()).
                    build();

            return chain.filter(exchange.mutate().request(modifiedRequest).build());
        };
    }


/*
    @Bean
    @Order(0)
    public GlobalFilter b() {
        return (exchange, chain) -> {
            log.info("second pre filter");
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                log.info("second post filter");
            }));
        };
    }

 */
}
