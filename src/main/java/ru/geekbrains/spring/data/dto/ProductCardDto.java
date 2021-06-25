package ru.geekbrains.spring.data.dto;

import ru.geekbrains.spring.data.entities.Product;

public class ProductCardDto {
    public ProductCardDto(Product product) {
        this.id = product.getId();
        this.title = product.getTitle();
        this.price = product.getPrice();
    }

    public Long id;
    public String title;
    public int price;
}
