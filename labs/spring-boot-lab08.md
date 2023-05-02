### Spring boot Lab08

* Implement a producer and consumer using cloud-stream

* Add the following dependency after creating the projects (*lab08-producer-app, lab08-consumer-app*)

``` xml
<dependency>
	<groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-stream-binder-kafka</artifactId>
</dependency>
```

### lab08-producer-app

* Create a **movie-topic**
* You will use the following payload to post a movie information
```
{
 "title": "Spectre",
}
```

### lab08-consumer-app*

* This consumer listens to __movie_topic___
* It reads the message and prints on the console


