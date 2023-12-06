package com.projectX_F23.ProjectX.Project_X.repository;

import com.projectX_F23.ProjectX.Project_X.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    private final JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void save(User user) {
        String sql = "INSERT INTO users (email, username, password, verified, role, profileInfo) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, user.getEmail(), user.getUsername(), user.getPassword(), user.getVerified(), user.getRole(), user.getProfileInfo());
    }

    public User findByUsername(String username) {
        String sql = "SELECT * FROM users WHERE username = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{username}, (resultSet, rowNum) ->
                new User(
                        resultSet.getLong("userId"),
                        resultSet.getString("email"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getBoolean("verified"),
                        resultSet.getString("role"),
                        resultSet.getString("profileInfo")
                ));
    }

    public User findByEmail(String email)

    {
        String sql = "SELECT * FROM users WHERE email = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{email}, (resultSet, rowNum) ->
                new User(
                        resultSet.getLong("userId"),
                        resultSet.getString("email"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getBoolean("verified"),
                        resultSet.getString("role"),
                        resultSet.getString("profileInfo")
                ));
    }
    public User findById(Long userId) {
        String sql = "SELECT * FROM users WHERE userId = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{userId}, (resultSet, rowNum) ->
                new User(
                        resultSet.getLong("userId"),
                        resultSet.getString("email"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getBoolean("verified"),
                        resultSet.getString("role"),
                        resultSet.getString("profileInfo")
                ));
    }

}
