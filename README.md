# API - Customer Address

API desenvolvida com Spring Boot 2.5.2 com função de realizar o cadastro de uam pessoa e seus endereços. Autenticação JWT, Spring security

A aplicação consiste em:
- Cadastro de pessoas e endereço através do POST;
- Atualização de pessoas através do PUT;
- Atualização de endereço através do PUT;
- Consulta de  pessoas através do GET;
- Consulta de endreços através do GET;
- Deletar pessoas através do DELET;
- Deletar endereços através do DELET;

   No Postman
---
    Cadastrar pessoa
    POST -> http://localhost:8080/customers
    
    {
    "name": "Tabarelli",
    "email": "T83218@email.com",
    "document": "197478282",
    "phone": "1178668558",
    "birthDate": "18-05-1996"
}


---
    Consultar pessoas
    GET -> http://localhost:8080/customers
   
---
    Consultar Id
    GET -> http://localhost:8080/customers/ID
    
---   
    Atualizar pessoas
    PUT -> http://localhost:8080/customers
    
---
