# DataBase-II-Project
Aplikacja do organizacji turniejów piłkarskich

### Technologie:  
- MongoDB
- Scala Play Framework
- sbt
- Java 11
- Express Node.js
- Docker

### Skład :
- Skowron Mateusz
- Strojewski Jakub
- Wójcik Michał

# [Documentation Here](Documentation.pdf)

### Setup:
Po pobraniu projektu wypakowujemy go. Na początku przechodzimy do serwera - w pliku .env uzupełniamy stosowne dane dostępowe do bazy:
```
$ cd DataBase-II-Project-main/server
$ nano .env
```
Następnie za pomocą platformy Docker budujemy obraz i uruchamiamy go:
```
$ docker build -t server .
$ docker run -p 3001:3001 server
```
W tym momencie możemy zbudować aplikację webową - otwieramy drugi terminal i wpisujemy poniższe polecenia. 
```
$ cd ../webapp/target/docker/stage
$ docker build -t webapp .
$ docker run --network=host -p 9000:9000 webapp
```
Wpisujemy w przeglądarce http://localhost:9000 i możemy korzystać z platformy :))
