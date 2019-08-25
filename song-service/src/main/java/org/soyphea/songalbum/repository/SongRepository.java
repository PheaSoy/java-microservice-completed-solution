package org.soyphea.songalbum.repository;


import org.soyphea.songalbum.Song;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SongRepository  extends MongoRepository<Song,String> {

}
