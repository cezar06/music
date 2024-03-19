package com.chipi.music;

import com.chipi.music.artist.Artist;
import com.chipi.music.artist.ArtistRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class ArtistRepositoryTest {

    @Autowired
    private ArtistRepository artistRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    void testFindArtistByName() {
        // Arrange
        String artistName = "Test Artist";
        Artist artist = new Artist();
        artist.setName(artistName);
        entityManager.persistAndFlush(artist);

        // Act
        Optional<Artist> foundArtist = artistRepository.findArtistByName(artistName);

        // Assert
        assertEquals(artistName, foundArtist.orElseThrow().getName());
    }
}
