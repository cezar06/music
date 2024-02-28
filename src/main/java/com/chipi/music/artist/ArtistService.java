package com.chipi.music.artist;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ArtistService
{
    private final ArtistRepository artistRepository;

    @Autowired
    public ArtistService(ArtistRepository artistRepository)
    {
        this.artistRepository = artistRepository;
    }

    public List<Artist> getArtists()
    {
        return artistRepository.findAll();
    }

    public void addNewArtist(Artist artist)
    {
        Optional<Artist> artistOptional = artistRepository.findArtistByName(artist.getName());
        if (artistOptional.isPresent())
        {
            throw new IllegalStateException("artist already exists");
        }
        artistRepository.save(artist);
    }

    public void deleteArtist(Long artistId)
    {
        boolean exists = artistRepository.existsById(artistId);
        if (!exists)
        {
            throw new IllegalStateException("artist with id" + artistId + "does not exist");
        }

        artistRepository.deleteById(artistId);
    }
    @Transactional
    public void updateArtist(Long artistId, String name, String location, String genre)
    {
        Artist artist = artistRepository.findById(artistId).orElseThrow(() -> new IllegalStateException("artist " +
                "with id " + artistId + "does not exist"));
        if (name != null && !name.isEmpty() && !Objects.equals(artist.getName(), name))
        {
            Optional<Artist> artistOptional = artistRepository.findArtistByName(name);
            if (artistOptional.isPresent())
            {
                throw new IllegalStateException("artist already exists");
            }
            System.out.println("ceva");
            artist.setName(name);
        }

        if (location != null && !location.isEmpty() && !Objects.equals(artist.getLocation(), location))
        {
            artist.setLocation(location);
        }

        if (genre != null && !genre.isEmpty() && !Objects.equals(artist.getGenre(), genre))
        {
            artist.setGenre(genre);
        }
    }
}
