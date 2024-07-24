Api Intcomex

Introducción
Cuenta con los siguientes servicios :
Crear Categoría ( POST /Category/) 
url de acceso http://3.138.182.70/api/category
Body: { "categoryName": "SERVIDORES", "description": "SERVIDORES", "picture": "picture_1.jpg" }

Crear Producto ( POST /Product/) url de acceso
http://3.138.182.70/api/products
Body: { "productName": "Yacero TEST", "quantityPerUnit": 2, "unitPrice": 81.00, "unitsInStock": 2, "unitsOnOrder": 2,
"reorderLevel": 2, "supplierId": 1, "categoryId": 2 }

listar productos ( GET /Products/) url de acceso
http://3.138.182.70/api/products
Boy: { "productName": "Yacero TEST", "quantityPerUnit": 2, "unitPrice": 81.00, "unitsInStock": 2, "unitsOnOrder": 2, "reorderLevel": 2, "supplierId": 1, "categoryId": 2 }
El servicio retorna todo los productos paginados.
listar productos por ID (GET /Products/id/) url de acceso
http://3.138.182.70/api/products/2
