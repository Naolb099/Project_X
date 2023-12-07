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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
        User loggedInUser = (User) session.getAttribute("loggedInUser");

        // Check if the user is logged in
        if (loggedInUser == null) {
            return "redirect:/login";
        }

        model.addAttribute("post", new Post());
        model.addAttribute("loggedInUser", loggedInUser);

        return "createPost";
    }

    @PostMapping("/createPost")
    public String createOrUpdatePost(@ModelAttribute Post post,
                                     HttpSession session,
                                     RedirectAttributes redirectAttributes) {
        try {
            User loggedInUser = (User) session.getAttribute("loggedInUser");

            if (loggedInUser == null) {
                return "redirect:/login";
            }

            post.setUserId(loggedInUser.getId());
            post.setUser(loggedInUser); // Add this line
            post.setPostDate(LocalDateTime.now());

            postRepository.save(post);

            redirectAttributes.addFlashAttribute("successMessage", "Post saved successfully!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "An error occurred while saving the post.");
        }

        return "redirect:/home";
    }

}
