package com.chipi.music.song;


import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.util.List;

@RestController
@RequestMapping(path = "api/song")
public class SongController
{
    private final SongService songService;

    public SongController(SongService songService)
    {
        this.songService = songService;
    }

    @GetMapping
    public List<Song> getSongs()
    {
        return songService.getSongs();
    }

    @PostMapping
    public void addNewSong(@RequestBody Song song)
    {
        songService.addNewSong(song);
    }

    @DeleteMapping(path = "{songId}")
    public void deleteSong(@PathVariable("songId") Long songId)
    {
        songService.deleteSong(songId);
    }

    @PutMapping(path = "{songId}")
    public void updateSong(@PathVariable("songId") Long songId, @RequestParam(required = false) String title,
                           @RequestParam(required = false) Duration duration,
                           @RequestParam(required = false) Long albumId, @RequestParam(required = false) Long artistId)
    {
        songService.updateSong(songId, title, duration, albumId, artistId);
    }
}
