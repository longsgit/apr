### Spring boot Lab05

* Create a new Empty project __spring-boot-lab05__ in IntelliJ

##### Application 01
* Create a Module __palindrome-api__ which is a spring boot web application
* It runs on **8080** 
* It has an endpoint that accepts a word and computes if the given word is a palindrome or not
* **Containerize it and run it**


##### Application 02

* Create a Module __word-play-api__ which is a spring boot web application 
* It runs on **8080**
* Implement an endpoint **http://localhost:8080/game/{word}** 
* This communicates with **palindrome-api** and tells you whether the word is a palindrome or not
* **Containerize it and run it**
* **Externalize the palindrome-api's host and port in ENV**


##### RestTemplate
* Talk to other services using **HttpClient** or  **RestTemplate** or __WebClient__ class provided by Spring
* If you want to use  RestTemplate/WebClient create an instance and call the methods on it. Refer to API documentation for RestTemplate or WebClient.
