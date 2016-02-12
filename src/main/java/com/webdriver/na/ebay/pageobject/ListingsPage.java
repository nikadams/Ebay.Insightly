/**
 *   File Name: ListingsPage.java<br>
 *
 *   Adams, Nik<br>
 *   Created: Feb 10, 2016
 *
 */

package com.webdriver.na.ebay.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * ListingsPage //ADDD (description of class)
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
public class ListingsPage {

	private WebDriver driver;

	@FindBy(css = "span.listingscnt")
	WebElement listingsCountText;

	public ListingsPage(WebDriver driver) {
		this.driver = driver;

	}

	/* Return the listing count of search as an integer */
	public int getListingsCount() {
		String[] countArr = this.listingsCountText.getText().replaceAll(",", "").split(" ");
		return Integer.parseInt(countArr[0]);
	}

}
