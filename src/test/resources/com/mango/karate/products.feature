
Feature: Create product endpoint /products
  
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

  
  Scenario: Attach a price to a product
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
  And def productId = response.id
  And print 'ID del producto: ' + productId


  Given url 'http://localhost:8080/products/'+productId+'/prices'
  And request
  """
  {
    "value": 99.99,
    "initDate": "2024-01-01",
    "endDate": "2024-06-30"
  }
  """
  When method post
  Then status 200

  
  Scenario: Attach a price to a product with wrong date range
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
    And def productId = response.id
    And print 'ID del producto: ' + productId

  Given url 'http://localhost:8080/products/'+productId+'/prices'
  And request
    """
    {
      "value": 99.99,
      "initDate": "2025-01-01",
      "endDate": "2024-06-30"
    }
    """
  When method post
  Then status 400


Scenario: Get Prices
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
  And def productId = response.id

  Given url 'http://localhost:8080/products/'+productId+'/prices'
  And request
    """
    {
        "value": 99.99,
        "initDate": "2024-01-01",
        "endDate": "2024-06-30"
    }
    """
  When method post
  Then status 200
  Given url 'http://localhost:8080/products/'+productId+'/prices'
  And request
    """
    {
      "value": 66.66,
      "initDate": "2024-06-30",
      "endDate": "2024-12-31"
    }
    """
  When method post
  Then status 200


  Given url 'http://localhost:8080/products/'+productId+'/prices'
  And param date = '2024-04-15'
  When method GET
  Then status 200
  And match response.value == 99.99