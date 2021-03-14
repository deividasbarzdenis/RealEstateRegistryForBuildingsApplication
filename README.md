#Backend for a Real Estate Registry For Building App

This is a Java Maven project that has backend features and the REST API, an application for Real Estate Registry For Building.

The project is developed using spring boot as the backend service, react as the frontend application and H2 as the database.

The backend was implemented with Spring Boot, the web server running is Tomcat and database runs on H2.

This project has all REST endpoints required for the frontend project real_estate_registry_for_buildings-react to run.

##Table of Contents
* Running the Application
* Front end code
* H2 Console
* Screenshots

##Running the Application
Run Spring boot
~~~~
mvn clean spring-boot:run
~~~~
Run React app
~~~~
npm install
npm start
~~~~
Frontend URLFrontend URL
~~~~
http://localhost:3000/
~~~~
Documentation API (Swagger) by accessing
~~~~
http://localhost:8080/swagger-ui.html
~~~~
##Front end code
React Application - Import https://github.com/deividasbarzdenis/real_estate_registry_for_buildings-react
##H2 Console
http://localhost:8080/h2
Use jdbc:h2:mem:building as JDBC URL
##Screenshots
