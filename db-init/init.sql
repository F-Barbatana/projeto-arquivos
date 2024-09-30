CREATE TABLE IF NOT EXISTS Directory (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    parent_id BIGINT, 
    CONSTRAINT fk_parent_directory FOREIGN KEY (parent_id) REFERENCES Directory(id)
);

CREATE TABLE IF NOT EXISTS File (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    directory_id BIGINT,
    CONSTRAINT fk_directory FOREIGN KEY (directory_id) REFERENCES Directory(id)
);

