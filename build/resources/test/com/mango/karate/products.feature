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