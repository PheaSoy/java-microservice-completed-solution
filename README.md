# spring-microservice-completed
In this project, I am implementing the completed solution with MicroService by using Spring Frameworks.
## Services
* service-discovery: implementing by using `spring-cloud-starter-netflix-eureka-server` with given the service registry from the client microservice.
* spring-boot-oauth2: implementing by using spring-security-oauth2 that providing the authentication and authorization.
* spring-cloud-gateway: implementing by using spring-cloud-gateway that providing the gateway pattern with features such as routing, security,load balancing, RateLimit, Hystrix fallback when the microservice backend failed some cases.