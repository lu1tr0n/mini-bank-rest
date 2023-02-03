CREATE DATABASE IF NOT EXISTS `bank` !40100 DEFAULT CHARACTER SET utf8mb4 ;
-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: bank
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.24-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `account`
--

USE bank;

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `id_account` bigint(20) NOT NULL,
  `account_number` varchar(255) NOT NULL,
  `account_state` bit(1) DEFAULT NULL,
  `account_type` varchar(255) DEFAULT NULL,
  `starting_balance` decimal(38,2) DEFAULT NULL,
  `id_customer` bigint(20) NOT NULL,
  PRIMARY KEY (`id_account`),
  UNIQUE KEY `UK_66gkcp94endmotfwb8r4ocxm9` (`account_number`),
  KEY `FKt3l7uoac73es7gsh4nd8ihcn2` (`id_customer`),
  CONSTRAINT `FKt3l7uoac73es7gsh4nd8ihcn2` FOREIGN KEY (`id_customer`) REFERENCES `customer` (`id_person`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,'478758',_binary '','Ahorro',115.00,1),(2,'225487',_binary '','Corriente',-500.00,2),(3,'495878',_binary '','Ahorro',-150.00,3),(4,'496825',_binary '','Ahorro',0.00,2),(52,'585545',_binary '','Corriente',1000.00,1);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `account_seq`
--

DROP TABLE IF EXISTS `account_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_seq`
--

LOCK TABLES `account_seq` WRITE;
/*!40000 ALTER TABLE `account_seq` DISABLE KEYS */;
INSERT INTO `account_seq` VALUES (151);
/*!40000 ALTER TABLE `account_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `id_customer` bigint(20) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `state` bit(1) DEFAULT NULL,
  `id_person` bigint(20) NOT NULL,
  PRIMARY KEY (`id_person`),
  CONSTRAINT `FKeu1h389po5xyx30dp359ss6pd` FOREIGN KEY (`id_person`) REFERENCES `person` (`id_person`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'1234',_binary '',1),(2,'5678',_binary '',2),(3,'1245',_binary '',3);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movements`
--

DROP TABLE IF EXISTS `movements`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movements` (
  `id_movement` bigint(20) NOT NULL,
  `balance` decimal(38,2) DEFAULT NULL,
  `movement_date` datetime DEFAULT NULL,
  `movement_description` varchar(255) DEFAULT NULL,
  `movement_type` varchar(255) DEFAULT NULL,
  `movement_value` decimal(38,2) DEFAULT NULL,
  `id_account` bigint(20) NOT NULL,
  PRIMARY KEY (`id_movement`),
  KEY `FKq94h417xhef41w54grra3gsr` (`id_account`),
  CONSTRAINT `FKq94h417xhef41w54grra3gsr` FOREIGN KEY (`id_account`) REFERENCES `account` (`id_account`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movements`
--

LOCK TABLES `movements` WRITE;
/*!40000 ALTER TABLE `movements` DISABLE KEYS */;
INSERT INTO `movements` VALUES (452,775.00,'2023-01-28 18:34:05','Movimiento debitando por $50','Debito',-50.00,1),(453,725.00,'2023-01-29 18:34:05','Movimiento debitando por $25','Debito',-25.00,1),(454,700.00,'2023-01-29 18:34:05','Movimiento debitando por $10','Debito',-10.00,1),(502,690.00,'2023-01-28 18:34:05','Retiro de $575','Debito',-575.00,1),(552,100.00,'2023-01-29 18:34:05','Deposito de $600','Credito',600.00,2),(602,0.00,'2023-01-29 18:34:05','Deposito de $150','Credito',150.00,3),(603,540.00,'2023-01-29 18:34:05','Retiro de $540','Debito',540.00,4);
/*!40000 ALTER TABLE `movements` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movements_seq`
--

DROP TABLE IF EXISTS `movements_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movements_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movements_seq`
--

LOCK TABLES `movements_seq` WRITE;
/*!40000 ALTER TABLE `movements_seq` DISABLE KEYS */;
INSERT INTO `movements_seq` VALUES (701);
/*!40000 ALTER TABLE `movements_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `person` (
  `id_person` bigint(20) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `document_id` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `names` varchar(255) DEFAULT NULL,
  `surnames` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_person`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES (1,'Otavalo sn y principal',31,'04521496-5','M','Jose','Lema','098254785'),(2,'Amazonas y NNUU',28,'00831586-0','F','Marianela','Montalvo','097548965'),(3,'13 junio y Equinoccial',39,'01448527-7','M','Juan','Osorio','098874587');
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person_seq`
--

DROP TABLE IF EXISTS `person_seq`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `person_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person_seq`
--

LOCK TABLES `person_seq` WRITE;
/*!40000 ALTER TABLE `person_seq` DISABLE KEYS */;
INSERT INTO `person_seq` VALUES (101);
/*!40000 ALTER TABLE `person_seq` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'bank'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-01-31  0:14:32
