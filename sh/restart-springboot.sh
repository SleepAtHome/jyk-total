source /etc/profile
killall java
nohup java -jar /appdata/jyk-total.jar > nohup.log 2>&1 &

## command: sh /appdata/jykOperate/restart-springboot.sh