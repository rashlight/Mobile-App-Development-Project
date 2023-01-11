# Mobile App Development API Server

Created by group 9

### Application properties file
```
server.port=8081

#spring.jpa.hibernate.ddl-auto = none
#spring.jpa.hibernate.ddl-auto = create
#spring.jpa.hibernate.ddl-auto = create-drop
spring.jpa.hibernate.ddl-auto = update

spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL55Dialect
spring.jpa.properties.hibernate.enable_lazy_load_no_trans = true

spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

#spring.profiles.active=local

spring.datasource.url = jdbc:mysql://localhost:3306/food
spring.datasource.username = root
spring.datasource.password = password

```  

### API usage
GET requests are used by passing query parameters
- Login with Username and Password (with return user token)
```
http://localhost:8081/api/users?username=...&password=...
```
- Find user by token
```
http://localhost:8081/api/users/{Token}
```
- Get all item
```
http://localhost:8081/api/item
```
- Get all cart item
```
http://localhost:8081/api/cart?token=....
```
- Get orders
```
http://localhost:8081/api/order?token=...
```
- Get all comments
```
http://localhost:8081/api/comments?token=...
```
- Get avarage rating
```
http://localhost:8081/api/comments/average?itemId=..
```
POST requests will use a compliant JSON body or passing parameters
- Add new user or sign up (auto generate token)
```
http://localhost:8081/api/users/create
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
- Add new item
```
http://localhost:8081/api/item
{
    "name":"hot dog",
    "price":"10000"
}
```
- Add item to cart item
```
http://localhost:8081/api/cart/add/{itemId}/{amount}?token=...
```
- Update cart item
```
http://localhost:8081/api/cart/update/{itemid}/{amount}?token=....
```
- Checkout
```
http://localhost:8081/checkout?token=.....
```
- Add comment
```
http://localhost:8081/api/comments

  {
    "token": "26438128-da68-45ba-bb8a-67255488198d",
    "itemId": 2,
    "description" :"gosh",
    "rating": 5
}
```
- Delete item
```
http://localhost:8081/api/item/{itemId}
```

- Delete cart
```
http://localhost:8081/api/cart/remove/{cartid}?token=...
```
