# Spring Boot multiple datasources

An example of Spring Boot, written in Kotlin, demonstrates how to use Hibernate with Kotlin as well as multiple datasources with the ability to create tables of the datasources and support for distributed transactions in multiple datasources.

To understand more about the project read the following tutorials,

- [How to deal with Hibernate entities in Kotlin](https://www.geekyhacker.com/how-to-deal-with-hibernate-entities-in-kotlin/)
- [Spring Boot connect to multiple datasources](https://www.geekyhacker.com/spring-boot-connect-to-multiple-datasources/)
- [Spring transaction with multiple datasources](https://www.geekyhacker.com/spring-transaction-with-multiple-datasources/)

## How to run

First, start the databases (MySQL 8 and PostgreSQL 15) with `docker-compose`,

```bash
$ docker-compose up -d
```

Then run the project using `mvnw`,

```bash
$ ./mvnw spring-boot:run -Dserver.port=8090 
```

Lastly, open the browser and type `http://localhost:8080/swagger-ui/index.html`. You should see the Swagger interface to interact with the API.

## Tips

To change the database configuration modify `docker-compose.yml` and if necessary `application.properties`.
