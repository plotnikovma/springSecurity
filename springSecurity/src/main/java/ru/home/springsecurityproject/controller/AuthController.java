package ru.home.springsecurityproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 *
 * @author mplotnikov
 * @since 20.09.2021
 */
@Controller
@RequestMapping("/auth")
public class AuthController
{
    @GetMapping("/login")
    public String getLoginPage()
    {
        return "login";
    }

    @GetMapping("/success")
    public String getSuccessPage()
    {
        return "success";
    }
}
