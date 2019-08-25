package org.soyphea.songalbum.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SongAlbumDetails {

    boolean favorite;
    String songId;
    String songName;
    String albumId;
    String albumName;
    String singerName;


}
