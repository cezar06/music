package com.chipi.music.song;

import jakarta.persistence.*;

import java.time.Duration;

@Entity
@Table
public class Song
{   @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id", nullable = false)
    private Long id;
    private String title;
    private Duration duration;
    private Long albumId;
    private Long artistId;

    public Song()
    {
    }

    public Song(String title, Duration duration, Long albumId, Long artistId)
    {
        this.title = title;
        this.duration = duration;
        this.albumId = albumId;
        this.artistId = artistId;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public Duration getDuration()
    {
        return duration;
    }

    public void setDuration(Duration duration)
    {
        this.duration = duration;
    }

    public Long getAlbumId()
    {
        return albumId;
    }

    public void setAlbumId(Long albumId)
    {
        this.albumId = albumId;
    }

    public Long getArtistId()
    {
        return artistId;
    }

    public void setArtistId(Long artistId)
    {
        this.artistId = artistId;
    }

    @Override
    public String toString()
    {
        return "Song{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", duration=" + duration +
                ", albumId=" + albumId +
                ", artistId=" + artistId +
                '}';
    }
}
