CREATE TABLE cover (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(255),
    original_song_id BIGSERIAL,
    cover_artist_id BIGSERIAL,
    cover_date DATE,
    FOREIGN KEY (original_song_id) REFERENCES song (id),
    FOREIGN KEY (cover_artist_id) REFERENCES artist (id)
);
