package ru.geekbrains.spring.data.dto;

import ru.geekbrains.spring.data.entities.Card;

public class ProductUserDto {
    public ProductUserDto(Card card) {
        this.id = card.getId();
        this.userId = card.getUser_id();
        this.productId = card.getProduct_id();
        this.price = card.getPrice();
    }

    public Long id;
    public Long userId;
    public Long productId;
    public int price;
}
