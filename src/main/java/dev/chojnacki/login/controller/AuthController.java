package dev.chojnacki.login.controller;

import dev.chojnacki.login.entity.dto.RegisterRequest;
import dev.chojnacki.login.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {
    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String registerForm(Model model) {
        model.addAttribute("user", new RegisterRequest());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(RegisterRequest registerRequest) {
        try {
            userService.registerUser(registerRequest);
            return "redirect:/login";
        } catch (IllegalArgumentException e) {
            return "/register";
        }
    }
}
