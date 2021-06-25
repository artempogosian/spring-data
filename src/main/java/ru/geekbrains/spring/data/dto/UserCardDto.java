package ru.geekbrains.spring.data.dto;

import ru.geekbrains.spring.data.entities.User;

public class UserCardDto {
    public UserCardDto(User user) {
        this.id = user.getId();
        this.name = user.getName();
    }

    public Long id;
    public String name;
}
