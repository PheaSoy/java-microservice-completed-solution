package org.soyphea.song;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    Object target = this.getClass().getName();
    final Logger logger = LoggerFactory.getLogger(target.getClass());

    private final UserRepository songRepository;

    public UserController(UserRepository songRepository) {
        this.songRepository = songRepository;
    }

    @PostMapping("/song")
    public ResponseEntity<?> addSong(@RequestBody User song){
        return ResponseEntity.ok(songRepository.save(song));
    }

    @GetMapping("/songs")
    public ResponseEntity<?> listAll(){
        logger.info("List all the songs");
        return ResponseEntity.ok(songRepository.findAll());
    }

    @GetMapping("/song")
    public ResponseEntity<?> listAllSongMatchWithSinger(@RequestParam String singer){
        logger.info("List all the songs matched with singer:{}",singer);
        return ResponseEntity.ok(songRepository.findBySingerName(singer));
    }
    @GetMapping("/song/{name}")
    public ResponseEntity<?> listSongMatchedWithSongName(@PathVariable("name") String name) {
        logger.info("List all the songs matched with name:{}",name);
        return songRepository.findByName(name).map(mySong -> ResponseEntity.ok(mySong)).orElseThrow(() -> new UserException(name));
    }




}
