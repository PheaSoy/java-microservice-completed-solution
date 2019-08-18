package org.soyphea.song;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "song")
public class Song {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    Long id;

    String name;

    @JsonProperty("singer_name")
    String singerName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

}
