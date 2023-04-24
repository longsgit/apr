* Set up Docker Desktop
* You get all the tools needed to work with Docker
* Two main components; **Docker Engine(Server)** and **Docker Client**
* Docker( and kubernetes) is build using **Golang** known for high concurrency

```
docker version
```

* Docker is used create containers
* A container is a Linux box with a particular software application installed and running inside
* MySQL container; Couchbase Container; herbalife-api container
* It means, you have a linux os running in your machine which has Mysql installed and configured

### How do you set up a container

* In OO, how do you create objects?
* You define a class and instantiate the class using **new** keyword

* **Image** is like a class
* **Container** is like an Object
* You create an Image and run or instantiate the image to create containers
* All the images are usually present in **hub.docker.com**

### Set up MySQL

```
docker pull mysql:latest
docker run --name hl-mysql-day06  -p3306:3306 -e MYSQL_ROOT_PASSWORD=root mysql:latest
```

#### Configure volumes

```
docker run --name hl-mysql-day06  -p3306:3306 -v<folder_in_host_machine>:/var/lib/mysql   -e MYSQL_ROOT_PASSWORD=root mysql:latest
```

```
docker run --name hl-mysql-day06  -p3306:3306 -vC:/data:/var/lib/mysql   -e MYSQL_ROOT_PASSWORD=root mysql:latest
```


### Dockerizing Spring boot REST

``` Dockerfile
FROM openjdk:17
COPY target/yourjarFile.jar app.jar
#EXPOSE is not mandatory; It helps if you run from Docker Desktop UI
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]
```

* Bundle the image

```
docker build -t my-api:0.0.1 .
```

* This command looks for **Dockerfile** in the current folder
* If you have a docker file named as **Dockerfile-dev**

```
docker build -t my-api:0.0.1 -f ./Dockerfile-dev
```

* Run the image

```
docker run --name nameOfTheImage -phost:container my-api:0.0.1
```


### Environment variables

``` Dockerfile
FROM openjdk:17
COPY target/yourjarFile.jar app.jar
EXPOSE 8080
ENV WELCOME "Default Welcome"
ENTRYPOINT ["java", "-jar", "-Dwelcome=${WELCOME}", "/app.jar"]
```

```
docker run --name nameOfTheImage -phost:container -e WELCOME="Welcome to Spring" my-api:0.0.1
```

### docker compose

* Configure yml file and list all the services and run them at one shot

```
docker-compose -p lab05 up -d
```

```
docker-compose -p lab05 down --rmi all
```








