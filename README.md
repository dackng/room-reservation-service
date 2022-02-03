# Technical test

This simple project is to support meeting room reservation inside a company


# Topics

- H2 database
- Maven
- Unit tests
- Validations
- Swagger
- SpringBoot

## Installation and deployment
Run the following commands:

`mvn clean` 
`mvn install` 
`mvn spring-boot:run` 

This is the Swagger:

`http://localhost:8080/swagger-ui.html` 

## API Endpoints
Also there is a JSON file `room-reservation-service.postman_collection.json` to import in Postman

- GET: Getting all reservations by date

`http://localhost:8080/api/v1/reservation` 

- POST: Creating reservation and also there is a request with values into JSON file

`http://localhost:8080/api/v1/reservation` 

- GET: Getting all rooms available

`http://localhost:8080/api/v1/room` 
