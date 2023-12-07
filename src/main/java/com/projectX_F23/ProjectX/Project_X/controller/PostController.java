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

        // Retrieve the logged-in user from the session
        User loggedInUser = (User) session.getAttribute("loggedInUser");

        if (loggedInUser != null) {
            // Add the user information to the model
            model.addAttribute("loggedInUser", loggedInUser);
            return "createPost";
        } else {
            // Handle the case where the user is not logged in
            return "redirect:/login"; // Redirect to the login page or handle as appropriate
        }
    }

    @PostMapping("/post")
    public String createPost(@ModelAttribute Post post, HttpSession session) {
        // Retrieve the logged-in user from the session
        User loggedInUser = (User) session.getAttribute("loggedInUser");

        if (loggedInUser != null) {
            // Set the user and post date before saving
            post.setUser(loggedInUser);
            post.setPostDate(LocalDateTime.now());
            postRepository.save(post, loggedInUser);
            return "redirect:/home";
        } else {
            // Handle the case where the user is not logged in
            return "redirect:/login"; // Redirect to the login page or handle as appropriate
        }
    }

}
