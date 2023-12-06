package com.projectX_F23.ProjectX.Project_X.controller;

import com.projectX_F23.ProjectX.Project_X.model.Post;
import com.projectX_F23.ProjectX.Project_X.model.User;
import com.projectX_F23.ProjectX.Project_X.repository.PostRepository;
import com.projectX_F23.ProjectX.Project_X.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.time.LocalDateTime;

@Controller
public class PostController {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Autowired
    public PostController(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/createPost")
    public String showPostForm(Model model, HttpSession session) {
        model.addAttribute("post", new Post());
        User loggedInUser = (User) session.getAttribute("loggedInUser");

        // Check if the user is logged in
        if (loggedInUser != null) {
            // Add the user information to the model
            model.addAttribute("loggedInUser", loggedInUser);
        }
        return "createPost";
    }

    @PostMapping("/post")
    public String createPost(@ModelAttribute Post post, Principal principal) {
        if (principal != null) {
            User user = userRepository.findByUsername(principal.getName());
            if (user != null) {
                post.setUser(user);
                post.setPostDate(LocalDateTime.now());
                postRepository.save(post);
            }

        }
        return "redirect:/home";
    }
}
