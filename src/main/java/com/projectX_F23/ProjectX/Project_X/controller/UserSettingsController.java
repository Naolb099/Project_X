package com.projectX_F23.ProjectX.Project_X.controller;

import com.projectX_F23.ProjectX.Project_X.repository.UserRepository;
import com.projectX_F23.ProjectX.Project_X.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class UserSettingsController {

    private final UserRepository userRepository;

    @Autowired
    public UserSettingsController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/usersettings")
    public String showUserSettings(User user, Model model) {
        //User currentUser = userRepository.findByUsername(user.getUsername());
        // This is just a placeholder until findByUsername works
        User currentUser = getCurrentUser();
        model.addAttribute("user", currentUser);
        return "userSettings";
    }

    @PostMapping("/usersettings")
    public String updateInfo(@ModelAttribute User user,
                             @RequestParam(name = "saveChanges", required = false) String saveChanges,
                             @RequestParam(name = "logOut", required = false) String logOut,
                             @RequestParam(name = "deleteAccount", required = false) String deleteAccount){

        //User currentUser = userRepository.findByUsername(user.getUsername());
        // This is just a placeholder until findByUsername works
        User currentUser = getCurrentUser();

        if (saveChanges != null) {
            // Save Changes button was pressed
            currentUser.setUsername(user.getUsername());
            // Save password if match

        } else if (logOut != null) {
            // Log Out button was pressed
            // Actions
        } else if (deleteAccount != null) {
            // Delete account button was pressed
            // Actions
        }

        return "redirect:usersettings";
    }

    private User getCurrentUser() {
        User user = new User();
        user.setUsername("dylanleehilger");
        user.setEmail("dylan.hilger@trojans.dsu.edu");
        user.setPassword("Password1!");
        user.setVerified(Boolean.TRUE);
        user.setRole("USER");
        user.setProfileInfo("This is a test");
        return user;
    }
}