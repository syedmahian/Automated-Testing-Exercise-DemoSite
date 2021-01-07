
Feature: Create a user with login credentials and then logging in.
				
					As a Customer, I want to create a new user with an email and password
					So that, I can login as the user

  @tag1
  Scenario: Create a new User
    Given the correct address
    When I create a new user
    Then I can login as the user
    And check more outcomes

  