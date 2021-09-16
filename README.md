# Mysql replication with SpringBoot
> Mysql replication 을 통해 Master - Slave 구성하여, SpringBoot의 transaction 요청을 분개하여 처리
- Docker, mysql, SpringBoot

## mysql 실행
```
# cd mysql-replication
# docker-compose up -d 

# docker exec -it master bash 
root@master \# mysql -u root -p 
root@master \# show master status; 
root@master \# exit;

# docker exec -it slave bash
root@slave \# mysql -u root -p
root@slave \# CHANGE MASTER TO MASTER_HOST='master', MASTER_PORT=3306, MASTER_USER='root', MASTER_PASSWORD='password', MASTER_LOG_FILE='binlog.000002',MASTER_LOG_POS=156; 
root@slave \# START SLAVE; 
root@slave \# SHOW SLAVE STATUS\G; 
```
<br>

## SpringBoot 실행
boot-application 폴더 import 후, 실행
- Maven, SpringBoot 2.5.4



> 참고 : https://velog.io/@max9106/DB-Spring-Replication
