Feature: Prueba del endpoint /products
Scenario: products
  Given url 'http://localhost:8080/products'
  And request
  """
  {
    "name": "Zapatos deportivos",
    "description": "Calzado cómodo para correr"
  }
  """

  When method post
  Then status 201


Feature: Agregar precio a un producto
Scenario: Crear un precio para un producto existente
  Given url 'http://localhost:8080/products/d290f1ee-6c54-4b01-90e6-d701748f0851/prices'
  And request
  """
  {
    "value": 99.99,
    "initDate": "2024-01-01",
    "endDate": "2024-06-30"
  }
  """
  When method post
  Then status 201
  And match response.value == 99.99
