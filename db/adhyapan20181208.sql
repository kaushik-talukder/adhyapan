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
  `address` varchar(45) NOT NULL,
  `spoc` varchar(45) NOT NULL,
  `contact` varchar(15) NOT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
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
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `school`
--

LOCK TABLES `school` WRITE;
/*!40000 ALTER TABLE `school` DISABLE KEYS */;
INSERT INTO `school` VALUES (1,'Jodhpur Park Boys\' School','JPBS','2018-12-06 00:00:00','2018-12-06 00:00:00'),(2,'South Point','SP','2018-12-06 00:00:00','2018-12-06 00:00:00'),(3,'Kamala Girls','KG','2018-12-06 20:59:37','2018-12-06 20:59:37'),(4,'Patha Bhaban','PB','2018-12-06 21:09:03','2018-12-06 21:09:03'),(5,'Others','OTH','2018-12-07 12:52:42','2018-12-07 12:52:42');
/*!40000 ALTER TABLE `school` ENABLE KEYS */;
UNLOCK TABLES;

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
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `standard`
--

LOCK TABLES `standard` WRITE;
/*!40000 ALTER TABLE `standard` DISABLE KEYS */;
INSERT INTO `standard` VALUES (1,'IX','Class 9','2018-12-06 00:00:00','2018-12-06 00:00:00'),(2,'X','Class 10','2018-12-06 00:00:00','2018-12-06 00:00:00'),(3,'XI','Class 11','2018-12-06 00:00:00','2018-12-06 00:00:00'),(4,'XII','Class 12','2018-12-06 00:00:00','2018-12-06 00:00:00');
/*!40000 ALTER TABLE `standard` ENABLE KEYS */;
UNLOCK TABLES;

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
  `school_id` int(11) DEFAULT NULL,
  `student_contact` varchar(15) DEFAULT NULL,
  `guardian_name` varchar(200) NOT NULL,
  `guardian_contact` varchar(15) NOT NULL,
  `address` varchar(100) DEFAULT NULL,
  `is_active` varchar(1) NOT NULL,
  `gender` varchar(1) NOT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_school_id_idx` (`school_id`),
  CONSTRAINT `fk_school_id` FOREIGN KEY (`school_id`) REFERENCES `school` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,'ANIKT','Anik','Talukder',1,'9632587410','Sudhir Talukder','9876643210','Garia','Y','M','2018-12-07 14:27:43','2018-12-07 14:27:43'),(2,'RAHULDAS','Rahul','Das',4,'9632587410','SK Das','9856321470','Rabindranagar','Y','M','2018-12-07 14:58:18','2018-12-07 14:58:18'),(3,'JOYDAS','Joyantee','Das',3,'9632587410','A C Das','9874563210','Garia','Y','F','2018-12-07 15:00:35','2018-12-07 15:00:35');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

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
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject`
--

LOCK TABLES `subject` WRITE;
/*!40000 ALTER TABLE `subject` DISABLE KEYS */;
INSERT INTO `subject` VALUES (1,'Physics','PHY','2018-12-06 00:00:00','2018-12-06 00:00:00'),(2,'Chemistry','CHE','2018-12-06 00:00:00','2018-12-06 00:00:00'),(3,'Mathematics','MATH','2018-12-06 00:00:00','2018-12-06 00:00:00'),(4,'Biology','BIO',NULL,NULL),(5,'English','ENG',NULL,NULL),(6,'Bengali','BEN',NULL,NULL),(7,'Statistics','STAT',NULL,NULL),(8,'Computer Sc','CS',NULL,NULL),(9,'Geography','GEO','2018-12-06 16:57:44','2018-12-06 16:57:44');
/*!40000 ALTER TABLE `subject` ENABLE KEYS */;
UNLOCK TABLES;

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
  `school_id` int(11) DEFAULT NULL,
  `subject_id` int(11) DEFAULT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_teacher_school_idx` (`school_id`),
  KEY `fk_teacher_subject_idx` (`subject_id`),
  CONSTRAINT `fk_teacher_school` FOREIGN KEY (`school_id`) REFERENCES `school` (`id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `fk_teacher_subject` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES (2,'Sajal','Guha','SKG','9876543210','Naktala',1,3,'2018-12-06 00:00:00','2018-12-06 00:00:00'),(3,'Shibaji','Chakraborty','SC','9874563210','Dhakuria',1,2,NULL,NULL),(4,'Partha','Chakraborty','PSC','9856321470','Gariahat',2,1,'2018-12-07 12:51:39','2018-12-07 12:51:39'),(5,'Kaushik','Talukder','KT','9876543210','Mahamayatala',5,8,'2018-12-07 12:53:08','2018-12-07 12:53:08');
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-08 11:16:16
