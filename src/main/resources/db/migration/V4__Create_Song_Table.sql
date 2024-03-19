CREATE TABLE song (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(255),
    album_id BIGSERIAL,
    artist_id BIGSERIAL,
    FOREIGN KEY (album_id) REFERENCES album (id),
    FOREIGN KEY (artist_id) REFERENCES artist (id)
);
