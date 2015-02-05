-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema hacknslash
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema hacknslash
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `hacknslash` DEFAULT CHARACTER SET latin1 ;
USE `hacknslash` ;

-- -----------------------------------------------------
-- Table `hacknslash`.`players`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hacknslash`.`players` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NOT NULL,
  `Level` INT(11) NOT NULL DEFAULT '1',
  `Experience` INT(11) NULL DEFAULT '0',
  `MapLevel` INT(11) NOT NULL DEFAULT '1',
  `CurrentPosition` VARCHAR(45) NULL DEFAULT '2,2',
  `Health` INT(11) NULL DEFAULT '10',
  `Mana` INT(11) NULL DEFAULT '0',
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `Name_UNIQUE` (`Name` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
