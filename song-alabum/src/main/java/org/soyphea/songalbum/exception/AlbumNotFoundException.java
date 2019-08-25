package org.soyphea.songalbum.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class AlbumNotFoundException extends RuntimeException {

    public AlbumNotFoundException() {
    }

    public AlbumNotFoundException(String message) {
        super(message);
    }
}
