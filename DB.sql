CREATE TABLE user (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    email VARCHAR(100),
    role VARCHAR(20)
);

CREATE TABLE post (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(200) NOT NULL,
    content TEXT,
    view_count INT DEFAULT 0,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    updated_at DATETIME,
    user_id BIGINT,
    CONSTRAINT fk_post_user FOREIGN KEY (user_id) REFERENCES user(id)
);

CREATE TABLE comment (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    content TEXT,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    post_id BIGINT,
    user_id BIGINT,
    parent_id BIGINT NULL,
    CONSTRAINT fk_comment_post FOREIGN KEY (post_id) REFERENCES post(id),
    CONSTRAINT fk_comment_user FOREIGN KEY (user_id) REFERENCES user(id),
    CONSTRAINT fk_comment_parent FOREIGN KEY (parent_id) REFERENCES comment(id)
);

CREATE TABLE file_entity (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    original_name VARCHAR(255),
    saved_name VARCHAR(255),
    file_path VARCHAR(255),
    post_id BIGINT,
    CONSTRAINT fk_file_post FOREIGN KEY (post_id) REFERENCES post(id)
);
