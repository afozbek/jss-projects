CREATE DATABASE  IF NOT EXISTS `db_users`;
USE `db_users`;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Insert data for table `users`
--

LOCK TABLES `users` WRITE;
INSERT INTO `users` VALUES (1,'Yasin','Razlik','yrazlik@gmail.com'),(2,'Ayşe','Fatma','aysefatma@hotmail.com');
UNLOCK TABLES;