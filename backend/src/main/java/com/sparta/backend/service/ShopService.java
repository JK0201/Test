package com.sparta.backend.service;

import com.sparta.backend.dto.ShopRequestDto;
import com.sparta.backend.dto.ShopResponseDto;
import com.sparta.backend.entity.Item;
import com.sparta.backend.entity.RestApiStatus;
import com.sparta.backend.repository.ShopRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j(topic = "Shop Service")
@Service
@RequiredArgsConstructor
public class ShopService {

    private final ShopRepository shopRepository;

    public ShopResponseDto addItem(ShopRequestDto req) {
        Item item = shopRepository.save(new Item(req));

        log.info("new item title : " + item.getTitle());

        return new ShopResponseDto(item);
    }

    public List<ShopResponseDto> getList() {
        return shopRepository.findAll().stream().map(ShopResponseDto::new).toList();
    }

    public ShopResponseDto updateItem(Long id, ShopRequestDto req) {
        Item cur_item = shopRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 상품은 존재하지 않습니다."));

        cur_item.update(id, req);

        Item updatedItem = shopRepository.save(cur_item);

        log.info("updated item id : " + updatedItem.getId());

        return new ShopResponseDto(updatedItem);
    }


    public ResponseEntity<RestApiStatus> deleteItem(Long id) {
        Item cur_item = shopRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 상품은 존재하지 않습니다."));

        shopRepository.delete(cur_item);

        log.info("deleted item id :" + cur_item.getId());

        return ResponseEntity.ok(new RestApiStatus("삭제완료"));
    }
}
