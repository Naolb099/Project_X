package com.projectX_F23.ProjectX.Project_X.controller;

import com.projectX_F23.ProjectX.Project_X.repository.UserRepository;
import com.projectX_F23.ProjectX.Project_X.model.User;
import jakarta.servlet.http.HttpSession;
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
    public String showUserSettings(Model model, HttpSession session) {
        // Retrieve the logged-in user from the session
        User currentUser = (User) session.getAttribute("loggedInUser");
        // Check if the user is logged in
        if (currentUser == null) {
            // Redirect to the login page if the user is not logged in
            return "redirect:/login";
        }

        model.addAttribute("user", currentUser);
        return "usersettings";
    }

    //works---------------------------------------------------------- down
//    @PostMapping("/usersettings")
//    public String updateInfo(@ModelAttribute User user,
//                             @RequestParam(name = "saveChanges", required = false) String saveChanges,
//                             HttpSession session,
//                             RedirectAttributes redirectAttributes) {
//
//        try {
//            User currentUser = (User) session.getAttribute("loggedInUser");
//
//            if (currentUser == null) {
//                // Redirect to the login page if the user is not logged in
//                return "redirect:/login";
//            }
//
//            if (saveChanges != null) {
//                // Save Changes button was pressed
//
//                // Update user information
//                currentUser.setUsername(user.getUsername());
//                currentUser.setPassword(user.getPassword());
//                currentUser.setVerified(user.getVerified());
//                currentUser.setRole(user.getRole());
//                currentUser.setProfileInfo(user.getProfileInfo());
//
//                // Use the UserRepository to update the user in the database
//                userRepository.update(currentUser);
//
//                // Update the user in the session
//                session.setAttribute("loggedInUser", currentUser);
//
//                // Redirect with a success message
//                redirectAttributes.addFlashAttribute("successMessage", "User information updated successfully!");
//            } else {
//                // Handle other button actions (logOut, deleteAccount) if needed
//            }
//
//        } catch (Exception e) {
//            // Log the exception details
//            e.printStackTrace(); // Use a logger for better logging in a real application
//
//            // Optionally, add an error message for the user
//            redirectAttributes.addFlashAttribute("errorMessage", "An unexpected error occurred.");
//        }
//
//        return "redirect:/usersettings";
//    }


    //works---------------------------------------------------------- up



    @PostMapping("/usersettings")
    public String updateInfo(@ModelAttribute User user,
                             @RequestParam(name = "saveChanges", required = false) String saveChanges,
                             @RequestParam(name = "logOut", required = false) String logOut,
                             @RequestParam(name = "deleteAccount", required = false) String deleteAccount,
                             HttpSession session,
                             RedirectAttributes redirectAttributes) {

        try {
            User currentUser = (User) session.getAttribute("loggedInUser");

            if (currentUser == null) {
                // Redirect to the login page if the user is not logged in
                return "redirect:/login";
            }
        if (saveChanges != null) {
            // Save Changes button was pressed
            // ... your existing code ...
            // Save Changes button was pressed

            // Update user information
            currentUser.setUsername(user.getUsername());
            currentUser.setPassword(user.getPassword());
            currentUser.setVerified(user.getVerified());
            currentUser.setRole(user.getRole());
            currentUser.setProfileInfo(user.getProfileInfo());

            // Use the UserRepository to update the user in the database
            userRepository.update(currentUser);

            // Update the user in the session
            session.setAttribute("loggedInUser", currentUser);

            // Redirect with a success message
            redirectAttributes.addFlashAttribute("successMessage", "User information updated successfully!");
        } else if (logOut != null) {
            // Log Out button was pressed
            // ... your existing code ...
            session.invalidate();

            // Redirect to the login page after logging out
            return "redirect:/login";
        } else if (deleteAccount != null) {
            // Delete Account button was pressed
            // ... your existing code ...
            // Delete Account button was pressed

            // Use the UserRepository to delete the user from the database
            userRepository.deleteByEmail(currentUser.getEmail());

            // Invalidate the session after deleting the account
            session.invalidate();

            // Redirect to the home page or login page after deleting the account
            return "redirect:/login"; // Adjust the redirection URL as needed for your application
        }
        } catch (Exception e) {
            // Log the exception details
            e.printStackTrace(); // Use a logger for better logging in a real application

            // Optionally, add an error message for the user
            redirectAttributes.addFlashAttribute("errorMessage", "An unexpected error occurred.");
        }

        return "redirect:/usersettings";
    }


