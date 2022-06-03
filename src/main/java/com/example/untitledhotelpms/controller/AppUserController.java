package com.example.untitledhotelpms.controller;

import com.example.untitledhotelpms.domain.AppUser;
import com.example.untitledhotelpms.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/users")
public class AppUserController {

    private final AppUserService appUserService;
    private final RewardsService rewardsService;

    public AppUserController(AppUserService appUserService, RewardsService rewardsService) {
        this.appUserService = appUserService;
        this.rewardsService = rewardsService;
    }

    @GetMapping("/{id}")
    public ModelAndView showUser(@PathVariable Long id) {
        ModelAndView mav = new ModelAndView("users/userDetail");
        mav.addObject("appUser", appUserService.findById(id));
        return mav;
    }

    @GetMapping("/new")
    public String initCreationForm(Model model) {
        model.addAttribute("appUser", AppUser.builder().build());
        return "users/createOrUpdateUserForm";
    }

    @PostMapping("/new")
    public String processCreationForm(@Validated AppUser appUser,
                                      BindingResult result) {
        if (result.hasErrors()) {
            return "users/createOrUpdateUserForm";
        } else {
            AppUser savedUser = appUserService.save(appUser);
            return "redirect:/users/" + savedUser.getId();
        }
    }

    @GetMapping("/{id}/edit")
    public String initUpdateForm(@PathVariable Long id, Model model) {
        model.addAttribute(appUserService.findById(id));
        return "users/createOrUpdateUserForm";
    }

    @PostMapping("/{id}/edit")
    public String processUpdateForm(@Validated AppUser appUser, BindingResult result, @PathVariable Long id) {
        if (result.hasErrors()) {
            return "users/createOrUpdateUserForm";
        } else {
            appUser.setId(id);
            AppUser savedUser = appUserService.save(appUser);
            return "redirect:/users/" + savedUser.getId();
        }
    }
}
