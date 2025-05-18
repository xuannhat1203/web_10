package com.demo1.controller;

import com.demo1.modal.Account;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class AccountController {
    @PostMapping("/register")
    public String register(@ModelAttribute("account") Account account, Model model) {
        // Simulate saving to database (add your DB logic here)
        // accountService.save(account);
        model.addAttribute("message", "Registration successful!");
        model.addAttribute("account", account);
        return "registerSuccess";
    }
}

