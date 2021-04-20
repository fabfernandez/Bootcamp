# Hotels API Fabrizio Fernandez
___
## **Endpoints Disponibles:** 

> **GET /api/v1/hotels**

Request params: 

- dateFrom, dateTo (formato dd/MM/aaaa)
- city

Ejemplo: 

`localhost:8080/api/v1/hotels?dateFrom=10/03/2021&dateTo=20/03/2021&city=Puerto Iguazú`
___
> **POST /api/v1/hotels**

Request body:
```json
{
  "userName": "seba_gonzalez@unmail.com",
  "booking": {
    "dateFrom": "10/02/2021",
    "dateTo": "20/02/2021",
    "destination": "Puerto Iguazú",
    "hotelCode": "CH-0002",
    "peopleAmount": 2,
    "roomType": "Doble",
    "people": [{
      "dni": "12345678",
      "name": "Pepito",
      "lastName": "Gomez",
      "birthDate": "10/11/1982",
      "mail": "pepitogomez@gmail.com"
    },
      {
        "dni": "13345678",
        "name": "Fulanito",
        "lastName": "Gomez",
        "birthDate": "10/11/1983",
        "mail": "fulanitogomez@gmail.com"
      }
    ],
    "paymentMethod": {
      "type": "CREDIT",
      "number": "1234-1234-1234-1234",
      "dues": 6
    }
  }
}
```

# Archivos

Los archivos de base de datos se encuentran en la carpeta `resources` del proyecto.

Estan en formato JSON, por ejemplo: `dbHotels.json`

# Beta continuo

# Notas del desarrollador:
