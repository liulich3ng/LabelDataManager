package com.liulich3ng.repository;

import com.liulich3ng.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Integer> {
    @Override
    Optional<Item> findById(Integer integer);
}
