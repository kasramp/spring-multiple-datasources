# Spring Boot multiple datasources

An example of Spring Boot, written in Kotlin, demonstrates how to use multiple datasources with the ability of creating tables of the datasources.


## How to run

First need to start the databases (MySQL and PostgreSQL) with `docker-compose`,

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