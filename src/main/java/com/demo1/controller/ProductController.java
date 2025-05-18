package com.demo1.controller;

import com.demo1.modal.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {
    @PostMapping("/add")
    public String addProduct(@ModelAttribute("product") Product product, Model model) {
        model.addAttribute("product", product);
        return "productResult";
    }
}

