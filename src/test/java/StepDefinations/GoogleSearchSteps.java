package StepDefinations;

import static org.junit.Assert.assertTrue;
import org.junit.Assert;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Config.PropertiesFile;
import PageFactory.googleSearch;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class GoogleSearchSteps {

	WebDriver driver = null;
	public static String browserName = null;
	public static String inputTextData = null;
	public static String inputUrl = null;

	@Before(order = 0)
	public void browserOpen() {
		String projectPath = System.getProperty("user.dir"); // strong path in string
		PropertiesFile.getProperties(); // call getproperty
		if (browserName.equalsIgnoreCase("chrome")) {
			System.getProperty("webdriver.chrome.driver", projectPath + "/src/test/resources/drivers/chromedriver"); // absolute /TestAutomationC/src/test/resources/drivers/chromedriver
			driver = new ChromeDriver();
		}
	}

	@Before(order = 1) // ordering with conditional tags
	public void browserMaximise() {
		driver.manage().window().maximize();
	}

	googleSearch searchObj = new googleSearch(driver);
	public WebElement searchResults;

	@Given("^user is on (.*) page$")
	public void user_is_on_google_page(String url) {
		driver.navigate().to(url);
		if (driver.findElements(By.id("L2AGLb")).size() > 0) {
			searchObj = new googleSearch(driver);
			searchObj.acceptCookiePopup();
		}
	}

	@When("^user enters (.*) in search box$")
	public void user_enters_text_in_search_box(String textSearch) {
		searchObj.enterSearchText(textSearch);
	}

	@And("user click search icon or hits Enter key")
	public void user_click_search_icon_or_hits_Enter_key() {
		searchObj.pressEnter();
	}

	@Then("^search results (.*) appeared on the page$")
	public void search_results_appeared_on_the_page(String searchedPhrase) {
		String getSearch = searchObj.searchResult();
		assertTrue(getSearch.contains(searchedPhrase));
	}

	@And("click first real non - Ad result")
	public void click_first_real_non_Ad_result() {
		searchObj.clickFirstNonAdResult();
	}

	@Then("validate page open successfully")
	public void validate_page_open_successfully() throws InterruptedException {
		Thread.sleep(1000);
		WebDriverWait pageLoadWait = new WebDriverWait(driver, java.time.Duration.ofSeconds(10));
		pageLoadWait.until(ExpectedConditions.titleContains("Test Automation")); // Update the title as needed
	}

	@And("^page contains initial (.*)$")
	public void page_contains_initial_search_phrase(String searchedPhrase) {
		String pageSource = driver.getPageSource();
		Assert.assertTrue(pageSource.contains(searchedPhrase));
		Assert.assertTrue(driver.getTitle().contains(searchedPhrase));

	}

	// Updated for configuration feature
	@Given("user is on google page from configuration")
	public void user_is_on_google_page_from_configuration() {

		PropertiesFile.getUrlProperties();
		driver.navigate().to(inputUrl);
		// driver.get("https://"+inputUrl);
		if (driver.findElements(By.id("L2AGLb")).size() > 0) {
			searchObj = new googleSearch(driver);
			searchObj.acceptCookiePopup();
		}
	}

	@When("user enters input searchtext from config file")
	public void user_enters_input_searchtext_from_config_file() {
		PropertiesFile.getInputProperties(); // call function to set inputTextData value as text from config
		String textSearch = inputTextData;
		searchObj = new googleSearch(driver);
		searchObj.enterSearchText(textSearch);
	}

	@Then("searched searched Phrase results appeared on the page")
	public void searched_results_appeared_on_the_page() {
		PropertiesFile.getInputProperties();
		String searchedPhrase = inputTextData;
		String getSearch = searchObj.searchResult();
		assertTrue(getSearch.contains(searchedPhrase));

	}

	@And("validate page contains initial searched Input Phrase searched Phrase")
	public void validate_page_contains_initial_searched_Input_Phrase() {
		PropertiesFile.getInputProperties();
		String searchedPhrase = inputTextData;
		String pageSource = driver.getPageSource();
		Assert.assertTrue(pageSource.contains(searchedPhrase));
		Assert.assertTrue(driver.getTitle().contains(searchedPhrase));
	}

	@After
	public void closeBrowser() {
		driver.close();
		driver.quit();
		PropertiesFile.setProperties(); // when everything executed, note passed result in config file
	}

}
