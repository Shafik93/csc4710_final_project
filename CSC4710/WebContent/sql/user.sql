CREATE DATABASE sampledb;


use  sampledb;

CREATE TABLE tb_user 
(
  
  username VARCHAR(50) primary key,
  `password` VARCHAR(50) NOT NULL,
  email VARCHAR(50) NOT NULL
);

CREATE TABLE `author` (
  `email` varchar(100) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `affiliation` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`email`)
);

CREATE TABLE `paper` (
  `paperid` int(11) NOT NULL,
  `title` varchar(50) DEFAULT NULL,
  `Abstract` varchar(250) DEFAULT NULL,
  `pdf` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`paperid`)
);

CREATE TABLE `pcmember` (
  `email` varchar(50) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`email`)
);

CREATE TABLE `review` (
  `reportid` int(11) DEFAULT NULL,
  `sdate` date DEFAULT NULL,
  `comment` varchar(250) DEFAULT NULL,
  `recommendation` char(1) DEFAULT NULL,
  `paperid` int(11) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  UNIQUE KEY `paperid` (`paperid`,`email`),
  KEY `email` (`email`),
  CONSTRAINT `review_ibfk_1` FOREIGN KEY (`paperid`) REFERENCES `paper` (`paperid`),
  CONSTRAINT `review_ibfk_2` FOREIGN KEY (`email`) REFERENCES `pcmember` (`email`)
);

CREATE TABLE `writepaper` (
  `paperid` int(11) NOT NULL,
  `email` varchar(50) NOT NULL,
  `ordersignificance` int(11) DEFAULT NULL,
  PRIMARY KEY (`paperid`,`email`),
  KEY `email` (`email`),
  CONSTRAINT `writepaper_ibfk_1` FOREIGN KEY (`paperid`) REFERENCES `paper` (`paperid`),
  CONSTRAINT `writepaper_ibfk_2` FOREIGN KEY (`email`) REFERENCES `author` (`email`)
);

