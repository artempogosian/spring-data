DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS products CASCADE;
DROP TABLE IF EXISTS card CASCADE;

CREATE TABLE users (id serial, name varchar(255) not null, PRIMARY KEY (id));
CREATE TABLE products (id serial, title varchar(255) not null, price int not null, PRIMARY KEY (id));
CREATE TABLE card (id serial, product_id integer REFERENCES products (id), user_id integer REFERENCES users (id), price int not null);

insert into products (title, price) values
('Milk', 80),
('Bread', 25),
('Sugar', 70);

insert into users (name) values
('Bob'),
('Jack'),
('John');

