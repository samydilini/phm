# PHM test
This test is for File input output tests.
It has two parts.
 1. reading from a file with command line
 2. saving to a file using swing.
you can choose to do both from the command line

This project is set up to run with docker.
Prerequisites 
* gradle 8.11-rc-1
* docker

Running
- build files using gradle
`./gradlew clean build`

- build docker file
`docker build -t file_io .`

-start
`docker run -it file_io`

Handy commands
-remove
`docker-compose down`
or 
`docker-compose down --rmi all`
or 
`docker-compose down --rmi all --volumes`

other supportive commands
docker volume prune -f
docker network prune -f  


