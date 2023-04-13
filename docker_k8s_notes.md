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
docker run --name hl-mysql-day06  -p3306:3306 -v<host_volume_folder>:/var/lib/mysql   -e MYSQL_ROOT_PASSWORD=root mysql:latest
```
















