CREATE TABLE IF NOT EXISTS users (
    userId BIGINT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255) UNIQUE,
    username VARCHAR(255) UNIQUE,
    password VARCHAR(255) UNIQUE,
    verified BOOLEAN,
    role VARCHAR(255),
    profileInfo VARCHAR(500)
);

CREATE TABLE IF NOT EXISTS posts (
    postId BIGINT AUTO_INCREMENT PRIMARY KEY,
    userId BIGINT NOT NULL,
    title VARCHAR(255),
    content VARCHAR(1000),
    postDate TIMESTAMP,
    tags VARCHAR(255),
    FOREIGN KEY (userId) REFERENCES users(userId)
);

CREATE TABLE IF NOT EXISTS comments (
    commentId BIGINT AUTO_INCREMENT PRIMARY KEY,
    userId BIGINT NOT NULL,
    postId BIGINT NOT NULL,
    content VARCHAR(1000),
    commentDate TIMESTAMP,
    FOREIGN KEY (userId) REFERENCES users(userId),
    FOREIGN KEY (postId) REFERENCES posts(postId)
);

CREATE TABLE IF NOT EXISTS votes (
    voteId BIGINT AUTO_INCREMENT PRIMARY KEY,
    userId BIGINT NOT NULL,
    postId BIGINT NOT NULL,
    commentId BIGINT,
    type VARCHAR(255),
    FOREIGN KEY (userId) REFERENCES users(userId),
    FOREIGN KEY (postId) REFERENCES posts(postId),
    FOREIGN KEY (commentId) REFERENCES comments(commentId)
);

CREATE TABLE IF NOT EXISTS post_trackers (
    postTrackerId BIGINT AUTO_INCREMENT PRIMARY KEY,
    postId BIGINT NOT NULL UNIQUE,
    upvoteCount INTEGER,
    downvoteCount INTEGER,
    FOREIGN KEY (postId) REFERENCES posts(postId)
);
