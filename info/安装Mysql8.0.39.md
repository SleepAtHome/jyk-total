## Mysql
版本8.0.39社区版 先安装Windows版本，在本地 <br>
下载地址：https://dev.mysql.com/downloads/mysql/<br>

Windows版本安装步骤：
1. 加环境变量： D:\source\mysql-8.0.39-winx64\bin
2. 创建D:\source\mysql-8.0.39-winx64\my.ini文件

```` my.ini文件
[mysqld]
# 设置3306端口
port=3306
# 设置mysql的安装目录   ----------是你的文件路径-------------
basedir=D:\\source\mysql-8.0.39-winx64
# 设置mysql数据库的数据的存放目录  ---------是你的文件路径data文件夹自行创建
datadir=D:\\source\mysql-8.0.39-winx64\data
# 允许最大连接数
max_connections=200
# 允许连接失败的次数。
max_connect_errors=10
# 服务端使用的字符集默认为utf8mb4
character-set-server=utf8mb4
# 创建新表时将使用的默认存储引擎
default-storage-engine=INNODB
# 默认使用“caching_sha2_password”插件认证
authentication_policy=caching_sha2_password
[mysql]
# 设置mysql客户端默认字符集
default-character-set=utf8mb4
[client]
# 设置mysql客户端连接服务端时默认使用的端口
port=3306
default-character-set=utf8mb4
````

3. 在D:\source\mysql-8.0.39-winx64\bin中打开powershell(需要管理员打开)
4. 执行命令：mysqld --initialize --console(创建mysql并获取初始密码)

````
PS D:\source\mysql-8.0.39-winx64\bin> mysqld --initialize --console
2024-07-27T11:17:47.951071Z 0 [System] [MY-013169] [Server] D:\source\mysql-8.0.39-winx64\bin\mysqld.exe (mysqld 8.0.39) initializing of server in progress as process 25456
2024-07-27T11:17:47.975089Z 1 [System] [MY-013576] [InnoDB] InnoDB initialization has started.
2024-07-27T11:17:48.298692Z 1 [System] [MY-013577] [InnoDB] InnoDB initialization has ended.
2024-07-27T11:17:52.203396Z 6 [Note] [MY-010454] [Server] A temporary password is generated for root@localhost: FGV0X7ph*V3e
````
5. 执行命令：mysqld --install mysql
6. 执行命令：net start mysql

````
PS D:\source\mysql-8.0.39-winx64> mysqld --install mysql
Service successfully installed.

PS D:\source\mysql-8.0.39-winx64> net start mysql
mysql 服务正在启动 .
mysql 服务已经启动成功。

PS D:\source\mysql-8.0.39-winx64>
````
7. 连接Mysql：mysql -uroot -p （使用刚才第一步获取的密码）
````
PS D:\source\mysql-8.0.39-winx64> mysql -uroot -p
Enter password: ************
Welcome to the MySQL monitor.  Commands end with ; or \g.
Your MySQL connection id is 9
Server version: 8.0.39

Copyright (c) 2000, 2024, Oracle and/or its affiliates.

Oracle is a registered trademark of Oracle Corporation and/or its
affiliates. Other names may be trademarks of their respective
owners.

Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

mysql>
````
8. 修改root密码：ALTER USER 'root'@'localhost' IDENTIFIED BY '新密码';(MySQL 8.0及以上版本)

````
mysql> ALTER USER 'root'@'localhost' IDENTIFIED BY 'Dwxxls@2024';
Query OK, 0 rows affected (0.01 sec)

mysql> quit
````

9. 退出Mysql客户端