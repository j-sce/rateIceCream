SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=1;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=1;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `rateicecream_app_test` DEFAULT CHARACTER SET utf8 ;
USE `rateicecream_app_test` ;

CREATE TABLE IF NOT EXISTS `producers` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(200) NOT NULL UNIQUE,
  PRIMARY KEY (`id`)
)
ENGINE = InnoDB
AUTO_INCREMENT = 1001;

CREATE TABLE IF NOT EXISTS `ice_creams` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(200) NOT NULL,
  `producer` VARCHAR(100) NOT NULL,
  `barcode` VARCHAR(13) NOT NULL UNIQUE,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`producer`) REFERENCES `producers`(`name`)
)
ENGINE = InnoDB
AUTO_INCREMENT = 1001;

CREATE TABLE IF NOT EXISTS `producer_ice_creams` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `producer_id` BIGINT NOT NULL,
  `ice_cream_id` BIGINT NOT NULL,
   PRIMARY KEY (`id`),
   FOREIGN KEY (`producer_id`) REFERENCES `producers`(`id`),
   FOREIGN KEY (`ice_cream_id`) REFERENCES `ice_creams`(`id`)
)
ENGINE = InnoDB
AUTO_INCREMENT = 1001;

CREATE TABLE IF NOT EXISTS `users` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(100) NOT NULL UNIQUE,
  `password` VARCHAR(100) NOT NULL,
  `role` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`)
)
ENGINE = InnoDB
AUTO_INCREMENT = 1001;

CREATE INDEX ix_producer_ice_creams_producer_id
ON producer_ice_creams (producer_id);

CREATE INDEX ix_producer_ice_creams_ice_cream_id
ON producer_ice_creams (ice_cream_id);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


insert into producers(name)
values ('Producer1');

insert into producers(name)
values ('Producer2');


insert into ice_creams(name, producer, barcode)
values ('ice_cream1', 'Producer1', '1234567890123');

insert into ice_creams(name, producer, barcode)
values ('ice_cream2', 'Producer1', '2345678901234');

insert into ice_creams(name, producer, barcode)
values ('ice_cream3', 'Producer2', '3456789012345');

insert into ice_creams(name, producer, barcode)
values ('ice_cream4', 'Producer2', '4567890123456');
