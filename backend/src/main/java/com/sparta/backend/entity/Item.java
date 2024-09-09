package com.sparta.backend.entity;

import com.sparta.backend.dto.ShopRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private int price;

    public Item(ShopRequestDto req) {
        this.username = req.getUsername();
        this.title = req.getTitle();
        this.content = req.getContent();
        this.price = req.getPrice();
    }

    public void update(Long id, ShopRequestDto req) {
        this.id = id;
        this.username = req.getUsername();
        this.title = req.getTitle();
        this.content = req.getContent();
        this.price = req.getPrice();
    }
}
