package org.soyphea.songalbum.repository;

import org.soyphea.songalbum.model.Album;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface AlbumRepository extends MongoRepository<Album,String> {

    Optional<Album> findByName(String name);
    List<Album> findByUserId(String userId);
}
