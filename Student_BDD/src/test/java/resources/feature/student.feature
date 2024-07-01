Feature: Testing different request on the student application

  @SMOKE
  Scenario: Check if the student details can be access by user
    When User sends a GET HTTP request to list endpoint
    Then User must get back a valid status code


  @POSITIVE
  Scenario Outline: Create a new student & verify if the student is added
    When I create a new student by providing the information firstName "<firstName>" lastName "<lastName>" email "<email>" programme "<programme>" courses "<courses>"
    Then I verify that the student with "<email>" is created
    Then I delete student data so it is not visible to anyone
    Examples:
      | firstName | lastName | email      | programme          | courses     |
      | Komal     | kanji    | @gmail.com | Financial Analysis | Accounting  |