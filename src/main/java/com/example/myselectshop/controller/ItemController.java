package com.example.myselectshop.controller;

import com.example.myselectshop.dto.ItemRequestDto;
import com.example.myselectshop.dto.ItemResponseDto;
import com.example.myselectshop.entity.Item;
import com.example.myselectshop.service.ItemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping("/post")
    public ItemResponseDto createItem(@RequestBody ItemRequestDto itemRequestDto) {
        return itemService.createItem(itemRequestDto);
    }

    @GetMapping("/post")
    public List<ItemResponseDto> getItems() {
        return itemService.getItems();
    }

    @PutMapping("/post/{id}")
    public Item updateItem(@PathVariable Long id, @RequestBody ItemRequestDto itemRequestDto) {
        return itemService.updateItem(id, itemRequestDto);
    }

    @DeleteMapping("/post/{id}")
    public ResponseEntity<String> deleteItem(@PathVariable Long id) {
        itemService.deleteItem(id);
        return ResponseEntity.ok().body("{\"msg\":\"삭제완료\"}");
    }
}
