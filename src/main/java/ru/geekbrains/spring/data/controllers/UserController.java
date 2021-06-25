package ru.geekbrains.spring.data.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.spring.data.dto.ProductCardDto;
import ru.geekbrains.spring.data.dto.UserDto;
import ru.geekbrains.spring.data.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}/products")
    public List<ProductCardDto> getProductsByUserId(@PathVariable Long userId) {
        return userService.getByUserId(userId);
    }

    @PostMapping("/{userId}/buy/product/{productId}")
    public HttpStatus buyProduct(@PathVariable Long userId, @PathVariable Long productId) {
        userService.buyProduct(userId, productId);
        return HttpStatus.ACCEPTED;
    }
}
