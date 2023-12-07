package com.projectX_F23.ProjectX.Project_X.model;

import java.time.LocalDateTime;

public class Post {
    private Long postId;
    private Long userId;
    private String title;
    private String content;
    private LocalDateTime postDate;

    private User user; // Ensure this field is present

    // Getters and setters
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    // Default constructor
    public Post() {
    }

    // Constructor with fields
    public Post(Long userId, String title, String content, LocalDateTime postDate) {
        this.userId = userId;
        this.title = title;
        this.content = content;
        this.postDate = postDate;
    }

    // Getters and setters
    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getPostDate() {
        return postDate;
    }

    public void setPostDate(LocalDateTime postDate) {
        this.postDate = postDate;
    }
}
