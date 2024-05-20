package com.example.myselectshop.entity;

import com.example.myselectshop.dto.ItemRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "item")
@NoArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private int price;
    private String username;

    public Item(ItemRequestDto itemRequestDto) {
        this.title = itemRequestDto.getTitle();
        this.content = itemRequestDto.getContent();
        this.price = itemRequestDto.getPrice();
        this.username = itemRequestDto.getUsername();
    }

    public void update(ItemRequestDto itemRequestDto) {
        this.title = itemRequestDto.getTitle();
        this.content = itemRequestDto.getContent();
        this.price = itemRequestDto.getPrice();
        this.username = itemRequestDto.getUsername();
    }
}
