## BATCH-1:
## GROUP-2:

### Step-1: to create a maven project:
run the following command in the directory where you want to create the project mvn archetype:generate -DgroupId=com.batch-1.project -DartifactId=exam-result-search-app -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false

### Step-2: Importing the project and creating the modules in the Intellij:
now import the maven project into the Intellij and create two modules: name the first module as "student-result", which will be our first Microservice now name the another module as "result-processor", which will be our second Microservice

### Step-3: Creating a docker-compose file:
create a file named as "docker-compose.yml" which will contain the services we will be using in our project, in our case it will have two services first one being a rabbitMq service (rabbitmq:3-management) second one being a database service which is MySql (mysql:8.0-oracle), this will be our database

#### Step-4: creating Microservice-1:(student-result):
Microservice-1 will be having a user controller which will be having access to only get request's. annotate the controller with "@RestController". Now create a model(Student) class which consists of total eight variables which are private. annotate the class with "@JsonIdentityInfo" annotation. now generate the following things in the "Student" class


### Step-5: Creating Microservice-2 (result-processor):
Microservice-2 will be having a admin controller which will be having access to post, put, delete requests. As we are using MySql as our database we should annotate the student class with "@Entity" annotation, then our class will be considered as a table we have to give one variable as a primary key, as we are accessing the all the requests operations using student we will be giving the name variable with "@Id" annotation. now generate the getters, setters for all the variables and generate a default constructor, a parameterized constructor and a toString method. As our Microservice-2 will be interacting with the database, we should have a repository(ResultsRepository) interface extending the JpaRepository, so that we can use all the methods available in the jpa repository to perform the CRUD operations on our database. annotate the ResultsRepository interface with a "@Repository" annotation, so that spring will consider it as a repository

### Step-6 Creating Queue between the two Microservices:
As our Microservices will be communicating with each other, each Microservice should have a sender and a receiver we will be using two Queues for our Microservices to communicate with each other


### Step-7 Providing the Authentication for the Mappings:
Using the "SpringSecurityBasicConfig" class which extends the "WebSecurityConfigurerAdapter" class. using this we create two roles 1.student role 2.admin role by using this class we will make the Microservice-1 to have access to only "GET" requests for the student role and we will grant the "POST, PUT, DELETE" Mapping requests to the admin role

### Step-8 Compile the Application:
mvn clean install
### Step-9 Running the Application:
mvn spring-boot:run

### Step-10 Curl Commands:

FOR POST REQUEST:
curl --location --request POST 'localhost:8082/storeresult' \

FOR GET REQUEST:
curl --location --request GET 'localhost:8081/getresult?name=arpit' \

FOR PUT REQUEST:
curl --location --request PUT 'localhost:8082/updateresult?name=arpit' \

FOR DELETE REQUEST:
curl --location --request DELETE 'localhost:8082/deleteresult?name=sonali' \

### Step-11: Creating a Docker Image:
docker-compose -f docker-compose.yml up -d