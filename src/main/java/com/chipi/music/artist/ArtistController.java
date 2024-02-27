package com.chipi.music.artist;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/artist")
public class ArtistController
{
    private final ArtistService artistService;

    public ArtistController(ArtistService artistService)
    {
        this.artistService = artistService;
    }

    @GetMapping
    public List<Artist> getArtists()
    {
        return artistService.getArtists();
    }

    @PostMapping
    public void addNewArtist(@RequestBody Artist artist)
    {
        artistService.addNewArtist(artist);
    }

    @DeleteMapping(path = "{artistId}")
    public void deleteArtist(@PathVariable("artistId") Long artistId)
    {
        artistService.deleteArtist(artistId);
    }

    @PutMapping(path = "{artistId}")
    public void updateArtist(@PathVariable("artistId") Long artistId, @RequestParam(required = false) String name,
                             @RequestParam(required = false) String location,
                             @RequestParam(required = false) String genre)
    {
        artistService.updateArtist(artistId, name, location, genre);
    }
}
