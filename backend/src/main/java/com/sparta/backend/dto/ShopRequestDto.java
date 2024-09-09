package com.sparta.backend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShopRequestDto {
    private String username;
    private String title;
    private String content;
    private int price;
}

