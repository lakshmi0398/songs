// Write your code here
package com.example.song;

import java.util.*;

class Song {
    private int songId;
    private String songName;
    private String lyricist;
    private String singer;
    private String musicDirector;

    public Song(int songId, String songName, String lyricist, String singer, String musicDirector) {
        this.songId = songId;
        this.songName = songName;
        this.lyricist = lyricist;
        this.singer = singer;
        this.musicDirector = musicDirector;
    }

    public void setsongId(int songId) {
        this.songId = songId;
    }

    public int getsongId() {
        return songId;
    }

    public void setsongName(String songName) {
        this.songName = songName;
    }

    public String getsongName() {
        return songName;
    }

    public void setlyricist(String lyricist) {
        this.lyricist = lyricist;
    }

    public String getlyricist() {
        return lyricist;
    }

    public void setsinger(String singer) {
        this.singer = singer;
    }

    public String getsinger() {
        return singer;
    }

    public void setmusicDirector(String musicDirector) {
        this.musicDirector = musicDirector;
    }

    public String getmusicDirector() {
        return musicDirector;
    }
}