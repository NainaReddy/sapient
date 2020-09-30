# sapient
springboot 2.3.4 version
redis 2.4.5 version



1. Created springboot project using spring initialiser
2. Setup/install of mysql on windows and linked to the project ( given datasource url, username & password in application.properties) used hibernate jpa and added mysql connector in pom.xml
3. created database and created table using mysql workbench
4. on the directory of the project created as git repository using command 'git init'
5. created repository in github and copied the url. (https://www.5balloons.info/adding-a-new-spring-maven-project-from-eclipse-to-git-repobitbucket/) for reference
6. download redis from https://github.com/dmajkic/redis/downloads and started redis server using redis-server.exe (referred https://dzone.com/articles/implementation-of-redis-in-micro-servicespring-boo)
7. refer https://www.journaldev.com/18141/spring-boot-redis-cache for implementation

1. Read CSV file and map to entity used OpenCSV. Refer to https://www.geeksforgeeks.org/mapping-csv-to-javabeans-using-opencsv/
for creating csv fil refer: https://www.computerhope.com/issues/ch001356.htm
Last for swagger refer https://dzone.com/articles/spring-boot-restful-api-documentation-with-swagger