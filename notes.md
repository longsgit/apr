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





























