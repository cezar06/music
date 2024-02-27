package com.chipi.music.album;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table
public class Album
{
    @Id
    @SequenceGenerator(
            name = "album_sequence",
            sequenceName = "album_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE
    )
    private Long id;
    private String title;
    private LocalDate releaseDate;
    private Long artistId;

    public Album(String title, LocalDate releaseDate, Long artistId)
    {
        this.title = title;
        this.releaseDate = releaseDate;
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

    public LocalDate getReleaseDate()
    {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate)
    {
        this.releaseDate = releaseDate;
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
        return "Album{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", releaseDate=" + releaseDate +
                ", artistId=" + artistId +
                '}';
    }
}