package com.projectX_F23.ProjectX.Project_X.repository;

import com.projectX_F23.ProjectX.Project_X.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

@Repository
public class PostRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PostRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(Post post) {
        String sql = "INSERT INTO posts (userId, title, content, postDate) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, post.getUserId(), post.getTitle(), post.getContent(), post.getPostDate());
    }

    public Post findById(Long postId) {
        String sql = "SELECT * FROM posts WHERE postId = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{postId}, this::mapRowToPost);
    }

    private Post mapRowToPost(ResultSet rs, int rowNum) throws SQLException {
        Post post = new Post();
        post.setPostId(rs.getLong("postId"));
        post.setUserId(rs.getLong("userId"));  // Retrieve and set userId
        post.setTitle(rs.getString("title"));
        post.setContent(rs.getString("content"));
        post.setPostDate(rs.getTimestamp("postDate").toLocalDateTime());
        return post;
    }
}
