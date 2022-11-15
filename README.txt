
Overview:
This microservice uses a spring mvc architecture comprising of the controller class which makes rest calls to the exposed API,
model which is used to map/represent the CSV file object, a repository class which gives us access to CRUD functions to edit our h2 directory and finally a service which handles all the business logic and serves those public methods to the controller.

Deployment:
Using aws id first  create a EC2 instance 
on the EC2 instance setup id ensure all the relevant ip address and my port are accessible
launch the instance
connect to the instance and install relevan java version and tomcat server
then upload maven packaged jar file to the instance to run 