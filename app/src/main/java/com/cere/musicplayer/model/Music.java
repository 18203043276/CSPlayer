package com.cere.musicplayer.model;

import android.support.annotation.NonNull;

import com.litesuits.orm.db.annotation.Column;
import com.litesuits.orm.db.annotation.PrimaryKey;
import com.litesuits.orm.db.annotation.Table;
import com.litesuits.orm.db.enums.AssignType;

/**
 * Created by CeRe on 2017/3/3.
 */
@Table("Music")
public class Music implements Comparable<Music> {
    @PrimaryKey(AssignType.AUTO_INCREMENT)
    @Column("_id")
    private long id;

    @Column("title")
    private String title;

    @Column("artist")
    private String artist;

    @Column("album")
    private String album;

    @Column("album_artist")
    private String album_artist;

    @Column("time")
    private String time;

    @Column("path")
    private String path;

    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }

    public String getArtist(){
        return artist;
    }
    public void setArtist(String artist){
        this.artist = artist;
    }

    public String getAlbum(){
        return album;
    }
    public void setAlbum(String album){
        this.album = album;
    }

    public String getAlbumArtist(){
        return album_artist;
    }
    public void setAlbumArtist(String album_artist){
        this.album_artist = album_artist;
    }

    public String getTime(){
        return time;
    }
    public void setTime(String time){
        this.time = time;
    }

    public String getPath(){
        return path;
    }
    public void setPath(String path){
        this.path = path;
    }

    @Override
    public int compareTo(@NonNull Music o) {
        return 0;
    }
}
