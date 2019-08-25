package org.soyphea.songalbum.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soyphea.songalbum.exception.AlbumNotFoundException;
import org.soyphea.songalbum.model.Album;
import org.soyphea.songalbum.repository.AlbumRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AlbumController {

    String name = this.getClass().getName();

    private Logger logger = LoggerFactory.getLogger(name);
    private final AlbumRepository albumRepository;

    public AlbumController(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @PostMapping("/albums")
    public ResponseEntity<Album> createSongAlbum(@RequestBody Album album) {
        return ResponseEntity.ok(albumRepository.save(album));
    }

    // TODO Check the album should not existing

    @GetMapping("/albums/{id}")
    public ResponseEntity<Album> getAlbumInfoByAlbumId(@PathVariable("id") String albumId) {
        logger.info("Get album info by album id:{}",albumId);
        return albumRepository.findById(albumId).map(album -> ResponseEntity.ok(album)).orElseThrow(() -> new AlbumNotFoundException());

    }


    @GetMapping("/albums")
    public ResponseEntity<List<Album>> getAllAlbumsByUserID(@RequestParam("user") String albumId) {
        logger.info("List all album with user id");
        return ResponseEntity.ok(albumRepository.findByUserId(albumId));
    }


}
