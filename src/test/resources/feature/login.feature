@SmokeFeature
Feature: Test login functionality

 # @Smoketest
  Scenario: Check login is successful with valid credentials
    Given user is on login page
    When user enters username "admin@gmail.com" and password "admin@2025#"
    And clicks on the login button

