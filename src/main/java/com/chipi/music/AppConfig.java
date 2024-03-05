package com.chipi.music;

import com.chipi.music.album.Album;
import com.chipi.music.album.AlbumRepository;
import com.chipi.music.artist.Artist;
import com.chipi.music.artist.ArtistRepository;
import com.chipi.music.song.Song;
import com.chipi.music.song.SongRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

@Configuration
public class AppConfig
{
    @Bean
    CommandLineRunner commandLineRunner(ArtistRepository artistRepository, SongRepository songRepository,
                                        AlbumRepository albumRepository)
    {
        return args ->
        {
            Artist artist1 = new Artist("Beyoncé", "Texas", "R&B");
            Artist artist2 = new Artist("Ed Sheeran", "England", "Pop");
            Artist artist3 = new Artist("Kendrick Lamar", "California", "Hip Hop");
            Artist artist4 = new Artist("Taylor Swift", "Pennsylvania", "Pop");
            Artist artist5 = new Artist("Adele", "London", "Pop");
            Artist artist6 = new Artist("Drake", "Ontario", "Hip Hop");
            Artist artist7 = new Artist("Rihanna", "Barbados", "Pop");
            Artist artist8 = new Artist("Coldplay", "England", "Alternative Rock");
            Artist artist9 = new Artist("Ariana Grande", "Florida", "Pop");
            Artist artist10 = new Artist("Bruno Mars", "Hawaii", "Pop");
            artistRepository.saveAll(List.of(artist1, artist2, artist3, artist4, artist5, artist6, artist7, artist8,
                    artist9, artist10));

            Album album1 = new Album("Lemonade", LocalDate.of(2016, 4, 23), artist1.getId());
            Album album2 = new Album("÷ (Divide)", LocalDate.of(2017, 3, 3), artist2.getId());
            Album album3 = new Album("DAMN.", LocalDate.of(2017, 4, 14), artist3.getId());
            Album album4 = new Album("1989", LocalDate.of(2014, 10, 27), artist4.getId());
            Album album5 = new Album("21", LocalDate.of(2011, 1, 19), artist5.getId());
            albumRepository.saveAll(List.of(album1, album2, album3, album4, album5));

            Song song1 = new Song("Formation", Duration.ofMinutes(3).plusSeconds(26), album1.getId(), artist1.getId());
            Song song2 = new Song("Shape of You", Duration.ofMinutes(3).plusSeconds(53), album2.getId(),
                    artist2.getId());
            Song song3 = new Song("HUMBLE.", Duration.ofMinutes(2).plusSeconds(57), album3.getId(), artist3.getId());
            Song song4 = new Song("Shake It Off", Duration.ofMinutes(3).plusSeconds(39), album4.getId(),
                    artist4.getId());
            Song song5 = new Song("Rolling in the Deep", Duration.ofMinutes(3).plusSeconds(48), album5.getId(),
                    artist5.getId());
            songRepository.saveAll(List.of(song1, song2, song3, song4, song5));
        };
    }
}

