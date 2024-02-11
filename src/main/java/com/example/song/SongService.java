/*

 * You can use the following import statements
  
 * import org.springframework.http.HttpStatus;
 * import org.springframework.web.server.ResponseStatusException;

 */

package com.example.song;

import java.util.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException.NotFound;
import org.springframework.web.server.ResponseStatusException;

import com.example.song.Song;
import com.example.song.SongRepository;

// Don't modify the below code
public class SongService implements SongRepository {
    private static HashMap<Integer, Song> playlist = new HashMap<>();

    public SongService() {
        playlist.put(1, new Song(1, "Butta Bomma", "Ramajogayya Sastry", "Armaan Malik", "Thaman S"));
        playlist.put(2, new Song(2, "Kathari Poovazhagi", "Vijay", "Benny Dayal, Swetha Mohan", "A.R. Rahman"));
        playlist.put(3, new Song(3, "Tum Hi Ho", "Mithoon", "Arijit Singh", "Mithoon"));
        playlist.put(4, new Song(4, "Vizhiyil", "Vairamuthu", "Unni Menon", "A.R. Rahman"));
        playlist.put(5, new Song(5, "Nenjame", "Panchu Arunachalam", "S.P.Balasubrahmanyam", "Ilaiyaraaja"));
    }

    int uniqueId = 6;

    // Don't modify the above code

    // Write your code here
    @Override
    public ArrayList<Song> getSongs() {
        Collection<Song> songCollection = playlist.values();
        ArrayList<Song> songs = new ArrayList<>(songCollection);
        return songs;

    }

    public Song addSong(Song song) {
        song.setsongId(uniqueId);
        playlist.put(uniqueId, song);
        uniqueId += 1;
        return song;

    }

    public Song getSongById(int songId) {
        Song song = playlist.get(songId);
        if (song == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return song;

    }

    public Song updateSong(int songId, Song song) {
        Song exstingSong = playlist.get(songId);

        if (exstingSong == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        if (song.getsongName() != null) {
            exstingSong.setsongName(song.getsongName());
        }
        if (song.getmusicDirector() != null) {
            exstingSong.setmusicDirector(song.getmusicDirector());
        }
        if (song.getlyricist() != null) {
            exstingSong.setlyricist(song.getlyricist());
        }
        if (song.getsinger() != null) {
            exstingSong.setsinger(song.getsinger());
        }

        return exstingSong;

    }

    public void deleteSongById(int songId) {
        Song song = playlist.get(songId);
        if (song == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            playlist.remove(songId);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }
    }

}