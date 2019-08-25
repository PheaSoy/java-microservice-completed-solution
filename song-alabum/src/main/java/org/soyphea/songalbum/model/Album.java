package org.soyphea.songalbum.model;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document("album")
public class Album {

    public Album(){
    }

    public Album(String name, Date createDate, String userId) {
        this.name = name;
        this.createDate = createDate;
        this.userId = userId;
    }

    @Id
    String id;

    @Indexed
    private String name;

    @CreatedDate
    Date createDate = new Date();

    @CreatedBy
    String userId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }





}
