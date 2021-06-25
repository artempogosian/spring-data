package ru.geekbrains.spring.data.controllers;

import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.spring.data.dto.ProductDto;
import ru.geekbrains.spring.data.dto.UserCardDto;
import ru.geekbrains.spring.data.entities.Product;
import ru.geekbrains.spring.data.services.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/{productId}/users")
    public List<UserCardDto> getUsersByProductId(@PathVariable Long productId) {
        return productService.getUsersByProductId(productId);
    }

    @PatchMapping("/{productId}")
    public ResponseEntity<ProductDto> updateProductPrice(@PathVariable Long productId, @RequestBody Product product) {
        if (product == null)
            return new ResponseEntity<>(new ProductDto(), HttpStatus.BAD_REQUEST);
        int newPrice = product.getPrice();
        if (newPrice <= 0)
            return new ResponseEntity<>(new ProductDto(), HttpStatus.BAD_REQUEST);
        ProductDto updatedProduct;
        try {
            updatedProduct = productService.updateProduct(productId, newPrice);
        } catch (NotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ProductDto(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedProduct, HttpStatus.ACCEPTED);
    }

    @GetMapping
    public List<ProductDto> getAllProducts() {
        return productService.getAllProducts();
    }
}
