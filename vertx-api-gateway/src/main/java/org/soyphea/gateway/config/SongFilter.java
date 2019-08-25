package org.soyphea.gateway.config;

import org.apache.commons.lang.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.util.UUID;


//@Component
public class SongFilter extends AbstractGatewayFilterFactory<SongFilter.Config> {

    private Logger logger = LoggerFactory.getLogger(SongFilter.class);

    public SongFilter() {
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config) {
        return (exchange, chain) -> {
            logger.info("Song filter applied.");
            ServerHttpRequest request = exchange.getRequest();

            ServerHttpRequest modifiedRequest = exchange.getRequest().mutate().
                    header("Gateway UUID", UUID.randomUUID().toString()).
                    build();
            return chain.filter(exchange.mutate().request(modifiedRequest).build());
        };
    }

    public static class Config {
        // Put the configuration properties
    }
}