INSERT INTO users (email, username, password, verified, role, profileInfo) VALUES
                                                                               ('john.kerry@example.com', 'johnkerry', 'hashedpassword2', false, 'ADMIN', 'Information about Jane');
INSERT INTO users (email, username, password, verified, role, profileInfo)
VALUES
    ('john.doe@example.com', 'JohnDoe', 'hashedpassword', true, 'USER', 'Profile information about John'),
    ('jane.smith@example.com', 'JaneSmith', 'hashedpassword', true, 'USER', 'Profile information about Jane'),
    ('alice.johnson@example.com', 'AliceJohnson', 'hashedpassword', true, 'USER', 'Profile information about Alice');



INSERT INTO posts (userId, title, content, postDate, tags) VALUES
                                                               (1, 'First Post', 'Content of the first post', CURRENT_TIMESTAMP, 'tag1, tag2');
INSERT INTO comments (userId, postId, content, commentDate) VALUES
                                                                (1, 1, 'This is a comment on the first post', CURRENT_TIMESTAMP);
INSERT INTO votes (userId, postId, commentId, type) VALUES
                                                        (1, 1, null, 'UPVOTE');
INSERT INTO votes (userId, postId, commentId, type) VALUES
                                                        (1, 1, 1, 'UPVOTE');
INSERT INTO post_trackers (postId, upvoteCount, downvoteCount) VALUES
                                                                   (1, 10, 2);


