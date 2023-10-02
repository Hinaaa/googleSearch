# googleSearch
google Search
Automation google search as per requirements

# Pre requisites:
Cucumber.io
Java Development Kit (JDK) - Version 8 or higher
Maven - A build automation tool
Web browser (e.g., Chrome)
Dependencies mentioned in POM.xml

# Running test:
Execute file from src/test/java/Features

# TestCases
src/test/java/Features/GoogleSearch.feature: Validate Google Search Funcationality
src/test/java/Features/GoogleSearchFromConfigFile.feature: Validate Google Search Funcationality when input from config file
More scenario's can be added in these files under tag @Scenario

# Files:
src/test/java/Features-: contain feature files for test scenario
src/test/java//pagefactory-: All resuable functions and element id's in custom control defined here
src/test/java/StepDefination-: Code associated with cucumber scenario's
src/test/java/RunnerClass-: Define excution path and glue code for report generation path
src/test/java/Config: Define browser, inputText and application url configurable data an functions for configuration 
src/test/resources/drivers/chromedriver: contain chromedriver instance.

# Approaches and Automation Concepts:
Browser, input search Text and application url is configurable in config.properties file
Another test where Browser, input search Text and application url is provided through data table
Centralized approach for reusability 
Assertions has been placed for validation
Page object model approach used
Comments mentioned for better understanding
Maintainable and re-usable code
Choosing tech stack: cucumber java has been used as mentioned in recommendation


# Configurations:
result=passed, get updated when test case passed
browser=chrome, browse value given = chrome
inputText=Test Automation, input text to search and validate
url=https://www.google.com/, input url

# Manual Execution:
Steps are mentioned in .feature files

  Scenario: Validate google saerch is working with config file input
    Given user is on google page from configuration (Configurable)
    When user enters input searchtext from config file (The text is configurable from config file by setting)
    And user click search icon or hits Enter key
    Then searched searched Phrase results appeared on the page
    When click first real non - Ad result
    Then validate page open successfully
    And validate page contains initial searched Input Phrase searched Phrase

# Reports:
Reports generated from given glue path in RunnerClass 
1. html report: target/htmlReports
2. JSONReports: target/JSONReports
3. JunitReports target/JunitReports
