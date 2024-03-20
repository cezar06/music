package com.chipi.music;

import com.chipi.music.artist.Artist;
import com.chipi.music.artist.ArtistRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.JsonPathAssertions;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@DataJpaTest
class ArtistRepositoryTest
{

    @Autowired
    private ArtistRepository artistRepository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    void givenArtist_whenUpdate_thenSucces()
    {
        // Given
        Artist newArtist = new Artist("Artist1", "testLocation", "testGenre");
        entityManager.persist(newArtist);

        // When
        String newName = "New Artist 001";
        newArtist.setName(newName);
        artistRepository.save(newArtist);

        // Then
        Artist retrievedArtist = entityManager.find(Artist.class, newArtist.getId());
        assertEquals(newName, retrievedArtist.getName());
    }

    @Test
    void givenArtistCreated_whenFindById_thenSuccess() {
        // Given
        Artist newArtist = new Artist("Artist1", "testLocation1", "testGenre1");
        entityManager.persist(newArtist);

        // When
        Optional<Artist> retrievedArtistOptional = artistRepository.findById(newArtist.getId());

        // Then
        assertTrue(retrievedArtistOptional.isPresent());
        Artist retrievedArtist = retrievedArtistOptional.get();
        assertEquals(newArtist.getId(), retrievedArtist.getId());
    }

    @Test
    void givenArtistsCreated_whenFindArtistByName_thenSuccess() {
        // Given
        Artist newArtist1 = new Artist("Artist1", "testlocation1", "testGenre1");
        Artist newArtist2 = new Artist("Artist2", "testlocation2", "testGenre2");
        artistRepository.save(newArtist1);
        artistRepository.save(newArtist2);

        // When
        Optional<Artist> foundArtist = artistRepository.findArtistByName("Artist1");

        // Then
        assertTrue(foundArtist.isPresent());
        assertEquals("Artist1", foundArtist.get().getName());
        assertEquals("testlocation1", foundArtist.get().getLocation());
        assertEquals("testGenre1", foundArtist.get().getGenre());
    }

    @Test
    void givenArtistCreated_whenDelete_thenSuccess() {
        // Given
        Artist newArtist = new Artist("Artist1", "testLocation1", "testGenre1");
        entityManager.persist(newArtist);

        // When
        artistRepository.delete(newArtist);

        // Then
        Artist deletedArtist = entityManager.find(Artist.class, newArtist.getId());
        assertNull(deletedArtist);
    }

}
