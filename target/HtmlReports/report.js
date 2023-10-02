$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/Features/GoogleSearchFromConfigFile.feature");
formatter.feature({
  "name": "Validate Google Search Funcationality when input froom config file",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Validate google saerch is working with config file input",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "user is on google page from configuration",
  "keyword": "Given "
});
formatter.match({
  "location": "StepDefinations.GoogleSearchSteps.user_is_on_google_page_from_configuration()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user enters input searchtext from config file",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinations.GoogleSearchSteps.user_enters_input_searchtext_from_config_file()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user click search icon or hits Enter key",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinations.GoogleSearchSteps.user_click_search_icon_or_hits_Enter_key()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "searched searched Phrase results appeared on the page",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinations.GoogleSearchSteps.searched_results_appeared_on_the_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "click first real non - Ad result",
  "keyword": "When "
});
formatter.match({
  "location": "StepDefinations.GoogleSearchSteps.click_first_real_non_Ad_result()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "validate page open successfully",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinations.GoogleSearchSteps.validate_page_open_successfully()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "validate page contains initial searched Input Phrase searched Phrase",
  "keyword": "And "
});
formatter.match({
  "location": "StepDefinations.GoogleSearchSteps.validate_page_contains_initial_searched_Input_Phrase()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});