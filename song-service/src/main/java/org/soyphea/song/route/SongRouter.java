package org.soyphea.song.route;

import org.soyphea.song.entity.Song;
import org.soyphea.song.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyExtractors.toMono;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Configuration
public class SongRouter {

    @Autowired
    private SongRepository songRepository;

    @Bean
    RouterFunction<?> routerFunction(){
        return route(
                GET("/song"), r -> ok().body(songRepository.findAll(), Song.class))
                .andRoute(GET("/song/{id}"),r -> ok().body(songRepository.findById(r.pathVariable("id")),Song.class));
    }


    @Bean
    RouterFunction<ServerResponse> createSong() {
        return route(POST("/song"), r -> {
            Mono<Song> song = r.body(toMono(Song.class));
            Mono<Song> result = song.flatMap(songRepository::save);
            return ok().body(result,Song.class);
        });
    }

}
