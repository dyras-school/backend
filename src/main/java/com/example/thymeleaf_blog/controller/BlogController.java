package com.example.thymeleaf_blog.controller;

import com.example.thymeleaf_blog.dto.BlogResponseDTO;
import com.example.thymeleaf_blog.dto.CreateBlogDTO;
import com.example.thymeleaf_blog.entities.Blog;
import com.example.thymeleaf_blog.service.BlogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blog")
@CrossOrigin(origins = {"http://localhost:3000"}, methods = {RequestMethod.GET, RequestMethod.DELETE, RequestMethod.POST})
public class BlogController {

    private final BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping
    public List<BlogResponseDTO> findAll(@RequestParam(required = false, defaultValue = "") String contains){
        return blogService.findAll(contains)
                .stream()
                .map(Blog::toResponseDTO)
                .toList();
    }

    @GetMapping("/{id}")
    public BlogResponseDTO findById(@PathVariable("id") int id){
        return blogService.findById(id).toResponseDTO();
    }

    @PostMapping
    public BlogResponseDTO addBlog(@RequestBody CreateBlogDTO createBlogDTO){
        return blogService.addBlog(createBlogDTO.title(), createBlogDTO.text())
                .toResponseDTO();
    }
}
