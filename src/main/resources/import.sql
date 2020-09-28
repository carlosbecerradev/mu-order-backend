/* clientes */
INSERT INTO customers(name,lastname,email,created) VALUES('Joseh', 'Doese', 'dao@gmail.com','2020-05-15');
INSERT INTO customers(name,lastname,email,created) VALUES('Doeh', 'Castilla', 'wao@gmail.com','2020-04-5');
INSERT INTO customers(name,lastname,email,created) VALUES('Woeh', 'Becerra', 'wdao@gmail.com','2020-05-15');
INSERT INTO customers(name,lastname,email,created) VALUES('Fulano', 'Gafa', 'Fulano@gmail.com','2020-01-25');
INSERT INTO customers(name,lastname,email,created) VALUES('Melgano', 'Faro', 'Melgano@gmail.com','2020-02-8');
INSERT INTO customers(name,lastname,email,created) VALUES('Taradio', 'Feliz', 'Taradio@gmail.com','2020-03-21');
INSERT INTO customers(name,lastname,email,created) VALUES('Refeo', 'Vata', 'Refeo@gmail.com','2020-04-14');
INSERT INTO customers(name,lastname,email,created) VALUES('Hugo', 'Hello', 'Hugo@gmail.com','2020-07-4');
INSERT INTO customers(name,lastname,email,created) VALUES('Murcia', 'Breum', 'Murcia@gmail.com','2020-06-16');

/* Agregando usuario y sus roles */
INSERT INTO `users` (username, password, email, enabled, created) VALUES ('chars', '$2a$10$Oi/S83ZRGEBMyN5P/lloZOm9cVtnosTNCiJ5ClQEV4A25vhWpkToS','chars@up.com', 1,'2020-06-16');
INSERT INTO `users` (username, password, email, enabled, created) VALUES ('admin', '$2a$10$dUu/ixrZAV9AlfmkcYYkY.7OFpSDUWBTvzSZP8Mbxf9MMAfKJTlLi','adm@up.com', 1,'2020-06-16');

INSERT INTO `authorities` (user_id, `authority`) VALUES (1, 'ROLE_USER');
INSERT INTO `authorities` (user_id, `authority`) VALUES (2, 'ROLE_ADMIN');
INSERT INTO `authorities` (user_id, `authority`) VALUES (2, 'ROLE_USER');