package com.chipi.music.song;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;
import java.util.Objects;

@Service
public class SongService
{
    private final SongRepository songRepository;

    public SongService(SongRepository songRepository)
    {
        this.songRepository = songRepository;
    }

    public List<Song> getSongs()
    {
        return songRepository.findAll();
    }

    public void addNewSong(Song song)
    {
        songRepository.save(song);
    }

    public void deleteSong(Long songId)
    {
        boolean exists = songRepository.existsById(songId);
        if (!exists)
        {
            throw new IllegalStateException("song with id " + songId + "does not exist");
        }

        songRepository.deleteById(songId);
    }
    @Transactional
    public void updateSong(Long songId, String title, Duration duration, Long albumId, Long artistId)
    {
        Song song = songRepository.findById(songId).orElseThrow(() -> new IllegalStateException("song " +
                "with id " + songId + " does not exist"));
        if (title != null && !title.isEmpty() && !Objects.equals(song.getTitle(), title))
        {
            song.setTitle(title);
        }

        if (duration != null && !Objects.equals(song.getDuration(), duration))
        {
            song.setDuration(duration);
        }

        if (albumId != null && !Objects.equals(song.getAlbumId(), albumId))
        {
            song.setAlbumId(albumId);
        }

        if (artistId != null && !Objects.equals(song.getArtistId(), artistId))
        {
            song.setArtistId(artistId);
        }
    }
}
