package com.projectX_F23.ProjectX.Project_X.controller;

import com.projectX_F23.ProjectX.Project_X.repository.UserRepository;
import com.projectX_F23.ProjectX.Project_X.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class UserSettingsController {
    @Autowired
    public UserSettingsController(UserRepository userRepository) {
    }

    @GetMapping("/usersettings")
    public String showUserSettings(User user, Model model) {
//        User currentUser = userRepository.findByUsername(user.getUsername());
        User currentUser = getCurrentUser();
        model.addAttribute("user", currentUser);
        return "userSettings";
    }
    private User getCurrentUser() {
        //This is just a placeholder until findByUsername works
        User user = new User();
        user.setUsername("dylanleehilger");
        user.setEmail("dylan.hilger@trojans.dsu.edu");
        user.setPassword("Password1!");
        return user;
    }
}