package ru.geekbrains.spring.data.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.spring.data.dto.ProductDto;
import ru.geekbrains.spring.data.dto.ProductUserDto;
import ru.geekbrains.spring.data.dto.UserCardDto;
import ru.geekbrains.spring.data.services.CardService;
import ru.geekbrains.spring.data.services.ProductService;
import ru.geekbrains.spring.data.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/card")
@RequiredArgsConstructor
public class CardController {
    private final CardService cardService;

    @GetMapping
    public List<ProductUserDto> getCard() {
        return cardService.getCard();
    }
}
