package org.soyphea.songalbum.repository;

import org.soyphea.songalbum.model.SongAlbum;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SongAlbumRepository extends MongoRepository<SongAlbum,String> {
}
