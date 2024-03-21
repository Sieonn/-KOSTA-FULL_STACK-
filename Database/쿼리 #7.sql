DROP TABLE account;
CREATE TABLE account(
id VARCHAR(30) PRIMARY KEY,
NAME VARCHAR(50) NOT NULL,
balance INTEGER DEFAULT 0 ,
TYPE VARCHAR(20),
grade VARCHAR(20));

DROP TABLE member;
CREATE TABLE member(
id VARCHAR(30) PRIMARY KEY,
NAME VARCHAR(50) NOT NULL,
PASSWORD VARCHAR(20),
email varchar(50),
address VARCHAR(200)
);
DROP TABLE board;
CREATE TABLE board(
	num INT AUTO_INCREMENT PRIMARY KEY,
	subject varchar(255) DEFAULT NULL,
	content VARCHAR(255) DEFAULT NULL,
	writedate date DEFAULT NULL,
	filenum INT DEFAULT NULL REFERENCES FILE(num),
	writer VARCHAR(100) DEFAULT NULL REFERENCES member(id),
	viewcount int DEFAULT 0,
	likecount int DEFAULT 0
);

DROP TABLE FILE;
CREATE TABLE if NOT EXISTS FILE(
	num INT AUTO_INCREMENT PRIMARY KEY,
	DIRECTORY VARCHAR(255) DEFAULT NULL,
	NAME VARCHAR(255) DEFAULT NULL,
	size BIGINT DEFAULT NULL,
	contenttype VARCHAR(255) DEFAULT NULL,
	uploaddate DATE DEFAULT null
);

CREATE TABLE boardlike(
	num INT AUTO_INCREMENT PRIMARY KEY,
	memberid VARCHAR(30) REFERENCES member(id),
	boardnum INT REFERENCES board(num)
);

DROP TABLE userinfo;

CREATE TABLE userInfo(
   id VARCHAR(25userinfo5) PRIMARY KEY,
   PASSWORD VARCHAR(50),
   NAME VARCHAR(100),
   nickname VARCHAR(100),
   email VARCHAR(100),
   address VARCHAR(100),
   profile_img VARCHAR(255),
   thumbnail_img VARCHAR(255)

);


CREATE TABLE Location(
num INT AUTO_INCREMENT PRIMARY KEY,
address VARCHAR(255),
title VARCHAR(255)
);

INSERT INTO Location (address, title) VALUES ('서울 금천구 가산디지털1로 70','호서대벤처타워');
INSERT INTO Location (address, title) VALUES ('전북특별자치도 남원시 숲정이3길 13','청화대');
INSERT INTO Location (address, title) VALUES ('서울 영등포구 국회대로 지하 758','국회의사당');
