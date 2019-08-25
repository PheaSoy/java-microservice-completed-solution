package org.soyphea.songalbum.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AlbumExistException extends RuntimeException {
    public AlbumExistException() {
    }

    public AlbumExistException(String message) {
        super(message);
    }
}
