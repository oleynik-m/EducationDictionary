REST service with database using Spring Boot
Build and run application with Compose:  
1.cd src/main/docker  
2.docker-compose build  
3.docker-compose up  

GET - http://localhost:8000/api/education - all objects  
GET - localhost:8000/api/education/id/{id} - get by id  
GET - localhost:8000/api/education/name/{name} - get by name  
POST - localhost:8000/api/education - new object  
PUT - localhost:8000/api/education/{id} - update object  
DELETE - localhost:8000/api/education/{ID} - delete object   
