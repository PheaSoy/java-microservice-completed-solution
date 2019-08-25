package org.soyphea.songalbum.controller;

import org.soyphea.songalbum.exception.AlbumNotFoundException;
import org.soyphea.songalbum.model.Album;
import org.soyphea.songalbum.repository.AlbumRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AlbumController {

    private final AlbumRepository albumRepository;

    public AlbumController(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @PostMapping("/albums")
    private ResponseEntity<Album> createSongAlbum(@RequestBody Album album) {
        return ResponseEntity.ok(albumRepository.save(album));
    }

    @GetMapping("/albums/{id}")
    private ResponseEntity<Album> getAlbumInfoByAlbumId(@PathVariable("id") String albumId) {

        return albumRepository.findById(albumId).map(album -> ResponseEntity.ok(album)).orElseThrow(() -> new AlbumNotFoundException());

    }


    @GetMapping("/albums/{user}")
    private ResponseEntity<Album> getAllAlbumsByUserID(@RequestParam("user") String albumId) {

        return albumRepository.findByUser(albumId).map(album -> ResponseEntity.ok(album)).orElseThrow(() -> new AlbumNotFoundException());

    }



}
