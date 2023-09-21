SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=1;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=1;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `rateicecream_app` DEFAULT CHARACTER SET utf8 ;
USE `rateicecream_app` ;

CREATE TABLE IF NOT EXISTS `producers` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(200) NOT NULL UNIQUE,
  PRIMARY KEY (`id`)
)
ENGINE = InnoDB
AUTO_INCREMENT = 1;

CREATE TABLE IF NOT EXISTS `ice_creams` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(200) NOT NULL,
  `producer` VARCHAR(100) NOT NULL,
  `barcode` VARCHAR(13) NOT NULL UNIQUE,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`producer`) REFERENCES `producers`(`name`)
)
ENGINE = InnoDB
AUTO_INCREMENT = 1;

CREATE TABLE IF NOT EXISTS `producer_ice_creams` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `producer_id` BIGINT NOT NULL,
  `ice_cream_id` BIGINT NOT NULL,
   PRIMARY KEY (`id`),
   FOREIGN KEY (`producer_id`) REFERENCES `producers`(`id`),
   FOREIGN KEY (`ice_cream_id`) REFERENCES `ice_creams`(`id`)
)
ENGINE = InnoDB
AUTO_INCREMENT = 1;

CREATE TABLE IF NOT EXISTS `users` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(100) NOT NULL UNIQUE,
  `password` VARCHAR(100) NOT NULL,
   `enabled` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
)
ENGINE = InnoDB
AUTO_INCREMENT = 1;

CREATE TABLE IF NOT EXISTS `user_ice_cream_ratings` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `user_id` BIGINT NOT NULL,
  `ice_cream_id` BIGINT NOT NULL,
  `user_ice_cream_rating` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`user_id`) REFERENCES `users`(`id`),
  FOREIGN KEY (`ice_cream_id`) REFERENCES `ice_creams`(`id`)
)
ENGINE = InnoDB
AUTO_INCREMENT = 1;

CREATE TABLE IF NOT EXISTS `roles` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL UNIQUE,
  PRIMARY KEY (`id`)
)
ENGINE = InnoDB
AUTO_INCREMENT = 1;


CREATE TABLE IF NOT EXISTS `users_roles` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `user_id` BIGINT NOT NULL,
  `role_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`user_id`) REFERENCES `users`(`id`),
  FOREIGN KEY (`role_id`) REFERENCES `roles`(`id`)
)
ENGINE = InnoDB
AUTO_INCREMENT = 1;


CREATE INDEX ix_producer_ice_creams_producer_id
ON producer_ice_creams (producer_id);

CREATE INDEX ix_producer_ice_creams_ice_cream_id
ON producer_ice_creams (ice_cream_id);


CREATE INDEX ix_user_ice_cream_ratings_user_id
ON user_ice_cream_ratings (user_id);

CREATE INDEX ix_user_ice_cream_ratings_ice_cream_id
ON user_ice_cream_ratings (ice_cream_id);

CREATE INDEX ix_users_roles_user_id
ON users_roles (user_id);

CREATE INDEX ix_users_roles_role_id
ON users_roles (role_id);



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;


