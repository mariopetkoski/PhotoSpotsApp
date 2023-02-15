package com.example.backend.web;

import com.example.backend.Exceptions.InvalidArgumentsException;
import com.example.backend.Exceptions.InvalidUsernameOrPasswordException;
import com.example.backend.Exceptions.UsernameAlreadyExistsException;
import com.example.backend.service.AuthService;
import com.example.backend.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private final AuthService authService;
    private final UserService userService;

    public RegisterController(AuthService authService, UserService userService) {
        this.authService = authService;
        this.userService = userService;
    }

    @GetMapping
    public String getRegisterPage(@RequestParam(required = false) String error, Model model) {
        if(error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        return "register";
    }

    @PostMapping
    public String register(@RequestParam String username,
                           @RequestParam String password,
                           @RequestParam String email) throws UsernameAlreadyExistsException, InvalidUsernameOrPasswordException {
        this.userService.register(email, username, password);
        return "redirect:/login";
    }
}
