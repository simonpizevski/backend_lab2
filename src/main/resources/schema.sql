CREATE TABLE IF NOT EXISTS category
(
    id INT AUTO_INCREMENT PRIMARY KEY,
    name        VARCHAR(255) NOT NULL,
    symbol      VARCHAR(255),
    description TEXT
);

CREATE TABLE IF NOT EXISTS location
(
    id            INT AUTO_INCREMENT PRIMARY KEY,
    name          VARCHAR(255) NOT NULL,
    category_id   INT,
    user_id       VARCHAR(255) NOT NULL,
    status        VARCHAR(50) DEFAULT 'public',
    last_modified TIMESTAMP,
    description   TEXT,
    coordinate    GEOMETRY     NOT NULL SRID 4326,
    created_at    TIMESTAMP,
    FOREIGN KEY (category_id) REFERENCES category (id)
);

