package ru.geekbrains.spring.data.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.spring.data.entities.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {
}
