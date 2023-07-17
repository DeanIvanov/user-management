-- create database and database-specific user

# DROP DATABASE IF EXISTS `user-management`;
CREATE DATABASE IF NOT EXISTS `user-management`;
USE `user-management`;
CREATE USER IF NOT EXISTS `superuser`@`%` IDENTIFIED BY '1234';
GRANT ALL PRIVILEGES ON `user-management`.* TO `superuser`@`%`;

-- create all tables

-- Table: users
CREATE TABLE IF NOT EXISTS users (
    id int  NOT NULL AUTO_INCREMENT,
    name varchar(15)  NOT NULL,
    surname varchar(20)  NOT NULL,
    dob date  NOT NULL,
    phone varchar(13)  NOT NULL,
    email varchar(50)  NOT NULL,
    username varchar(50)  NOT NULL,
    password varchar(68)  NOT NULL,
    authority varchar(25)  NOT NULL,
    enabled boolean  NOT NULL default 1,
    UNIQUE INDEX users_unique_keys (username,email),
    CONSTRAINT users_pk PRIMARY KEY (id)
);