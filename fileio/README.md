# PHM test
This test is for File input test.
You will be guided by the prompts in the command line.

This project is set up to run with docker.
Prerequisites 
* gradle 8.11-rc-1
* docker

Running
- build files using gradle
`./gradlew clean build`

- build docker file
`docker build -t file_io .`

- start
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


