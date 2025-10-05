Feature: Prueba del endpoint /actuator/health

Scenario: health
  Given url 'http://localhost:8080/actuator/health'
  When method get
  Then status 200