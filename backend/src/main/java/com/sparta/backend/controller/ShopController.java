package com.sparta.backend.controller;

import com.sparta.backend.dto.ShopRequestDto;
import com.sparta.backend.dto.ShopResponseDto;
import com.sparta.backend.entity.RestApiStatus;
import com.sparta.backend.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ShopController {

    private final ShopService shopService;

    @PostMapping("/post")
    public ShopResponseDto addItem(@RequestBody ShopRequestDto req) {
        return shopService.addItem(req);
    }

    @GetMapping("/post")
    public List<ShopResponseDto> getList() {
        return shopService.getList();
    }

    @PutMapping("/post/{id}")
    public ShopResponseDto updateItem(@PathVariable Long id, @RequestBody ShopRequestDto req) {
        return shopService.updateItem(id, req);
    }

    @DeleteMapping("/post/{id}")
    public ResponseEntity<RestApiStatus> deleteItem(@PathVariable Long id) {
        return shopService.deleteItem(id);
    }
}

