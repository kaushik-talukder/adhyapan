-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: adhyapan
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `center`
--

DROP TABLE IF EXISTS `center`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `center` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `address` varchar(45) DEFAULT NULL,
  `spoc` varchar(45) NOT NULL,
  `contact` varchar(15) NOT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `NAME_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `center`
--

LOCK TABLES `center` WRITE;
/*!40000 ALTER TABLE `center` DISABLE KEYS */;
INSERT INTO `center` VALUES (1,'Adhyapan - Garia','Garia','Sayak Mohinta','9830868330','2018-12-06 00:00:00','2018-12-06 00:00:00');
/*!40000 ALTER TABLE `center` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`adhyapan`@`%`*/ /*!50003 TRIGGER `center_BEFORE_UPDATE` BEFORE UPDATE ON `center` FOR EACH ROW BEGIN
	set new.updated_at = now();
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `class`
--

DROP TABLE IF EXISTS `class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `class` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `class_code` varchar(100) NOT NULL,
  `subject_id` int(11) NOT NULL,
  `teacher_id` int(11) NOT NULL,
  `center_id` int(11) NOT NULL,
  `standard_id` int(11) NOT NULL,
  `fee` double NOT NULL,
  `start_date` date NOT NULL,
  `end_date` date NOT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class`
--

LOCK TABLES `class` WRITE;
/*!40000 ALTER TABLE `class` DISABLE KEYS */;
INSERT INTO `class` VALUES (1,'MATH-SKG-XII',3,7,1,4,500,'2018-12-11','2019-12-11','2018-12-11 15:24:38','2018-12-13 11:51:01'),(2,'PHY-CKD-XI',1,9,1,3,600,'2018-12-13','2019-12-13','2018-12-13 11:53:36','2018-12-13 11:53:36');
/*!40000 ALTER TABLE `class` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`adhyapan`@`%`*/ /*!50003 TRIGGER `class_BEFORE_UPDATE` BEFORE UPDATE ON `class` FOR EACH ROW BEGIN
    set new.updated_at = now();
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `fee_category`
--

DROP TABLE IF EXISTS `fee_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `fee_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category` varchar(45) NOT NULL,
  `description` varchar(45) DEFAULT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fee_category`
--

LOCK TABLES `fee_category` WRITE;
/*!40000 ALTER TABLE `fee_category` DISABLE KEYS */;
INSERT INTO `fee_category` VALUES (1,'Registration Fee','Registration Fee','2018-12-13 14:25:04','2018-12-13 14:25:04'),(2,'Tution Fee','Tution Fee','2018-12-13 14:25:28','2018-12-13 14:25:28'),(3,'Exam Fee','Exam Fee','2018-12-13 14:25:51','2018-12-13 14:25:51');
/*!40000 ALTER TABLE `fee_category` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`adhyapan`@`%`*/ /*!50003 TRIGGER `payment_category_BEFORE_UPDATE` BEFORE UPDATE ON `fee_category` FOR EACH ROW BEGIN
	set new.updated_at = now();
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `fee_txn`
--

DROP TABLE IF EXISTS `fee_txn`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `fee_txn` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fee_category_id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  `class_id` int(11) DEFAULT NULL,
  `exam_id` int(11) DEFAULT NULL,
  `month_code` varchar(45) NOT NULL,
  `fee_amount` double NOT NULL,
  `remarks` varchar(256) NOT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_txn_fee_category_idx` (`fee_category_id`),
  KEY `fk_txn_student_id_idx` (`student_id`),
  KEY `fk_txn_class_id_idx` (`class_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fee_txn`
--

LOCK TABLES `fee_txn` WRITE;
/*!40000 ALTER TABLE `fee_txn` DISABLE KEYS */;
/*!40000 ALTER TABLE `fee_txn` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`adhyapan`@`%`*/ /*!50003 TRIGGER `fee_txn_BEFORE_UPDATE` BEFORE UPDATE ON `fee_txn` FOR EACH ROW BEGIN
	set new.updated_at = now();
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `school`
--

DROP TABLE IF EXISTS `school`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `school` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `school_name` varchar(45) NOT NULL,
  `school_code` varchar(45) NOT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `school`
--

LOCK TABLES `school` WRITE;
/*!40000 ALTER TABLE `school` DISABLE KEYS */;
INSERT INTO `school` VALUES (1,'Jodhpur Park Boys\' School','JPBS','2018-12-06 00:00:00','2018-12-06 00:00:00'),(2,'South Point','SP','2018-12-06 00:00:00','2018-12-06 00:00:00'),(3,'Kamala Girls','KG','2018-12-06 20:59:37','2018-12-06 20:59:37'),(4,'Patha Bhaban','PB','2018-12-06 21:09:03','2018-12-06 21:09:03'),(5,'Others','OTH','2018-12-07 12:52:42','2018-12-07 12:52:42'),(6,'Baghajatin Boys','','2018-12-14 10:55:19','2018-12-14 10:55:19'),(7,'Jodhpur Girls High School','JGHS','2018-12-14 11:46:02','2018-12-14 11:46:02'),(8,'Khanpur Boys','KB','2018-12-14 13:07:37','2018-12-14 13:07:37');
/*!40000 ALTER TABLE `school` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`adhyapan`@`%`*/ /*!50003 TRIGGER `school_BEFORE_UPDATE` BEFORE UPDATE ON `school` FOR EACH ROW BEGIN
    set new.updated_at = now();
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `standard`
--

DROP TABLE IF EXISTS `standard`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `standard` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `standard` varchar(45) NOT NULL,
  `description` varchar(45) DEFAULT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `standard`
--

LOCK TABLES `standard` WRITE;
/*!40000 ALTER TABLE `standard` DISABLE KEYS */;
INSERT INTO `standard` VALUES (1,'IX','Class 9','2018-12-06 00:00:00','2018-12-06 00:00:00'),(2,'X','Class 10','2018-12-06 00:00:00','2018-12-06 00:00:00'),(3,'XI','Class 11','2018-12-06 00:00:00','2018-12-06 00:00:00'),(4,'XII','Class 12','2018-12-06 00:00:00','2018-12-10 12:04:44');
/*!40000 ALTER TABLE `standard` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`adhyapan`@`%`*/ /*!50003 TRIGGER `standard_BEFORE_UPDATE` BEFORE UPDATE ON `standard` FOR EACH ROW BEGIN
	set new.updated_at = now();
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `student_code` varchar(50) NOT NULL,
  `first_name` varchar(100) NOT NULL,
  `last_name` varchar(100) NOT NULL,
  `school_id` int(11) NOT NULL,
  `standard_id` int(11) NOT NULL,
  `student_contact` varchar(15) DEFAULT NULL,
  `guardian_name` varchar(200) NOT NULL,
  `guardian_contact` varchar(15) NOT NULL,
  `address` varchar(100) DEFAULT NULL,
  `gender` varchar(1) NOT NULL,
  `start_date` date NOT NULL,
  `end_date` date NOT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `student_code_UNIQUE` (`student_code`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,'ANIKT','Anik','Talukder',1,3,'9632587410','Sudhir Talukder','9876643210','Garia','M','2018-12-11','2018-12-11','2018-12-07 14:27:43','2018-12-11 11:43:52'),(2,'RAHULDAS','Rahul','Das',4,3,'9632587410','SK Das','9856321470','Rabindranagar','M','2018-12-11','2018-12-11','2018-12-07 14:58:18','2018-12-11 11:43:52'),(3,'JOYDAS','Joyantee','Das',3,3,'9632587410','A C Das','9874563210','Garia','F','2018-12-11','2018-12-11','2018-12-07 15:00:35','2018-12-11 11:43:52'),(4,'SAYALMOINTA','Sayak','Mohinta',2,3,'9876543212','S Mohinta','9876543211','Garia','M','2018-12-11','2018-12-11','2018-12-09 14:18:04','2018-12-11 11:43:52'),(5,'SHUVOJIT','Shubojit','Das',4,3,'9632587410','S das','9876543210','Garia','M','2018-12-11','2018-12-11','2018-12-10 12:16:46','2018-12-11 11:43:52'),(6,'KAUSHIkTALUK','Kaushik','Talukder',1,3,'2589631478','S Talukder','3698521470','Ramgarh','M','2018-12-09','3000-01-31','2018-12-10 16:21:38','2018-12-10 16:21:38'),(7,'ARUPM','Arup','Majumdar',2,4,'9632587410','N Majumdar','3698521470','Garia','M','2018-12-10','3000-12-31','2018-12-10 16:29:21','2018-12-10 16:29:21'),(10,'SOUMIKCHAK','Soumik','Chakraborty',4,1,'9632587410','S Chak','9874563210','Bali','M','2018-10-01','3000-12-31','2018-12-11 14:49:37','2018-12-11 14:49:37');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`adhyapan`@`%`*/ /*!50003 TRIGGER `student_BEFORE_UPDATE` BEFORE UPDATE ON `student` FOR EACH ROW BEGIN
    set new.updated_at = now();
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `student_class`
--

DROP TABLE IF EXISTS `student_class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `student_class` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `class_id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  `start_date` date NOT NULL,
  `end_date` date NOT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_class`
--

LOCK TABLES `student_class` WRITE;
/*!40000 ALTER TABLE `student_class` DISABLE KEYS */;
INSERT INTO `student_class` VALUES (5,1,7,'2018-12-12','2018-12-12','2018-12-12 16:06:11','2018-12-12 16:10:51'),(6,1,7,'2018-12-12','2018-12-12','2018-12-12 16:06:32','2018-12-12 16:10:51'),(7,1,7,'2018-12-13','3000-12-31','2018-12-13 11:46:46','2018-12-13 11:46:46'),(8,2,3,'2018-12-13','3000-12-31','2018-12-13 11:54:04','2018-12-13 11:54:04'),(9,2,4,'2018-12-13','3000-12-31','2018-12-13 11:54:04','2018-12-13 11:54:04'),(10,2,5,'2018-12-13','2018-12-13','2018-12-13 11:54:04','2018-12-13 23:07:24');
/*!40000 ALTER TABLE `student_class` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`adhyapan`@`%`*/ /*!50003 TRIGGER `student_class_BEFORE_UPDATE` BEFORE UPDATE ON `student_class` FOR EACH ROW BEGIN
	set new.updated_at = now();
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `subject`
--

DROP TABLE IF EXISTS `subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `subject` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `subject_name` varchar(45) NOT NULL,
  `subject_code` varchar(45) NOT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject`
--

LOCK TABLES `subject` WRITE;
/*!40000 ALTER TABLE `subject` DISABLE KEYS */;
INSERT INTO `subject` VALUES (1,'Physics','PHY','2018-12-06 00:00:00','2018-12-06 00:00:00'),(2,'Chemistry','CHE','2018-12-06 00:00:00','2018-12-06 00:00:00'),(3,'Mathematics','MATH','2018-12-06 00:00:00','2018-12-06 00:00:00'),(9,'Geography','GEO','2018-12-06 16:57:44','2018-12-06 16:57:44'),(10,'Biology','BIO','2018-12-14 11:49:15','2018-12-14 11:49:15'),(11,'Statistics','STAT','2018-12-14 13:02:18','2018-12-14 13:02:18');
/*!40000 ALTER TABLE `subject` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`adhyapan`@`%`*/ /*!50003 TRIGGER `subject_BEFORE_UPDATE` BEFORE UPDATE ON `subject` FOR EACH ROW BEGIN
    set new.updated_at = now();
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `teacher` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `teacher_code` varchar(45) NOT NULL,
  `contact` varchar(15) NOT NULL,
  `address` varchar(45) DEFAULT NULL,
  `school_id` int(11) NOT NULL,
  `subject_id` int(11) NOT NULL,
  `start_date` date NOT NULL,
  `end_date` date NOT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES (7,'Sajal','Guha','SKG','9632587410','Naktala',1,3,'2018-12-11','3000-12-31','2018-12-11 14:22:46','2018-12-11 14:22:46'),(8,'Shibaji','Chakrabarty','SC','9874563210','Dhakuria',1,2,'2018-12-11','3000-12-31','2018-12-11 14:27:33','2018-12-11 14:27:33'),(9,'Chandan','Das','CKD','9874563210','Santoshpur',1,1,'2018-12-11','3000-12-31','2018-12-11 14:32:47','2018-12-11 14:32:47'),(10,'Pradip','Das','PD','9874563210','Jodhpur Park',1,9,'2018-12-02','3000-12-31','2018-12-11 14:34:15','2018-12-11 14:34:15'),(11,'Ashish','Das','AKD','9874563210','Kolkata',4,1,'2018-10-01','3000-12-31','2018-12-11 14:36:48','2018-12-11 14:36:48'),(12,'Partha','Chakraborty','PSC','9632587410','Gariahat',2,1,'2018-12-11','3000-12-31','2018-12-11 14:37:51','2018-12-11 14:37:51'),(13,'Kaushik','Talukder','KT','9856321470','Garia',5,3,'2018-09-03','3000-12-31','2018-12-11 14:39:09','2018-12-11 14:39:09'),(14,'Sayak','Mohinta','SM','9830868330','Garia',2,2,'2018-10-01','3000-12-31','2018-12-11 14:42:06','2018-12-11 14:42:06'),(15,'Rahul','Das','RD','9874563210','Garia',5,3,'2018-10-07','2018-12-10','2018-12-11 14:46:12','2018-12-14 14:10:29');
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`adhyapan`@`%`*/ /*!50003 TRIGGER `teacher_BEFORE_UPDATE` BEFORE UPDATE ON `teacher` FOR EACH ROW BEGIN
    set new.updated_at = now();
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Dumping events for database 'adhyapan'
--

--
-- Dumping routines for database 'adhyapan'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-14 16:43:45
