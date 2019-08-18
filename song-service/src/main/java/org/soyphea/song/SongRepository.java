package org.soyphea.song;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SongRepository  extends CrudRepository<Song,String> {


    List findBySingerName(String singerName);
}
