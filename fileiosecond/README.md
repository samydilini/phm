# PHM test
This test is for File output tests.
you can choose to do both from the command line
This is not set up in docker as there are graphical limitations for docker.
Path of the file can be found in gradle.properties.

Prerequisites 
* gradle 8.11-rc-1


Running
- build files using gradle
`./gradlew clean build`

- run
`./gradlew run`

-test

`./gradlew test`

Tech dept. Move the common code such as IoConfiguration to a common place and share it among the projects.

