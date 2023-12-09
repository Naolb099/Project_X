package com.projectX_F23.ProjectX.Project_X.controller;

import com.projectX_F23.ProjectX.Project_X.repository.UserRepository;
import com.projectX_F23.ProjectX.Project_X.model.User;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Objects;


@Controller
public class UserSettingsController {

    private final UserRepository userRepository;

    @Autowired
    public UserSettingsController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/usersettings")
    public String showUserSettings(Model model, HttpSession session) {
        // Retrieve the logged-in user from the session
        User currentUser = (User) session.getAttribute("loggedInUser");
        // Check if the user is logged in
        if (currentUser == null) {
            return "redirect:/login";
        }

        model.addAttribute("user", currentUser);

        // Pass the user information to the home page as well
        model.addAttribute("loggedInUser", currentUser);

        return "usersettings";
    }



    @PostMapping("/usersettings")
    public String updateInfo(@ModelAttribute User user,
                             @RequestParam(name = "saveChanges", required = false) String saveChanges,
                             @RequestParam(name = "logOut", required = false) String logOut,
                             @RequestParam(name = "deleteAccount", required = false) String deleteAccount,
                             HttpSession session,
                             RedirectAttributes redirectAttributes, Model model) {

        try {
            User currentUser = (User) session.getAttribute("loggedInUser");

            if (currentUser == null) {
                return "redirect:/login";
            }

        if (saveChanges != null) { // Save changes button was pressed

            if (!Objects.equals(user.getPassword(), "") || !Objects.equals(user.getUsername(), currentUser.getUsername())) { // Changes were made
                currentUser.setUsername(user.getUsername());
                if (!Objects.equals(user.getPassword(), "")) {
                    // Password not blank
                    currentUser.setPassword(user.getPassword());
                }
                currentUser.setVerified(user.getVerified());
                currentUser.setRole(user.getRole());
                currentUser.setProfileInfo(user.getProfileInfo());

                userRepository.update(currentUser);

                session.setAttribute("loggedInUser", currentUser);

                redirectAttributes.addFlashAttribute("successMessage", "User information updated successfully!");

                return "redirect:/usersettings";
            }
        } else if (logOut != null) { // Log out button was pressed

            session.invalidate();

            redirectAttributes.addFlashAttribute("successMessage", "Logged out successfully!");
            // Redirect to the login page after logging out
            return "redirect:/login";
        } else if (deleteAccount != null) { // Delete account button was pressed

            userRepository.deleteByEmail(currentUser.getEmail());

            session.invalidate();

            redirectAttributes.addFlashAttribute("error", "Account deleted successfully!");
            // Redirect to the home page or login page after deleting the account
            return "redirect:/login";
        }
        } catch (Exception e) {
            // Log the exception details
            e.printStackTrace();

            redirectAttributes.addFlashAttribute("errorMessage", "An unexpected error occurred.");
        }

        return "redirect:/usersettings";
    }

}