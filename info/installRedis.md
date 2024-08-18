## 安装Linux Redis 步骤

yum install redis
systemctl start redis
systemctl status redis

记得开通阿里云防火墙端口

redis-cli ping 确定Redis正在运行

试用Redis：
find / -name redis-cli

/usr/bin/redis-cli 进入客户端

可以使用了

修改Redis密码：
vim /etc/redis.conf

修改下面这一行
requirepass  123456

重启Redis
systemctl restart redis