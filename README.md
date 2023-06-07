## Getting Started Install SurveyBox API

### Reference Documentation

SurveyBox is a software system service which created in 2023 by Institute of Science and Technology Advanced Development students

### Requirement
***
* Java version 17 or latest
* postgesql 14 up
***


### Installation

after clone this project run command below
```
cp application.properties.txt application.properties
```

### Connection Database
Check the file ```application.properties``` and create database name ``` surveybox_db ```
```
spring.datasource.driverClassName=org.postgresql.Driver
spring.datasource.url=jdbc:postgresql://localhost:5432/surveybox_db
spring.datasource.username=postgres
spring.datasource.password=
```
