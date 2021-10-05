"The microservice architecture is structured on the business domain and it's a collection 
of small autonomous services.
 
In a microservice architecture, all the components are self-contained and wrap up around 
a single business capability."

# Microservice architecture over Monolithic architecture

1. Visibility is high - MS Architecture provides better visibility to your services.
2. Improves resilience - Improves the resilience of our service network
3. Production time reduced - Reduce the delivery time from idea to final product.
4. Reduced cost - Reduce the overall cost of designing, implementing, and maintaining IT services.

# 7 principles in which the microservice architecture has been built.

1. Scalability
2. Flexibility
3. Independent and autonomous
4. Decentralized governance
5. Resiliency: The ability of the system to recover from the failure and remain functional.
6. Failure isolation.
7. Continuous delivery through the DevOps

#10 Essential Microservices patterns:
      Read more: https://javarevisited.blogspot.com/2021/09/microservices-design-patterns-principles.html#ixzz77mtOptLI

1. Circuit Braker.

    - Is the solution for the failure of remote calls or the hang without a response until some timeout limit is reached.
    - iIprove the fault tolerance and resilience of the ms architecture and also prevent the cascading of failure to other microservices.                                                                      
                                                                        
2. Database per microservices.

    - The concept is straightforward. There is a data store for each microservice (whole schema or a table). 
    Other services are unable to access data repositories that they do not control. 
    A solution like this has a lot of advantages.
      It is easy to scale.
      The microservice encapsulates the domain's data. 
      Understanding the service and its data as a whole is much easier. 
    - Shared Database is a anti-pattern, if that is a option consider Monolithic.
    
3. Event sourcing.

    - This pattern is based in the idea of any change in the entity should be captured by the system.
    - The event sourcing is responsible for giving a new ordered sequence of events.
    - the application state can be reconstructed by querying the database in offset order. 
    
4. CQRS.

    - Command: change the state of the object or entity
    - Query: return the state of the entity and wont change anything.
    - The pattern resolve risk of data contention, perfomance and security.
    - The complexity of the system is reduced as the query models and commands are separated.
      
5. BFF.

    - This is a big improvement in microservice architecture as this allows to isolate the backend of the application from the frontend.
    - Decouple the front-end apps from the backend architecture.
    - This pattern apply for a scenario where mobile app, web app and external apis needs to communicate with the backend services
      in a microservices architecture.
    - React, Angular are popular frameworks.
        
6. API Gateway.

    - the scenario is when large application with multiple clients and it is responsible for giving a single entry point to ms.
    - API Gateway sits between client apps and ms and it serves as a reverse proxy, forwarding client requests to services.
    - Authentication, SSL termination, Caching, Tracing are other component it can provide.
    
7. Strangler.
    - incrementally transform your monolithic application to microservices by replacing old functionality with a new service.
      
8. Externalize configuration.

    - Often services need to be run in different environments. Environment-specific configuration is required, such as secret keys, 
      database credentials, and so on. Changing the service for each environment has a number of drawbacks. So how we can enable a 
      service to run in multiple environments without modification?
    - annotations: @EnableConfigServer  
     
9. Consumer-driven contract tracing.

    - 

10. Saga.

     - SAGA is one of the best solutions to keep consistency with data in distributed architecture without 
       having the ACID principles. SAGA is responsible for committing multiple transactions by giving rollback opportunities.
     - 2 types of SAGA ( Choreagraphy & Orchestration).
     - implementation is dificult , some times is necesary to use Distributed queue brokers.
     
11. Bulkhead.     

## REST & SOA

Services Oriented Architecture (SOA) is the unbrella.
web servcies is a SOA using web-related technologie.REST and its subset RESTful area set of
practices to implement web services. Finally microservices are a new set of SOA.

SOA : architectures designed with a focus on services
Web services: is a subset of SOA -- revolves around using HTTP protocols
REST: architectural style or HTTP based interfaces that use HTTP endpoint to invoke actions or query data.
Microservices: promotes implementing apps as a set of simple independent deployable services.


## HTTP GET, POST & PUT

GET: query resource,visible at address line, for setting on website (filters, sorting, search engine).Easy to bookmarck (caching, proxy)
POST: save resource,invisible to user, for submit information.It is secure, get input from request body, parameters are not saved in browser history.
PUT: update resource.
