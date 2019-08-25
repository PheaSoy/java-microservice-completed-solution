package org.soyphea.songalbum.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soyphea.songalbum.event.SongChannel;
import org.soyphea.songalbum.exception.AlbumExistException;
import org.soyphea.songalbum.exception.AlbumNotFoundException;
import org.soyphea.songalbum.exception.SongNotExist;
import org.soyphea.songalbum.model.SongAlbum;
import org.soyphea.songalbum.model.SongAlbumDetails;
import org.soyphea.songalbum.repository.AlbumRepository;
import org.soyphea.songalbum.repository.SongAlbumRepository;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class SongAlbumService {

    private Logger logger = LoggerFactory.getLogger(SongAlbumService.class);

    private SongChannel songChannel;

    private final SongAlbumRepository songAlbumRepository;

    private final AlbumRepository albumRepository;

    public SongAlbumService(SongAlbumRepository songAlbumRepository, AlbumRepository albumRepository, SongChannel songChannel) {
        this.songAlbumRepository = songAlbumRepository;
        this.albumRepository = albumRepository;
        this.songChannel = songChannel;
    }

// TODO check the logic and call to song micro-services to check if song valid or
    //  not. Using Event-driven to check the condition.

    public SongAlbum addSongToAlbum(SongAlbum songAlbum) {
        if (albumRepository.findById(songAlbum.getAlbumId()).isPresent()) {

            if (!isSongAlreadyMappedAlbum(songAlbum)) {
                if (!isSongExist(songAlbum)) {
                    return songAlbumRepository.save(songAlbum);
                } else {
                    throw  new SongNotExist(String.format("Song ID:%s Not Exist",songAlbum.getSongId()));
                }
            } else {
                throw new AlbumExistException("Duplicate joining.");
            }
        } else {
            throw new AlbumNotFoundException();
        }
    }

    // TODO call to song-service to get the details song information. // Event-driven
    public List<SongAlbumDetails> listAllSongsByGivenAlbumId(String songAlbumId) {
        return Arrays.asList(new SongAlbumDetails(false, "0001",
                "Shap of You", "ALB0001", "Ed-Sheeran for Me", "Ed-Sheeran"));
    }


    private boolean isSongExist(SongAlbum songAlbum) {
        logger.info("Sending the message to song channel.");
        songChannel.send().send(MessageBuilder.withPayload(songAlbum).build());
        return true;
    }

    private boolean isSongAlreadyMappedAlbum(SongAlbum songAlbum) {
        return songAlbumRepository.findBySongIdAndAlbumId(songAlbum.getSongId(), songAlbum.getAlbumId()).isPresent();
    }

}
