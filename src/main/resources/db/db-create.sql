-- create database and database-specific user

# DROP DATABASE IF EXISTS `user-management`;
CREATE DATABASE IF NOT EXISTS `user-management`;
USE `user-management`;
CREATE USER IF NOT EXISTS `superuser`@`%` IDENTIFIED BY '1234';
GRANT ALL PRIVILEGES ON `user-management`.* TO `superuser`@`%`;

-- create all tables

-- Table: users
CREATE TABLE IF NOT EXISTS users (
    id int NOT NULL AUTO_INCREMENT,
    name varchar(15) NULL,
    surname varchar(20) NULL,
    dob date NULL,
    phone varchar(13) NULL,
    email varchar(50) NULL,
    username varchar(50) NOT NULL,
    password varchar(68)  NOT NULL,
    enabled bit  not null default 1,
    UNIQUE INDEX users_unique_keys (email),
    CONSTRAINT users_pk PRIMARY KEY (id)
);

-- Table: authorities
CREATE TABLE IF NOT EXISTS authorities (
    username varchar(50)  NOT NULL,
    authority varchar(25)  NOT NULL
);

-- add all foreign keys

-- Reference: authorities_users (table: authorities)
# ALTER TABLE authorities ADD CONSTRAINT authorities_users FOREIGN KEY authorities_users (username)
#     REFERENCES users (username);