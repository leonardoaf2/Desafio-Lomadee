# API - Customer Address

API desenvolvida com Spring Boot 2.5.2 com função de realizar o cadastro de uam pessoa e seus endereços. Autenticação JWT, Spring security

A aplicação consiste em:
- Cadastro de pessoas e endereço através do POST;
- Atualização de pessoas através do PUT;
- Atualização de endereço através do PUT;
- Consulta de  pessoas através do GET;
- Consulta de endreços através do GET;
- Deletar pessoas através do DELETE;
- Deletar endereços através do DELETE;

   No Postman
   
   Entre em http://localhost:8080/customers/cadastrar | POST
   Coloque body depois raw e Json
   faça o casdatro da seguinte maneira
{
    "name": "Anderson",
    "email": "Anderson@email.com",
    "document": "197478282",
    "phone": "777777389",
    "birthDate": "09-05-1998",
    "senha": "12345678"
}

------------Obs: pegue o ID que for gerado--------------------

Logo depois colocar http://localhost:8080/customers/logar | POST
    {
	"email": "Anderson@email.com",
	"senha": "12345678"
    }

Pegar o TOKEN que sera gerado EX : Basic QW5kZXJzb25AZW1haWwuY29tOjEyMzQ1Njc4
Ir em Headers, em KEY colocar: Authorization | em VALUE colocar o TOKEN : Basic QW5kZXJzb25AZW1haWwuY29tOjEyMzQ1Njc4
em POST ainda, aperte SEND

---------- USUARIO CADASTRADO ---------------

postar um address http://localhost:8080/address | POST
EM CUSTOMER COLOCAR O ID DO USUARIO QUE FOI CADASTRADO!
Coloque body depois raw e Json

{
    "zipCode": "88888",
    "street": "rua amerala e verde",
    "number": "356",
    "complement": "casa de madeira",
    "district": "SP",
    "city": "São Paulo",
    "state": "São Paulo",
    "country": "Brasil",
    "customer": { "id": 3 }
}

ver customers e seus endereços http://localhost:8080/address | GET
Coloque body depois raw e Json

    Consultar pessoas
    GET -> http://localhost:8080/customers

    Consultar Id
    GET -> http://localhost:8080/customers/ID
 
    Atualizar pessoas
    PUT -> http://localhost:8080/customers

