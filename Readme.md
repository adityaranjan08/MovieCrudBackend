# Movie Project

## Table of contents

- [Movie Project](#attachment-service)
    - [Table of contents](#table-of-contents)
    - [Overview](#overview)
    - [Microservices](#overview)

# Overview
This is a simple Movie Application. The client will be able to register
himself on the database and after authorization he will be able to save his favourite movies list
and perform various  CRUD operations like [ADD,DELETE,UPDATE,GET] on the movie list .

In this Project the client sends request to the microservices through the httpRequest and the the 
request is then handled by the api-gateway . from the api-gateway the request is sent to the subsequent microservices. 
the request then follows the eureka server for checking on which port the microservices are running . After that the particular 
request travels through the controller then service to repository layer where the crud operation happens to the database 
and then the response is sent back to the service layer to the controller and finally to the client.




# Microservices
### GatewayServer
     - The API Gateway is primarily responsible for request routing. The Gateway intercepts all requests from clients. It then routes the requests to the appropriate microservice.
     - An API gateway is an API management tool that sits between a client and a collection of backend services.
     - An API gateway acts as a reverse proxy to accept all application programming interface (API) calls, aggregate the various services required to fulfill them, and return the appropriate result
     - Api Gateway acts as load balancing between backend services



### EurekaServer
     - It is a part of spring cloud project and it helps micro services find each other. 
     - It has the knowledge of the micro-service’s address (host name + port-number)
     - Eureka provides service discovery in a microservices architecture. 
     - Services registers themselves on the Eureka server and details like name, host, and port are stored there.
     - Details of other registered microservices become available for the registered service.
     


### userAuthService
      - userAuth service is basically responsible for the authorization purpose and generation of token after the successfull 
        authentication.



### userMovieService
       - userMovie Service is responsible for registering the users as well as storing the favourite 
        movies of that particular user in a list. Further the user can do operation like add, delete, retrieve and update
        the list as per the need. 

      - Used Feign client for registering the user . Created a proxy interface 'user' to make 
        outbound API calls to the userAuth service .

      - Feign Client enables synchronous communication of one microservice to another, which are registered on 
       our Discovery Server using a service name.
