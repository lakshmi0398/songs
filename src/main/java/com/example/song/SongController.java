/*
 * You can use the following import statements
 * 
 * import org.springframework.web.bind.annotation.*;
 * import java.util.*;
 * 
 */

// Write your code here
package com.example.song;

import com.example.song.Song;
import com.example.song.SongService;
import java.util.*;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

@RestController
class SongController {
  SongService songService = new SongService();

  @GetMapping("/songs")
  public ArrayList<Song> getSongs() {
    return songService.getSongs();
  }

  @PostMapping("/songs")
  public Song addSong(@RequestBody Song song) {
    return songService.addSong(song);
  }

  @GetMapping("/songs/{songId}")
  public Song getSongById(@PathVariable int songId) {
    return songService.getSongById(songId);
  }

  @PutMapping("/songs/{songId}")
  public Song updateSong(@PathVariable int songId, @RequestBody Song song) {
    return songService.updateSong(songId, song);
  }

  @DeleteMapping("/songs/{songId}")
  public void deleteSongById(@PathVariable int songId) {
    songService.deleteSongById(songId);
  }
}