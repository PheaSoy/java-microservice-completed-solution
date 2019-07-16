package org.soyphea.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class RouteConfiguration {

    @Bean
        RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {

        return routeLocatorBuilder.routes()
                .route("auth-server", predicateSpec -> predicateSpec.path("/uaa/**").uri("lb://auth-service"))
                .route("song", predicateSpec -> predicateSpec.path("/song/**").uri("lb://song-service"))
                .build();
    }

}
