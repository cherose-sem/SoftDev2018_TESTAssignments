Feature: Get the type of Triangle 
  Return the type of the triangle 

  Scenario: This is Scalene
    Given The sides are 7,10,5
    When I ask what type of triangle
    Then I should get "SCALENE_TRIANGLE"

  Scenario: This is Isosceles
    Given The sides are 7,5,7
    When I ask what type of triangle
    Then I should get "ISOSCELES_TRIANGLE"

  Scenario: This is Equilateral
    Given The sides are 7,7,7
    When I ask what type of triangle
    Then I should get "EQUILATERAL_TRIANGLE"