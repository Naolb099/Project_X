package com.projectX_F23.ProjectX.Project_X.controller;

import com.projectX_F23.ProjectX.Project_X.model.User;
import com.projectX_F23.ProjectX.Project_X.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class LogInController {

    private final UserRepository userRepository;

    @Autowired
    public LogInController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@ModelAttribute User user, Model model) {
        User existingUser = userRepository.findByUsername(user.getUsername());

        if (existingUser != null && existingUser.getPassword().equals(user.getPassword())) {
            // Passwords match, user is authenticated
            return "redirect:/dashboard";
        } else {
            redirectAttrs.addFlashAttribute("error", "The error XYZ occurred.");
            // Passwords do not match or user not found
            model.addAttribute("error", "Invalid username or password");
            // Return the same login page with the error message
            model.addAttribute("user", new User()); // Add this line to ensure the form is populated with the user object
            return "login";
        }
    }
}
