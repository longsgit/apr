### Spring boot Lab06

* Create a new Empty project __spring-boot-lab06-kafka__ in IntelliJ

#####  Calculator

* Create a Module __calculator-api__ which is a spring boot web application
* It runs on **8080** 
* It has endpoints to square and increment numbers
<br/>

* The endpoints receive the number and post a message to a topic square_topic  or increment_topic


##### Calculator consumers

* Create a Module __calculator-db-consumer__ which is a Kafka consumer application
* This consumer listens to __square_topic_ or increment_topic and store it in a DB (*calculator-operations (id, number, operation)*)

<br/>

* Create a Module **calculator-result-consumer** which is a Kafka consumer application
* This consumer listens to __square_topic_ or increment_topic and computes the result and prints it to the console
