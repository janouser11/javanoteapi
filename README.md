# Simple Note Api

This project is hosted at [https://safe-inlet-97630.herokuapp.com/api/notes](https://safe-inlet-97630.herokuapp.com/api/notes). Please be patient while it fires up for the first time.

A react front end application connected to this api can be found at [https://thawing-sea-27868.herokuapp.com/](https://thawing-sea-27868.herokuapp.com/).

The repo for the front end app is [here](https://github.com/janouser11/noteapp)

## To run locally

If maven is not installed, you can install it following the steps [here](http://blog.netgloo.com/2014/08/14/installing-maven-on-mac-os-x-without-homebrew/) or [here](https://maven.apache.org/install.html).

In the project directory, you can run: `mvn clean & mvn package & java -jar target\note-rest-service-0.1.0.jar` which will then build the project. You can find it at [http://localhost:8080/api/notes](http://localhost:8080/api/notes).

### Endpoints

Get all notes </br>
GET `/api/notes`</br>
`curl -i -H "Content-Type: application/json" -X GET http://localhost:8080/api/notes`

Create a new note</br>
POST `/api/notes`</br>
`curl -i -H "Content-Type: application/json" -X POST -d '{"body" : "Pick up milk!"}' h ttp://localhost/api/notes`

Get a specific note</br>
GET `/api/notes/{id}`</br>
`curl -i -H "Content-Type: application/json" -X GET http://localhost/api/notes/1`

Search all notes by text in their bodies</br>
GET `/api/notes/?query=text-to-search-for`</br>
`curl -i -H "Content-Type: application/json" -X GET http://localhost/api/notes?query=text-to-search-for`
