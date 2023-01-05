# Mobile App Development API Server

Created by group X

### Application properties file
```
  spring.jpa.hibernate.ddl-auto=update
  spring.datasource.url=jdbc:mysql://${MYSQL_HOST:localhost}:3306/usth_food_db
  spring.datasource.username=username
  spring.datasource.password=password
  spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```  

### API usage
GET requests are used by passing query parameters, for example:
```
http://localhost:5000/api/username=...&password=...
```
POST requests will use a compliant JSON body, for example:
```
{
    "firstname": "Pham",
    "secondname":"Hieu",
    "gender":"male",
    "dob":"2002-04-16",
    "role":"chef",
    "username":"phamhieu",
    "password":"123456789",
    "email":"banyamanohg@gmail.com",
    "token":"123456789",
    "tokenGeneratedDate":"10:10:10",
    "createddate":"2002-04-16"
}
```
Reponse are temporarily the same
