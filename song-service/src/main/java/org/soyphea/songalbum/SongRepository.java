package org.soyphea.songalbum;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface SongRepository  extends CrudRepository<Song,String> {


    List findBySingerName(String singerName);
    Optional<Song> findByName(String name);
}
