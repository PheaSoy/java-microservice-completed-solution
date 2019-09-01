package org.soyphea.songalbum.controller;

import org.soyphea.songalbum.domain.Song;
import org.soyphea.songalbum.exeption.SongNotFoundException;
import org.soyphea.songalbum.repository.SongRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class SongController {

    private final SongRepository songRepository;

    public SongController(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @GetMapping("/songs/{id}")
    public ResponseEntity<Song> getSongById(@PathVariable("id") String id){
        return songRepository.findById(id).map(song -> ResponseEntity.ok(song)).orElseThrow(() -> new SongNotFoundException("Not found Song"));
    }

    @PostMapping("/songs")
    public ResponseEntity<Song> createSong(@RequestBody Song song){
       return ResponseEntity.ok(songRepository.save(song));
    }

    @GetMapping("/songs")
    public ResponseEntity<?> createSong(@RequestParam("singer_id") String singerId){
        return ResponseEntity.ok(songRepository.findBySingerId(singerId));
    }



}
