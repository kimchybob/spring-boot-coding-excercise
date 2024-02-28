    # See
    # https://github.com/intuit/karate#syntax-guide
    # for how to write feature scenarios
Feature: As an api user I want to find the oldest user accounts with zero followers

  Scenario: Get top 3 oldest user accounts with zero followers
    Given url microserviceUrl
    And path '/getLonelyUser'
    When method GET
    Then status 200
    And match header Content-Type contains 'application/json'
    # see https://github.com/intuit/karate#schema-validation
    # Define the required schema
    * def userSchema = { id : '#number', 'login' : '#string', 'html_url' : '#string' }
    # The response should have an list of account objects
    And match response == '#[] userSchema'
