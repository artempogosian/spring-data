package ru.geekbrains.spring.data.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.spring.data.dto.ProductUserDto;
import ru.geekbrains.spring.data.entities.Card;
import ru.geekbrains.spring.data.repositories.CardRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CardService {
    private final CardRepository cardRepository;

    public List<ProductUserDto> getCard() {
        List<Card> productsUsers = cardRepository.findAll();
        return productsUsers.stream()
                .sorted(Comparator.comparingLong(Card::getUser_id))
                .map(ProductUserDto::new)
                .collect(Collectors.toList());
    }
}
