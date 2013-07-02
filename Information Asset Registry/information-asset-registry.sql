CREATE DATABASE  IF NOT EXISTS `information asset registry` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `information asset registry`;
-- MySQL dump 10.13  Distrib 5.6.12, for Win64 (x86_64)
--
-- Host: localhost    Database: information asset registry
-- ------------------------------------------------------
-- Server version 5.6.12-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `actionlist`
--

DROP TABLE IF EXISTS `actionlist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `actionlist` (
  `type` varchar(45) NOT NULL,
  PRIMARY KEY (`type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actionlist`
--

LOCK TABLES `actionlist` WRITE;
/*!40000 ALTER TABLE `actionlist` DISABLE KEYS */;
INSERT INTO `actionlist` VALUES ('Add'),('Edit'),('Login'),('Logout'),('Retire');
/*!40000 ALTER TABLE `actionlist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `asset`
--

DROP TABLE IF EXISTS `asset`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `asset` (
  `pk` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`pk`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asset`
--

LOCK TABLES `asset` WRITE;
/*!40000 ALTER TABLE `asset` DISABLE KEYS */;
INSERT INTO `asset` VALUES (3),(4);
/*!40000 ALTER TABLE `asset` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `attributelist`
--

DROP TABLE IF EXISTS `attributelist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `attributelist` (
  `attribute` varchar(45) NOT NULL,
  PRIMARY KEY (`attribute`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attributelist`
--

LOCK TABLES `attributelist` WRITE;
/*!40000 ALTER TABLE `attributelist` DISABLE KEYS */;
INSERT INTO `attributelist` VALUES ('Availability'),('Classification'),('Confidentiality'),('Custodian'),('Financial'),('Integrity'),('Owner'),('Storage'),('Type');
/*!40000 ALTER TABLE `attributelist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `availability`
--

DROP TABLE IF EXISTS `availability`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `availability` (
  `pk` int(11) NOT NULL AUTO_INCREMENT,
  `value` int(11) NOT NULL,
  `assetFk` int(11) NOT NULL,
  PRIMARY KEY (`pk`),
  KEY `fk_Availability_Asset1_idx` (`assetFk`),
  KEY `fk_Availability_PossibleValues1_idx` (`value`),
  CONSTRAINT `fk_Availability_Asset1` FOREIGN KEY (`assetFk`) REFERENCES `asset` (`pk`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Availability_PossibleValues1` FOREIGN KEY (`value`) REFERENCES `rating` (`value`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `availability`
--

LOCK TABLES `availability` WRITE;
/*!40000 ALTER TABLE `availability` DISABLE KEYS */;
INSERT INTO `availability` VALUES (1,1,3),(2,2,4);
/*!40000 ALTER TABLE `availability` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `classification`
--

DROP TABLE IF EXISTS `classification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `classification` (
  `pk` int(11) NOT NULL AUTO_INCREMENT,
  `assetFk` int(11) NOT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`pk`),
  KEY `fk_Classification_ClassTypeList1_idx` (`value`),
  KEY `fk_Classification_Asset1_idx` (`assetFk`),
  CONSTRAINT `fk_Classification_ClassTypeList1` FOREIGN KEY (`value`) REFERENCES `classificationlist` (`value`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Classification_Asset1` FOREIGN KEY (`assetFk`) REFERENCES `asset` (`pk`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classification`
--

LOCK TABLES `classification` WRITE;
/*!40000 ALTER TABLE `classification` DISABLE KEYS */;
INSERT INTO `classification` VALUES (1,3,'Confidential'),(2,4,'Public');
/*!40000 ALTER TABLE `classification` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `classificationlist`
--

DROP TABLE IF EXISTS `classificationlist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `classificationlist` (
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`value`),
  UNIQUE KEY `pk_UNIQUE` (`value`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classificationlist`
--

LOCK TABLES `classificationlist` WRITE;
/*!40000 ALTER TABLE `classificationlist` DISABLE KEYS */;
INSERT INTO `classificationlist` VALUES ('Confidential'),('Internal'),('Public'),('Sensitive');
/*!40000 ALTER TABLE `classificationlist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `confidentiality`
--

DROP TABLE IF EXISTS `confidentiality`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `confidentiality` (
  `pk` int(11) NOT NULL AUTO_INCREMENT,
  `value` int(11) NOT NULL,
  `assetFk` int(11) NOT NULL,
  PRIMARY KEY (`pk`),
  KEY `fk_Confidentiality_PossibleValues1_idx` (`value`),
  KEY `fk_Confidentiality_Asset1_idx` (`assetFk`),
  CONSTRAINT `fk_Confidentiality_PossibleValues1` FOREIGN KEY (`value`) REFERENCES `rating` (`value`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Confidentiality_Asset1` FOREIGN KEY (`assetFk`) REFERENCES `asset` (`pk`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `confidentiality`
--

LOCK TABLES `confidentiality` WRITE;
/*!40000 ALTER TABLE `confidentiality` DISABLE KEYS */;
INSERT INTO `confidentiality` VALUES (3,1,3),(4,3,4);
/*!40000 ALTER TABLE `confidentiality` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `custodian`
--

DROP TABLE IF EXISTS `custodian`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `custodian` (
  `pk` int(11) NOT NULL AUTO_INCREMENT,
  `assetFk` int(11) NOT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`pk`),
  KEY `fk_Custodian_Asset1_idx` (`assetFk`),
  CONSTRAINT `fk_Custodian_Asset1` FOREIGN KEY (`assetFk`) REFERENCES `asset` (`pk`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `custodian`
--

LOCK TABLES `custodian` WRITE;
/*!40000 ALTER TABLE `custodian` DISABLE KEYS */;
INSERT INTO `custodian` VALUES (3,3,'A'),(4,4,'John Cross');
/*!40000 ALTER TABLE `custodian` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dateacquired`
--

DROP TABLE IF EXISTS `dateacquired`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dateacquired` (
  `pk` int(11) NOT NULL AUTO_INCREMENT,
  `assetFk` int(11) NOT NULL,
  `value` date NOT NULL,
  PRIMARY KEY (`pk`),
  KEY `fk_DateAcquired_Asset1_idx` (`assetFk`),
  CONSTRAINT `fk_DateAcquired_Asset1` FOREIGN KEY (`assetFk`) REFERENCES `asset` (`pk`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dateacquired`
--

LOCK TABLES `dateacquired` WRITE;
/*!40000 ALTER TABLE `dateacquired` DISABLE KEYS */;
INSERT INTO `dateacquired` VALUES (3,3,'2011-01-01'),(4,4,'2013-01-03');
/*!40000 ALTER TABLE `dateacquired` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `financial`
--

DROP TABLE IF EXISTS `financial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `financial` (
  `pk` int(11) NOT NULL AUTO_INCREMENT,
  `value` int(11) NOT NULL,
  `assetFk` int(11) NOT NULL,
  PRIMARY KEY (`pk`),
  KEY `fk_FinancialValue_PossibleValues1_idx` (`value`),
  KEY `fk_FinancialValue_Asset1_idx` (`assetFk`),
  CONSTRAINT `fk_FinancialValue_PossibleValues1` FOREIGN KEY (`value`) REFERENCES `rating` (`value`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_FinancialValue_Asset1` FOREIGN KEY (`assetFk`) REFERENCES `asset` (`pk`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `financial`
--

LOCK TABLES `financial` WRITE;
/*!40000 ALTER TABLE `financial` DISABLE KEYS */;
INSERT INTO `financial` VALUES (3,1,3),(4,2,4);
/*!40000 ALTER TABLE `financial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `identifier`
--

DROP TABLE IF EXISTS `identifier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `identifier` (
  `pk` int(11) NOT NULL AUTO_INCREMENT,
  `assetFk` int(11) NOT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`pk`),
  KEY `fk_Identifier_Asset1_idx` (`assetFk`),
  CONSTRAINT `fk_Identifier_Asset1` FOREIGN KEY (`assetFk`) REFERENCES `asset` (`pk`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `identifier`
--

LOCK TABLES `identifier` WRITE;
/*!40000 ALTER TABLE `identifier` DISABLE KEYS */;
INSERT INTO `identifier` VALUES (3,3,'A'),(4,4,'KJCHC');
/*!40000 ALTER TABLE `identifier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `integrity`
--

DROP TABLE IF EXISTS `integrity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `integrity` (
  `pk` int(11) NOT NULL AUTO_INCREMENT,
  `value` int(11) NOT NULL,
  `assetFk` int(11) NOT NULL,
  PRIMARY KEY (`pk`),
  KEY `fk_Integrity_PossibleValues1_idx` (`value`),
  KEY `fk_Integrity_Asset1_idx` (`assetFk`),
  CONSTRAINT `fk_Integrity_PossibleValues1` FOREIGN KEY (`value`) REFERENCES `rating` (`value`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Integrity_Asset1` FOREIGN KEY (`assetFk`) REFERENCES `asset` (`pk`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `integrity`
--

LOCK TABLES `integrity` WRITE;
/*!40000 ALTER TABLE `integrity` DISABLE KEYS */;
INSERT INTO `integrity` VALUES (3,1,3),(4,1,4);
/*!40000 ALTER TABLE `integrity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `log`
--

DROP TABLE IF EXISTS `log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `log` (
  `pk` int(11) NOT NULL AUTO_INCREMENT,
  `userFk` int(11) NOT NULL,
  `dateTime` datetime DEFAULT NULL,
  `action` varchar(45) NOT NULL,
  `assetFk` int(11) DEFAULT NULL,
  `attribute` varchar(45) DEFAULT NULL,
  `attributeFk` int(11) DEFAULT NULL,
  PRIMARY KEY (`pk`),
  KEY `fk_Logs_User1_idx` (`userFk`),
  KEY `fk_Logs_Asset1_idx` (`assetFk`),
  KEY `fk_Logs_attributeList1_idx` (`attribute`),
  KEY `fk_Logs_Action1_idx` (`action`),
  CONSTRAINT `fk_Logs_User1` FOREIGN KEY (`userFk`) REFERENCES `user` (`pk`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Logs_Asset1` FOREIGN KEY (`assetFk`) REFERENCES `asset` (`pk`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Logs_attributeList1` FOREIGN KEY (`attribute`) REFERENCES `attributelist` (`attribute`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Logs_Action1` FOREIGN KEY (`action`) REFERENCES `actionlist` (`type`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `log`
--

LOCK TABLES `log` WRITE;
/*!40000 ALTER TABLE `log` DISABLE KEYS */;
INSERT INTO `log` VALUES (1,1,'2013-06-25 01:00:00','Login',NULL,NULL,NULL),(2,1,'2013-06-25 02:00:00','Logout',NULL,NULL,NULL),(4,1,'2013-07-02 07:36:05','Login',NULL,NULL,NULL),(6,1,'2013-07-02 07:40:24','Login',NULL,NULL,NULL),(7,1,'2013-07-02 07:41:09','Login',NULL,NULL,NULL),(8,1,'2013-07-02 07:41:28','Add',3,NULL,NULL),(9,1,'2013-07-02 07:42:29','Add',4,NULL,NULL),(10,1,'2013-07-02 07:44:25','Login',NULL,NULL,NULL),(11,1,'2013-07-02 07:51:43','Login',NULL,NULL,NULL),(12,1,'2013-07-02 07:52:06','Login',NULL,NULL,NULL);
/*!40000 ALTER TABLE `log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `name`
--

DROP TABLE IF EXISTS `name`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `name` (
  `pk` int(11) NOT NULL AUTO_INCREMENT,
  `assetFk` int(11) NOT NULL,
  `value` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`pk`),
  KEY `fk_Name_Asset1_idx` (`assetFk`),
  CONSTRAINT `fk_Name_Asset1` FOREIGN KEY (`assetFk`) REFERENCES `asset` (`pk`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `name`
--

LOCK TABLES `name` WRITE;
/*!40000 ALTER TABLE `name` DISABLE KEYS */;
INSERT INTO `name` VALUES (3,3,'A'),(4,4,'Chair');
/*!40000 ALTER TABLE `name` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `owner`
--

DROP TABLE IF EXISTS `owner`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `owner` (
  `pk` int(11) NOT NULL AUTO_INCREMENT,
  `assetFk` int(11) NOT NULL,
  `value` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`pk`),
  KEY `fk_Owner_Asset_idx` (`assetFk`),
  CONSTRAINT `fk_Owner_Asset` FOREIGN KEY (`assetFk`) REFERENCES `asset` (`pk`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `owner`
--

LOCK TABLES `owner` WRITE;
/*!40000 ALTER TABLE `owner` DISABLE KEYS */;
INSERT INTO `owner` VALUES (3,3,'A'),(4,4,'Juan Cruz');
/*!40000 ALTER TABLE `owner` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rating`
--

DROP TABLE IF EXISTS `rating`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rating` (
  `value` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`value`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rating`
--

LOCK TABLES `rating` WRITE;
/*!40000 ALTER TABLE `rating` DISABLE KEYS */;
INSERT INTO `rating` VALUES (1,'High'),(3,'Low'),(2,'Mid');
/*!40000 ALTER TABLE `rating` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `retentionperiod`
--

DROP TABLE IF EXISTS `retentionperiod`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `retentionperiod` (
  `pk` int(11) NOT NULL AUTO_INCREMENT,
  `assetFk` int(11) NOT NULL,
  `value` date NOT NULL,
  PRIMARY KEY (`pk`),
  KEY `fk_RetentionPeriod_Asset1_idx` (`assetFk`),
  CONSTRAINT `fk_RetentionPeriod_Asset1` FOREIGN KEY (`assetFk`) REFERENCES `asset` (`pk`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `retentionperiod`
--

LOCK TABLES `retentionperiod` WRITE;
/*!40000 ALTER TABLE `retentionperiod` DISABLE KEYS */;
INSERT INTO `retentionperiod` VALUES (3,3,'2011-01-03'),(4,4,'2013-01-06');
/*!40000 ALTER TABLE `retentionperiod` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `storage`
--

DROP TABLE IF EXISTS `storage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `storage` (
  `pk` int(11) NOT NULL AUTO_INCREMENT,
  `value` varchar(45) NOT NULL,
  `assetFk` int(11) NOT NULL,
  PRIMARY KEY (`pk`),
  KEY `fk_Location_Asset1_idx` (`assetFk`),
  CONSTRAINT `fk_Location_Asset1` FOREIGN KEY (`assetFk`) REFERENCES `asset` (`pk`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `storage`
--

LOCK TABLES `storage` WRITE;
/*!40000 ALTER TABLE `storage` DISABLE KEYS */;
INSERT INTO `storage` VALUES (1,'A',3),(2,'Classroom',4);
/*!40000 ALTER TABLE `storage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `type`
--

DROP TABLE IF EXISTS `type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `type` (
  `pk` int(11) NOT NULL AUTO_INCREMENT,
  `value` varchar(45) NOT NULL,
  `assetFk` int(11) NOT NULL,
  PRIMARY KEY (`pk`),
  KEY `fk_table1_Asset1_idx` (`assetFk`),
  KEY `fk_table1_TypeList1_idx` (`value`),
  CONSTRAINT `fk_table1_Asset1` FOREIGN KEY (`assetFk`) REFERENCES `asset` (`pk`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_table1_TypeList1` FOREIGN KEY (`value`) REFERENCES `typelist` (`value`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `type`
--

LOCK TABLES `type` WRITE;
/*!40000 ALTER TABLE `type` DISABLE KEYS */;
INSERT INTO `type` VALUES (3,'Electronic',3),(4,'Physical',4);
/*!40000 ALTER TABLE `type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `typelist`
--

DROP TABLE IF EXISTS `typelist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `typelist` (
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`value`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `typelist`
--

LOCK TABLES `typelist` WRITE;
/*!40000 ALTER TABLE `typelist` DISABLE KEYS */;
INSERT INTO `typelist` VALUES ('Electronic'),('Paper'),('Physical');
/*!40000 ALTER TABLE `typelist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `pk` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(256) NOT NULL,
  `type` varchar(45) NOT NULL,
  PRIMARY KEY (`pk`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  KEY `fk_User_userTypeList1_idx` (`type`),
  CONSTRAINT `fk_User_userTypeList1` FOREIGN KEY (`type`) REFERENCES `usertypelist` (`type`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'admin','1234','Admin'),(2,'guest','1234','Guest');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usertypelist`
--

DROP TABLE IF EXISTS `usertypelist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usertypelist` (
  `type` varchar(45) NOT NULL,
  PRIMARY KEY (`type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usertypelist`
--

LOCK TABLES `usertypelist` WRITE;
/*!40000 ALTER TABLE `usertypelist` DISABLE KEYS */;
INSERT INTO `usertypelist` VALUES ('Admin'),('Guest');
/*!40000 ALTER TABLE `usertypelist` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-07-02  7:58:22
