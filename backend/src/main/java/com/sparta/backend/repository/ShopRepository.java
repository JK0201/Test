package com.sparta.backend.repository;

import com.sparta.backend.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<Item, Long> {
}
