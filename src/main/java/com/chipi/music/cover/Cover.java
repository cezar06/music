package com.chipi.music.cover;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table
public class Cover
{
    @Id
    @SequenceGenerator(
            name = "cover_sequence",
            sequenceName = "cover_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE
    )
    private Long id;
    private Long originalSongId;
    private Long coverArtistId;
    private LocalDate coverDate;

    public Cover(Long originalSongId, Long coverArtistId, LocalDate coverDate)
    {
        this.originalSongId = originalSongId;
        this.coverArtistId = coverArtistId;
        this.coverDate = coverDate;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getOriginalSongId()
    {
        return originalSongId;
    }

    public void setOriginalSongId(Long originalSongId)
    {
        this.originalSongId = originalSongId;
    }

    public Long getCoverArtistId()
    {
        return coverArtistId;
    }

    public void setCoverArtistId(Long coverArtistId)
    {
        this.coverArtistId = coverArtistId;
    }

    public LocalDate getCoverDate()
    {
        return coverDate;
    }

    public void setCoverDate(LocalDate coverDate)
    {
        this.coverDate = coverDate;
    }

    @Override
    public String toString()
    {
        return "Cover{" +
                "id=" + id +
                ", originalSongId=" + originalSongId +
                ", coverArtistId=" + coverArtistId +
                ", coverDate=" + coverDate +
                '}';
    }
}
