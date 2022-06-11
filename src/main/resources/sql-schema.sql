drop schema ims;

CREATE SCHEMA IF NOT EXISTS `ims`;

USE `ims` ;

CREATE TABLE IF NOT EXISTS `ims`.`customers` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

DROP TABLE IF EXISTS items;

CREATE TABLE IF NOT EXISTS ims.items(
	item_id INT(11) NOT NULL AUTO_INCREMENT,
    item_name VARCHAR(45) NOT NULL,
    item_cost DOUBLE not null,
    PRIMARY KEY (item_id)

);

DROP TABLE IF EXISTS `order`;

CREATE TABLE IF NOT EXISTS ims.`order`(
	order_id INT(11) NOT NULL AUTO_INCREMENT,
    f_customer_id INT(11) NOT NULL,
    PRIMARY KEY (order_id),
    FOREIGN KEY (f_customer_id) REFERENCES customers(id) on delete cascade


);

DROP TABLE IF EXISTS order_items;

CREATE TABLE IF NOT EXISTS order_items(

	order_item_id INT(11) NOT NULL AUTO_INCREMENT,
    quantity INT(11) NOT NULL,
    f_order_id INT NOT NULL,
    f_item_id INT NOT NULL,
    PRIMARY KEY (order_item_id),
    FOREIGN KEY (f_order_id) REFERENCES `order`(order_id) on delete cascade,
    FOREIGN KEY (f_item_id) REFERENCES items(item_id) on delete cascade

);
