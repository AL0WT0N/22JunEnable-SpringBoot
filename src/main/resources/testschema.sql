DROP TABLE IF EXISTS `customer`;

CREATE TABLE `customer` (
	`id` BIGINT AUTO_INCREMENT,
	`first_name` VARCHAR(255) NOT NULL,
	`last_name` VARCHAR(255) NOT NULL,
	`age` INT NOT NULL,
	PRIMARY KEY(`id`)
);