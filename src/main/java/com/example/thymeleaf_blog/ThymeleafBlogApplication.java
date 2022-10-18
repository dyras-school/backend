package com.example.thymeleaf_blog;

import com.example.thymeleaf_blog.repo.AppUserRepo;
import com.example.thymeleaf_blog.repo.BlogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ThymeleafBlogApplication implements CommandLineRunner {

    @Autowired
    BlogRepo blogRepo;

    @Autowired
    AppUserRepo appUserRepo;

    public static void main(String[] args) {
        SpringApplication.run(ThymeleafBlogApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {


    }
}
