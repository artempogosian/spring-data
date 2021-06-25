package ru.geekbrains.spring.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
- Создайте проект на Spring Boot;
- Создайте две сущности, которые минимально описывают пользователя (id, имя) и товары (id, название, цена).
	Если требуется то в ходе выполнения работы можете создавать дополнительные сущности;
 - Реализуйте возможность “покупки” пользователем товара. В момент “покупки” цена товара в заказе должна фиксироваться.
	То есть изменение цены товара не должно влиять на уже сохраненные заказы;
	(Переусложнять задачу не надо, постарайтесь реализовать минимальный функционал, который требуется для решения задачи)
- Реализуйте REST-сервис, предоставляющий возможность:
	a.) показа покупок пользователя по его id;
	b.) показа пользователей, которые купили товар указанный по id.
*/

@SpringBootApplication
public class SpringDataApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringDataApplication.class, args);
    }
}
