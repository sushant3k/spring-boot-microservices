# spring-boot-microservices
A barebone tutorial on how to spring boot microservices using Neflix stack

## Discovery Service

eureka-discovery-server project is a sample implementation of discovery service provided by Netflix Eureka

## Proxy Service

Zuul-proxy service is a sample implementation of zuul proxy service provided by Netflix. 

## Microservices

### customer-management

Customer management is one microservice that is discoverable via Eureka and can be accessed through Zuul Proxy

### user-management

User management is one microservice that is discoverable via Eureka and can be accessed through Zuul Proxy. This service uses eureka discovery to discover customer management and invokes one of its end points using Feign Client. 

The service also uses circuit breaker if the customer-management endpoint is not accessible. 

## configServer

This is a remote config server (native) implemented using spring cloud config and is used for remote configuration management for different microservices. 

## configFiles

Directory that stores different configuration files. 

## build

Stores docker compose files. Two files reflect 2 VMs on which different containers are hosted. One service is hosted on one container. 


