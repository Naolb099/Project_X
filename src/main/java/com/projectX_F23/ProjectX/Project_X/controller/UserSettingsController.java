package com.projectX_F23.ProjectX.Project_X.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserSettingsController {
    @GetMapping("/usersettings")
    public String showUserSettings()
    {
        return "userSettings";
    }
}