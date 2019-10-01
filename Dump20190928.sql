-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: loandb
-- ------------------------------------------------------
-- Server version	8.0.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tcomputer`
--

DROP TABLE IF EXISTS `tcomputer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tcomputer` (
  `idtcomputer` int(11) NOT NULL AUTO_INCREMENT,
  `operational_system` varchar(45) NOT NULL,
  `cores` int(11) NOT NULL,
  `has_accessories` bit(1) NOT NULL,
  `idproduct` int(11) DEFAULT NULL,
  PRIMARY KEY (`idtcomputer`),
  KEY `FK_ProductId` (`idproduct`),
  CONSTRAINT `FK_ProductId` FOREIGN KEY (`idproduct`) REFERENCES `tproduct` (`idtproduct`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tcomputer`
--

LOCK TABLES `tcomputer` WRITE;
/*!40000 ALTER TABLE `tcomputer` DISABLE KEYS */;
INSERT INTO `tcomputer` VALUES (1,'windows 10',8,_binary '',NULL),(2,'windows 10',16,_binary '',1),(3,'Linux',4,_binary '\0',1),(4,'OSTESTE',45,_binary '\0',11),(5,'TESTEOS',4,_binary '\0',13);
/*!40000 ALTER TABLE `tcomputer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tcustomer`
--

DROP TABLE IF EXISTS `tcustomer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tcustomer` (
  `idtcustomer` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(250) NOT NULL,
  `lastname` varchar(100) NOT NULL,
  `email` varchar(200) NOT NULL,
  `birthday` varchar(45) DEFAULT NULL,
  `CPF` varchar(45) NOT NULL,
  `street` varchar(45) DEFAULT NULL,
  `number` int(11) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idtcustomer`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tcustomer`
--

LOCK TABLES `tcustomer` WRITE;
/*!40000 ALTER TABLE `tcustomer` DISABLE KEYS */;
INSERT INTO `tcustomer` VALUES (1,'Bianca','Gotaski','biancagotaski@gmail.com','08/02/1995','161.597.777-50','Rua Ana Lima',951,'São João de Meriti','Rio de Janeiro'),(2,'Paola','Oliveira','paola@oliveira.com','12/12/1987','555.444.777-90','Rua São José',60,'Rio de Janeiro','Rio de Janeiro'),(3,'Test','test12','tes@te.com','31/02/2017','121.345.675-80','Rua Teste',12,'Test','Test');
/*!40000 ALTER TABLE `tcustomer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tloan`
--

DROP TABLE IF EXISTS `tloan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tloan` (
  `idtloan` int(11) NOT NULL AUTO_INCREMENT,
  `startDate` varchar(45) NOT NULL,
  `endDate` varchar(45) NOT NULL,
  `idcustomer` int(11) DEFAULT NULL,
  PRIMARY KEY (`idtloan`),
  KEY `idcustomer` (`idcustomer`),
  CONSTRAINT `idcustomer` FOREIGN KEY (`idcustomer`) REFERENCES `tcustomer` (`idtcustomer`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tloan`
--

LOCK TABLES `tloan` WRITE;
/*!40000 ALTER TABLE `tloan` DISABLE KEYS */;
/*!40000 ALTER TABLE `tloan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tloanproduct`
--

DROP TABLE IF EXISTS `tloanproduct`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tloanproduct` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idloan` int(11) NOT NULL,
  `idproduct` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_ProductLoanId` (`idproduct`),
  KEY `FK_LoanProductId` (`idloan`),
  CONSTRAINT `FK_LoanProductId` FOREIGN KEY (`idloan`) REFERENCES `tloan` (`idtloan`),
  CONSTRAINT `FK_ProductLoanId` FOREIGN KEY (`idproduct`) REFERENCES `tproduct` (`idtproduct`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tloanproduct`
--

LOCK TABLES `tloanproduct` WRITE;
/*!40000 ALTER TABLE `tloanproduct` DISABLE KEYS */;
/*!40000 ALTER TABLE `tloanproduct` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tprinter`
--

DROP TABLE IF EXISTS `tprinter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tprinter` (
  `idtprinter` int(11) NOT NULL AUTO_INCREMENT,
  `is_laser` bit(1) NOT NULL,
  `max_leaf` int(11) NOT NULL,
  `has_wifi` bit(1) NOT NULL,
  `idproduct` int(11) DEFAULT NULL,
  PRIMARY KEY (`idtprinter`),
  KEY `FK_IdProduct` (`idproduct`),
  CONSTRAINT `FK_IdProduct` FOREIGN KEY (`idproduct`) REFERENCES `tproduct` (`idtproduct`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tprinter`
--

LOCK TABLES `tprinter` WRITE;
/*!40000 ALTER TABLE `tprinter` DISABLE KEYS */;
INSERT INTO `tprinter` VALUES (1,_binary '',250,_binary '',NULL),(4,_binary '',100,_binary '',2),(5,_binary '\0',300,_binary '\0',10),(6,_binary '\0',380,_binary '\0',12);
/*!40000 ALTER TABLE `tprinter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tproduct`
--

DROP TABLE IF EXISTS `tproduct`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tproduct` (
  `idtproduct` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `serial_number` int(11) NOT NULL,
  `brand` varchar(100) NOT NULL,
  `value` int(11) DEFAULT NULL,
  `idloan` int(11) DEFAULT NULL,
  PRIMARY KEY (`idtproduct`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tproduct`
--

LOCK TABLES `tproduct` WRITE;
/*!40000 ALTER TABLE `tproduct` DISABLE KEYS */;
INSERT INTO `tproduct` VALUES (1,'SAMSUNG DATA SERIES PROFESSIONAL',22051108,'SAMSUNG',5200,NULL),(2,'HP ORIGINALS MEGATRON',22054579,'HP',1240,NULL),(3,'XIAOMI LTDA',11798045,'XIAOMI',750,NULL),(4,'Asus Professional Gamebooks',21453305,'Asus',5600,NULL),(5,'UAHUS',65652632,'jasja',454,NULL),(6,'uashuahs',5454510,'asujahs',5444,NULL),(7,'PRODUTOTESTE',65656566,'TESTMARCA',54554,NULL),(8,'testssssssssss',1920192,'ajsasjij',9283928,NULL),(9,'IIIIIHXABIM',4545454,'XABIM',5454554,NULL),(10,'IMPRESSORA 2000',545451515,'IMPXX',5400,NULL),(11,'PRODUTOTESTE',656098780,'TESTE',5454545,NULL),(12,'IMPRESSORATESTE',454505408,'TESTE',54545,NULL),(13,'COMPUTADOR TESTE',65656097,'PCTESTE',2544,NULL);
/*!40000 ALTER TABLE `tproduct` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tprojector`
--

DROP TABLE IF EXISTS `tprojector`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tprojector` (
  `idtprojector` int(11) NOT NULL AUTO_INCREMENT,
  `resolution` varchar(45) NOT NULL,
  `has_LCD` bit(1) NOT NULL,
  `has_laser` bit(1) NOT NULL,
  `idproduct` int(11) DEFAULT NULL,
  PRIMARY KEY (`idtprojector`),
  KEY `idproduct` (`idproduct`),
  CONSTRAINT `idproduct` FOREIGN KEY (`idproduct`) REFERENCES `tproduct` (`idtproduct`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tprojector`
--

LOCK TABLES `tprojector` WRITE;
/*!40000 ALTER TABLE `tprojector` DISABLE KEYS */;
INSERT INTO `tprojector` VALUES (1,'1080',_binary '\0',_binary '\0',NULL),(2,'3600',_binary '',_binary '\0',3),(3,'4800',_binary '\0',_binary '\0',4),(4,'6565',_binary '\0',_binary '\0',5),(5,'656',_binary '\0',_binary '\0',6),(6,'5454',_binary '\0',_binary '\0',7),(7,'01219',_binary '\0',_binary '\0',8),(8,'45454',_binary '\0',_binary '\0',9);
/*!40000 ALTER TABLE `tprojector` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tuser`
--

DROP TABLE IF EXISTS `tuser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tuser` (
  `idtuser` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `email` varchar(200) NOT NULL,
  `password` varchar(45) NOT NULL,
  `admin` bit(1) NOT NULL,
  PRIMARY KEY (`idtuser`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tuser`
--

LOCK TABLES `tuser` WRITE;
/*!40000 ALTER TABLE `tuser` DISABLE KEYS */;
INSERT INTO `tuser` VALUES (9,'Admin','admin@gmail.com','ads',_binary ''),(10,'Admin2','bianca-admin@gmail.com','12345',_binary ''),(11,'Elisabete','elisa@bete.com','1098',_binary '\0'),(13,'Gotaski','gotaski@gmail.com','gotaski',_binary '\0'),(14,'Admin3','admin3@gmail.com','admin3',_binary ''),(15,'Admin','admin@admin.com','admin',_binary '');
/*!40000 ALTER TABLE `tuser` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-10-01 17:10:17
