package org.soyphea.songalbum.repository;


import org.soyphea.songalbum.domain.Song;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SongRepository  extends MongoRepository<Song,String> {

    List<Song> findBySingerId(String singerId);
}
