@UI
Feature: As a user of application I want to validate login functionality

#  @firstTestcase @validCredentials
#  Scenario: Validate login functionality with valid credentials
#    Given user has launched url "https://www.saucedemo.com/"
#    And user has entered credentials
#      | UserName      | Password     |
#      | standard_user | secret_sauce |
#    When User click on Login
#    Then user verify "Products" on Dashboard
#    And user closes the browser
#
#  @invalidCredentials
#  Scenario: Validate login functionality with invalid credentials
#    Given user has launched url "https://www.saucedemo.com/"
#    And user has entered credentials
#      | UserName      | Password |
#      | standard_user | sample   |
#    And User click on Login
#    Then user verify "dashboard" on Dashboard


  Scenario: Validate login functionality with valid credentials
    Given user has launched url "https://www.saucedemo.com/"
    And user has entered username "standard_user" and password "secret_sauce"
#    And User click on Login
#    Then user verify "Products" on Dashboard
#

#  @sample @chrome
#  Scenario: Validate login functionality with invalid credentials
##    Given user has launched url "https://www.saucedemo.com/"
#    And user has entered username "standard_user" and password "secret_sauce"
#    And User click on Login
#    Then user verify "Products" on Dashboard
















  @sample @chrome @sampleEmpty
  Scenario Outline: Validate login functionality with valid credentials
#    Given user has launched url "https://www.saucedemo.com/"
    And user has entered username "<userName>" and password "<Password>"
    And User click on Login
    Then user verify "Products" on Dashboard

    Examples:
      | userName       | Password     |
      | standard_user  | secret_sauce |
      | standard_user1 |              |

















#    And user verify "Sauce Labs Backpack" on Dashboard


#  @scenarioOutlineExample
#  Scenario Outline: validate login functionality
#    Given user has launched url "https://www.saucedemo.com/"
#    And user has entered username "<userName>" and password "<password>"
#    And User click on Login
#    Then user verify "Products" on Dashboard
#    Examples:
#      | userName      | password     |
#      | standard_user | secret_sauce |
#      | standard_user | sample       |

  @dataTableMaps
  Scenario: validate login functionality
    Given user has launched url "https://www.saucedemo.com/"
    And user has entered credentials
      | userName      | password     |
      | standard_user | secret_sauce |
#    And user has entered username "<userName>" and password "<password>"
    And User click on Login
    Then user verify "Products" on Dashboard


  @dataTableMap
  Scenario: validate login functionality
    Given user has launched url "https://www.saucedemo.com/"
    And user has entered credentials
      | standard_user | secret_sauce |
#    And user has entered username "<userName>" and password "<password>"
    And User click on Login
    Then user verify "Products" on Dashboard


  @dataTableLists
  Scenario: validate login functionality
    Given user has launched url "https://www.saucedemo.com/"
    And user has entered credentials
      | standard_user |
      | standard_user |
#    And user has entered username "<userName>" and password "<password>"
    And User click on Login
    Then user verify "Products" on Dashboard


  @scenarioOutlineDataTable
  Scenario Outline: validate login functionality
    Given user has launched url "https://www.saucedemo.com/"
    And user has entered credentials
      | userName   | password   |
      | <userName> | <password> |
    And User click on Login
    Then user verify "Products" on Dashboard
    Examples:
      | userName      | password     |
      | standard_user | secret_sauce |
      | standard_user | sample       |


#  @dataTable
#  Scenario: validate login functionality
#    Given user has launched url "https://www.saucedemo.com/"
#    And user has entered credentials
#      | UserName      | Password     |
#      | standard_user | secret_sauce |
##    And user has entered username "<userName>" and password "<password>"
#    And User click on Login
#    Then user verify "Products" on Dashboard






