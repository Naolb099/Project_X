package com.projectX_F23.ProjectX.Project_X.controller;

import com.projectX_F23.ProjectX.Project_X.model.User;
import com.projectX_F23.ProjectX.Project_X.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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
    public String loginUser(@ModelAttribute User user, Model model, HttpSession session) {
        try {
            User foundUser = userRepository.findByEmail(user.getEmail());

            if (foundUser != null && foundUser.getPassword().equals(user.getPassword())) {
                // Store the logged-in user in the session
                session.setAttribute("loggedInUser", foundUser);
                return "redirect:/home";
            } else {
                model.addAttribute("error", "Invalid email or password.");
                return "login";
            }
        } catch (EmptyResultDataAccessException e) {
            // Handle the case when no user is found with the given email
            model.addAttribute("error", "Invalid email or password.");
            return "login";
        }
    }

}

