package ru.geekbrains.spring.data.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.spring.data.dto.ProductCardDto;
import ru.geekbrains.spring.data.dto.UserDto;
import ru.geekbrains.spring.data.entities.Product;
import ru.geekbrains.spring.data.entities.User;
import ru.geekbrains.spring.data.repositories.ProductRepository;
import ru.geekbrains.spring.data.repositories.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public List<ProductCardDto> getByUserId(long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty())
            return new ArrayList();

        return user.get().getProducts().stream().map(ProductCardDto::new).collect(Collectors.toList());
    }

    public void buyProduct(long userId, long productId) {
        Optional<User> userItem = userRepository.findById(userId);
        Optional<Product> productItem = productRepository.findById(productId);

        if (userItem.isEmpty() || productItem.isEmpty())
            return;

        User user = userItem.get();
        Product product = productItem.get();

        userRepository.buyProduct(product.getId(), user.getId(), product.getPrice());
    }

    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(UserDto::new).collect(Collectors.toList());
    }
}
