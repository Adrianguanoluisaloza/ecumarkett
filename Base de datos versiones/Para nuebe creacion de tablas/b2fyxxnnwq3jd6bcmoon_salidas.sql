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
a38a16d0-767a-11eb-abe2-cecd029e558e:1-551617874';

--
-- Table structure for table `salidas`
--

DROP TABLE IF EXISTS `salidas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `salidas` (
  `idSalida` int NOT NULL AUTO_INCREMENT,
  `numSalida` varchar(10) COLLATE utf8mb4_general_ci NOT NULL,
  `idCliente` int NOT NULL,
  `fecha` date NOT NULL,
  `subtotal` decimal(10,2) NOT NULL,
  `igv` decimal(10,2) NOT NULL,
  `total` decimal(10,2) NOT NULL,
  `estado` varchar(8) COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'Pagada',
  PRIMARY KEY (`idSalida`),
  KEY `fk_cliente` (`idCliente`),
  CONSTRAINT `fk_cliente` FOREIGN KEY (`idCliente`) REFERENCES `clientes` (`idCliente`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salidas`
--

LOCK TABLES `salidas` WRITE;
/*!40000 ALTER TABLE `salidas` DISABLE KEYS */;
INSERT INTO `salidas` VALUES (1,'001',4,'2024-05-28',25.83,5.67,31.50,'Pagada'),(2,'002',4,'2024-05-28',36.90,8.10,45.00,'Pagada'),(3,'003',4,'2024-06-24',49.20,10.80,60.00,'Pagada'),(4,'004',1,'2025-04-29',615.00,135.00,750.00,'Anulada'),(5,'005',1,'2025-04-30',820.00,180.00,1000.00,'Pagada'),(6,'006',1,'2025-04-30',26.65,5.85,32.50,'Pagada'),(7,'007',1,'2025-04-03',5.33,1.17,6.50,'Pagada'),(8,'008',1,'2025-04-30',205.00,45.00,250.00,'Anulada'),(9,'009',1,'2025-04-09',5.33,1.17,6.50,'Anulada'),(10,'0010',1,'2025-04-30',106.60,23.40,130.00,'Anulada'),(11,'0011',1,'2025-04-08',226.32,49.68,276.00,'Aprobada'),(12,'0012',1,'2025-04-16',410.00,90.00,500.00,'Pagada'),(13,'0013',5,'2025-05-14',410.00,90.00,500.00,'Anulada'),(14,'0014',5,'2025-05-05',410.00,90.00,500.00,'Aprobada'),(15,'0014',5,'2025-05-05',463.30,101.70,565.00,'Anulada'),(16,'0016',5,'2025-05-04',41.00,9.00,50.00,'Anulada'),(17,'0017',5,'2025-05-04',41000.00,9000.00,50000.00,'Anulada'),(18,'0018',5,'2025-05-06',32800.00,7200.00,40000.00,'Anulada'),(19,'0019',5,'2025-05-06',20500.00,4500.00,25000.00,'Anulada'),(20,'0020',5,'2025-05-07',202950.00,44550.00,247500.00,'Anulada'),(21,'0021',5,'2025-05-06',410.00,90.00,500.00,'Anulada'),(22,'0022',5,'2025-05-07',656000.00,144000.00,800000.00,'Anulada'),(23,'0023',5,'2025-05-07',32.80,7.20,40.00,'Pagada'),(24,'0024',5,'2025-05-07',41000.00,9000.00,50000.00,'Anulada'),(25,'0025',5,'2025-05-07',9020.00,1980.00,11000.00,'Pagada'),(26,'0026',5,'2025-05-07',8429.60,1850.40,10280.00,'Anulada'),(27,'0027',5,'2025-05-08',8200.00,1800.00,10000.00,'Pagada'),(28,'0028',5,'2025-05-08',3280.00,720.00,4000.00,'Pagada'),(29,'0029',5,'2025-05-08',410.00,90.00,500.00,'Pagada'),(30,'0030',5,'2025-05-09',16400.00,3600.00,20000.00,'Pagada');
/*!40000 ALTER TABLE `salidas` ENABLE KEYS */;
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

-- Dump completed on 2025-05-26 12:29:34
