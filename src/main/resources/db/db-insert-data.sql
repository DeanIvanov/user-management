use `user-management`;

-- Dummy Data Import for Table Users (encoded passwords for '12345678')

INSERT INTO `users` (`id`, `name`, `surname`, `dob`, `phone`, `email`, `username`, `password`, `authority`, `enabled`)

VALUES
    (1, 'Dean', 'Ivanov', '1996-05-14', '0885145741', 'dean96@gmail.com', 'dean96', '$2a$10$w6VAEGILgYJUTctlSRg2zeVvBDEl5N/68L3BPhl6gZJ36BbCT9FO6', 'ROLE_USER', true),
    (2, 'Swagger', 'Swaggerov', '1999-01-01', '0887651837', 'swagger@gmail.com', 'swagger', '$2a$10$w6VAEGILgYJUTctlSRg2zeVvBDEl5N/68L3BPhl6gZJ36BbCT9FO6', 'ROLE_USER', true),
    (3, 'Roberto', 'Georgiev', '1998-01-01', '0889456362', 'robertog@gmail.com', 'robertog', '$2a$10$w6VAEGILgYJUTctlSRg2zeVvBDEl5N/68L3BPhl6gZJ36BbCT9FO6', 'ROLE_USER', true),
    (4, 'Daniel', 'Atanasov', '1997-01-01', '0887784521', 'datanasov@gmail.com', 'datanasov', '$2a$10$w6VAEGILgYJUTctlSRg2zeVvBDEl5N/68L3BPhl6gZJ36BbCT9FO6', 'ROLE_USER', true),
    (5, 'Pavel', 'Stavski', '1996-01-01', '0888215215', 'pavelstavski@gmail.com', 'pavelstavski', '$2a$10$w6VAEGILgYJUTctlSRg2zeVvBDEl5N/68L3BPhl6gZJ36BbCT9FO6', 'ROLE_USER', true),
    (6, 'Ivan', 'Ivanov', '1995-01-01', '0886125651', 'iivanov@gmail.com', 'iivanov', '$2a$10$w6VAEGILgYJUTctlSRg2zeVvBDEl5N/68L3BPhl6gZJ36BbCT9FO6', 'ROLE_USER', true),
    (7, 'Georgi', 'Georgiev', '1994-01-01', '0887861828', 'georgig@gmail.com', 'georgig', '$2a$10$w6VAEGILgYJUTctlSRg2zeVvBDEl5N/68L3BPhl6gZJ36BbCT9FO6', 'ROLE_USER', true),
    (8, 'Gergana', 'Zhivkova', '1993-01-01', '0888578282', 'gzhiv@gmail.com', 'gzhiv', '$2a$10$w6VAEGILgYJUTctlSRg2zeVvBDEl5N/68L3BPhl6gZJ36BbCT9FO6', 'ROLE_USER', true),
    (9, 'Zlatko', 'Kirilov', '1992-01-01', '0889215615', 'zkirilov@gmail.com', 'zkirilov', '$2a$10$w6VAEGILgYJUTctlSRg2zeVvBDEl5N/68L3BPhl6gZJ36BbCT9FO6', 'ROLE_USER', true),
    (10, 'Spas', 'Mladenov', '1991-01-01', '0887548911', 'spasm@gmail.com', 'spasm', '$2a$10$w6VAEGILgYJUTctlSRg2zeVvBDEl5N/68L3BPhl6gZJ36BbCT9FO6', 'ROLE_USER', true),
    (11, 'Marina', 'Boteva', '1990-01-01', '0888258284', 'mboteva@gmail.com', 'mboteva', '$2a$10$w6VAEGILgYJUTctlSRg2zeVvBDEl5N/68L3BPhl6gZJ36BbCT9FO6', 'ROLE_USER', true),
    (12, 'Desislava', 'Popova', '1999-01-01', '0889218847', 'desipop@gmail.com', 'desipop', '$2a$10$w6VAEGILgYJUTctlSRg2zeVvBDEl5N/68L3BPhl6gZJ36BbCT9FO6', 'ROLE_USER', true),
    (13, 'Iliana', 'Petrova', '1998-01-01', '0885782458', 'ipetrova@gmail.com', 'ipetrova', '$2a$10$w6VAEGILgYJUTctlSRg2zeVvBDEl5N/68L3BPhl6gZJ36BbCT9FO6', 'ROLE_USER', true),
    (14, 'Pavel', 'Yankov', '1997-01-01', '0889564821', 'pavelyan@gmail.com', 'pavelyan', '$2a$10$w6VAEGILgYJUTctlSRg2zeVvBDEl5N/68L3BPhl6gZJ36BbCT9FO6', 'ROLE_USER', true),
    (15, 'Yavor', 'Atanasov', '1996-01-01', '0888547174', 'yasov@gmail.com', 'yasov', '$2a$10$w6VAEGILgYJUTctlSRg2zeVvBDEl5N/68L3BPhl6gZJ36BbCT9FO6', 'ROLE_USER', true);
