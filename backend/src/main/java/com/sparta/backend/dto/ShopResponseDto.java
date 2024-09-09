package com.sparta.backend.dto;

import com.sparta.backend.entity.Item;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShopResponseDto {
    private Long id;
    private String username;
    private String title;
    private String content;
    private int price;

    public ShopResponseDto(Item item) {
        this.id = item.getId();
        this.username = item.getUsername();
        this.title = item.getTitle();
        this.content = item.getContent();
        this.price = item.getPrice();
    }
}
