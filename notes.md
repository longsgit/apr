### ToDo

* Transactions
* Paging using spring data REST
* ConfigMaps in k8s
* openapi/swagger with spring boot 3.0 (*Done*)
* Handle deserialization exception in kafka (*Need to get it working*)
* Process a stream of messages in kafka
* @Valid in Quarkus


### Topics

* Core Java
* Spring framework basics
* Spring boot basics
* Spring boot with database
* JDBC, ORM
* REST API
* Inter service Communication
* MongoDB
* Kafka
* Docker (images, volumes, env variables)
* Kubernetes (cluster, pods, services, deployments,)
* Unit testing; Mock objects
* Spring security
* API Gateways
* Basics of microservices architecture; patterns and challenges
* Introduction to Quarkus


## Basics

* All you need is JDK to get started working with Java applications
* JDK contains the core libraries and the tools like compiler, runtime engine etc
* Latest version is 20. You have a release every 6 months	
* the bin folder contains javac, jar, java
* **javac** is the java compiler
* **java** is the execution engine
* complete OO language; case sensitive; statically typed language
* Java code is stored in .java files
* Execution starts from a main method. **public static void main**

```
> javac Hello.java
> java Hello
```

* .class files contain bytecodes. JVM executes the .class files

* **.NET languages**: C#, VB.NET, F#
* **JVM languages**: Java, Groovy, Scala, Kotlin
* **IDE**: Eclipse, Intelli J, NetBeans, Visual Studio Code


### Day 01 recap

* Maven or Gradle
* Data types; Primitive and Reference types
* String -> Immutable
* For string manipulation use StringBuilder instead
* Arrays; syntax is a bit flexible; you can write your square brackets in a number of places


### OO concepts

