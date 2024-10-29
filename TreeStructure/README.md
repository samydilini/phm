# PHM test

This project is set up to run with docker.
Prerequisites 
* gradle 8.11-rc-1
* docker

Running
- build files using gradle
`./gradlew clean build`

- build docker file
`docker build -t tree-structure .`

-start
`docker run --rm tree-structure`

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


