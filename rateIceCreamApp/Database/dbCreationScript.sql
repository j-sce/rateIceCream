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


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;