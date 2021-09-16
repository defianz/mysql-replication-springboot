# https://velog.io/@max9106/DB-Spring-Replication 참고

# master 쪽 계정 생성 - 권한 부여
#CREATE USER 'defian'@'%' IDENTIFIED BY 'password';
#GRANT ALL PRIVILEGES ON *.* TO 'defian'@'%';
#flush privileges;
#quit;

# master status 확인
show master status;

# slave server - 마스터 설정
CHANGE MASTER TO MASTER_HOST='master', MASTER_PORT=3306, MASTER_USER='root', MASTER_PASSWORD='password', MASTER_LOG_FILE='binlog.000002',MASTER_LOG_POS=156;

# slave 실행
START SLAVE;

# slave 연결 확인
SHOW SLAVE STATUS\G;