package org.soyphea.songalbum;

public class SongException extends RuntimeException {
    public SongException() {
    }

    public SongException(String message) {
        super("Song :"+message+"Not found!!!!");
    }
}
