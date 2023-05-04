package com.herbalife.mysecuredapp.controller;

import com.herbalife.mysecuredapp.entity.AppUser;
import com.herbalife.mysecuredapp.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class AppUserController {

    @Autowired
    private AppUserService appUserService;

    @PostMapping
    public void addUser(@RequestBody AppUser appUser) {
        appUserService.save(appUser);
    }

}
