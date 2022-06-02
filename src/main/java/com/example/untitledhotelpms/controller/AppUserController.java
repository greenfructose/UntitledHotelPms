package com.example.untitledhotelpms.controller;

import com.example.untitledhotelpms.domain.AppUser;
import com.example.untitledhotelpms.service.AppUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/users")
public class AppUserController {

    private static AppUserService appUserService;

    @GetMapping("/{id}")
    public ModelAndView showUser(@PathVariable Long id) {
        ModelAndView mav = new ModelAndView("users/userDetail");
        mav.addObject("user", appUserService.findById(id));
        return mav;
    }
}
