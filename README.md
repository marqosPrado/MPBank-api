# MP Bank API

Esse projeto é uma API para uma instituição financeira fictícia, MP Bank. Com essa API podemos cadastrar clientes e associar uma conta bancária a eles, além de realizar transações entre os clientes.

## Tecnologias:

#### Java 17
#### MariaDB
#### Maven
#### Spring Boot
#### Spring Data JPA

### Customer Endpoint:

POST: ``/api/create`` cadastrar um cliente
###### Input:
```json
{
  "cpf_id": "<CPF>",
  "fullName": "<NOME DO CLIENTE>",
  "email": "example@example.com",
  "mobileNumber": "XXXXXXXXXXX"
}
```

GET: ``/api`` lista dos os clientes cadastrados
```json
[
  {
    "cpf_id": "10101010101",
    "fullName": "Alexander Lee",
    "email": "alexander@example.com",
    "mobileNumber": "1010101010"
  },
  {
    "cpf_id": "11111111111",
    "fullName": "Alice Johnson",
    "email": "alice@example.com",
    "mobileNumber": "1111111111"
  },
  {
    "cpf_id": "12121212121",
    "fullName": "Mia Davis",
    "email": "mia@example.com",
    "mobileNumber": "1212121212"
  }
]
```

### Account Endpoint:
GET: ``/api/account`` lista todas as contas cadastradas
```json
[
  {
    "account_id": "2088e036-74e8-4133-bf25-1bf4ad9f952f",
    "accountSequence": "F4ak-1q",
    "customer": {
      "cpf_id": "31213121323",
      "fullName": "Evelyn Martinez",
      "email": "evelyn@example.com",
      "mobileNumber": "3131313131"
    },
    "balance": 0.0,
    "account_status": true,
    "created_at": "2023-07-12T16:55:23.081616"
  },
  {
    "account_id": "e6f42ce4-2fd3-4b62-8801-1c465c005576",
    "accountSequence": "jFTK-x0",
    "customer": {
      "cpf_id": "31213131323",
      "fullName": "Evelyn Martinez",
      "email": "evelynexample.com",
      "mobileNumber": "3131313131"
    },
    "balance": 0.0,
    "account_status": true,
    "created_at": "2023-07-12T16:55:11.265545"
  },
  {
    "account_id": "8060a4ed-6314-4ec1-aa60-2135b4368bdf",
    "accountSequence": "4Jq4-Ls",
    "customer": {
      "cpf_id": "55555555555",
      "fullName": "Emily Wilson",
      "email": "emily@example.com",
      "mobileNumber": "5555555555"
    },
    "balance": 13142.0,
    "account_status": true,
    "created_at": "2023-07-12T16:13:18.449133"
  }
]
```
POST: ``/api/deposit`` fazer um depósito em uma conta
###### Input:
```json
{
  "account": "vYPb-1r",
  "balance": 1000
}
```
###### Output:
```json
{
        "account_id": "1a04d100-8840-4bca-8284-34e87e258a06",
        "accountSequence": "vYPb-1r",
        "customer": {
            "cpf_id": "20202020202",
            "fullName": "Sophia Davis",
            "email": "sophia@example.com",
            "mobileNumber": "2020202020"
        },
        "balance": 1000.0,
        "account_status": true,
        "created_at": "2023-07-12T16:15:44.5737"
    }
```

DELETE: ``/api/account`` desativa a conta, muda o a "account_status" para "false"
###### Input:
```json
{
    "accountSequence": "TL1y-wp"
}
```
###### Output:
```json
{
    "account_id": "54950d54-0667-4a8d-966d-a88438140965",
    "accountSequence": "TL1y-wp",
    "customer": {
        "cpf_id": "44444444444",
        "fullName": "Michael Davis",
        "email": "michael@example.com",
        "mobileNumber": "4444444444"
    },
    "balance": 25343.0,
    "account_status": false,
    "created_at": "2023-07-12T16:13:05.612118"
}
```

PUT: ``/api/account`` seta o "account_status" para "true"
###### Input:
```json
{
    "accountSequence": "TL1y-wp"
}
```
###### Output:
```json
{
    "account_id": "54950d54-0667-4a8d-966d-a88438140965",
    "accountSequence": "TL1y-wp",
    "customer": {
        "cpf_id": "44444444444",
        "fullName": "Michael Davis",
        "email": "michael@example.com",
        "mobileNumber": "4444444444"
    },
    "balance": 25343.0,
    "account_status": true,
    "created_at": "2023-07-12T16:13:05.612118"
}
```

### Transaction Endpoint
POST: ``/api/transaction`` faz uma transação entre clientes
###### Input:
```json
{
    "from_account": "frFfJz",
    "to_account": "YQ7C-PO",
    "amount": 999
}
```

