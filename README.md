# DataBase-II-Project
Aplikacja do organizacji turniejów piłkarskich
### Technologie:  
- MongoDB
- Scala Play Framework
- sbt
- Java 11
- Express Node.js
### Skład :
- Skowron Mateusz
- Strojewski Jakub
- Wójcik Michał
# [Documentation Here](Documentation.pdf)

### Setup:
Po pobraniu projektu wypakowujemy go. Na początku przechodzimy do serwera - w pliku .env uzupełniamy stosowne dane dostępowe do bazy:
```
$ cd DataBase-II-Project-main/folder
$ nano .env
```
Następnie ściągamy odpowiednie zależności i uruchamiamy serwer:
```
$ npm install
$ node app.js
```
W tym momencie możemy uruchomić aplikację - otwieramy drugi terminal i wpisujemy poniższe polecenia. Wymagany jest zainstalowany sbt - narzędzie do budowania prjektów w Scali i ustawiona Java 11 (niestety nowsze wersje nie współpracują z sbt)
```
$ cd ..
$ sbt run
```
