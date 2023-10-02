Feature: Validate Google Search Funcationality
 
  Scenario Outline: Validate google saerch is working with data table input
    Given user is on <url> page
    When user enters <searchInputPhrase> in search box
    And user click search icon or hits Enter key
    Then  search results <searchInputPhrase> appeared on the page
    When click first real non - Ad result
    Then validate page open successfully
    And page contains initial <searchInputPhrase>
    
    Examples:
    |url|searchInputPhrase|
    |https://www.google.com/|Test Automation|