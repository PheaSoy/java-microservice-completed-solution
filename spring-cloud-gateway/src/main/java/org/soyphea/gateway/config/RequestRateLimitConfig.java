package org.soyphea.gateway.config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class RequestRateLimitConfig {

    private Logger logger = LoggerFactory.getLogger(RequestRateLimitConfig.class);

    @Bean
    KeyResolver userKeyResolver() {
        logger.info("Rate limit executed.");
        //return exchange -> Mono.just(exchange.getRequest().getHeaders().get("device_id").get(0));
        return exchange ->  Mono.just(exchange.getRequest().getRemoteAddress().getAddress().getHostAddress());
    }
}
