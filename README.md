# Spring Boot multiple datasources

An example of Spring Boot, written in Kotlin, demonstrates how to use Hibernate with Kotlin as well as multiple datasources with the ability of creating tables of the datasources. And support for transaction in multiple datasources.

To understand more about the project read the following tutorials,

- [How to deal with Hibernate entities in Kotlin](https://geekyhacker.com/2019/09/30/how-to-deal-with-hibernate-entities-in-kotlin/)
- [Spring Boot connect to multiple datasources](https://geekyhacker.com/2019/10/05/spring-boot-connect-to-multiple-datasources/)

- [Spring transaction with multiple datasources](https://geekyhacker.com/2019/10/07/spring-transaction-with-multiple-datasources/)


## How to run

First need to start the databases (MySQL 8 and PostgreSQL 12) with `docker-compose`,

```bash
$ docker-compose up -d
```

Then run the project using `mvnw`,

```bash
$ ./mvnw spring-boot:run -Dserver.port=8090 
```

Lastly, open the browser and type `localhost:8090/swagger-ui.html`. 
You should see the Swagger interface to interact with the API.

## Tips

To change the database configurations modify `docker-compose.yml` and if necessary `application.properties`.  
