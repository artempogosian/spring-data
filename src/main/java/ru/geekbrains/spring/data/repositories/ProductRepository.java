package ru.geekbrains.spring.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.geekbrains.spring.data.entities.Product;
import ru.geekbrains.spring.data.entities.User;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT u FROM User u JOIN u.products p where p.id = :id")
    List<User> findUsersByProductId(@Param("id") long productId);
}
