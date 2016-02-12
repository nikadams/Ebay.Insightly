/**
 *   File Name: HomePage.java<br>
 *
 *   Adams, Nik<br>
 *   Created: Feb 10, 2016
 *
 */

package com.webdriver.na.ebay.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * HomePage //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods)
 *
 * @author Adams, Nik
 * @version 1.0.0
 * @since 1.0
 *
 */
public class HomePage {

	final static String HOMEPAGE_URL = "http://ebay.com";

	private WebDriver driver;

	/* Locator for search Button on Homepage */
	@FindBy(id = "gh-btn")
	private WebElement searchBtn;

	/* Locator for search Text field on Homepage */
	@FindBy(id = "gh-ac")
	private WebElement searchTxtField;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	// Clicks the search button on the main page
	public ListingsPage clickSearchBtn() {
		this.searchBtn.click();
		return PageFactory.initElements(this.driver, ListingsPage.class);
	}

	public HomePage navigateToHomePage() {
		this.driver.get(HOMEPAGE_URL);
		return this;
	}

	// Type search string into search bar
	public HomePage typeSearchEntry(String search) {
		this.searchTxtField.sendKeys(search);
		return this;
	}

}
