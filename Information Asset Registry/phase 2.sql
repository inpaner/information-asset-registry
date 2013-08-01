CREATE DATABASE  IF NOT EXISTS `information asset registry` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `information asset registry`;
-- MySQL dump 10.13  Distrib 5.6.12, for Win64 (x86_64)
--
-- Host: localhost    Database: information asset registry
-- ------------------------------------------------------
-- Server version	5.6.12-log

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
  `pk` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(45) NOT NULL,
  PRIMARY KEY (`pk`),
  UNIQUE KEY `type_UNIQUE` (`type`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actionlist`
--

LOCK TABLES `actionlist` WRITE;
/*!40000 ALTER TABLE `actionlist` DISABLE KEYS */;
INSERT INTO `actionlist` VALUES (3,'Add'),(5,'Delete'),(4,'Edit'),(1,'Login'),(2,'Logout');
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
  `name` varchar(45) NOT NULL,
  `identifier` varchar(45) NOT NULL,
  `date acquired` date NOT NULL,
  `storage` varchar(45) NOT NULL,
  `type` int(11) NOT NULL,
  `financial` int(11) NOT NULL,
  `confidentiality` int(11) NOT NULL,
  `internal` int(11) NOT NULL,
  `availability` int(11) NOT NULL,
  `owner` int(11) NOT NULL,
  `custodian` int(11) NOT NULL,
  `retention period` int(11) NOT NULL,
  `classification` varchar(45) NOT NULL,
  PRIMARY KEY (`pk`),
  UNIQUE KEY `identifier_UNIQUE` (`identifier`),
  KEY `fk_Asset_Type1_idx` (`type`),
  KEY `fk_Asset_Rating1_idx` (`financial`),
  KEY `fk_Asset_Rating2_idx` (`confidentiality`),
  KEY `fk_Asset_Rating3_idx` (`internal`),
  KEY `fk_Asset_Rating4_idx` (`availability`),
  KEY `fk_Asset_User1_idx` (`owner`),
  KEY `fk_Asset_User2_idx` (`custodian`),
  KEY `fk_Asset_Retention Period1_idx` (`retention period`),
  KEY `fk_Asset_Classification1_idx` (`classification`),
  CONSTRAINT `fk_Asset_Type1` FOREIGN KEY (`type`) REFERENCES `type` (`pk`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Asset_Rating1` FOREIGN KEY (`financial`) REFERENCES `rating` (`pk`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Asset_Rating2` FOREIGN KEY (`confidentiality`) REFERENCES `rating` (`pk`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Asset_Rating3` FOREIGN KEY (`internal`) REFERENCES `rating` (`pk`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Asset_Rating4` FOREIGN KEY (`availability`) REFERENCES `rating` (`pk`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Asset_User1` FOREIGN KEY (`owner`) REFERENCES `user` (`pk`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Asset_User2` FOREIGN KEY (`custodian`) REFERENCES `user` (`pk`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Asset_Retention Period1` FOREIGN KEY (`retention period`) REFERENCES `retention period` (`pk`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Asset_Classification1` FOREIGN KEY (`classification`) REFERENCES `classification` (`pk`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `asset`
--

LOCK TABLES `asset` WRITE;
/*!40000 ALTER TABLE `asset` DISABLE KEYS */;
INSERT INTO `asset` VALUES (1,'Chair','MK-2332','2013-03-01','Room 3',3,1,1,1,1,1,2,1,'1');
/*!40000 ALTER TABLE `asset` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `classification`
--

DROP TABLE IF EXISTS `classification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `classification` (
  `pk` varchar(45) NOT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`pk`),
  UNIQUE KEY `pk_UNIQUE` (`value`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `classification`
--

LOCK TABLES `classification` WRITE;
/*!40000 ALTER TABLE `classification` DISABLE KEYS */;
INSERT INTO `classification` VALUES ('2','Confidential'),('3','Internal'),('4','Public'),('1','Sensitive');
/*!40000 ALTER TABLE `classification` ENABLE KEYS */;
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
  `core` varchar(45) DEFAULT NULL,
  `coreFk` int(11) DEFAULT NULL,
  `attribute` varchar(45) DEFAULT NULL,
  `previousValue` varchar(45) DEFAULT NULL,
  `value` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`pk`),
  KEY `fk_Logs_User1_idx` (`userFk`),
  KEY `fk_Logs_Action1_idx` (`action`),
  CONSTRAINT `fk_Logs_User1` FOREIGN KEY (`userFk`) REFERENCES `user` (`pk`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Logs_Action1` FOREIGN KEY (`action`) REFERENCES `actionlist` (`type`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `log`
--

LOCK TABLES `log` WRITE;
/*!40000 ALTER TABLE `log` DISABLE KEYS */;
/*!40000 ALTER TABLE `log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rating`
--

DROP TABLE IF EXISTS `rating`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rating` (
  `pk` int(11) NOT NULL,
  `value` varchar(45) NOT NULL,
  PRIMARY KEY (`pk`),
  UNIQUE KEY `name_UNIQUE` (`value`)
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
-- Table structure for table `retention period`
--

DROP TABLE IF EXISTS `retention period`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `retention period` (
  `pk` int(11) NOT NULL AUTO_INCREMENT,
  `days` int(11) NOT NULL,
  PRIMARY KEY (`pk`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `retention period`
--

LOCK TABLES `retention period` WRITE;
/*!40000 ALTER TABLE `retention period` DISABLE KEYS */;
INSERT INTO `retention period` VALUES (1,45);
/*!40000 ALTER TABLE `retention period` ENABLE KEYS */;
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
  PRIMARY KEY (`pk`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `type`
--

LOCK TABLES `type` WRITE;
/*!40000 ALTER TABLE `type` DISABLE KEYS */;
INSERT INTO `type` VALUES (1,'Paper'),(2,'Electronic'),(3,'Physical');
/*!40000 ALTER TABLE `type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `pk` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(256) NOT NULL,
  `type` int(11) NOT NULL,
  PRIMARY KEY (`pk`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  UNIQUE KEY `name_UNIQUE` (`name`),
  KEY `fk_User_UserType1_idx` (`type`),
  CONSTRAINT `fk_User_UserType1` FOREIGN KEY (`type`) REFERENCES `usertype` (`pk`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'John Smith','admin','1234',1),(2,'Jane Smith','guest','1234',2);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usertype`
--

DROP TABLE IF EXISTS `usertype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usertype` (
  `pk` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(45) NOT NULL,
  PRIMARY KEY (`pk`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usertype`
--

LOCK TABLES `usertype` WRITE;
/*!40000 ALTER TABLE `usertype` DISABLE KEYS */;
INSERT INTO `usertype` VALUES (1,'Admin'),(2,'Guest');
/*!40000 ALTER TABLE `usertype` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-08-01 22:16:58
