/* Agregando usuario y sus roles */
INSERT INTO `users` (username, password, email, enabled, created, nickname) VALUES ('chars', '$2a$10$Oi/S83ZRGEBMyN5P/lloZOm9cVtnosTNCiJ5ClQEV4A25vhWpkToS','chars@up.com', 1,'2020-06-16', 'Chars');
INSERT INTO `users` (username, password, email, enabled, created, nickname) VALUES ('admin', '$2a$10$dUu/ixrZAV9AlfmkcYYkY.7OFpSDUWBTvzSZP8Mbxf9MMAfKJTlLi','adm@up.com', 1,'2020-06-16', 'Administrador');

INSERT INTO `authorities` (`user_id`, `authority`) VALUES (1, 'ROLE_USER');
INSERT INTO `authorities` (`user_id`, `authority`) VALUES (2, 'ROLE_ADMIN');
INSERT INTO `authorities` (`user_id`, `authority`) VALUES (2, 'ROLE_USER');

/* Items Categories */
INSERT INTO `item_categories` (name, enabled) VALUES ("Set", 1);
INSERT INTO `item_categories` (name, enabled) VALUES ("Helm", 1);
INSERT INTO `item_categories` (name, enabled) VALUES ("Wings", 1);
INSERT INTO `item_categories` (name, enabled) VALUES ("Weapons", 1);
INSERT INTO `item_categories` (name, enabled) VALUES ("Shield", 1);
INSERT INTO `item_categories` (name, enabled) VALUES ("Ring and Pendant", 1); 
INSERT INTO `item_categories` (name, enabled) VALUES ("Ancient Set", 1);
INSERT INTO `item_categories` (name, enabled) VALUES ("Ancient Ring and Ancient Pendant", 1);

/* Items Options */
INSERT INTO `item_options` (name, enabled) VALUES ("No Options", 1);
INSERT INTO `item_options` (name, enabled) VALUES ("Full Options", 1);
INSERT INTO `item_options` (name, enabled) VALUES ("Semi Full Options", 1);
INSERT INTO `item_options` (name, enabled) VALUES ("Only Luck", 1);

/* Items Types*/
INSERT INTO `item_types` (name, enabled) VALUES ("Normal", 1);
INSERT INTO `item_types` (name, enabled) VALUES ("Excellent", 1);
INSERT INTO `item_types` (name, enabled) VALUES ("Ancient", 1);
INSERT INTO `item_types` (name, enabled) VALUES ("Excellent + Ancient", 1);

/* Item Category Options */
INSERT INTO `item_category_options` (item_option_id, item_category_id) VALUES (1, 1);
INSERT INTO `item_category_options` (item_option_id, item_category_id) VALUES (2, 1);
INSERT INTO `item_category_options` (item_option_id, item_category_id) VALUES (3, 1);
INSERT INTO `item_category_options` (item_option_id, item_category_id) VALUES (4, 1);
INSERT INTO `item_category_options` (item_option_id, item_category_id) VALUES (1, 2);
INSERT INTO `item_category_options` (item_option_id, item_category_id) VALUES (2, 2);
INSERT INTO `item_category_options` (item_option_id, item_category_id) VALUES (3, 2);
INSERT INTO `item_category_options` (item_option_id, item_category_id) VALUES (4, 2);
INSERT INTO `item_category_options` (item_option_id, item_category_id) VALUES (1, 3);
INSERT INTO `item_category_options` (item_option_id, item_category_id) VALUES (2, 3);
INSERT INTO `item_category_options` (item_option_id, item_category_id) VALUES (3, 3);
INSERT INTO `item_category_options` (item_option_id, item_category_id) VALUES (4, 3);
INSERT INTO `item_category_options` (item_option_id, item_category_id) VALUES (1, 4);
INSERT INTO `item_category_options` (item_option_id, item_category_id) VALUES (2, 4);
INSERT INTO `item_category_options` (item_option_id, item_category_id) VALUES (3, 4);
INSERT INTO `item_category_options` (item_option_id, item_category_id) VALUES (4, 4);
INSERT INTO `item_category_options` (item_option_id, item_category_id) VALUES (1, 5);
INSERT INTO `item_category_options` (item_option_id, item_category_id) VALUES (2, 5);
INSERT INTO `item_category_options` (item_option_id, item_category_id) VALUES (3, 5);
INSERT INTO `item_category_options` (item_option_id, item_category_id) VALUES (4, 5);
INSERT INTO `item_category_options` (item_option_id, item_category_id) VALUES (1, 6);
INSERT INTO `item_category_options` (item_option_id, item_category_id) VALUES (2, 6);
INSERT INTO `item_category_options` (item_option_id, item_category_id) VALUES (3, 6); 
INSERT INTO `item_category_options` (item_option_id, item_category_id) VALUES (1, 7);
INSERT INTO `item_category_options` (item_option_id, item_category_id) VALUES (2, 7);
INSERT INTO `item_category_options` (item_option_id, item_category_id) VALUES (3, 7);
INSERT INTO `item_category_options` (item_option_id, item_category_id) VALUES (4, 7);
INSERT INTO `item_category_options` (item_option_id, item_category_id) VALUES (1, 8);
INSERT INTO `item_category_options` (item_option_id, item_category_id) VALUES (2, 8);
INSERT INTO `item_category_options` (item_option_id, item_category_id) VALUES (3, 8);

