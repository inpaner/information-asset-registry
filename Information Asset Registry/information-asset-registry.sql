SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `Information Asset Registry` ;
CREATE SCHEMA IF NOT EXISTS `Information Asset Registry` ;
USE `Information Asset Registry` ;

-- -----------------------------------------------------
-- Table `Information Asset Registry`.`Asset`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Information Asset Registry`.`Asset` ;

CREATE  TABLE IF NOT EXISTS `Information Asset Registry`.`Asset` (
  `pk` INT NOT NULL AUTO_INCREMENT ,
  PRIMARY KEY (`pk`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Information Asset Registry`.`Owner`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Information Asset Registry`.`Owner` ;

CREATE  TABLE IF NOT EXISTS `Information Asset Registry`.`Owner` (
  `pk` INT NOT NULL AUTO_INCREMENT ,
  `assetFk` INT NOT NULL ,
  `value` VARCHAR(45) NULL ,
  PRIMARY KEY (`pk`) ,
  INDEX `fk_Owner_Asset_idx` (`assetFk` ASC) ,
  CONSTRAINT `fk_Owner_Asset`
    FOREIGN KEY (`assetFk` )
    REFERENCES `Information Asset Registry`.`Asset` (`pk` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Information Asset Registry`.`Custodian`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Information Asset Registry`.`Custodian` ;

CREATE  TABLE IF NOT EXISTS `Information Asset Registry`.`Custodian` (
  `pk` INT NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(45) NULL ,
  `value` INT NOT NULL ,
  PRIMARY KEY (`pk`) ,
  INDEX `fk_Custodian_Asset1_idx` (`value` ASC) ,
  CONSTRAINT `fk_Custodian_Asset1`
    FOREIGN KEY (`value` )
    REFERENCES `Information Asset Registry`.`Asset` (`pk` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Information Asset Registry`.`TypeList`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Information Asset Registry`.`TypeList` ;

CREATE  TABLE IF NOT EXISTS `Information Asset Registry`.`TypeList` (
  `value` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`value`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Information Asset Registry`.`Rating`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Information Asset Registry`.`Rating` ;

CREATE  TABLE IF NOT EXISTS `Information Asset Registry`.`Rating` (
  `value` INT NOT NULL ,
  `name` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`value`) ,
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Information Asset Registry`.`Financial`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Information Asset Registry`.`Financial` ;

CREATE  TABLE IF NOT EXISTS `Information Asset Registry`.`Financial` (
  `pk` INT NOT NULL AUTO_INCREMENT ,
  `value` INT NOT NULL ,
  `assetFk` INT NOT NULL ,
  PRIMARY KEY (`pk`) ,
  INDEX `fk_FinancialValue_PossibleValues1_idx` (`value` ASC) ,
  INDEX `fk_FinancialValue_Asset1_idx` (`assetFk` ASC) ,
  CONSTRAINT `fk_FinancialValue_PossibleValues1`
    FOREIGN KEY (`value` )
    REFERENCES `Information Asset Registry`.`Rating` (`value` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_FinancialValue_Asset1`
    FOREIGN KEY (`assetFk` )
    REFERENCES `Information Asset Registry`.`Asset` (`pk` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Information Asset Registry`.`Confidentiality`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Information Asset Registry`.`Confidentiality` ;

CREATE  TABLE IF NOT EXISTS `Information Asset Registry`.`Confidentiality` (
  `pk` INT NOT NULL AUTO_INCREMENT ,
  `value` INT NOT NULL ,
  `assetFk` INT NOT NULL ,
  PRIMARY KEY (`pk`) ,
  INDEX `fk_Confidentiality_PossibleValues1_idx` (`value` ASC) ,
  INDEX `fk_Confidentiality_Asset1_idx` (`assetFk` ASC) ,
  CONSTRAINT `fk_Confidentiality_PossibleValues1`
    FOREIGN KEY (`value` )
    REFERENCES `Information Asset Registry`.`Rating` (`value` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Confidentiality_Asset1`
    FOREIGN KEY (`assetFk` )
    REFERENCES `Information Asset Registry`.`Asset` (`pk` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Information Asset Registry`.`Integrity`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Information Asset Registry`.`Integrity` ;

CREATE  TABLE IF NOT EXISTS `Information Asset Registry`.`Integrity` (
  `pk` INT NOT NULL AUTO_INCREMENT ,
  `value` INT NOT NULL ,
  `assetFk` INT NOT NULL ,
  PRIMARY KEY (`pk`) ,
  INDEX `fk_Integrity_PossibleValues1_idx` (`value` ASC) ,
  INDEX `fk_Integrity_Asset1_idx` (`assetFk` ASC) ,
  CONSTRAINT `fk_Integrity_PossibleValues1`
    FOREIGN KEY (`value` )
    REFERENCES `Information Asset Registry`.`Rating` (`value` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Integrity_Asset1`
    FOREIGN KEY (`assetFk` )
    REFERENCES `Information Asset Registry`.`Asset` (`pk` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Information Asset Registry`.`Availability`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Information Asset Registry`.`Availability` ;

CREATE  TABLE IF NOT EXISTS `Information Asset Registry`.`Availability` (
  `pk` INT NOT NULL AUTO_INCREMENT ,
  `value` INT NOT NULL ,
  `assetFk` INT NOT NULL ,
  PRIMARY KEY (`pk`) ,
  INDEX `fk_Availability_Asset1_idx` (`assetFk` ASC) ,
  INDEX `fk_Availability_PossibleValues1_idx` (`value` ASC) ,
  CONSTRAINT `fk_Availability_Asset1`
    FOREIGN KEY (`assetFk` )
    REFERENCES `Information Asset Registry`.`Asset` (`pk` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Availability_PossibleValues1`
    FOREIGN KEY (`value` )
    REFERENCES `Information Asset Registry`.`Rating` (`value` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Information Asset Registry`.`Storage`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Information Asset Registry`.`Storage` ;

CREATE  TABLE IF NOT EXISTS `Information Asset Registry`.`Storage` (
  `pk` INT NOT NULL AUTO_INCREMENT ,
  `value` VARCHAR(45) NULL ,
  `assetFk` INT NOT NULL ,
  PRIMARY KEY (`pk`) ,
  INDEX `fk_Location_Asset1_idx` (`assetFk` ASC) ,
  CONSTRAINT `fk_Location_Asset1`
    FOREIGN KEY (`assetFk` )
    REFERENCES `Information Asset Registry`.`Asset` (`pk` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Information Asset Registry`.`userTypeList`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Information Asset Registry`.`userTypeList` ;

CREATE  TABLE IF NOT EXISTS `Information Asset Registry`.`userTypeList` (
  `type` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`type`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Information Asset Registry`.`User`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Information Asset Registry`.`User` ;

CREATE  TABLE IF NOT EXISTS `Information Asset Registry`.`User` (
  `pk` INT NOT NULL AUTO_INCREMENT ,
  `username` VARCHAR(45) NOT NULL ,
  `password` VARCHAR(256) NOT NULL ,
  `type` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`pk`) ,
  INDEX `fk_User_userTypeList1_idx` (`type` ASC) ,
  UNIQUE INDEX `username_UNIQUE` (`username` ASC) ,
  CONSTRAINT `fk_User_userTypeList1`
    FOREIGN KEY (`type` )
    REFERENCES `Information Asset Registry`.`userTypeList` (`type` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Information Asset Registry`.`AttributeList`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Information Asset Registry`.`AttributeList` ;

CREATE  TABLE IF NOT EXISTS `Information Asset Registry`.`AttributeList` (
  `attribute` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`attribute`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Information Asset Registry`.`ActionList`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Information Asset Registry`.`ActionList` ;

CREATE  TABLE IF NOT EXISTS `Information Asset Registry`.`ActionList` (
  `type` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`type`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Information Asset Registry`.`Log`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Information Asset Registry`.`Log` ;

CREATE  TABLE IF NOT EXISTS `Information Asset Registry`.`Log` (
  `pk` INT NOT NULL AUTO_INCREMENT ,
  `userFk` INT NOT NULL ,
  `dateTime` DATETIME NULL ,
  `action` VARCHAR(45) NOT NULL ,
  `assetFk` INT NULL ,
  `attribute` VARCHAR(45) NULL ,
  `attributeFk` INT NULL ,
  PRIMARY KEY (`pk`) ,
  INDEX `fk_Logs_User1_idx` (`userFk` ASC) ,
  INDEX `fk_Logs_Asset1_idx` (`assetFk` ASC) ,
  INDEX `fk_Logs_attributeList1_idx` (`attribute` ASC) ,
  INDEX `fk_Logs_Action1_idx` (`action` ASC) ,
  CONSTRAINT `fk_Logs_User1`
    FOREIGN KEY (`userFk` )
    REFERENCES `Information Asset Registry`.`User` (`pk` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Logs_Asset1`
    FOREIGN KEY (`assetFk` )
    REFERENCES `Information Asset Registry`.`Asset` (`pk` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Logs_attributeList1`
    FOREIGN KEY (`attribute` )
    REFERENCES `Information Asset Registry`.`AttributeList` (`attribute` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Logs_Action1`
    FOREIGN KEY (`action` )
    REFERENCES `Information Asset Registry`.`ActionList` (`type` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Information Asset Registry`.`ClassificationList`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Information Asset Registry`.`ClassificationList` ;

CREATE  TABLE IF NOT EXISTS `Information Asset Registry`.`ClassificationList` (
  `value` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`value`) ,
  UNIQUE INDEX `pk_UNIQUE` (`value` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Information Asset Registry`.`Classification`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Information Asset Registry`.`Classification` ;

CREATE  TABLE IF NOT EXISTS `Information Asset Registry`.`Classification` (
  `pk` INT NOT NULL AUTO_INCREMENT ,
  `assetFk` INT NOT NULL ,
  `value` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`pk`) ,
  INDEX `fk_Classification_ClassTypeList1_idx` (`value` ASC) ,
  INDEX `fk_Classification_Asset1_idx` (`assetFk` ASC) ,
  CONSTRAINT `fk_Classification_ClassTypeList1`
    FOREIGN KEY (`value` )
    REFERENCES `Information Asset Registry`.`ClassificationList` (`value` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Classification_Asset1`
    FOREIGN KEY (`assetFk` )
    REFERENCES `Information Asset Registry`.`Asset` (`pk` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Information Asset Registry`.`Name`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Information Asset Registry`.`Name` ;

CREATE  TABLE IF NOT EXISTS `Information Asset Registry`.`Name` (
  `pk` INT NOT NULL AUTO_INCREMENT ,
  `assetFk` INT NOT NULL ,
  `value` VARCHAR(45) NULL ,
  PRIMARY KEY (`pk`) ,
  INDEX `fk_Name_Asset1_idx` (`assetFk` ASC) ,
  CONSTRAINT `fk_Name_Asset1`
    FOREIGN KEY (`assetFk` )
    REFERENCES `Information Asset Registry`.`Asset` (`pk` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Information Asset Registry`.`Identifier`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Information Asset Registry`.`Identifier` ;

CREATE  TABLE IF NOT EXISTS `Information Asset Registry`.`Identifier` (
  `pk` INT NOT NULL AUTO_INCREMENT ,
  `assetFk` INT NOT NULL ,
  `value` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`pk`) ,
  INDEX `fk_Identifier_Asset1_idx` (`assetFk` ASC) ,
  CONSTRAINT `fk_Identifier_Asset1`
    FOREIGN KEY (`assetFk` )
    REFERENCES `Information Asset Registry`.`Asset` (`pk` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Information Asset Registry`.`DateAcquired`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Information Asset Registry`.`DateAcquired` ;

CREATE  TABLE IF NOT EXISTS `Information Asset Registry`.`DateAcquired` (
  `pk` INT NOT NULL AUTO_INCREMENT ,
  `assetFk` INT NOT NULL ,
  `value` DATETIME NOT NULL ,
  PRIMARY KEY (`pk`) ,
  INDEX `fk_DateAcquired_Asset1_idx` (`assetFk` ASC) ,
  CONSTRAINT `fk_DateAcquired_Asset1`
    FOREIGN KEY (`assetFk` )
    REFERENCES `Information Asset Registry`.`Asset` (`pk` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Information Asset Registry`.`RetentionPeriod`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Information Asset Registry`.`RetentionPeriod` ;

CREATE  TABLE IF NOT EXISTS `Information Asset Registry`.`RetentionPeriod` (
  `pk` INT NOT NULL AUTO_INCREMENT ,
  `assetFk` INT NOT NULL ,
  `value` DATETIME NOT NULL ,
  INDEX `fk_RetentionPeriod_Asset1_idx` (`assetFk` ASC) ,
  PRIMARY KEY (`pk`) ,
  CONSTRAINT `fk_RetentionPeriod_Asset1`
    FOREIGN KEY (`assetFk` )
    REFERENCES `Information Asset Registry`.`Asset` (`pk` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Information Asset Registry`.`Type`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Information Asset Registry`.`Type` ;

CREATE  TABLE IF NOT EXISTS `Information Asset Registry`.`Type` (
  `pk` INT NOT NULL AUTO_INCREMENT ,
  `value` VARCHAR(45) NOT NULL ,
  `assetFk` INT NOT NULL ,
  PRIMARY KEY (`pk`) ,
  INDEX `fk_table1_Asset1_idx` (`assetFk` ASC) ,
  INDEX `fk_table1_TypeList1_idx` (`value` ASC) ,
  CONSTRAINT `fk_table1_Asset1`
    FOREIGN KEY (`assetFk` )
    REFERENCES `Information Asset Registry`.`Asset` (`pk` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_table1_TypeList1`
    FOREIGN KEY (`value` )
    REFERENCES `Information Asset Registry`.`TypeList` (`value` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

USE `Information Asset Registry` ;

-- -----------------------------------------------------
-- Placeholder table for view `Information Asset Registry`.`view1`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Information Asset Registry`.`view1` (`id` INT);

-- -----------------------------------------------------
-- View `Information Asset Registry`.`view1`
-- -----------------------------------------------------
DROP VIEW IF EXISTS `Information Asset Registry`.`view1` ;
DROP TABLE IF EXISTS `Information Asset Registry`.`view1`;
USE `Information Asset Registry`;
;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `Information Asset Registry`.`Asset`
-- -----------------------------------------------------
START TRANSACTION;
USE `Information Asset Registry`;
INSERT INTO `Information Asset Registry`.`Asset` (`pk`) VALUES (1);

COMMIT;

-- -----------------------------------------------------
-- Data for table `Information Asset Registry`.`TypeList`
-- -----------------------------------------------------
START TRANSACTION;
USE `Information Asset Registry`;
INSERT INTO `Information Asset Registry`.`TypeList` (`value`) VALUES ('Paper');
INSERT INTO `Information Asset Registry`.`TypeList` (`value`) VALUES ('Electronic');
INSERT INTO `Information Asset Registry`.`TypeList` (`value`) VALUES ('Physical');

COMMIT;

-- -----------------------------------------------------
-- Data for table `Information Asset Registry`.`Rating`
-- -----------------------------------------------------
START TRANSACTION;
USE `Information Asset Registry`;
INSERT INTO `Information Asset Registry`.`Rating` (`value`, `name`) VALUES (1, 'High');
INSERT INTO `Information Asset Registry`.`Rating` (`value`, `name`) VALUES (2, 'Mid');
INSERT INTO `Information Asset Registry`.`Rating` (`value`, `name`) VALUES (3, 'Low');

COMMIT;

-- -----------------------------------------------------
-- Data for table `Information Asset Registry`.`userTypeList`
-- -----------------------------------------------------
START TRANSACTION;
USE `Information Asset Registry`;
INSERT INTO `Information Asset Registry`.`userTypeList` (`type`) VALUES ('Admin');
INSERT INTO `Information Asset Registry`.`userTypeList` (`type`) VALUES ('Guest');

COMMIT;

-- -----------------------------------------------------
-- Data for table `Information Asset Registry`.`User`
-- -----------------------------------------------------
START TRANSACTION;
USE `Information Asset Registry`;
INSERT INTO `Information Asset Registry`.`User` (`pk`, `username`, `password`, `type`) VALUES (1, 'admin', '1234', 'Admin');
INSERT INTO `Information Asset Registry`.`User` (`pk`, `username`, `password`, `type`) VALUES (2, 'guest', '1234', 'Guest');

COMMIT;

-- -----------------------------------------------------
-- Data for table `Information Asset Registry`.`AttributeList`
-- -----------------------------------------------------
START TRANSACTION;
USE `Information Asset Registry`;
INSERT INTO `Information Asset Registry`.`AttributeList` (`attribute`) VALUES ('Owner');
INSERT INTO `Information Asset Registry`.`AttributeList` (`attribute`) VALUES ('Custodian');
INSERT INTO `Information Asset Registry`.`AttributeList` (`attribute`) VALUES ('Type');
INSERT INTO `Information Asset Registry`.`AttributeList` (`attribute`) VALUES ('Classification');
INSERT INTO `Information Asset Registry`.`AttributeList` (`attribute`) VALUES ('Storage');
INSERT INTO `Information Asset Registry`.`AttributeList` (`attribute`) VALUES ('Financial');
INSERT INTO `Information Asset Registry`.`AttributeList` (`attribute`) VALUES ('Confidentiality');
INSERT INTO `Information Asset Registry`.`AttributeList` (`attribute`) VALUES ('Integrity');
INSERT INTO `Information Asset Registry`.`AttributeList` (`attribute`) VALUES ('Availability');

COMMIT;

-- -----------------------------------------------------
-- Data for table `Information Asset Registry`.`ActionList`
-- -----------------------------------------------------
START TRANSACTION;
USE `Information Asset Registry`;
INSERT INTO `Information Asset Registry`.`ActionList` (`type`) VALUES ('Login');
INSERT INTO `Information Asset Registry`.`ActionList` (`type`) VALUES ('Logout');
INSERT INTO `Information Asset Registry`.`ActionList` (`type`) VALUES ('Add');
INSERT INTO `Information Asset Registry`.`ActionList` (`type`) VALUES ('Edit');
INSERT INTO `Information Asset Registry`.`ActionList` (`type`) VALUES ('Retire');

COMMIT;

-- -----------------------------------------------------
-- Data for table `Information Asset Registry`.`Log`
-- -----------------------------------------------------
START TRANSACTION;
USE `Information Asset Registry`;
INSERT INTO `Information Asset Registry`.`Log` (`pk`, `userFk`, `dateTime`, `action`, `assetFk`, `attribute`, `attributeFk`) VALUES (1, 1, '2013-6-25 1:0:0', 'Login', NULL, NULL, NULL);
INSERT INTO `Information Asset Registry`.`Log` (`pk`, `userFk`, `dateTime`, `action`, `assetFk`, `attribute`, `attributeFk`) VALUES (2, 1, '2013-6-25 2:0:0', 'Logout', NULL, NULL, NULL);
INSERT INTO `Information Asset Registry`.`Log` (`pk`, `userFk`, `dateTime`, `action`, `assetFk`, `attribute`, `attributeFk`) VALUES (3, 1, '2013-6-26 4:0:0', 'Edit', 1, 'Classification', 1);
INSERT INTO `Information Asset Registry`.`Log` (`pk`, `userFk`, `dateTime`, `action`, `assetFk`, `attribute`, `attributeFk`) VALUES (4, 1, '2013-6-26 4:0:1', 'Edit', 1, 'Classification', 2);

COMMIT;

-- -----------------------------------------------------
-- Data for table `Information Asset Registry`.`ClassificationList`
-- -----------------------------------------------------
START TRANSACTION;
USE `Information Asset Registry`;
INSERT INTO `Information Asset Registry`.`ClassificationList` (`value`) VALUES ('Sensitive');
INSERT INTO `Information Asset Registry`.`ClassificationList` (`value`) VALUES ('Confidential');
INSERT INTO `Information Asset Registry`.`ClassificationList` (`value`) VALUES ('Internal');
INSERT INTO `Information Asset Registry`.`ClassificationList` (`value`) VALUES ('Public');

COMMIT;

-- -----------------------------------------------------
-- Data for table `Information Asset Registry`.`Classification`
-- -----------------------------------------------------
START TRANSACTION;
USE `Information Asset Registry`;
INSERT INTO `Information Asset Registry`.`Classification` (`pk`, `assetFk`, `value`) VALUES (1, 1, 'Internal');
INSERT INTO `Information Asset Registry`.`Classification` (`pk`, `assetFk`, `value`) VALUES (2, 1, 'Public');

COMMIT;
