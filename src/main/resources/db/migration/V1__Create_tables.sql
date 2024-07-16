CREATE TABLE users (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       username VARCHAR(50) NOT NULL,
                       password VARCHAR(100) NOT NULL,
                       email VARCHAR(100) NOT NULL,
                       role VARCHAR(50) NOT NULL,
                       enabled BOOLEAN NOT NULL
);

CREATE TABLE topics (
                        id BIGINT AUTO_INCREMENT PRIMARY KEY,
                        title VARCHAR(255) NOT NULL,
                        message TEXT NOT NULL,
                        creation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                        status VARCHAR(50) NOT NULL,
                        author_id BIGINT,
                        course VARCHAR(255),
                        FOREIGN KEY (author_id) REFERENCES users(id)
);

CREATE TABLE responses (
                           id BIGINT AUTO_INCREMENT PRIMARY KEY,
                           message TEXT NOT NULL,
                           creation_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                           author_id BIGINT,
                           topic_id BIGINT,
                           FOREIGN KEY (author_id) REFERENCES users(id),
                           FOREIGN KEY (topic_id) REFERENCES topics(id)
);
