package com.projectX_F23.ProjectX.Project_X.repository;

import com.projectX_F23.ProjectX.Project_X.model.Post;
import com.projectX_F23.ProjectX.Project_X.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

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

public List<Post> findAll() {
    String sql = "SELECT p.*, u.userId as user_id, u.username " +
            "FROM posts p " +
            "JOIN users u ON p.userId = u.userId " +
            "ORDER BY p.postDate DESC";

    return jdbcTemplate.query(sql, this::mapRowToPostWithUser);
}


    private Post mapRowToPostWithUser(ResultSet rs, int rowNum) throws SQLException {
        Post post = new Post();
        post.setPostId(rs.getLong("postId"));
        post.setUserId(rs.getLong("userId"));
        post.setTitle(rs.getString("title"));
        post.setContent(rs.getString("content"));
        post.setPostDate(rs.getTimestamp("postDate").toLocalDateTime());

        User user = new User();
        user.setId(rs.getLong("user_id"));
        user.setUsername(rs.getString("username"));

        post.setUser(user);

        return post;
    }


}
