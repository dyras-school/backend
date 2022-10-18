package com.example.thymeleaf_blog.service;

import com.example.thymeleaf_blog.entities.AppUser;
import com.example.thymeleaf_blog.entities.Blog;
import com.example.thymeleaf_blog.repo.BlogRepo;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BlogService {
    private final BlogRepo blogRepo;

    public BlogService(BlogRepo blogRepo) {
        this.blogRepo = blogRepo;
    }

    public List<Blog> findAll(String contains) {
        if(contains.isBlank())
            return blogRepo.findAll();

        return blogRepo.findBlogByTitleContainsIgnoreCase(contains);
    }

    public Blog findById(int id) {
        return blogRepo.findById(id).orElseThrow();
    }

    public Blog addBlog(String title, String text) {
        return blogRepo.save(new Blog(title, text, (new AppUser("batman", "password"))));
    }

}
