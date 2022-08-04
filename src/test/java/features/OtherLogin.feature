@OtherLoginFeature @Regression
Feature: TechFios Other Login Functionality validation

  Background: 
    Given User is on Techfios login page

  @OtherSecenario1
  Scenario Outline: 1 User should not be able to login with invalid credentials (Other)
    When User enters username as "<username>"
    When User enters password as "<password>"
    When User clicks signin button
    Then User should land on dashboard page
    
    Examples:
    |username|password|
    |demo2@techfios.com|abc123|
    |demo@techfios.com|abc124|
    |demo2@techfios.com|abc124|