* Java beans (or POJO); private variables; public getter/setter methods; public methods
* constructor, method overloading
* static or shared members; static members can be accessed using class name or object reference also(not possible in C#)
* default is package-friendly; private, protected, public
* Every .java file can contain any number of classes (not recommended)
* Every .java file can contain only one public class. or each public class should match the name of the .java file
* extends keyword used for inheritance; overriding is straightforward; no keywords required; redefine the method in the super class without changing the signature
* final keyword on methods, prevent overriding; on classes prevent inheritance
* abstract keyword to define abstract classes;

### Day 03

* Generics; Generic Types
* Generics in Java is a compile time technique (or gimmick)
* java.util package contains collection classes; List, Set, Map
* Enums; enum keyword; you can have constructors, methods, variables in an enum
* Lambdas are expressions representing an anonymous inner class
* It is a shortcut implementation of functional interfaces ie., interface with just ONE abstract method
* @FunctionalInterface can be used to mark an interface as a functional interface

### Streams

* Built-in Functional interfaces 
* Predicate, Function, Supplier, Consumer
* **java.util.function** package
* Stream API
* Create a stream on a collection and process the items sequentially
* .stream() is used
* Streams cannot be reused; filter, map, forEach(you don't need a stream)
* A stream processes one item at a time. Takes the item through various stages till the terminal statement
* Streams are lazily evaluated. Unless the terminal statement(get, forEach) is met, the streams are not evaluated
* collect, map, filter, skip, distinct, reduce

### Packages

* java library is organized into modules
* Each module is organized into packages
* base module which contains all the core packages
* **java.lang** package is imported by default in all our code
* You can build an application and have modules or packages as the high level grouping
* The deployable entity in java applications is a jar(most part of it)
* A **jar** file a collection of packages. It's like a zip file
* java.util, java.io, java.nio, java.sql, java.time, java.net, java.xml
* **java.util.concurrent** contains all the classes that can be used for building concurrent applications

### Spring framework

* JDK for the core libraries that you can use to build applications in Java
* Web applications, Messaging, Security, Web services, SOAP-based or RESTful style, XML, Email, Transactions, EJB
* JEE sdk (Java Enterprise Edition)
* Enterprise Java Beans (EJB) or **System.EnterpriseServices**


``` java
class Account {
	accountNumber, balance;
	void deposit(amount) {}
	void withdraw(amount) {}
	void transferFund(to, amount) {}	
}
```

* Object pooling 
* Transaction for transferFund
* Security for withdraw and transferFund
* EJB comes to the rescue. EJB is a way by which you can provide enterprise services like Object pooling, txn, security to the classes in your application
* EJB made the design of the code very complicated
* FOllow some rules while writing code
* Implements 2-3 interfaces; No constructors; No static methods; Should not throw RuntimeException; Should not have final variables;
* **Heavy-weight** container


* Enter spring framework
* POJO framework for building enterprise applications in Java
* Light-weight container
* It provides all the services that your application needs without asking to you to change the design 
* Technically Spring framework is a collection of jar files that you add to your classpath/build path
* **Dependency Injection**: Mechanism by which you avoid unneccessary creation and lookup code in your application
* latest version is 6.x
* Web apps, console applications, messaging applications, cron jobs


### Creating a spring application

* Create a Maven/Gradle project
* Add the spring dependency to pom.xml
* Create a configuration xml file in resources folder
* Configure component:scan and base package in the xml file
* **Create classes and mark them as @Component and auto wire them using @Autowired** --> except this, all other steps are mundane and can be automated
* Create a class with a main method
* Create ApplicationContext container and access the beans


### Spring boot

* It's an agile way of creating spring applications
* Spring boot is an abstraction of spring framework
* Spring boot is 3.x

### ApplicationContext

* All the components are instantiated during startup itself, whether you use it or not
* ApplicationContext is an active container
* It instantiates all the components during startup. So any exception can be caught during startup itself; Any performance impact, it's only during the startup and not afterwards
* **@Lazy** is used to defer the instantiation of the beans
* All the components are in **singleton** scope by default. ie., throughout your application there is only one instance of the bean created
* You can change the scope by using **@Scope** annotation
* Since all the beans are in singleton scope, you don't maintain user specific data inside a component. Most components are designed to be stateless or generic

### Jdbc with Spring

* Spring data Jdbc
* Autowire JdbcTemplate and use it for all the CRUD operations
* RowMapper, SimpleJdbcCall for stored procedures
* https://github.com/brettwooldridge/HikariCP
* **show status where variable_name="threads_connected";**

### ORM

* Spring boot uses **Hibernate** implementation of JPA by default
* Create Entity classes and map them with the tables
* *@Id, @Column, @Entity, @Table*
* Define a repository interface by specifying the Entity class and Primary Key type
* Spring boot generates a class that implements the repository during runtime
* You can define finder methods in the repository
* You can define custom methods but need to use @Query annotation and specify the query to resolve the method
* Queries can be written in JPQL or Native SQL
* **JPQL**; you query entity classes and variables
* You can have **@Modifying** queries update/delete. But you need to execute the method in a transactional context
* You can mark the methods as **@Transactional** to execute the code in a transaction


### REST API

* API refers to RESTful services or applications, these days  
* Adding Spring Web dependency
* Internally Spring MVC is the framework that's used to build the REST API
* Apache Tomcat is the server that's used by default

### Softwares

* Offset Explorer (Kafka UI Client)
* Lens (Similar to Docker Desktop, but it's for k8s)
* Have "Kubernetes" enabled in Docker Desktop. Go to settings/preferences and "Enable Kubernetes"


### Last week

* ORM -> @OneToMany, @ManyToOne, Lazy Fetching
* Spring profiles -> Environments
* application-dev.yml or application-qa.yml
* Pass -Dspring.profiles.active=dev while launching the application


### Spring MVC

* Heart of a spring boot web application is a **DispatcherServlet**
* It stands in the front, receives requests from users, dispatches the requests to controllers for processing; gets the response and sends it to the users
* Controllers or RestControllers
* @RestController returns data as response
* @Controller returns view information. The view has to be resolved to a concrete page(jsp or html or pdf or excel)
* You can use @Controller/View resolvers/templates/static folder when you want to develop a traditional web application

### Synchronous communication with other services

* Send a request, wait for the response
* **HttpClient** (Core Java 11), **RestTemplate**(maintainence mode), **WebClient**(*preferred*) classes can be used to communicate
* You can configure these classes as @Bean and autowire them instead of creating an instance every time

### Basic concepts about Kafka

* A kafka consumer is identified using the **group Id** it belongs.
* When a consumer application starts, it **polls** for messages every few ms
* Kafka internally maintains a map of consumer groups and their offsets. **Offset** refers to the last read message's index or position
* Consumer reads a **batch** of messages from the latest offset and processes them **sequentially**
* On processing every message an **acknowledgment** is sent to kafka. And kafka updates the offset for that consumer group
* Kafka delivers each message to a consumer group **EXACTLY ONCE**
* Kafka maintains the order very strictly (But partition plays a role in it)
* Serialization/Deserialization of payload. 
* Configure key-serializer/value-serializer for producing messages
* Configure key-deserializer/value-deserializer for consuming messages
* Handle deserialization errors, configure **ErrorHandlingDeserializer** which delegates to the actual Deserializer

### Kafka Cloud streams

* Cloud streams library to talk to any MoM
* Code is MoM agnostic
* Spring cloud stream/ cloud stream binder for kafka/rabbitmq/solace
* **StreamBridge** to publish messages; Similar to **KafkaTemplate**
* FI  **Consumer<T>** to consume messages; similar t**o @KafkaListener**
* In the yml file, configure various bindings; bindings follow a pattern *-in-* or *-out-*
* Refer to the binding name in the code
* Handle deserialization errors, configure **ErrorHandlingDeserializer** which delegates to the actual Deserializer


### Maven project structure

* Define a parent project
* Have all the basic dependencies, java version configured
* Package it as **pom**
* Run **install**
* Refer to the parent in every other project by using the **<parent></parent>** configuration
	

### Unit testing

* JUnit 5 (**Jupiter**)
* Mockito





















