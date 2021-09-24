@registration
Feature: Register with email address

  @CaseId:TC-123
    @full-cases
  Scenario Outline: Register scenarios with test datalist
    Given I open the mobile app for the first time
    When I enter tap Register Now button
    And I enter "<username>" in the email field
    And I enter "<password>" in the password field
    And I enter "<gender>" in the gender field
    Then I should see the welcome page
    Examples:
      |username|password|gender|
      |user1@example.com|A82T+Pa|male|
      |user2@example.com|Hb2678*|female|
      |user3@example.com|hYp353#|female|
      |user4@example.com|hY3T*Ta|male|


  @CaseId:TC-124
  @quick-cases
  Scenario: Successfully Register
    Given I open the mobile app for the first time
    When I enter tap Register Now button
    And I enter "user1@example.com" in the email field
    And I enter "A82T+Pa" in the password field
    And I enter "male" in the gender field
    Then I should see the welcome page

