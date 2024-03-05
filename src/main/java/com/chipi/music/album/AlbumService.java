package com.chipi.music.album;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Service
public class AlbumService
{
    private final AlbumRepository albumRepository;

    public AlbumService(AlbumRepository albumRepository)
    {
        this.albumRepository = albumRepository;
    }

    public List<Album> getAlbums()
    {
        return albumRepository.findAll();
    }

    public void addNewAlbum(Album album)
    {
        albumRepository.save(album);
    }

    public void deleteAlbum(Long albumId)
    {
        boolean exists = albumRepository.existsById(albumId);
        if (!exists)
        {
            throw new IllegalStateException("album with id " + albumId + " does not exist");
        }

        albumRepository.deleteById(albumId);
    }

    @Transactional
    public void updateAlbum(Long albumId, String title, LocalDate releaseDate, Long artistId)
    {
        Album album = albumRepository.findById(albumId).orElseThrow(() -> new IllegalStateException("album " +
                "with id " + albumId + " does not exist"));
        if (title != null && !title.isEmpty() && !Objects.equals(album.getTitle(), title))
        {
            album.setTitle(title);
        }

        if (releaseDate != null && !Objects.equals(album.getReleaseDate(), releaseDate))
        {
            album.setReleaseDate(releaseDate);
        }

        if (artistId != null && !Objects.equals(album.getArtistId(), artistId))
        {
            album.setArtistId(artistId);
        }

    }
}
