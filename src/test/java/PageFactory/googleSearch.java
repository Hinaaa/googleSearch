package PageFactory;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class googleSearch {
	WebDriver driver;

	@FindBy(id = "L2AGLb")
	WebElement popup_accept;

	@FindBy(name = "q")
	WebElement txt_searchbox;

	@FindBy(css = "a")
	WebElement txt_search;

	@FindBy(id = "search")
	WebElement txt_searchResult;

	@FindBy(css = ".g")
	WebElement txt_firstSearchResult;

	// constructor so same driver pass for same session
	public googleSearch(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this); // it will run and initialise all variables

	}

	public void acceptCookiePopup() {
		popup_accept.click();
	}

	public void enterSearchText(String textSearch) {

		txt_searchbox.sendKeys(textSearch);
	}

	public void pressEnter() {

		txt_searchbox.sendKeys(Keys.ENTER);
	}

	public String searchResult() {
		return txt_searchResult.getText();
	}

	public void clickFirstNonAdResult() {
		if (txt_firstSearchResult != null) {
			List<WebElement> links = txt_firstSearchResult.findElements(By.cssSelector("a"));
			if (!links.isEmpty()) {
				links.get(0).click();
			}
		}
	}
}
