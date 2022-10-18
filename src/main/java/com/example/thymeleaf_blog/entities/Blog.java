package com.example.thymeleaf_blog.entities;

import com.example.thymeleaf_blog.dto.BlogResponseDTO;

import javax.persistence.*;

@Entity
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String text;

    @Column(nullable = false)
    private boolean hidden;

    @ManyToOne
    private AppUser appUser;

    public Blog(String title, String text, AppUser appUser) {
        this.title = title;
        this.text = text;
        this.hidden = false;
        this.appUser = appUser;
    }

    public Blog() {
    }
    public BlogResponseDTO toResponseDTO(){
        return new BlogResponseDTO(id, title, text, hidden, appUser.getId());
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public boolean isHidden() {
        return hidden;
    }
}
