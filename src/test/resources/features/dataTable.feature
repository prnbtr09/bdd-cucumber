Feature: Validate dataTable


#  As data Table Object
  @dataTable @validCredentials @chrome
  Scenario: Validate login functionality with valid credentials1
    Given user has launched url "https://www.saucedemo.com/"
    And user has entered credentials
      | UserName | standard_user |
      | password | secret_sauce  |
    And User click on Login

#Data table as Java Collection

#dataTable as List
  @dataTableAsList @validCredentials @chrome
  Scenario: Given user is verifying the data
    Given user has launched url "https://www.saucedemo.com/"
    When user has entered credentials
      | UserName | standard_user |
      | password | secret_sauce  |
    And User click on Login
    Then user verifies following Products
      | Sauce Labs Backpack     |
      | Sauce Labs Bike Light   |
      | Sauce Labs Bolt T-Shirt |

    #dataTable as Map
  @dataTableAsMap @chrome
  Scenario: Given user is verifying the data
    Given user has launched url "https://www.saucedemo.com/"
    When user has entered credentials
      | UserName | standard_user |
      | password | secret_sauce  |
    And User click on Login
    Then user verifies following Products and respective prices
      | Sauce Labs Backpack     | $29.99 |
      | Sauce Labs Bike Light   | $9.99  |
      | Sauce Labs Bolt T-Shirt | $15.99 |


    #dataTable as ListOfMap
  @dataTableAsListOfMap @chrome
  Scenario: Given user is verifying the data
    Given user has launched url "https://www.saucedemo.com/"
    When user has entered credentials
      | UserName | standard_user |
      | password | secret_sauce  |
    And User click on Login
    Then user verifies following Products and respective prices with Label
      | productName             | productPrice |
      | Sauce Labs Backpack     | $29.99       |
      | Sauce Labs Bike Light   | $9.99        |
      | Sauce Labs Bolt T-Shirt | $15.99       |


     #dataTable as ListOfList
  @dataTableAsListOfList @chrome
  Scenario: Given user is verifying the data
    Given user has launched url "https://www.saucedemo.com/"
    When user has entered credentials
      | UserName | standard_user |
      | password | secret_sauce  |
    And User click on Login
    Then user verifies following Products and respective prices with Label as List
      | Sauce Labs Backpack     | $29.99 |
      | Sauce Labs Bike Light   | $9.99  |
      | Sauce Labs Bolt T-Shirt | $15.99 |