/* Item Category Types */
INSERT INTO `item_category_types` (item_type_id, item_category_id) VALUES (1, 1);
INSERT INTO `item_category_types` (item_type_id, item_category_id) VALUES (2, 1);
INSERT INTO `item_category_types` (item_type_id, item_category_id) VALUES (1, 2);
INSERT INTO `item_category_types` (item_type_id, item_category_id) VALUES (2, 2);
INSERT INTO `item_category_types` (item_type_id, item_category_id) VALUES (1, 3);
INSERT INTO `item_category_types` (item_type_id, item_category_id) VALUES (2, 3);
INSERT INTO `item_category_types` (item_type_id, item_category_id) VALUES (1, 4);
INSERT INTO `item_category_types` (item_type_id, item_category_id) VALUES (2, 4);
INSERT INTO `item_category_types` (item_type_id, item_category_id) VALUES (1, 5);
INSERT INTO `item_category_types` (item_type_id, item_category_id) VALUES (2, 5);
INSERT INTO `item_category_types` (item_type_id, item_category_id) VALUES (1, 6);
INSERT INTO `item_category_types` (item_type_id, item_category_id) VALUES (2, 6);
INSERT INTO `item_category_types` (item_type_id, item_category_id) VALUES (3, 7);
INSERT INTO `item_category_types` (item_type_id, item_category_id) VALUES (3, 8);

/* Items */
INSERT INTO `items` (name, item_category_id, enabled) VALUES ("Red Dragon Set", 1, 1);
INSERT INTO `items` (name, item_category_id, enabled) VALUES ("Black Dragon Set", 1, 1);
INSERT INTO `items` (name, item_category_id, enabled) VALUES ("Red Spirit Set", 1, 1);
INSERT INTO `items` (name, item_category_id, enabled) VALUES ("Red Dragon Helm", 2, 1);
INSERT INTO `items` (name, item_category_id, enabled) VALUES ("Black Dragon Helm", 2, 1);
INSERT INTO `items` (name, item_category_id, enabled) VALUES ("Red Spirit Helm", 2, 1);
INSERT INTO `items` (name, item_category_id, enabled) VALUES ("Wings of Spirit", 3, 1);
INSERT INTO `items` (name, item_category_id, enabled) VALUES ("Wings of Despair", 3, 1);
INSERT INTO `items` (name, item_category_id, enabled) VALUES ("Wings of Soul", 3, 1);
INSERT INTO `items` (name, item_category_id, enabled) VALUES ("Legendary Staff", 4, 1);
INSERT INTO `items` (name, item_category_id, enabled) VALUES ("Viper Staff", 4, 1);
INSERT INTO `items` (name, item_category_id, enabled) VALUES ("Platina Staff", 4, 1);
INSERT INTO `items` (name, item_category_id, enabled) VALUES ("Dragon Shield", 5, 1);
INSERT INTO `items` (name, item_category_id, enabled) VALUES ("Elemental Shield", 5, 1);
INSERT INTO `items` (name, item_category_id, enabled) VALUES ("Grand Soul Shield", 5, 1);
INSERT INTO `items` (name, item_category_id, enabled) VALUES ("Ring of Magic", 6, 1);
INSERT INTO `items` (name, item_category_id, enabled) VALUES ("Ring of Poison", 6, 1);
INSERT INTO `items` (name, item_category_id, enabled) VALUES ("Pendant of Ice", 6, 1);
INSERT INTO `items` (name, item_category_id, enabled) VALUES ("Vicious Dragon Set", 7, 1);
INSERT INTO `items` (name, item_category_id, enabled) VALUES ("Vicious Ring of Earth", 8, 1);

