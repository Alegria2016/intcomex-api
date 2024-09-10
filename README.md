Api Intcomex



Intcomex Api:  es una Api desarrollada modo de prueba con Spring Boot y Mysql desplegada en un 
entorno Cloud AWS, cuenta con los siguientes servicios:

Crear Categoría ( POST /Category/) 



Body: { 
     "categoryName": "SERVIDORES", 
     "description": "SERVIDORES", 
     "picture": "picture_1.jpg" 
}

Crear Producto ( POST /Product/) 


Body: { 
      "productName": "Yacero TEST", 
      "quantityPerUnit": 2, 
      "unitPrice": 81.00, 
      "unitsInStock": 2, 
      "unitsOnOrder": 2,
      "reorderLevel": 2, 
      "supplierId": 1, 
      "categoryId": 2 
}

listar productos ( GET /Products/) 



El servicio retorna todos los productos paginados de 10 en 10.

Respuesta {
    "content": [
            {
                "id": 10,
                "productName": "Dabtype",
                "quantityPerUnit": 10,
                "unitPrice": 33.00,
                "unitsInStock": 10,
                "unitsOnOrder": 2,
                "reorderLevel": 10,
                "supplierId": 1,
                "category": {
                    "id": 1,
                    "categoryName": "SERVIDORES",
                    "description": "SERVIDORES",
                    "picture": "picture_1.jpg"
                }
           }
    ],
    "pageable": {
        "pageNumber": 0,
        "pageSize": 10,
        "sort": {
            "empty": true,
            "sorted": false,
            "unsorted": true
        },
        "offset": 0,
        "paged": true,
        "unpaged": false
    },
    "totalPages": 5,
    "totalElements": 49,
    "last": false,
    "size": 10,
    "number": 0,
    "sort": {
        "empty": true,
        "sorted": false,
        "unsorted": true
    },
    "numberOfElements": 10,
    "first": true,
    "empty": false
}


listar productos por ID (GET /Products/id/) url de acceso


Respuesta: {
        "id": 2,
        "productName": "Yacero",
        "quantityPerUnit": 2,
        "unitPrice": 81.00,
        "unitsInStock": 2,
        "unitsOnOrder": 2,
        "reorderLevel": 2,
        "supplierId": 1,
        "category": {
        "id": 2,
        "categoryName": "CLOUD",
        "description": "CLOUD",
        "picture": "picture_2.jpg"
        }
}

Instrucciones para despliegue de manera local:


2) Crear Base de Datos MySql con el nombre : intcomexdb 
  (se denato en el achivo re propiedades al igual que el usuario y contraseña corespondiente  a la BD)
3) Levantar proyecto en IDE de preferencia Intellij

Nota: para probar los test de integracion  crear DB con nombre intcomexdb-test como aparece en el archivo de propiedades para el ambiente de test.

