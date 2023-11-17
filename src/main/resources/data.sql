INSERT INTO users (email, username, password, verified, role, profileInfo) VALUES
                                                                               ('john.doe@example.com', 'johndoe', 'hashedpassword1', true, 'USER', 'Information about John'),
                                                                               ('naol.doe@example.com', 'janedoe', 'hashedpassword2', false, 'ADMIN', 'Information about Jane');
INSERT INTO posts (userId, title, content, postDate, tags) VALUES
                                                               (1, 'First Post', 'Content of the first post', CURRENT_TIMESTAMP, 'tag1, tag2'),
                                                               (2, 'Second Post', 'Content of the second post', CURRENT_TIMESTAMP, 'tag3, tag4');
INSERT INTO comments (userId, postId, content, commentDate) VALUES
                                                                (2, 1, 'This is a comment on the first post', CURRENT_TIMESTAMP),
                                                                (1, 2, 'This is a comment on the second post', CURRENT_TIMESTAMP);
INSERT INTO votes (userId, postId, commentId, type) VALUES
                                                        (1, 1, null, 'UPVOTE'),
                                                        (2, 1, null, 'DOWNVOTE'),
                                                        (1, null, 1, 'UPVOTE');
INSERT INTO votes (userId, postId, commentId, type) VALUES
                                                        (1, 1, null, 'UPVOTE'),
                                                        (2, 1, null, 'DOWNVOTE'),
                                                        (1, null, 1, 'UPVOTE');
INSERT INTO post_trackers (postId, upvoteCount, downvoteCount) VALUES
                                                                   (1, 10, 2),
                                                                   (2, 5, 3);
