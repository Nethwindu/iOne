-- MariaDB dump 10.19  Distrib 10.4.32-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: ione
-- ------------------------------------------------------
-- Server version	10.4.32-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `checkout_history`
--

DROP TABLE IF EXISTS `checkout_history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `checkout_history` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `amount_paid` double NOT NULL,
  `balance` double NOT NULL,
  `checkout_time` datetime(6) DEFAULT NULL,
  `grand_total` double NOT NULL,
  `customer_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKg1s7v8eivgon17no72g2w2383` (`customer_id`),
  CONSTRAINT `FKg1s7v8eivgon17no72g2w2383` FOREIGN KEY (`customer_id`) REFERENCES `customers` (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `checkout_history`
--

LOCK TABLES `checkout_history` WRITE;
/*!40000 ALTER TABLE `checkout_history` DISABLE KEYS */;
INSERT INTO `checkout_history` VALUES (7,3000000,285000,'2025-05-02 23:35:36.000000',2715000,21),(8,4000000,300000,'2025-05-02 23:51:31.000000',3700000,22),(9,9000000,1530000,'2025-05-03 00:57:51.000000',7470000,16),(10,1000000,55000,'2025-05-03 14:10:22.000000',945000,19),(11,800000,80000,'2025-05-03 16:00:36.000000',720000,19),(12,400000,100000,'2025-06-17 21:22:20.000000',300000,17);
/*!40000 ALTER TABLE `checkout_history` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customers` (
  `customer_id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `company` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `register_date` date DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customers`
--

LOCK TABLES `customers` WRITE;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
INSERT INTO `customers` VALUES (15,'No. 12, Galle Road, Colombo 03, Sri Lanka','iMobile LK','contact@imobile.lk','Nuwan','Perera','+94 712345678','2024-11-20','ACTIVE'),(16,'45 Kandy Road, Kadawatha, Sri Lanka','SmartZone','info@smartzone.lk','Shehan','Fernando','+94 772334455','2025-01-10','ACTIVE'),(17,'221 Main Street, Jaffna, Sri Lanka','iWorld','sales@iworld.lk','Sanjana','Rajapaksha','+94 762112233','2025-03-15','ACTIVE'),(18,'No. 33, Station Road, Matara, Sri Lanka','Mobile Mart','hello@mobilemart.lk','Amal','Jayasinghe','+94 718765432',NULL,'ACTIVE'),(19,'77 Gampaha Road, Negombo, Sri Lanka','iZone Lanka','support@izonelanka.lk','Dinithi','Silva','+94 752346789','2025-04-27','INACTIVE'),(20,'20 Lake Drive, Kurunegala, Sri Lanka','Mega Phones','sales@megaphones.lk','Tharindu','Weerasinghe','+94 765432189','2023-09-12','INACTIVE'),(21,'99 Trinco Road, Batticaloa, Sri Lanka','Mobile King','king@mobileking.lk','Amal','Gunawardena','+94 771112345',NULL,'ACTIVE'),(22,'15 Nuwara Eliya Road, Badulla, Sri Lanka','Phone House','contact@phonehouse.lk','Ishara','Dissanayake','+94 784563219',NULL,'ACTIVE');
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `items`
--

DROP TABLE IF EXISTS `items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `items` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `model` varchar(255) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `storage` varchar(255) DEFAULT NULL,
  `price` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `items`
--

LOCK TABLES `items` WRITE;
/*!40000 ALTER TABLE `items` DISABLE KEYS */;
INSERT INTO `items` VALUES (40,'iPhone 12','White','128GB',100000),(41,'iPhone 12','Gold','256GB',115000),(42,'iPhone 12 Pro','Black','128GB',120000),(43,'iPhone 12 Pro','Red','256GB',135000),(44,'iPhone 12 Pro Max','Green','128GB',140000),(45,'iPhone 12 Pro Max','White','256GB',155000),(47,'iPhone 13','Black','256GB',135000),(48,'iPhone 13 Pro','Red','128GB',145000),(49,'iPhone 13 Pro','Green','256GB',160000),(50,'iPhone 13 Pro Max','White','128GB',165000),(51,'iPhone 13 Pro Max','Gold','256GB',180000),(52,'iPhone 14','Black','128GB',140000),(53,'iPhone 14','Red','256GB',155000),(54,'iPhone 14 Pro','Green','128GB',165000),(55,'iPhone 14 Pro','White','256GB',180000),(56,'iPhone 14 Pro Max','Gold','128GB',185000),(57,'iPhone 14 Pro Max','Black','256GB',200000),(58,'iPhone 15','Red','128GB',160000),(59,'iPhone 15','Green','256GB',175000),(60,'iPhone 15 Pro','White','128GB',190000),(61,'iPhone 15 Pro','Gold','256GB',205000),(62,'iPhone 15 Pro Max','Black','128GB',210000),(63,'iPhone 15 Pro Max','Red','256GB',225000),(64,'iPhone 16','Green','128GB',180000),(65,'iPhone 16','White','256GB',195000),(66,'iPhone 16 Pro','Gold','128GB',210000),(67,'iPhone 16 Pro','Black','256GB',225000),(68,'iPhone 16 Pro Max','Red','128GB',230000),(69,'iPhone 16 Pro Max','Green','256GB',250000);
/*!40000 ALTER TABLE `items` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-06-17 22:25:22
