@tag
Feature: Verify the GET Accounts in the API

  
  Scenario: GET all accounts from the API
    Given Get call to <url>
    Then Response is <statusCode>

    Examples: 
      | url  							| statusCode |
      | /bankapp/accounts  |     200 | 
