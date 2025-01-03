Feature: Admin Update A Non Existing Book

  Scenario: Admin update a non existing book
    Given the admin base api url for put method is set
    When admin login with username "admin" and password "password"
    When admin select a book to put using the index 0
    And admin send put request to endpoint "/api/books"
    Then the admin response status code should be 404