package com.example.thymeleaf_blog.service;

import com.example.thymeleaf_blog.entities.AppUser;
import com.example.thymeleaf_blog.repo.AppUserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppUserService {
    private final AppUserRepo appUserRepo;

    public AppUserService(AppUserRepo appUserRepo) {
        this.appUserRepo = appUserRepo;
    }

    public List<AppUser> findAll() {
    return appUserRepo.findAll();
    }
}
