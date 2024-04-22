-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: web_2024
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `choices`
--

DROP TABLE IF EXISTS `choices`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `choices` (
  `choice_id` bigint NOT NULL AUTO_INCREMENT,
  `choice_text` varchar(255) DEFAULT NULL,
  `is_correct` bit(1) DEFAULT NULL,
  `questionid` bigint NOT NULL,
  PRIMARY KEY (`choice_id`),
  KEY `FKs7ye7nuhl6ilpco3sywex9v7i` (`questionid`),
  CONSTRAINT `FKs7ye7nuhl6ilpco3sywex9v7i` FOREIGN KEY (`questionid`) REFERENCES `questions` (`question_id`)
) ENGINE=InnoDB AUTO_INCREMENT=110 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `choices`
--

LOCK TABLES `choices` WRITE;
/*!40000 ALTER TABLE `choices` DISABLE KEYS */;
INSERT INTO `choices` VALUES (1,'FPT, URL, HTTP',_binary '\0',1),(2,'HTTP, URL, HTML',_binary '',1),(3,'HTTP, TCP, HTML',_binary '\0',1),(4,'FTP, IP, HTML',_binary '\0',1),(5,'HEAD, HTML, BODY',_binary '\0',2),(6,'HEAD, TITLE, BODY',_binary '\0',2),(7,'HEAD, BODY, HTML',_binary '\0',2),(8,'HTML, HEAD, BODY',_binary '',2),(9,'<HR>',_binary '\0',3),(10,'<P>',_binary '',3),(11,'<BR>',_binary '\0',3),(12,'<PRE>',_binary '\0',3),(13,'NAME',_binary '\0',4),(14,'CLASS',_binary '\0',4),(15,'HREF',_binary '',4),(16,'ID',_binary '\0',4),(17,'<PIC>',_binary '\0',5),(18,'<IMG>',_binary '',5),(19,'<IMAGE>',_binary '\0',5),(20,'<PICTURE>',_binary '\0',5),(21,'<ADDRESS>',_binary '',6),(22,'<PRE>',_binary '\0',6),(23,'<BLOCKQUOTE>',_binary '\0',6),(24,'<AUTHOR>',_binary '\0',6),(25,'<ADDRESS>',_binary '\0',7),(26,'<PRE>',_binary '',7),(27,'<BLOCKQUOTE>',_binary '\0',7),(28,'<AUTHOR>',_binary '\0',7),(29,'<SPAN>',_binary '\0',8),(30,'<PRE>',_binary '\0',8),(31,'<BLOCKQUOTE>',_binary '\0',8),(32,'<DIV>',_binary '',8),(33,'<LI>',_binary '\0',9),(34,'<UL>',_binary '\0',9),(35,'<OL>',_binary '',9),(36,'<DL>',_binary '\0',9),(37,'<LI>',_binary '\0',10),(38,'<UL>',_binary '\0',11),(39,'<OL>',_binary '',12),(40,'<DL>',_binary '\0',13),(41,'<LI>',_binary '\0',11),(42,'<UL>',_binary '\0',10),(43,'<OL>',_binary '',12),(44,'<DL>',_binary '\0',13),(45,'<LI>',_binary '\0',12),(46,'<UL>',_binary '\0',11),(47,'<OL>',_binary '',10),(48,'<DL>',_binary '\0',13),(49,'<LI>',_binary '\0',13),(50,'<UL>',_binary '\0',12),(51,'<OL>',_binary '',11),(52,'<DL>',_binary '\0',10),(53,'FPT, URL, HTTP',_binary '\0',14),(54,'HTTP, URL, HTML',_binary '',14),(55,'HTTP, TCP, HTML',_binary '\0',14),(56,'FTP, IP, HTML',_binary '\0',14),(57,'HEAD, HTML, BODY',_binary '\0',15),(58,'HEAD, TITLE, BODY',_binary '\0',15),(59,'HEAD, BODY, HTML',_binary '\0',15),(60,'HTML, HEAD, BODY',_binary '',15),(61,'<HR>',_binary '\0',16),(62,'<P>',_binary '',16),(63,'<BR>',_binary '\0',16),(64,'<PRE>',_binary '\0',16),(65,'NAME',_binary '\0',17),(66,'CLASS',_binary '\0',17),(67,'HREF',_binary '',17),(68,'ID',_binary '\0',17),(69,'<PIC>',_binary '\0',18),(70,'<IMG>',_binary '',18),(71,'<IMAGE>',_binary '\0',18),(72,'<PICTURE>',_binary '\0',18),(73,'<ADDRESS>',_binary '',19),(74,'<PRE>',_binary '\0',19),(75,'<BLOCKQUOTE>',_binary '\0',19),(76,'<AUTHOR>',_binary '\0',19),(77,'<ADDRESS>',_binary '\0',20),(78,'<PRE>',_binary '',21),(79,'<BLOCKQUOTE>',_binary '\0',21),(80,'<AUTHOR>',_binary '\0',21),(81,'<SPAN>',_binary '\0',22),(82,'<PRE>',_binary '\0',22),(83,'<BLOCKQUOTE>',_binary '\0',22),(84,'<DIV>',_binary '',22),(85,'<LI>',_binary '\0',22),(86,'<UL>',_binary '\0',23),(87,'<OL>',_binary '',23),(88,'<DL>',_binary '\0',23),(89,'<LI>',_binary '\0',24),(90,'<UL>',_binary '\0',24),(91,'<OL>',_binary '',24),(92,'<DL>',_binary '\0',24),(93,'FPT, URL, HTTP',_binary '\0',25),(94,'HTTP, URL, HTML',_binary '',25),(95,'HTTP, TCP, HTML',_binary '\0',25),(96,'FTP, IP, HTML',_binary '\0',26),(97,'HEAD, HTML, BODY',_binary '\0',26),(98,'HEAD, TITLE, BODY',_binary '',26),(99,'HEAD, BODY, HTML',_binary '\0',26),(100,'HTML, HEAD, BODY',_binary '',27),(101,'<HR>',_binary '\0',27),(102,'<P>',_binary '',27),(103,'<BR>',_binary '',28),(104,'<PRE>',_binary '\0',28),(105,'NAME',_binary '\0',29),(106,'CLASS',_binary '\0',29),(108,'HREF',_binary '',30),(109,'HREF1',_binary '\0',30);
/*!40000 ALTER TABLE `choices` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exam_results`
--

DROP TABLE IF EXISTS `exam_results`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `exam_results` (
  `exam_result_id` bigint NOT NULL AUTO_INCREMENT,
  `end_time` datetime(6) DEFAULT NULL,
  `score` float DEFAULT NULL,
  `start_time` datetime(6) DEFAULT NULL,
  `status` bit(1) NOT NULL,
  `exam_id` bigint NOT NULL,
  `user_id` bigint NOT NULL,
  PRIMARY KEY (`exam_result_id`),
  KEY `FKtf85ht7yquiorwjx2xbdx3fxw` (`exam_id`),
  KEY `FK8qfnytaq4h76j7wley63ol36s` (`user_id`),
  CONSTRAINT `FK8qfnytaq4h76j7wley63ol36s` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKtf85ht7yquiorwjx2xbdx3fxw` FOREIGN KEY (`exam_id`) REFERENCES `exams` (`exam_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exam_results`
--

LOCK TABLES `exam_results` WRITE;
/*!40000 ALTER TABLE `exam_results` DISABLE KEYS */;
INSERT INTO `exam_results` VALUES (1,'2024-04-17 17:45:47.956000',2,'2024-04-17 17:45:47.956000',_binary '',2,3),(2,'2024-04-17 17:45:47.956000',2,'2024-04-17 17:45:47.956000',_binary '',2,35),(3,'2024-04-17 17:45:47.956000',5,'2024-04-17 17:45:47.956000',_binary '',2,36),(4,'2024-04-17 17:45:47.956000',1,'2024-04-17 17:45:47.956000',_binary '',2,37),(5,'2024-04-17 17:45:47.956000',2,'2024-04-17 17:45:47.956000',_binary '',2,37),(6,'2024-04-17 18:20:47.956000',10,'2024-04-17 17:45:47.956000',_binary '',2,39),(7,'2024-04-17 18:20:47.956000',9,'2024-04-17 17:45:47.956000',_binary '',2,40),(8,'2024-04-17 18:20:47.956000',10,'2024-04-17 17:45:47.956000',_binary '',2,40),(9,'2024-04-17 18:20:47.956000',8,'2024-04-17 17:45:47.956000',_binary '',2,40),(10,'2024-04-17 18:20:47.956000',7,'2024-04-17 17:45:47.956000',_binary '',2,42),(11,'2024-04-17 18:20:47.956000',10,'2024-04-17 17:45:47.956000',_binary '',2,43);
/*!40000 ALTER TABLE `exam_results` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exams`
--

DROP TABLE IF EXISTS `exams`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `exams` (
  `exam_id` bigint NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `end_time` datetime(6) DEFAULT NULL,
  `exam_name` varchar(255) NOT NULL,
  `exam_type` varchar(255) NOT NULL,
  `start_time` datetime(6) DEFAULT NULL,
  `time_to_do` bigint DEFAULT NULL,
  PRIMARY KEY (`exam_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exams`
--

LOCK TABLES `exams` WRITE;
/*!40000 ALTER TABLE `exams` DISABLE KEYS */;
INSERT INTO `exams` VALUES (1,'Luyện tập Lập trình WEB 1',NULL,'Luyện tập Lập trình WEB 1','FREE',NULL,30),(2,'Kiểm Tra Lập trình WEB','2024-04-10 09:00:00.000000','Kiểm Tra Lập trình WEB','SPECIFIC','2024-04-12 08:00:00.000000',90),(3,'Luyện tập Lập trình WEB 2','2024-04-10 09:00:00.000000','Luyện tập Lập trình WEB 2','FREE','2024-04-13 08:00:00.000000',60);
/*!40000 ALTER TABLE `exams` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `questions`
--

DROP TABLE IF EXISTS `questions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `questions` (
  `question_id` bigint NOT NULL AUTO_INCREMENT,
  `question_text` varchar(255) DEFAULT NULL,
  `exam_id` bigint NOT NULL,
  PRIMARY KEY (`question_id`),
  KEY `FKrk78bmt53fns7np8casqa3q44` (`exam_id`),
  CONSTRAINT `FKrk78bmt53fns7np8casqa3q44` FOREIGN KEY (`exam_id`) REFERENCES `exams` (`exam_id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questions`
--

LOCK TABLES `questions` WRITE;
/*!40000 ALTER TABLE `questions` DISABLE KEYS */;
INSERT INTO `questions` VALUES (1,'Từ HTML là từ viết tắt của từ nào?:',1),(2,'Ai (tổ chức nào) tạo ra Web standards?:',1),(3,'Cấu trúc đơn giản của một trang HTML được khai báo theo thứ tự là:',1),(4,'Để trình bày một đoạn văn bản trong tài liệu HTML ta dùng thẻ:',1),(5,'Để khai báo một phần bị đánh dấu trên trang web ta sử dụng thẻ <A> với thuộc tính:',1),(6,'Để chèn hình ảnh vào trang web ta dùng thẻ:',1),(7,'Để hiển thị các thông tin như tác giả, địa chỉ, chữ ký trong tài liệu HTML ta dùng thẻ:',1),(8,'. Để hiển thị văn bản trên trình duyệt với tất cả các định dạng đã được xác định từ trước bỡi mã nguồn HTML ta dùng thẻ:',1),(9,' Để nhóm các thành phần có liên quan với nhau ta dùng thẻ:',1),(10,'Để khai báo một danh sách có thứ tự ta sử dụng thẻ:',1),(11,'Từ HTML là từ viết tắt của từ nào?:',2),(12,'Ai (tổ chức nào) tạo ra Web standards?:',2),(13,'Cấu trúc đơn giản của một trang HTML được khai báo theo thứ tự là:',2),(14,'Để trình bày một đoạn văn bản trong tài liệu HTML ta dùng thẻ:',2),(15,'Để khai báo một phần bị đánh dấu trên trang web ta sử dụng thẻ <A> với thuộc tính:',2),(16,'Để chèn hình ảnh vào trang web ta dùng thẻ:',2),(17,'Để hiển thị các thông tin như tác giả, địa chỉ, chữ ký trong tài liệu HTML ta dùng thẻ:',2),(18,'. Để hiển thị văn bản trên trình duyệt với tất cả các định dạng đã được xác định từ trước bỡi mã nguồn HTML ta dùng thẻ:',2),(19,' Để nhóm các thành phần có liên quan với nhau ta dùng thẻ:',2),(20,'Để khai báo một danh sách có thứ tự ta sử dụng thẻ:',2),(21,'Từ HTML là từ viết tắt của từ nào?:',3),(22,'Ai (tổ chức nào) tạo ra Web standards?:',3),(23,'Cấu trúc đơn giản của một trang HTML được khai báo theo thứ tự là:',3),(24,'Để trình bày một đoạn văn bản trong tài liệu HTML ta dùng thẻ:',3),(25,'Để khai báo một phần bị đánh dấu trên trang web ta sử dụng thẻ <A> với thuộc tính:',3),(26,'Để chèn hình ảnh vào trang web ta dùng thẻ:',3),(27,'Để hiển thị các thông tin như tác giả, địa chỉ, chữ ký trong tài liệu HTML ta dùng thẻ:',3),(28,'. Để hiển thị văn bản trên trình duyệt với tất cả các định dạng đã được xác định từ trước bỡi mã nguồn HTML ta dùng thẻ:',3),(29,' Để nhóm các thành phần có liên quan với nhau ta dùng thẻ:',3),(30,'Để khai báo một danh sách có thứ tự ta sử dụng thẻ:',3);
/*!40000 ALTER TABLE `questions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `role_id` bigint NOT NULL AUTO_INCREMENT,
  `rolename` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ROLE_ADMIN'),(2,'ROLE_USER'),(3,'ROLE_MODERATOR');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `confirmation_token` varchar(255) DEFAULT NULL,
  `confirmation_token_expiration` datetime(6) DEFAULT NULL,
  `created` datetime(6) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `user_status` bit(1) DEFAULT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,NULL,NULL,'2024-04-11 00:00:00.000000','dangbinh@gmail.com','$2a$10$Wk9uRAFAJh3JKGhG3BCHvuSpSbwTPamJcDrCVuxpolUCjAdNVJWZ.','0123123123',_binary '','user'),(2,NULL,NULL,'2024-04-11 00:00:00.000000','dangbinh1770@gmail.com','$2a$10$ZRkctAACOtYHh6qFhgQ1LuXLFmESWBNJdkrnjfm5udNwxQZpx9Yq2','0941435605',_binary '','admin'),(3,NULL,NULL,'2024-04-12 00:00:00.000000','binh@gmail.com','$2a$10$BuCTlN/iuJympQmVbZNri.zUsHKVyEE0bMC5Rp9ygZH9xGgdE3LDm','03123123',_binary '','user2'),(5,NULL,NULL,'2024-04-17 00:00:00.000000','dang56563@gmail.com','$2a$10$P3OC96T3fULPAXq2V.lIQe91EG23l4vtbZAfz.pIqgzNoFLPVerRG','09124124',_binary '','user9'),(26,NULL,NULL,'2024-04-17 00:00:00.000000','dang555@gmail.com','$2a$10$jF2SVfs3fHDPG2pV8HdI.OqACVf27xUkRICk5jnOvg8jdec3ydzoy','09124124',_binary '','user3223'),(27,NULL,NULL,'2024-04-17 00:00:00.000000','dang665@gmail.com','$2a$10$5zUdRMIs4wVg61uprCEUku7MeqdhgKxocToC6gVhjBzmrn2kL8Bk2','09124124',_binary '','user3423'),(30,NULL,NULL,'2024-04-17 00:00:00.000000','dang1215@gmail.com','$2a$10$VQ2m.7.7UlT64NVBDNOAwO3jvDtixaYzlnSX6de0r7xC87O4RGWvK','09124124',_binary '','user3663'),(32,NULL,NULL,'2024-04-17 00:00:00.000000','dang1123125@gmail.com','$2a$10$vaGWxj54PuS.rC9KUmgvbeVB/OtAGXsDWgSSG6isKGO9vxXUzMJCC','09124124',_binary '','user3622'),(34,NULL,NULL,'2024-04-17 00:00:00.000000','dangqeee@gmail.com','$2a$10$XNJOXNHK6X46xQyqEPP3zeDj2ONusFgWwK3PqrY9kah0dj9b9BcLC','09124124',_binary '','userưqewe'),(35,NULL,NULL,'2024-04-18 00:00:00.000000','dangbinh1231@gmail.com','$2a$10$W..lkTRjrsTQ2xUvDpnuu.V6XE1GgEHcbicn3Vp/ZSeqZVCamHrri','321312321',_binary '','user3'),(36,NULL,NULL,'2024-04-18 00:00:00.000000','dangbinh12131@gmail.com','$2a$10$eBo2C1k9p0MPD3lesVtzoe/R2VOx8DB4mLrYU5cEBGRwpDJiPCGze','321312321',_binary '','user4'),(37,NULL,NULL,'2024-04-18 00:00:00.000000','dangbinh1221@gmail.com','$2a$10$lT3t7GaFiibs08fOo0SKZ.o1ARvgxf8YRjOWFn/JtX5TrWCJd48z2','321312321',_binary '','user5'),(38,NULL,NULL,'2024-04-18 00:00:00.000000','dangbinh221@gmail.com','$2a$10$D2R5laSZx2R6/gvt4gg4Z.mO7N24mtE.HjdTebYLNUQFJea81jZLO','321312321',_binary '','user6'),(39,NULL,NULL,'2024-04-18 00:00:00.000000','dang12312@gmail.com','$2a$10$ypQ9qVtQxJinjx7tKYz00.2xMYbo1rCWpqgZ/j/bF.Le.nFWVXSgO','0912312312',_binary '','user1'),(40,NULL,NULL,'2024-04-18 00:00:00.000000','dang12312@gmail.com','$2a$10$W.sixOlkILX7laiQVxdto.VnJgifETVhsYiquODg6xF6Vy8FRsnTa','0912312312',_binary '','user7'),(41,NULL,NULL,'2024-04-18 00:00:00.000000','dang1212@gmail.com','$2a$10$ZTjCxUpB0FzC9vqkecJVH.2I4qeV4N6osY/O8tBtAO.WMqsNq8IKe','0912312312',_binary '','user8'),(42,NULL,NULL,'2024-04-18 00:00:00.000000','dang1231@gmail.com','$2a$10$fSJ.s5jjBPgxDcbgLxgk7.URbOkRQ8WkgNk323XYMdzBeqpLOlZGG','0912312312',_binary '','user10'),(43,NULL,NULL,'2024-04-18 00:00:00.000000','dang1221@gmail.com','$2a$10$uT.vK5wwOwSJwA2YlI2zceWTMMS7jwv6PtytvpMoXpzpxqS1KMcWC','0912312312',_binary '','user11'),(44,NULL,NULL,'2024-04-18 00:00:00.000000','dang1221@gmail.com','$2a$10$q2VnWidl2KlKY6eD9Sm8r.PnbfhnGtsB.pSw/TTACHwCtMRYw8nb6','0912312312',_binary '','user12'),(45,NULL,NULL,'2024-04-18 00:00:00.000000','dang5551@gmail.com','$2a$10$cLdjYqPONJNPCyFybE46ruv7lwNH/8xnzNchE27qTwTfM3NTrSpBS','0912312312',_binary '','user13');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_answers`
--

DROP TABLE IF EXISTS `user_answers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_answers` (
  `user_answer_id` bigint NOT NULL AUTO_INCREMENT,
  `choice_id` bigint DEFAULT NULL,
  `exam_result_id` bigint NOT NULL,
  `question_id` bigint NOT NULL,
  PRIMARY KEY (`user_answer_id`),
  KEY `FKajx4pyjrsow6r8gudsjp5uuji` (`choice_id`),
  KEY `FKs02be2jjct8is4e12jtj4oab0` (`exam_result_id`),
  KEY `FK6b46l4bb7a6wfxvmn6l7ig8vo` (`question_id`),
  CONSTRAINT `FK6b46l4bb7a6wfxvmn6l7ig8vo` FOREIGN KEY (`question_id`) REFERENCES `questions` (`question_id`),
  CONSTRAINT `FKajx4pyjrsow6r8gudsjp5uuji` FOREIGN KEY (`choice_id`) REFERENCES `choices` (`choice_id`),
  CONSTRAINT `FKs02be2jjct8is4e12jtj4oab0` FOREIGN KEY (`exam_result_id`) REFERENCES `exam_results` (`exam_result_id`)
) ENGINE=InnoDB AUTO_INCREMENT=111 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_answers`
--

LOCK TABLES `user_answers` WRITE;
/*!40000 ALTER TABLE `user_answers` DISABLE KEYS */;
INSERT INTO `user_answers` VALUES (1,2,1,1),(2,6,1,2),(3,7,1,3),(4,2,1,4),(5,11,1,5),(6,14,1,6),(7,16,1,7),(8,20,1,8),(9,22,1,9),(10,25,1,10),(11,2,2,1),(12,4,2,2),(13,8,2,3),(14,9,2,4),(15,11,2,5),(16,14,2,6),(17,16,2,7),(18,20,2,8),(19,22,2,9),(20,25,2,10),(21,2,3,1),(22,4,3,2),(23,9,3,3),(24,10,3,4),(25,11,3,5),(26,14,3,6),(27,18,3,7),(28,21,3,8),(29,26,3,9),(30,29,3,10),(31,1,4,1),(32,4,4,2),(33,5,4,3),(34,7,4,4),(35,11,4,5),(36,14,4,6),(37,18,4,7),(38,22,4,8),(39,28,4,9),(40,29,4,10),(41,3,5,1),(42,6,5,2),(43,7,5,3),(44,9,5,4),(45,12,5,5),(46,14,5,6),(47,18,5,7),(48,21,5,8),(49,28,5,9),(50,29,5,10),(51,2,6,1),(52,8,6,2),(53,10,6,3),(54,15,6,4),(55,18,6,5),(56,21,6,6),(57,32,6,7),(58,39,6,8),(59,43,6,9),(60,51,6,10),(61,2,7,1),(62,8,7,2),(63,10,7,3),(64,15,7,4),(65,18,7,5),(66,21,7,6),(67,32,7,7),(68,39,7,8),(69,43,7,9),(70,50,7,10),(71,2,8,1),(72,8,8,2),(73,10,8,3),(74,15,8,4),(75,18,8,5),(76,21,8,6),(77,32,8,7),(78,39,8,8),(79,43,8,9),(80,51,8,10),(81,2,9,1),(82,8,9,2),(83,10,9,3),(84,15,9,4),(85,18,9,5),(86,21,9,6),(87,32,9,7),(88,39,9,8),(89,42,9,9),(90,50,9,10),(91,2,10,1),(92,8,10,2),(93,10,10,3),(94,15,10,4),(95,18,10,5),(96,21,10,6),(97,32,10,7),(98,38,10,8),(99,42,10,9),(100,50,10,10),(101,2,11,1),(102,8,11,2),(103,10,11,3),(104,15,11,4),(105,18,11,5),(106,21,11,6),(107,32,11,7),(108,39,11,8),(109,43,11,9),(110,51,11,10);
/*!40000 ALTER TABLE `user_answers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_role`
--

DROP TABLE IF EXISTS `user_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_role` (
  `user_id` bigint NOT NULL,
  `role_id` bigint NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `FKa68196081fvovjhkek5m97n3y` (`role_id`),
  CONSTRAINT `FK859n2jvi8ivhui0rl0esws6o` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKa68196081fvovjhkek5m97n3y` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_role`
--

LOCK TABLES `user_role` WRITE;
/*!40000 ALTER TABLE `user_role` DISABLE KEYS */;
INSERT INTO `user_role` VALUES (2,1),(1,2),(2,2),(3,2),(5,2),(26,2),(27,2),(30,2),(32,2),(34,2),(35,2),(36,2),(37,2),(38,2),(39,2),(40,2),(41,2),(42,2),(43,2),(44,2),(45,2),(2,3);
/*!40000 ALTER TABLE `user_role` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-04-22 22:30:04
