INSERT INTO users (email, username, password, verified, role, profileInfo) VALUES
    (null, '[Deleted User]', null, true, 'USER', 'This populates posts when user is deleted'),
    ('john.doe@example.com', 'JohnDoe', 'hashedpassword', true, 'USER', 'Profile information about John'),
    ('jane.smith@example.com', 'JaneSmith', 'hashedpassword', true, 'USER', 'Profile information about Jane'),
    ('alice.johnson@example.com', 'AliceJohnson', 'hashedpassword', true, 'USER', 'Profile information about Alice');

INSERT INTO posts (userId, title, content, postDate) VALUES
    (2, 'First Post', 'Content of the first post', CURRENT_TIMESTAMP);
INSERT INTO comments (userId, postId, content, commentDate) VALUES
    (2, 1, 'This is a comment on the first post', CURRENT_TIMESTAMP);
INSERT INTO votes (userId, postId, commentId, type) VALUES
    (2, 1, null, 'UPVOTE');
INSERT INTO votes (userId, postId, commentId, type) VALUES
    (2, 1, 1, 'UPVOTE');
INSERT INTO post_trackers (postId, upvoteCount, downvoteCount) VALUES
    (1, 10, 2);
