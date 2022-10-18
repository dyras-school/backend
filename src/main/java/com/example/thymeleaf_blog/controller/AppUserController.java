package com.example.thymeleaf_blog.controller;

import com.example.thymeleaf_blog.dto.AppUserResponseDTO;
import com.example.thymeleaf_blog.entities.AppUser;
import com.example.thymeleaf_blog.service.AppUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class AppUserController {

    private final AppUserService appUserService;

    public AppUserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @GetMapping
    public List<AppUserResponseDTO> findAllUsers(){
        return appUserService.findAll()
                .stream()
                .map(AppUser::toResponseDTO)
                .toList();
    }

}
