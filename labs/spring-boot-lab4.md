* You will implement topic/session planner lab implemented in lab03 using **REST**

* Create a new Spring boot project **spring-boot-lab04-rest-api-jpa**
* Add **Web, JPA, MySQLDriver, Lombok** dependencies

* Create a table __topics__ in __training__ database with the following fields
* __id__ int(primary key, auto increment), __title__(varchar) and __duration__ (number)

<br/>

<br/>

* Define Entity class for topics table
* Define the repository for Topic
* Implement a __ConferenceService__ class that uses __TopicsDao__

``` java 

public class ConferenceService {
	
	public void addTopic(String title, int duration) {
		//Do not allow duplicate topics
		//Throw TopicFoundException if the topic exists
	}
	
	public List<Topic> getAllTopics() {
	
	} 
	
	public void removeTopic(String title) {
		//Throw TopicNotFoundException if the topic doesn't exist
		//Mark the method as @Transactional if you plan to use a delete query
	}
	
	public void updateDuration(String title, int duration) {
		//Throw TopicNotFoundException if the topic doesn't exist
		//Mark the method as @Transactional if you plan to use a update query
	}
	
}
```

* Create a **ConferenceController** class
* Define endpoints to add, remove, update and get all topics like this

```
POST -> addTopic(Topic topic)
PATCH  -> updateDuration(Topic topic)
GET  -> allTopics()
DELETE -> removeTopic(String title)

```
* **Handle all exceptions** wherever required



* Inject __ConferenceService__ in Controller class

* Insert the following topics and check the operations

```
Functional programming with Erlang - 60 min
Scala Tricks - 45 min
Spring unit testing - 90 min
Unit testing JavaScript - 90 min
Concurrency on the JVM - 60 min
Goroutines - 45 min
RoR - 90 min
```