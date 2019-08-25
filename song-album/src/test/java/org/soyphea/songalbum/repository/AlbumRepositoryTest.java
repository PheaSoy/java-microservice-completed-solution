package org.soyphea.songalbum.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.soyphea.songalbum.model.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@DataMongoTest
@ExtendWith(SpringExtension.class)
public class AlbumRepositoryTest {

    @Autowired
    AlbumRepository albumRepository;

    Album album;

    @BeforeEach
    public void init(){
        album = new Album("My SongAlbum Album",new Date(),"001");
    }

    @Test
    public void testSaveAlbumShouldBeOK(){
        Album albumSave = albumRepository.save(album);
        assertThat(albumSave.getName()).isEqualTo(album.getName());
    }

    @Test
    public void getSearchAlbumWithWrongNameShouldBeNotFound(){
       Optional<Album> albumSearch = albumRepository.findByName("Not_Found");
       assertThat(albumSearch.isPresent()).isEqualTo(false);
    }

    @Test
    public void getSearchAlbumWithCorrectNameShouldBeOK(){
        Optional<Album> albumSearch = albumRepository.findByName(album.getName());
        assertThat(albumSearch.isPresent()).isEqualTo(true);
    }


    @Test
    public void searchAlbumWithCorrectIdShouldBeOK(){
        Album albumSaveSearchId = albumRepository.save(album);
        Optional<Album> albumSearch = albumRepository.findById(albumSaveSearchId.getId());
        assertThat(albumSearch.isPresent()).isEqualTo(true);
    }
}
