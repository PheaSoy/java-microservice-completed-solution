# spring-microservice-completed
In this project, I am implementing the completed solution with MicroService by using Spring Frameworks.
## Services
* service-discovery: implementing by using `spring-cloud-starter-netflix-eureka-server` with given the service registry from the client microservice.
* spring-boot-oauth2: implementing by using spring-security-oauth2 that providing the authentication and authorization.
* spring-cloud-gateway: implementing by using `spring-cloud-starter-gateway` that providing the gateway pattern with features such as routing, security,load balancing, RateLimit, Hystrix fallback.
## Prerequisites
* Java8 or higher
* docker compose

## Getting Start
* Start all application by using docker-compose
``` docke-compose up```
* spring-cloud-gateway is running on port 8080
* service-discovery is running on port 8761
* song-service(bacend microservice) is running on port 8084
* spring-boot-oauth2 is running on port 8081
# spring-completed-microservice
