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

import java.util.List;


@Controller
public class homeController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/home")
    public String home(Model model, HttpSession session) {
        // Retrieve the logged-in user from the session
        User loggedInUser = (User) session.getAttribute("loggedInUser");

        // Check if the user is logged in
        if (loggedInUser != null) {
            // Add the user information to the model
            model.addAttribute("loggedInUser", loggedInUser);
        }
        List<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        return "home";
    }
}
