Feature: Validate Google Search Funcationality when input from config file

  Scenario: Validate google saerch is working with config file input
    Given user is on google page from configuration
    When user enters input searchtext from config file
    And user click search icon or hits Enter key
    Then searched searched Phrase results appeared on the page
    When click first real non - Ad result
    Then validate page open successfully
    And validate page contains initial searched Input Phrase searched Phrase
