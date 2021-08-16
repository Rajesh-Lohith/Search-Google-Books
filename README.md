# Search-Google-Books

This backend Java application is built using Java and Spring Boot. 

Tech-stack Used:

- Java
- Spring Boot
- Postgres
- Kafka
- Zoo Keeper
- Docker 
- Docker Compose
- Swagger

You can use this application to search books from Google_Books.

API calls will be made to Google_books API and the data retrieved will be saved in the DB. 

Data saving is done asynchronously with the help of Kafka. 

This applicationis containerized. 

--------------------------------------------------------------------

Steps to run the Application:

For Linux: 

- Goto project folder 
- run ./build.sh

To access the Swagger documentation:

- URL: http://localhost:8081/api/swagger-ui.html

--------------------------------------------------------------------

Pre-requisites: 

- Java 11
- Docker 
- Docker compose

--------------------------------------------------------------------

Potential features that can be added to this application:

--------------------------------------------------------------------

A user library can be created segregating the books by categorizing them in Fictions, Poetry, Technology, Romance etc...

Daily top list of the books can be shown to the users with the help of UI.

New releases can be shown to the users with the help of release dates. 

Best sellers and Top authors can be displayed to the end users. 

