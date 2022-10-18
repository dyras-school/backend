package com.example.thymeleaf_blog.dto;

public record BlogResponseDTO(int id, String title, String text, boolean hidden, int appUserId) {

}