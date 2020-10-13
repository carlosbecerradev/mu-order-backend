/* Agregando usuario y sus roles */
INSERT INTO `users` (username, password, email, enabled, created, nickname) VALUES ('chars', '$2a$10$Oi/S83ZRGEBMyN5P/lloZOm9cVtnosTNCiJ5ClQEV4A25vhWpkToS','chars@up.com', 1,'2020-06-16', 'Chars');
INSERT INTO `users` (username, password, email, enabled, created, nickname) VALUES ('admin', '$2a$10$dUu/ixrZAV9AlfmkcYYkY.7OFpSDUWBTvzSZP8Mbxf9MMAfKJTlLi','adm@up.com', 1,'2020-06-16', 'Administrador');

INSERT INTO `authorities` (user_id, `authority`) VALUES (1, 'ROLE_USER');
INSERT INTO `authorities` (user_id, `authority`) VALUES (2, 'ROLE_ADMIN');
INSERT INTO `authorities` (user_id, `authority`) VALUES (2, 'ROLE_USER');

/* Items Categories */
INSERT INTO item_categories(name, enabled) VALUES ("Sets", 1);
INSERT INTO item_categories(name, enabled) VALUES ("Armors", 1);
INSERT INTO item_categories(name, enabled) VALUES ("Wings", 1);
INSERT INTO item_categories(name, enabled) VALUES ("Weapons", 1);
INSERT INTO item_categories(name, enabled) VALUES ("Shields", 1);
INSERT INTO item_categories(name, enabled) VALUES ("Set Lucky", 1);
INSERT INTO item_categories(name, enabled) VALUES ("Accessories", 1);

/* Items */
INSERT INTO items(name, item_category_id,enabled) VALUES ("Set Red Dragon", 1, 1);
INSERT INTO items(name, item_category_id, enabled) VALUES ("Red Dragon Boots", 2, 1);
INSERT INTO items(name, item_category_id, enabled) VALUES ("Red Dragon Pants", 2, 1);
INSERT INTO items(name, item_category_id, enabled) VALUES ("Red Dragon Gloves", 2, 1);
INSERT INTO items(name, item_category_id, enabled) VALUES ("Red Dragon Armor", 2, 1);
INSERT INTO items(name, item_category_id, enabled) VALUES ("Red Dragon Helm", 2, 1);
INSERT INTO items(name, item_category_id, enabled) VALUES ("Wings of Liberty", 3, 1);
INSERT INTO items(name, item_category_id, enabled) VALUES ("Platina Staff", 4, 1);
INSERT INTO items(name, item_category_id, enabled) VALUES ("Grand Soul Shield", 5, 1);
INSERT INTO items(name, item_category_id, enabled) VALUES ("Ring Poison", 7, 1);

/* Items Options */
INSERT INTO item_options(name, enabled) VALUES ("Full Options", 1);
INSERT INTO item_options(name, enabled) VALUES ("Semi Full Options", 1);
INSERT INTO item_options(name, enabled) VALUES ("No Options", 1);
INSERT INTO item_options(name, enabled) VALUES ("Only Luck", 1);

/* Items Types*/
INSERT INTO item_types(name, enabled) VALUES ("Excellent", 1);
INSERT INTO item_types(name, enabled) VALUES ("No Excellent", 1);
INSERT INTO item_types(name, enabled) VALUES ("Ancient", 1);
INSERT INTO item_types(name, enabled) VALUES ("Normal", 1);

/* Orders */
INSERT INTO orders(item_options, item_type, item_level, observation, enabled, item_id, user_id) VALUES ("Full Options", 'Excellent', 13, 'Puedo pagar wc', 1, 2, 1);
INSERT INTO orders(item_options, item_type, item_level, observation, enabled, item_id, user_id) VALUES ("Only Luck", 'Ancient', 13, 'Ando sin WC', 1, 4, 1);
INSERT INTO orders(item_options, item_type, item_level, observation, enabled, item_id, user_id) VALUES (null, null, 13, 'Puedo pagar wc', 1, 1, 1);
INSERT INTO orders(item_options, item_type, item_level, observation, enabled, item_id, user_id) VALUES (null, null, 13, 'Para el CS', 0, 1, 1);
INSERT INTO orders(item_options, item_type, item_level, observation, enabled, item_id, user_id) VALUES ("Full Options", 'Excellent', 13, 'Para hoy', 1, 2, 1);
INSERT INTO orders(item_options, item_type, item_level, observation, enabled, item_id, user_id) VALUES ("Full Options", null, 13, 'Para el Domingo', 1, 7, 2);
INSERT INTO orders(item_options, item_type, item_level, observation, enabled, item_id, user_id) VALUES ("Full Options", 'Excellent', 13, 'Para Mañana', 0, 8, 2);
INSERT INTO orders(item_options, item_type, item_level, observation, enabled, item_id, user_id) VALUES ("Full Options", 'Excellent', 13, 'Para hoy Adm', 1, 9, 2);
INSERT INTO orders(item_options, item_type, item_level, observation, enabled, item_id, user_id) VALUES ("Full Options", 'Excellent', 13, 'Me mandan un mensaje a +51 911222111', 1, 10, 1);

/* Orders History */
INSERT INTO orders_history(mate_id, price, observation, order_id) VALUES (2, '10k WC', 'Me rebajo el precio', 1);
INSERT INTO orders_history(mate_id, price, observation, order_id) VALUES (2, null, 'Me lo regalo', 2);
INSERT INTO orders_history(mate_id, price, observation, order_id) VALUES (1, '5k WC', 'Me rebajo el precio', 3);
INSERT INTO orders_history(mate_id, price, observation, order_id) VALUES (1, null, 'Me lo regalo', 4);
INSERT INTO orders_history(mate_id, price, observation, order_id) VALUES (2, '10k WC', 'Me rebajo el precio', 5);
INSERT INTO orders_history(mate_id, price, observation, order_id) VALUES (2, null, 'Me lo regalo', 6);
INSERT INTO orders_history(mate_id, price, observation, order_id) VALUES (1, '15k WC', 'Me rebajo el precio', 7);
INSERT INTO orders_history(mate_id, price, observation, order_id) VALUES (1, null, 'Me lo regalo', 8);

/* Item Category Options */
INSERT INTO item_category_options(item_option_id, item_category_id) VALUES (1, 1);
INSERT INTO item_category_options(item_option_id, item_category_id) VALUES (2, 1);
INSERT INTO item_category_options(item_option_id, item_category_id) VALUES (3, 1);
INSERT INTO item_category_options(item_option_id, item_category_id) VALUES (4, 1);
INSERT INTO item_category_options(item_option_id, item_category_id) VALUES (1, 6);

/* Item Category Types */
INSERT INTO item_category_types(item_type_id, item_category_id) VALUES (1, 1);
INSERT INTO item_category_types(item_type_id, item_category_id) VALUES (2, 1);
INSERT INTO item_category_types(item_type_id, item_category_id) VALUES (3, 1);
INSERT INTO item_category_types(item_type_id, item_category_id) VALUES (4, 1);
INSERT INTO item_category_types(item_type_id, item_category_id) VALUES (1, 6);
INSERT INTO item_category_types(item_type_id, item_category_id) VALUES (3, 6);
