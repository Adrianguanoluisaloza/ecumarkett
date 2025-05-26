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
a38a16d0-767a-11eb-abe2-cecd029e558e:1-551617909';

--
-- Table structure for table `detallesalida`
--

DROP TABLE IF EXISTS `detallesalida`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detallesalida` (
  `id` int NOT NULL AUTO_INCREMENT,
  `idSalida` int NOT NULL,
  `idproducto` int NOT NULL,
  `cantidad` int NOT NULL,
  `importe` decimal(10,2) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_salida` (`idSalida`),
  KEY `fk_productos` (`idproducto`),
  CONSTRAINT `fk_productos` FOREIGN KEY (`idproducto`) REFERENCES `productos` (`idproducto`),
  CONSTRAINT `fk_salida` FOREIGN KEY (`idSalida`) REFERENCES `salidas` (`idSalida`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detallesalida`
--

LOCK TABLES `detallesalida` WRITE;
/*!40000 ALTER TABLE `detallesalida` DISABLE KEYS */;
INSERT INTO `detallesalida` VALUES (1,2,1,2,20.00),(2,2,2,1,25.00),(3,3,4,5,27.50),(4,3,3,5,32.50),(5,4,1,10,500.00),(6,4,2,10,250.00),(7,5,1,20,1000.00),(8,6,3,5,32.50),(9,7,3,1,6.50),(10,8,2,10,250.00),(11,9,3,1,6.50),(12,10,3,20,130.00),(13,11,3,4,26.00),(14,11,2,10,250.00),(15,12,1,10,500.00),(16,13,1,10,500.00),(17,14,1,10,500.00),(18,14,1,10,500.00),(19,14,3,10,65.00),(20,16,8,100,50.00),(21,17,8,100,50000.00),(22,18,8,20,40000.00),(23,19,9,50,25000.00),(24,20,9,495,247500.00),(25,21,9,1,500.00),(26,22,8,400,800000.00),(27,23,7,2,40.00),(28,24,9,100,50000.00),(29,25,9,22,11000.00),(30,26,9,20,10000.00),(31,26,5,2,280.00),(32,27,9,20,10000.00),(33,28,8,2,4000.00),(34,29,9,1,500.00),(35,30,8,10,20000.00);
/*!40000 ALTER TABLE `detallesalida` ENABLE KEYS */;
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

-- Dump completed on 2025-05-26 12:29:49
