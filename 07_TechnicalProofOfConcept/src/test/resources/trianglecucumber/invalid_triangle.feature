Feature: Handle Invalid Side lengths of a Triangle
  Return the type of the triangle as UNKNOWN

  Scenario: Invalid side of a String
    Given The sides are 1, 2 "hello"
    When I ask what type of triangle
    Then I should get "UNKNOWN"

  Scenario: Missing one side length
    Given The sides are 1,2
    When I ask what type of triangle
    Then I should get "UNKNOWN"

  Scenario: Invalid length of zero
    Given The sides are 1,0,2
    When I ask what type of triangle
    Then I should get "UNKNOWN"

  Scenario: Invalid lengths of a triangle
    Given The sides are 1,2,3
    When I ask what type of triangle
    Then I should get "UNKNOWN"