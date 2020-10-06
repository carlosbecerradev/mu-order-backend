/* Agregando usuario y sus roles */
INSERT INTO `users` (username, password, email, enabled, created, nickname) VALUES ('chars', '$2a$10$Oi/S83ZRGEBMyN5P/lloZOm9cVtnosTNCiJ5ClQEV4A25vhWpkToS','chars@up.com', 1,'2020-06-16', 'Chars');
INSERT INTO `users` (username, password, email, enabled, created, nickname) VALUES ('admin', '$2a$10$dUu/ixrZAV9AlfmkcYYkY.7OFpSDUWBTvzSZP8Mbxf9MMAfKJTlLi','adm@up.com', 1,'2020-06-16', 'Administrador');

INSERT INTO `authorities` (user_id, `authority`) VALUES (1, 'ROLE_USER');
INSERT INTO `authorities` (user_id, `authority`) VALUES (2, 'ROLE_ADMIN');
INSERT INTO `authorities` (user_id, `authority`) VALUES (2, 'ROLE_USER');