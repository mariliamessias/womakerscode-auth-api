<p align="center">
<img src="https://d33wubrfki0l68.cloudfront.net/3d218442b01b3bdbf82b739df4d07e450234bf9e/08a8f/assets/images/womakerscode-brand.png" height="100">
</p>
<h1 align="center">Agendados de Meetups - AUTH-API - Projeto de Conclusão do curso</h1>
<p align="center">
</p>

<p> <i>Sobre a api: </i>

É responsável por armazenar os clients e seus respectivos parâmetros, o que implica em um gerenciamento de quais clients podem adquirir acesso a seus recursos. Além disso, é responsável também por armazenar os usuários do nosso fluxo, bem como o gerenciar o seu token de acesso.
    
Para ver documentação completa da arquitetura do projeto de conclusão construída, acessar: [https://github.com/mariliamessias/womakerscode-meetup-api].
 <h4>Rotas da aplicação: </h4>
  
  POST - /oauth/token </br>
  
  <i>Request: </i>
  ````
  curl --location --request POST 'localhost:9192' \
--header 'Authorization: {CLIENT AUTHORIZATION}' \
--form 'username="{USERNAME}"' \
--form 'password={PASSWORD}' \
--form 'grant_type="password"'
  ````
  
  <i>Response:</i>
  
  ````
  {
    "access_token": "eaa3283b-9491-47f2-b0ae-XXXX",
    "token_type": "bearer",
    "refresh_token": "2df08373-4ca7-4d59-a691-XXXX",
    "expires_in": 3599,
    "scope": "READ WRITE"
}
  ````
  
  POST - /oauth/check_token </br>
  
  <i>Request:</i>
  ````
  curl --location --request POST 'localhost:9192/oauth/check_token?token=eaa3283b-9491-47f2-b0ae-XXX' \
--header 'Authorization: Basic d2ViOnBpbg=='
  ````
  <i>Response:</i>
   ````
   {
    "aud": [
        "{RESOURCE_ID}"
    ],
    "user_name": "{USERNAME}",
    "scope": [
        "READ",
        "WRITE"
    ],
    "active": true,
    "exp": 1651767981,
    "authorities": [
        "READ",
        "NORMAL",
        "UPDATE"
    ],
    "client_id": "{CLIENT_ID}"
}
   ````
  
  POST - /users </br>
  
  <i>Request</i>
  ````
  curl --location --request POST 'localhost:9192' \
--header 'Content-Type: application/json' \
--data-raw '{
    "user_name": "{USERNAME}",
    "password": "{PASSWORD}",
    "email": "{EMAIL}"
}'
  ````
  
  <i>Response:</i>
  
  ````
  {
    "id": 7,
    "roles": [
        "NORMAL"
    ],
    "user_name": "{USERNAME}",
    "created_at": "2022-05-03T17:27:33.963884"
}
  ````
  

 <h4>Bibliotecas utilizadas no desenvolvimento dos três projetos:</h4>
 
 
```bash

  spring-boot-starter-web
  spring-boot-starter-test
  spring-cloud-starter-oauth2
  spring-boot-starter-validation
  spring-boot-starter-data-jpa
  passay
  junit-jupiter-api
  spring-secutiry
  mysql-connector
  h2database
  lombok
  azurewebapp
  dbunit
  ider-core
  spring-test-dbunit
```

