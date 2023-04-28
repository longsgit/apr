### Spring boot Lab07

### In Kafka

* Create a **movie-topic**
* You will use the following payload 
```
{
 "title": "Spectre",
 "year": 2012,
 "error": false
}
```

* Use Offset Explorer and publish the message to movie-topic. Add the header with key 

```
__TypeId__
```

* and value as the name of the class (*eg., com.xyz.model.Movie*)


### MongoDB

* Create a training DB
* Create two collections **movies** and **movies-errors**

### Movie details fetcher

* Create a spring boot project __spring-boot-lab07-__ which is a Kafka consumer application
* This consumer listens to __movie_topic___
* It reads the message and stores it in a collection in mongo(*training DB; movies collection*)
* If the payload has **error true** throw a RuntimeException; or if mongo db is not reachable
*  retry 3 times, and have another listener to store the message along with the error in a collection in mongo(**training DB; movie-errors collection**)



