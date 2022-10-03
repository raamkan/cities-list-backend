# cities-list-backend


Steps to build and deploy application in local

1. clone project into your workspace
2. run command -> gradle clean build
3. go to CityListApplication and run the application



Mysql database is used as data store. Mysql is dployed on AWS cloud

CREATE TABLE cities (
id INT NOT NULL AUTO_INCREMENT,
name VARCHAR(128) NOT NULL,
city_img TEXT NOT NULL,
PRIMARY KEY (id)
);



create table city_list_app.user_auth(
user_id INT NOT NULL,
username VARCHAR(128) NOT NULL,
password VARCHAR(255) NOT NULL,
role VARCHAR(255) NOT NULL,
PRIMARY KEY (user_id)
);


//
DataSource configuration
spring.datasource.url=jdbc:mysql://database-1.ctvubetyhxjl.us-east-1.rds.amazonaws.com:3306/city_list_app
spring.datasource.username=admin



Spring DATA JPA -> used for mysql communication.

Spring Security -> is used for Roles based authorization.


//       TEST           //
Repository level testcases are written for the coverage.




