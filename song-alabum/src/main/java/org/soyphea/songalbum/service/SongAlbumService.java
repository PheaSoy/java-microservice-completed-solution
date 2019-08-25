package org.soyphea.songalbum.service;

import org.soyphea.songalbum.model.SongAlbum;
import org.soyphea.songalbum.model.SongAlbumDetails;
import org.soyphea.songalbum.repository.SongAlbumRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class SongAlbumService {

    private final SongAlbumRepository songAlbumRepository;

    public SongAlbumService(SongAlbumRepository songAlbumRepository) {
        this.songAlbumRepository = songAlbumRepository;
    }
    // TODO check the logic and call to song microservice to check if song valid or not.
    public SongAlbum addSongToAlbum(SongAlbum songAlbum){
        return songAlbumRepository.save(songAlbum);
    }


    boolean favorite;
    String songId;
    String songName;
    String albumNameId;
    String albumName;
    String singerName;

    // TODO call to song-service to get the details song information.
    public List<SongAlbumDetails> listAllSongsByGivenAlbumId(String songAlbumId){
        return  Arrays.asList(new SongAlbumDetails(false,"0001",
                "Shap of You","ALB0001","Ed-Sheeran for Me","Ed-Sheeran"));
    }

}
