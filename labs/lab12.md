* Work with the __movies.txt__ file in the repo
* For each movie you have to connect to the following site __**http://www.omdbapi.com/?i=tt3896198&apikey=52d1c7f**__ and store the year of release, genre and language details in DB
* For example, if you want information about __Spectre__ movie use this URL http://www.omdbapi.com/?i=tt3896198&apikey=52d1c7f&t=Spectre

* Design using **parallel streams** to load the movies and invoke the URLs
* Print those movie names, whose details you are not able to fetch, on the console.

* Use any HTTP and Json library of your choice (__You need to configure Maven dependency for this__)
* You can also use plain __UrlConnection__ class
* You can use the following code to connect to an external service

``` java
		HttpRequest req = HttpRequest
					.newBuilder(new URI("url"))
					.GET()
					.build();
		HttpResponse<String> response = HttpClient.newBuilder().build().send(req, HttpResponse.BodyHandlers.ofString());
		String result = response.body();
```

* Create a **movies** table in training DB
* You can use title, year, genre, language columns