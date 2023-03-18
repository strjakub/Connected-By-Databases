# Connected by databases
Application for organizing football tournaments.

### Technology stack:  
- MongoDB
- Scala Play Framework
- sbt
- Java 11
- Express Node.js
- Docker

### Team :
- Skowron Mateusz
- Strojewski Jakub
- Wójcik Michał

# [Documentation](Documentation.pdf)

### Setup:
After downloading, unzip the project. At the beginning, we go to server's .env file and fill authentication data:
```
$ cd DataBase-II-Project-main/server
$ nano .env
```
Then using Docker platform we build the image and run it:
```
$ docker build -t server .
$ docker run -p 3001:3001 server
```
Now we can build our web app - we move to second terminal and pass the following commands:
```
$ cd ../webapp/target/docker/stage
$ docker build -t webapp .
$ docker run --network=host -p 9000:9000 webapp
```
Next we enter http://localhost:9000 and enjoy using the platform :)))
