package com.projectX_F23.ProjectX.Project_X.controller;

import com.projectX_F23.ProjectX.Project_X.model.User;
import com.projectX_F23.ProjectX.Project_X.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class homeController {
    @GetMapping("/home")
    public String home()
    {
        return "home";
    }
}
