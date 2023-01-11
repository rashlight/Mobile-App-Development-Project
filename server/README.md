# Mobile App Development API Server

Created by group 9

### Application properties file
Still in Development process so you can modified it as you like then place in resource folder
```
  spring.jpa.hibernate.ddl-auto=update
  spring.datasource.url=jdbc:mysql://${MYSQL_HOST:localhost}:3306/usth_food_db
  spring.datasource.username=username
  spring.datasource.password=password
  spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```  

### API usage
GET requests are used by passing query parameters
- Login with Username and Password
```
http://localhost:8080/api/users?username=...&password=...
```
- Find user by token
```
http://localhost:8080/api/users/{Token}
```

POST requests will use a compliant JSON body
- Add new user or sign up
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
    "avatarContent":"base64stringimageencoded"
}
```
