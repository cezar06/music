package com.chipi.music.artist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, Long>
{
    @Query("SELECT a from Artist a WHERE a.name = ?1")
    Optional<Artist> findArtistByName(String name);
}
