CREATE TABLE album (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(255),
    release_date DATE,
    artist_id BIGSERIAL,
    FOREIGN KEY (artist_id) REFERENCES artist (id)
);
