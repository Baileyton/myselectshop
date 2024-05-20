package com.example.myselectshop.service;

import com.example.myselectshop.dto.ItemRequestDto;
import com.example.myselectshop.dto.ItemResponseDto;
import com.example.myselectshop.entity.Item;
import com.example.myselectshop.repository.ItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public ItemResponseDto createItem(ItemRequestDto itemRequestDto) {
        Item item = new Item(itemRequestDto);
        Item saveItem = itemRepository.save(item);

        return new ItemResponseDto(saveItem);
    }

    public List<ItemResponseDto> getItems() {
        return itemRepository.findAll().stream().map(ItemResponseDto::new).toList();
    }

    @Transactional
    public Item updateItem(Long id, ItemRequestDto itemRequestDto) {
        Item item = findItem(id);
        item.update(itemRequestDto);

        return itemRepository.save(item);
    }

    private Item findItem(Long id) {
        return itemRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 게시글이 존재하지 않습니다.")
        );
    }

    public void deleteItem(Long id) {
        Item item = findItem(id);

        itemRepository.delete(item);
    }

}
