CREATE TABLE IF NOT EXISTS category
(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(255) NOT NULL,
    symbol      VARCHAR(255),
    description TEXT
);

CREATE TABLE IF NOT EXISTS location
(
    id          BIGINT AUTO_INCREMENT PRIMARY KEY,
    name          VARCHAR(255) NOT NULL,
    category_id BIGINT,
    user_id       VARCHAR(255) NOT NULL,
    is_public   BOOLEAN DEFAULT TRUE,
    last_modified TIMESTAMP,
    description   TEXT,
    coordinate    GEOMETRY     NOT NULL SRID 4326,
    created_at    TIMESTAMP,
    deleted     BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (category_id) REFERENCES category (id)
);

