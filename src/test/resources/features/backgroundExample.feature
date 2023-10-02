@UI
Feature: As a user of application I want to validate login functionality


  Background: common steps
    And user has entered username "standard_user" and password "secret_sauce"
    And User click on Login


  @sample @chrome
  Scenario: Validate Products on Dashboard
#    Given user has launched url "https://www.saucedemo.com/"
    Then user verify "Products" on Dashboard


  @sample @chrome
  Scenario: Validate Sauce Labs Backpack on Dashboard
#    Given user has launched url "https://www.saucedemo.com/"
    Then user verify "Sauce Labs Backpack" on Dashboard