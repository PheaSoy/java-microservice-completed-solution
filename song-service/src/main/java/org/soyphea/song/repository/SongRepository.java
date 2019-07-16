package org.soyphea.song.repository;

import org.soyphea.song.entity.Song;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface SongRepository extends ReactiveMongoRepository<Song,String> {
}
