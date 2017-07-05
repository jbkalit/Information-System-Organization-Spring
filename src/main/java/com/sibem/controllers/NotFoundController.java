package com.sibem.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NotFoundController {
    @RequestMapping("/401")
    public String render401(Model model) {
        // Add model attributes
        return "/error-handler/401";
    }
    
    @RequestMapping("/403")
    public String render403(Model model) {
        // Add model attributes
        return "/error-handler/403";
    }
    @RequestMapping("/404")
    public String render404(Model model) {
        // Add model attributes
        return "/error-handler/404";
    }
    @RequestMapping("/500")
    public String render500(Model model) {
        // Add model attributes
        return "/error-handler/500";
    }
}