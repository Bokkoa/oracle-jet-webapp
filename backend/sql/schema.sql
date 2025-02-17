CREATE USER 'services'@'%' IDENTIFIED WITH mysql_native_password BY 'services12345';

GRANT ALL PRIVILEGES ON *.* TO 'services'@'%' WITH GRANT OPTION;

CREATE SCHEMA `services` DEFAULT CHARACTER SET utf8 ;
