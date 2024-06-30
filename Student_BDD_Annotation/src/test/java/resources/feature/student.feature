Feature: Testing different request on the student application

  Scenario: Check if the student details can be access by user
    When User sends a GET HTTP request to list endpoint
    Then User must get back a valid status code 200

  Scenario: Create a new student & verify if the student is added
    When I create a new student by providing the information firstName "<firstName>" lastName "<lastName>" email "<email>" programme "<programme>" courses "<courses>"
    Then I verify that the student with "<firstName>" is created

    Example:
      | firstName   | lastName   | email           | programme           | courses       |
      | Komal       | Kanji      | @gmail.com      | Financial Analysis  | Accounting    |
      | James       | Brown      | @gmail.com      | Medicine            | Biochemistry  |