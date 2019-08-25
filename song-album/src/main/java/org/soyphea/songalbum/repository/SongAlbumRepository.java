package org.soyphea.songalbum.repository;

import org.soyphea.songalbum.model.SongAlbum;
import org.springframework.data.mongodb.repository.MongoRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface SongAlbumRepository extends MongoRepository<SongAlbum,String> {

    Optional<SongAlbum> findBySongIdAndAlbumId(String songId, String albumId);
}
