DROP DATABASE CODIA; 
CREATE DATABASE CODIA;
USE CODIA; 

CREATE TABLE user (
	ID INTEGER NOT NULL AUTO_INCREMENT,
	user_name VARCHAR(24),
    mail VARCHAR(255),
	user_password VARCHAR(24), 
    gender VARCHAR(24),
    phone_number VARCHAR(24),
    experience VARCHAR(50),
	languages VARCHAR(255),
    linkedin VARCHAR(255),
    UNIQUE KEY (user_name),
    UNIQUE KEY (mail),
    UNIQUE KEY (phone_number), 
    PRIMARY KEY (ID)
);
