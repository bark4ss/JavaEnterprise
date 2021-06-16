Use shop;

DROP TABLE IF EXISTS users;
CREATE TABLE users
(
    id int(10) PRIMARY KEY AUTO_INCREMENT,
    age int(10) NOT NULL,
    name VARCHAR(255) NOT NULL
);

DROP TABLE IF EXISTS autos;
CREATE TABLE autos
(
    id int(10) PRIMARY KEY AUTO_INCREMENT,
    color VARCHAR(255) NOT NULL,
    model VARCHAR(255) NOT NULL,
    user_id int(10),
    FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);

DROP TABLE IF EXISTS product;
CREATE TABLE product
(
    id int(10) PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    price decimal NOT NULL
);
