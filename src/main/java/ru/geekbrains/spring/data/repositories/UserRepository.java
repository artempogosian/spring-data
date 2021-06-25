package ru.geekbrains.spring.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.geekbrains.spring.data.entities.User;

import javax.transaction.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO card (product_id, user_id, price) VALUES (:product_id, :user_id, :price)", nativeQuery = true)
    void buyProduct(
            @Param("product_id") long productId,
            @Param("user_id") long userId,
            @Param("price") int price);
}
