package com.projectX_F23.ProjectX.Project_X.model;

import java.time.LocalDateTime;

public class Post {
    private Long postId;
    private Long userId;
    private String title;
    private String content;
    private LocalDateTime postDate;

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
    // ...
}
