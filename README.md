# Customer Rest API
# Customer Information Management

### Technologies
This service was developed for the Java platform using the Spring framework as support. Below is a list of the tools used:

* [Spring Boot - 2.1.8.RELEASE]
* [Java 1.8]
* [H2 Database - In Runtime Memory]
* [Swagger-UI]
* [Spring Security]
* [Spring Data]
* [Git]

### Development Environment

* [Windows 10]
* [JDK 1.8]
* [Visual Studio Code]
* [Spring Tools Suite]
* [BitBucket - Code Repository]
* [Git bash]
* [Google Chrome]
* [Postman]

### Installation
##### requirement:
* Java 1.8
* Maven

First! Download the project
git clone git clone https://aemelendezf@bitbucket.org/aemelendezf/customer-api.git

Second! Compile and Run the project.
Go to the project directory, the folder that was created when cloning the project.
##### Two steps to take:
* 1 - We compile the application, create the executable and run the Test using: mvn clean compile install
* 2 - Run the service by running the deliverable <customer-api.jar> that is in the target folder within the directory that we are already.: java -jar customer-api.jar
```sh
$ cd dirctory-project-customer-api
$ mvn clean compile install
$ cd target
$ java -jar customer-api.jar
```
### Use the Service !!
### SwaggerUI Documentation and Try it out!
* http://localhost:8080/swagger-ui.html
* http://localhost:8080/v2/api-docs


##### Endpoints:
#
| Name | Url |
| ------ | ------ |
| list | http://localhost:8080/api/v1/customers/list |
| add | http://localhost:8080/api/v1/customers/add |
| update | http://localhost:8080/api/v1/customers/update |
| delete | http://localhost:8080/api/v1/customers/delete/ |
| search by username | http://localhost:8080/api/v1/customers/by/username/ |
| search by status | http://localhost:8080/api/v1/customers/by/status/ |

##### Service Basic Authentication
#
    username: consultecti
    password: 09challenge19

