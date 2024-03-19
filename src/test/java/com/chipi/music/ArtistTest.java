package com.chipi.music;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.chipi.music.artist.Artist;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ArtistTest
{

    private Artist artist;

    @BeforeEach
    public void setUp()
    {
        artist = new Artist("John Doe", "New York", "Rock");
    }

    @Test
    public void testConstructorAndGetters()
    {
        assertEquals("John Doe", artist.getName());
        assertEquals("New York", artist.getLocation());
        assertEquals("Rock", artist.getGenre());
    }

    @Test
    public void testSetters()
    {
        artist.setName("Jane Doe");
        artist.setLocation("Los Angeles");
        artist.setGenre("Pop");

        assertEquals("Jane Doe", artist.getName());
        assertEquals("Los Angeles", artist.getLocation());
        assertEquals("Pop", artist.getGenre());
    }

    @Test
    public void testToString()
    {
        String expectedToString = "Artist{id=null, name='John Doe', location='New York', genre='Rock'}";
        assertEquals(expectedToString, artist.toString());
    }
}
