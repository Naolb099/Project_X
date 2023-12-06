package com.projectX_F23.ProjectX.Project_X.controller;

import com.projectX_F23.ProjectX.Project_X.model.User;
import com.projectX_F23.ProjectX.Project_X.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignUpController {

    private final UserRepository userRepository;

    @Autowired
    public SignUpController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/signup")
    public String signup(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping("/signup")
    public String registerUser(@ModelAttribute User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "signup";
        }

        if (userRepository.existsByUsername(user.getUsername())) {
            model.addAttribute("usernameExistsError", "Username already taken");
            return "signup";
        }


        try {
            userRepository.save(user);
        } catch (DataIntegrityViolationException e) {
            // Log the exception for debugging purposes
            // e.printStackTrace(); // Uncomment this line for debugging

            // Add an error message to the model and return to the signup page
            model.addAttribute("signupError", "An error occurred while processing your registration. Please try again.");
            return "signup";
        }

        user.setVerified(false);
        user.setRole("USER");

        userRepository.save(user);
        return "redirect:/login";
    }
}
