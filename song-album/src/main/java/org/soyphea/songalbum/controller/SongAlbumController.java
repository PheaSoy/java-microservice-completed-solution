package org.soyphea.songalbum.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soyphea.songalbum.exception.AlbumNotFoundException;
import org.soyphea.songalbum.model.Album;
import org.soyphea.songalbum.model.SongAlbum;
import org.soyphea.songalbum.model.SongAlbumDetails;
import org.soyphea.songalbum.repository.SongAlbumRepository;
import org.soyphea.songalbum.service.SongAlbumService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SongAlbumController {

    private Logger logger = LoggerFactory.getLogger(SongAlbumController.class);

    private final SongAlbumService songAlbumService;

    public SongAlbumController(SongAlbumService songAlbumService) {
        this.songAlbumService = songAlbumService;
    }

    @GetMapping("/albums/{id}/songs")
    private ResponseEntity<List<SongAlbumDetails>> listAllSongsByGivenAlbumId(@PathVariable("id") String albumId) {
        logger.info("Get all songs with album id:{}",albumId);
        return ResponseEntity.ok(songAlbumService.listAllSongsByGivenAlbumId(albumId));

    }

    @PostMapping("/albums/{id}/songs")
    private ResponseEntity<SongAlbum> addingSongToSongAlbum(@PathVariable("id") String albumId, @RequestBody SongAlbum songAlbum) {
        logger.info("Adding song:{} with album:{}",songAlbum.getSongId(),songAlbum.getAlbumId());
        return ResponseEntity.ok(songAlbumService.addSongToAlbum(songAlbum));

    }

}
