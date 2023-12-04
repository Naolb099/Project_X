package com.projectX_F23.ProjectX.Project_X.model;

public class User {
    private Long id;
    private String email;
    private String username;
    private String password;
    private Boolean verified;
    private String role;
    private String profileInfo;

    // No-arg constructor
    public User() {
    }

    // All-args constructor
    public User(Long userId, String email, String username, String password, Boolean verified, String role, String profileInfo) {
        this.id = userId;
        this.email = email;
        this.username = username;
        this.password = password;
        this.verified = verified;
        this.role = role;
        this.profileInfo = profileInfo;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Boolean getVerified() {
        return verified;
    }

    public String getRole() {
        return role;
    }

    public String getProfileInfo() {
        return profileInfo;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setProfileInfo(String profileInfo) {
        this.profileInfo = profileInfo;
    }
}
