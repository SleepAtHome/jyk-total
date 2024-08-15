CREATE TABLE IF NOT EXISTS `user` (
		id INT AUTO_INCREMENT PRIMARY KEY,
		account VARCHAR ( 50 ) UNIQUE NOT NULL,
		`password` VARCHAR ( 50 ) NOT NULL,
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
		img_dir VARCHAR ( 100 ),
		img_name VARCHAR ( 50 ),
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

CREATE TABLE IF NOT EXISTS `check_list_day` (
		id INT AUTO_INCREMENT PRIMARY KEY COMMENT '主键id',
		user_id INT COMMENT '用户id',
		matter VARCHAR ( 50 )  NOT NULL COMMENT '事项',
		frequency INT COMMENT '频率',
		finished INT DEFAULT 0 COMMENT '是否完成 完成-1 未完成-0',
		progress INT DEFAULT 0 COMMENT '完成进度 0-100 100为完成',
		create_by VARCHAR ( 50 ) NOT NULL,
		create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
		update_by VARCHAR ( 50 ) NOT NULL,
		update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4;

CREATE TABLE IF NOT EXISTS `check_list_record` (
		id INT AUTO_INCREMENT PRIMARY KEY COMMENT '主键id',
		user_id INT NOT NULL COMMENT '用户id',
		matter_id INT NOT NULL COMMENT '清单表id',
		check_list_type INT NOT NULL COMMENT '清单类型，对应清单表后缀 1-day 2-week 3-month 4-year',
		matter_start_time TIMESTAMP COMMENT '事项开始时间',
		matter_finish_time TIMESTAMP COMMENT '事项完成时间',
		finished INT DEFAULT 0 COMMENT '是否完成 完成-1 未完成-0',
		progress INT DEFAULT 0 COMMENT '完成进度 0-100 100为完成',
		memo VARCHAR ( 200 )  COMMENT '备注',
		weight INT default 9 COMMENT '权重 0-9 0最重要',
		create_by VARCHAR ( 50 ) NOT NULL,
		create_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
		update_by VARCHAR ( 50 ) NOT NULL,
		update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
) ENGINE = INNODB DEFAULT CHARSET = utf8mb4;

INSERT INTO `jyk_total`.`user`(`id`, `account`, `password`, `name`, `age`, `email`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (1, 'jyk', 'jyk', '景元奎', 28, '773669388@qq.com', 'jyk', '2024-07-27 20:59:00', 'jyk', '2024-07-27 20:59:00');

INSERT INTO `jyk_total`.`dish`(`id`, `dish_name`, `food`, `seasoning`, `chief`, `price`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (1, '咸蛋黄豆腐虾仁', '1,2,3', '4,5', '景元奎', 30, 'jyk', '2024-07-28 00:52:55', 'jyk', '2024-07-28 00:52:55');
INSERT INTO `jyk_total`.`dish`(`id`, `dish_name`, `food`, `seasoning`, `chief`, `price`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (2, '炒白菜', '2,3', '4,5', '景元奎', 20, '景元奎', '2024-07-28 01:30:33', '景元奎', '2024-07-28 01:30:33');
INSERT INTO `jyk_total`.`dish`(`id`, `dish_name`, `food`, `seasoning`, `chief`, `price`, `create_by`, `create_time`, `update_by`, `update_time`) VALUES (3, '耗油生菜', '1', '2', 'Jing yk', 10, '景元奎', '2024-07-28 22:46:15', '景元奎', '2024-07-28 22:46:15');
