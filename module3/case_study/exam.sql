drop schema if exists `exam`;
CREATE SCHEMA if not exists `exam` ;
use `exam`;
CREATE TABLE category(
id_category INT NOT NULL UNIQUE AUTO_INCREMENT,
name_category VARCHAR(45) NOT NULL,
PRIMARY KEY (id_category)
);
CREATE TABLE product (
    id_product INT NOT NULL UNIQUE AUTO_INCREMENT,
    name_product VARCHAR(45) NOT NULL,
    price DOUBLE NOT NULL,
    amount INT NOT NULL,
    color VARCHAR(45) NOT NULL,
    description VARCHAR(45) NOT NULL,
    id_category INT NOT NULL,
    PRIMARY KEY (id_product),
    CONSTRAINT fk_p_c FOREIGN KEY (id_category)
        REFERENCES category (id_category)
        ON DELETE CASCADE
);
INSERT INTO `exam`.`category` (`name_category`) VALUES ('phone');
INSERT INTO `exam`.`category` (`name_category`) VALUES ('tv');

