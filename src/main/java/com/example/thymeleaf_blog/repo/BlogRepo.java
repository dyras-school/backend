package com.example.thymeleaf_blog.repo;

import com.example.thymeleaf_blog.entities.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepo extends JpaRepository<Blog, Integer> {

    List<Blog> findBlogByTitleContainsIgnoreCase(String contains);
}