//    @PostMapping("/usersettings")
//    public String updateInfo(@ModelAttribute User user,
//                             @RequestParam(name = "saveChanges", required = false) String saveChanges,
//                             @RequestParam(name = "logOut", required = false) String logOut,
//                             @RequestParam(name = "deleteAccount", required = false) String deleteAccount,
//                             HttpSession session,
//                             RedirectAttributes redirectAttributes) {
//
//        try {
//            User currentUser = (User) session.getAttribute("loggedInUser");
//
//            if (currentUser == null) {
//                // Redirect to the login page if the user is not logged in
//                return "redirect:/login";
//            }
//
//            if ("saveChanges".equals(saveChanges)) {
//                                // Save Changes button was pressed
//
//                // Update user information
//                currentUser.setUsername(user.getUsername());
//                currentUser.setPassword(user.getPassword());
//                currentUser.setVerified(user.getVerified());
//                currentUser.setRole(user.getRole());
//                currentUser.setProfileInfo(user.getProfileInfo());
//
//                // Use the UserRepository to update the user in the database
//                userRepository.update(currentUser);
//
//                // Update the user in the session
//                session.setAttribute("loggedInUser", currentUser);
//
//                // Redirect with a success message
//                redirectAttributes.addFlashAttribute("successMessage", "User information updated successfully!");
//
//            } else if ("Log Out".equals(logOut)) {
//                // Log Out button was pressed
//
//                // Perform log out action
//                // ...
//
//            } else if ("Delete Account".equals(deleteAccount)) {
//                // Delete Account button was pressed
//
//                // Use the UserRepository to delete the user from the database
//                userRepository.deleteByEmail(currentUser.getEmail());
//
//                // Invalidate the session after deleting the account
//                session.invalidate();
//
//                // Redirect to the home page or login page after deleting the account
//                return "redirect:/login"; // Adjust the redirection URL as needed for your application
//            }
//
//        } catch (Exception e) {
//            // Log the exception details
//            e.printStackTrace(); // Use a logger for better logging in a real application
//
//            // Optionally, add an error message for the user
//            redirectAttributes.addFlashAttribute("errorMessage", "An unexpected error occurred.");
//        }
//
//        return "redirect:/usersettings";
//    }

//    @PostMapping("/usersettings")
//    public String deleteInfo(@ModelAttribute User user,
//                             @RequestParam(name = "deleteaccount", required = false) String deleteAccount,
//                             HttpSession session,
//                             RedirectAttributes redirectAttributes) {
//
//        try {
//            User currentUser = (User) session.getAttribute("loggedInUser");
//
//            if (currentUser == null) {
//                // Redirect to the login page if the user is not logged in
//                return "redirect:/login";
//            }
//
//            if (deleteAccount != null) {
//                // Delete account button was pressed
//
//                // Use the UserRepository to delete the user from the database
//                userRepository.deleteByEmail(currentUser.getEmail());
//
//                // Remove the user from the session
//                session.removeAttribute("loggedInUser");
//
//                // Redirect with a success message
//                redirectAttributes.addFlashAttribute("successMessage", "Account deleted successfully!");
//
//                // Redirect to a different page or perform other actions after account deletion
//                return "redirect:/signup";  // For example, redirect to the logout page
//            } else {
//                // Handle other button actions (logOut, saveChanges) if needed
//            }
//
//        } catch (Exception e) {
//            // Log the exception details
//            e.printStackTrace(); // Use a logger for better logging in a real application
//
//            // Optionally, add an error message for the user
//            redirectAttributes.addFlashAttribute("errorMessage", "An unexpected error occurred.");
//        }
//
//        return "redirect:/usersettings";
//    }


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