package com.chipi.music.album;


import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping(path = "api/album")
public class AlbumController
{
    private final AlbumService albumService;

    public AlbumController(AlbumService albumService)
    {
        this.albumService = albumService;
    }

    @GetMapping
    public List<Album> getAlbums()
    {
        return albumService.getAlbums();
    }

    @PostMapping
    public void addNewAlbum(@RequestBody Album album)
    {
        albumService.addNewAlbum(album);
    }

    @DeleteMapping(path = "{albumId}")
    public void deleteAlbum(@PathVariable("albumId") Long albumId)
    {
        albumService.deleteAlbum(albumId);
    }

    @PutMapping(path = "{albumId}")
    public void updateAlbum(@PathVariable("albumId") Long albumId, @RequestParam(required = false) String title,
                           @RequestParam(required = false) LocalDate releaseDate,
                           @RequestParam(required = false) Long artistId)
    {
        albumService.updateAlbum(albumId, title, releaseDate, artistId);
    }
}
