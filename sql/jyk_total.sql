CREATE TABLE IF NOT EXISTS `user` (
		id INT AUTO_INCREMENT PRIMARY KEY,
		`name` VARCHAR ( 50 ) NOT NULL,
		age INT,
		email VARCHAR ( 100 ),
		create_by VARCHAR ( 50 ) NOT NULL,
		create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
		update_by VARCHAR ( 50 ) NOT NULL,
		update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4;

CREATE TABLE IF NOT EXISTS `dish` (
		id INT AUTO_INCREMENT PRIMARY KEY,
		dish_name VARCHAR ( 50 ) NOT NULL,
		food VARCHAR ( 100 ) NOT NULL,
		seasoning VARCHAR ( 100 ) NOT NULL,
		chief VARCHAR ( 50 ) NOT NULL,
		price INT,
		create_by VARCHAR ( 50 ) NOT NULL,
		create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
		update_by VARCHAR ( 50 ) NOT NULL,
		update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4;

CREATE TABLE IF NOT EXISTS `food` (
		id INT AUTO_INCREMENT PRIMARY KEY,
		food_name VARCHAR ( 50 ) NOT NULL,
		create_by VARCHAR ( 50 ) NOT NULL,
		create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
		update_by VARCHAR ( 50 ) NOT NULL,
		update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4;

CREATE TABLE IF NOT EXISTS `seasoning` (
		id INT AUTO_INCREMENT PRIMARY KEY,
		seasoning_name VARCHAR ( 50 ) NOT NULL,
		create_by VARCHAR ( 50 ) NOT NULL,
		create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
		update_by VARCHAR ( 50 ) NOT NULL,
		update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4;