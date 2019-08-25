package org.soyphea.songalbum.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class SongNotExist extends RuntimeException {

    public SongNotExist() {
    }

    public SongNotExist(String message) {
        super(message);
    }
}
