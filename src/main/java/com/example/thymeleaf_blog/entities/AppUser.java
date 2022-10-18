package com.example.thymeleaf_blog.entities;

import com.example.thymeleaf_blog.dto.AppUserResponseDTO;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class AppUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "appUser", cascade = CascadeType.ALL)
    private List<Blog> blogs;

    public AppUser(String username, String password){
        this.username = username;
        this.password = password;
    }

    public AppUser() {

    }

    public AppUserResponseDTO toResponseDTO(){
        return new AppUserResponseDTO(id, username);
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", blogs=" + blogs +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AppUser)) return false;
        AppUser appUser = (AppUser) o;
        return id == appUser.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public int getId() {
        return id;
    }
}
