package com.liulich3ng.controller;

import com.liulich3ng.entity.Item;
import com.liulich3ng.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;

    @PostMapping("/items")
    public void createItem() {
        itemService.newItemWithChildren(1, List.of("hhh", "xswl"));
        itemService.newItemWithoutChildren(1, "llc");
    }

    @GetMapping("/items/{id}")
    public Item getItem(@PathVariable int id) {
        return itemService.getItemById(id);
    }
}
