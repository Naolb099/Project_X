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

    public boolean existsByUsername(String username) {
        String sql = "SELECT COUNT(*) FROM users WHERE username = ?";
        Integer count = jdbcTemplate.queryForObject(sql, new Object[]{username}, Integer.class);
        return count != null && count > 0;
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

    public void deleteByEmail(String email) {
        String sql = "DELETE FROM users WHERE email = ?";
        jdbcTemplate.update(sql, email);
    }

    public void update(User user) {
        String sql = "UPDATE users SET username = ?, password = ?, verified = ?, role = ?, profileInfo = ? WHERE email = ?";
        jdbcTemplate.update(
                sql,
                user.getUsername(),
                user.getPassword(),
                user.getVerified(),
                user.getRole(),
                user.getProfileInfo(),
                user.getEmail()
        );
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