/* Orders */
INSERT INTO `orders` (item_options, item_type, item_level, observation, enabled, item_id, user_id, created) VALUES ("Full Options", 'Excellent', 13, 'Puedo pagar wc', 1, 1, 1, now());
INSERT INTO `orders` (item_options, item_type, item_level, observation, enabled, item_id, user_id, created) VALUES (null, null, 0, 'Puedo pagar wc', 1, 2, 2, now());
INSERT INTO `orders` (item_options, item_type, item_level, observation, enabled, item_id, user_id, created) VALUES (null, null, 13, 'Para el CS', 0, 3, 1, now());
INSERT INTO `orders` (item_options, item_type, item_level, observation, enabled, item_id, user_id, created) VALUES ("Full Options", 'Excellent', 13, 'Para el fin de semana', 1, 4, 2, now());
INSERT INTO `orders` (item_options, item_type, item_level, observation, enabled, item_id, user_id, created) VALUES ("Full Options", null, 0, 'Para el Domingo', 1, 5, 1, now());
INSERT INTO `orders` (item_options, item_type, item_level, observation, enabled, item_id, user_id, created) VALUES ("Full Options", 'Excellent', 13, 'Para Mañana', 0, 6, 2, now());
INSERT INTO `orders` (item_options, item_type, item_level, observation, enabled, item_id, user_id, created) VALUES ("Full Options", null, 13, 'Para Mañana', 1, 7, 1, now());
INSERT INTO `orders` (item_options, item_type, item_level, observation, enabled, item_id, user_id, created) VALUES ("Full Options", 'Excellent', 0, 'Para Mañana', 1, 8, 2, now());
INSERT INTO `orders` (item_options, item_type, item_level, observation, enabled, item_id, user_id, created) VALUES ("Full Options", 'Normal', 13, 'Para Mañana', 0, 9, 1, now());
INSERT INTO `orders` (item_options, item_type, item_level, observation, enabled, item_id, user_id, created) VALUES ("Full Options", 'Excellent', 13, 'Para hoy', 1, 10, 2, now());
INSERT INTO `orders` (item_options, item_type, item_level, observation, enabled, item_id, user_id, created) VALUES ("Full Options", 'Excellent', 13, 'Me mandan un mensaje a +51 911222111', 1, 11, 1, now());
INSERT INTO `orders` (item_options, item_type, item_level, observation, enabled, item_id, user_id, created) VALUES ("Full Options", 'Excellent', 0, 'Para el CS', 0, 12, 2, now());
INSERT INTO `orders` (item_options, item_type, item_level, observation, enabled, item_id, user_id, created) VALUES ("Full Options", 'Excellent', 13, 'Para el CS', 1, 13, 1, now());
INSERT INTO `orders` (item_options, item_type, item_level, observation, enabled, item_id, user_id, created) VALUES ("Full Options", 'Excellent', 0, 'Para el CS', 1, 14, 2, now());
INSERT INTO `orders` (item_options, item_type, item_level, observation, enabled, item_id, user_id, created) VALUES ("Full Options", 'Excellent', 13, 'Para el CS', 0, 15, 1, now());
INSERT INTO `orders` (item_options, item_type, item_level, observation, enabled, item_id, user_id, created) VALUES ("Full Options", 'Excellent', 13, 'Doy 500 WC', 1, 16, 2, now());
INSERT INTO `orders` (item_options, item_type, item_level, observation, enabled, item_id, user_id, created) VALUES ("Semi Full Options", 'Excellent', 13, 'Doy 500 WC', 1, 17, 1, now());
INSERT INTO `orders` (item_options, item_type, item_level, observation, enabled, item_id, user_id, created) VALUES ("Semi Full Options", 'Excellent', 0, 'Doy 500 WC', 0, 18, 2, now());
INSERT INTO `orders` (item_options, item_type, item_level, observation, enabled, item_id, user_id, created) VALUES ("Only Luck", 'Ancient', 0, 'Ando sin WC', 1, 19, 1, now());
INSERT INTO `orders` (item_options, item_type, item_level, observation, enabled, item_id, user_id, created) VALUES ("No Options", null, 0, null, 1, 20, 2, now());

/* Orders History */
INSERT INTO `orders_history` (mate_id, price, observation, order_id, created) VALUES (2, '10k WC', 'Me rebajo el precio', 3, now());
INSERT INTO `orders_history` (mate_id, price, observation, order_id, created) VALUES (1, null, 'Me lo regalo', 6, now());
INSERT INTO `orders_history` (mate_id, price, observation, order_id, created) VALUES (2, null, 'Me lo regalo', 9, now());
INSERT INTO `orders_history` (mate_id, price, observation, order_id, created) VALUES (1, null, 'Me lo regalo', 12, now());
INSERT INTO `orders_history` (mate_id, price, observation, order_id, created) VALUES (2, '10k WC', 'Me rebajo el precio', 15, now());
INSERT INTO `orders_history` (mate_id, price, observation, order_id, created) VALUES (1, '5k WC', null, 18, now());