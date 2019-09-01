package org.soyphea.songalbum.controller;

import org.soyphea.songalbum.domain.Song;
import org.soyphea.songalbum.exeption.SongNotFoundException;
import org.soyphea.songalbum.repository.SongRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SongController {

    private final SongRepository songRepository;

    public SongController(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @GetMapping("/songs/{ig}")
    public ResponseEntity<Song> getSongById(@PathVariable("id") String id){
        return songRepository.findById(id).map(song -> ResponseEntity.ok(song)).orElseThrow(() -> new SongNotFoundException("Not found Song"));

    }

}
