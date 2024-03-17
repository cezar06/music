package com.chipi.music.artist;

import jakarta.transaction.Transactional;
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
    public List<ArtistDTO> getArtists()
    {
        return artistService.getArtists();
    }

    @PostMapping
    public void addNewArtist(@RequestBody ArtistDTO artistDTO)
    {
        artistService.addNewArtist(convertToEntity(artistDTO));
    }

    private Artist convertToEntity(ArtistDTO dto)
    {
        Artist artist = new Artist();
        artist.setId(dto.getId());
        artist.setName(dto.getName());
        artist.setLocation(dto.getLocation());
        artist.setGenre(dto.getGenre());
        return artist;
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
