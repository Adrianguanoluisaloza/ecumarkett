-- MySQL dump 10.13  Distrib 8.0.41, for Win64 (x86_64)
--
-- Host: b2fyxxnnwq3jd6bcmoon-mysql.services.clever-cloud.com    Database: b2fyxxnnwq3jd6bcmoon
-- ------------------------------------------------------
-- Server version	8.0.22-13

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
SET @MYSQLDUMP_TEMP_LOG_BIN = @@SESSION.SQL_LOG_BIN;
SET @@SESSION.SQL_LOG_BIN= 0;

--
-- GTID state at the beginning of the backup 
--

SET @@GLOBAL.GTID_PURGED=/*!80000 '+'*/ 'a05a675a-1414-11e9-9c82-cecd01b08c7e:1-491550428,
a38a16d0-767a-11eb-abe2-cecd029e558e:1-551617830';

--
-- Table structure for table `entrada`
--

DROP TABLE IF EXISTS `entrada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `entrada` (
  `identrada` int NOT NULL AUTO_INCREMENT,
  `idproducto` int NOT NULL,
  `stock` int NOT NULL,
  `fecha` date NOT NULL,
  `idproveedor` int NOT NULL,
  `precioE` decimal(10,2) NOT NULL,
  `precioV` decimal(10,2) NOT NULL,
  `total` decimal(8,2) NOT NULL,
  PRIMARY KEY (`identrada`),
  KEY `fk_proveedor` (`idproveedor`),
  KEY `fk_producto` (`idproducto`),
  CONSTRAINT `fk_producto` FOREIGN KEY (`idproducto`) REFERENCES `productos` (`idproducto`),
  CONSTRAINT `fk_proveedor` FOREIGN KEY (`idproveedor`) REFERENCES `proveedor` (`idproveedor`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entrada`
--

LOCK TABLES `entrada` WRITE;
/*!40000 ALTER TABLE `entrada` DISABLE KEYS */;
INSERT INTO `entrada` VALUES (2,2,15,'2024-05-17',1,22.00,25.00,330.00),(3,1,50,'2024-05-17',3,8.00,10.00,400.00),(6,3,16,'2024-05-22',4,5.00,6.50,80.00),(8,7,500,'2025-04-19',6,40.00,500.00,20000.00),(9,3,8,'2024-05-30',4,5.00,6.50,40.00),(10,2,10,'2024-06-05',4,19.00,25.00,190.00),(11,7,6000,'2024-06-05',6,22.00,500.00,132000.00),(12,2,8,'2024-06-05',2,23.00,25.00,184.00),(13,2,10,'2024-06-06',4,22.00,25.00,220.00),(14,2,10,'2024-06-06',1,8.50,25.00,85.00),(15,2,6,'2024-06-07',4,5.00,25.00,30.00),(16,4,10,'2024-06-21',2,10.00,11.50,100.00),(17,4,10,'2024-06-24',4,9.00,10.50,90.00),(18,4,20,'2024-06-24',3,10.00,10.50,200.00),(19,4,5,'2024-06-24',2,10.50,11.00,52.50),(20,1,5,'2024-06-24',4,10.00,11.00,50.00),(21,5,15,'2024-06-24',4,13.00,14.00,195.00),(22,1,20,'2025-04-05',1,20.00,50.00,400.00),(23,1,10,'2025-04-23',6,50.00,50.00,500.00),(24,5,50,'2024-05-10',6,40.00,140.00,2000.00),(25,8,50,'2025-05-04',7,200.00,500.00,10000.00);
/*!40000 ALTER TABLE `entrada` ENABLE KEYS */;
UNLOCK TABLES;
SET @@SESSION.SQL_LOG_BIN = @MYSQLDUMP_TEMP_LOG_BIN;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-05-26 12:29:18
