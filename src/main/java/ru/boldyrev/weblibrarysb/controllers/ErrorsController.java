package ru.boldyrev.weblibrarysb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorsController {

    @GetMapping("/error")
    public String processError() {
        return "/errors/error";
    }

    @GetMapping
    public String defaultPage() {
        return "/books";
    }
}
