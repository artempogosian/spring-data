package ru.geekbrains.spring.data.services;

import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.spring.data.dto.ProductDto;
import ru.geekbrains.spring.data.dto.UserCardDto;
import ru.geekbrains.spring.data.entities.Product;
import ru.geekbrains.spring.data.entities.User;
import ru.geekbrains.spring.data.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<UserCardDto> getUsersByProductId(long productId) {
        List<User> users = productRepository.findUsersByProductId(productId);
        return users.stream().map(UserCardDto::new).collect(Collectors.toList());
    }

    public ProductDto updateProduct(Long productId, Integer newPrice) throws NotFoundException {
        Optional<Product> productItem = productRepository.findById(productId);
        if (productItem.isEmpty())
            throw new NotFoundException("Product with id {} not found");
        Product product = productItem.get();
        product.setPrice(newPrice);
        Product updatedProduct = productRepository.save(product);
        return new ProductDto(updatedProduct);
    }

    public List<ProductDto> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(ProductDto::new).collect(Collectors.toList());
    }
}
