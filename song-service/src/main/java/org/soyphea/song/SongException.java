package org.soyphea.song;

public class SongException extends RuntimeException {
    public SongException() {
    }

    public SongException(String message) {
        super("Song :"+message+"Not found!!!!");
    }
}
