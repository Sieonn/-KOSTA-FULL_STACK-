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