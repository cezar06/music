CREATE TABLE song (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(255),
    duration INTERVAL,
    album_id BIGSERIAL,
    artist_id BIGSERIAL,
    FOREIGN KEY (album_id) REFERENCES album (id),
    FOREIGN KEY (artist_id) REFERENCES artist (id)
);
