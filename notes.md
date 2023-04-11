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









