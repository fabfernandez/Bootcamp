# Hotels API Fabrizio Fernandez

Consigna: https://drive.google.com/file/d/1HDzjBv8I2c144NVcoiNUdNXA0RMY1rGL/view
___
## **Endpoints Disponibles:** 

> **GET /api/v1/hotels**
Lista todos los hoteles en la base de datos o bien filtra resultados por fecha y ciudad.

Request params: (opcionales para filtrar)

- dateFrom, dateTo (formato dd/MM/aaaa)
- city

SE PERMITEN LOS 3 PARAMETROS O NINGUN PARAMETRO.

Ejemplos:

`localhost:8080/api/v1/hotels` ver todos

`localhost:8080/api/v1/hotels?dateFrom=10/03/2021&dateTo=20/03/2021&city=Puerto Iguazú`
filtrar
___
> **POST /api/v1/booking**

Ejemplo de Request body:
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

Ejemplo de Response:
```json
{
    "userName": "seba_gonzalez@unmail.com",
    "amount": 6300.0,
    "interest": 1.15,
    "total": 7244.999999999999,
    "bookingDTO": {
        "dateFrom": "10/02/2021",
        "dateTo": "20/02/2021",
        "destination": "Puerto Iguazú",
        "hotelCode": "CH-0002",
        "peopleAmount": 2,
        "roomType": "Doble",
        "people": [
            {
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
        ]
    },
    "statusCodeDTO": {
        "code": 200,
        "message": "Booking completed successfully."
    }
}
```

# Archivos

Los archivos de base de datos se encuentran en la carpeta `resources` del proyecto.

Estan en formato JSON, por ejemplo: `dbHotels.json`

# Beta continuo
- Falta la API de vuelos. Pendiente de desarrollo.
- El `interest` y el `total` en la respuesta del `POST /booking` podrian estar en un formato mas amigable.
- No se validan el formato de los emails de los clientes recibidos en el campo ``people``. Pendiente de desarrollo.
- Tampoco se validan los valores de dni, name, lastName, birthDate.
