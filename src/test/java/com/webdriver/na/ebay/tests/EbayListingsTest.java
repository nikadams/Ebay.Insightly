/**
 *   File Name: EbayListingsTest.java<br>
 *
 *   Adams, Nik<br>
 *   Created: Feb 10, 2016
 *
 */

package com.webdriver.na.ebay.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.webdriver.na.ebay.pageobject.HomePage;
import com.webdriver.na.ebay.pageobject.ListingsPage;
import com.webdriver.na.ebay.util.Driver;
import com.webdriver.na.ebay.util.TestData;

/**
 * EbayListingsTest //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * verifySearchListingCount() Navigates to ebay.com and searches for an item
 * provided by the DataProvider. Once the search is completed, it verifies the
 * number of listings is greater than 0.
 *
 * @author Adams, Nik
 * @version 1.0.0
 * @since 1.0
 *
 */
public class EbayListingsTest extends TestData {

	final static String LISTING_COUNT_ERROR = "Invalid listing count:";
	final static int zeroCOUNT = 0;

	private WebDriver driver;

	@BeforeMethod
	@Parameters("browser")
	public void setUp(String browser) {

		this.driver = Driver.driverInit(browser);

	}

	@AfterMethod
	public void tearDown() {
		this.driver.quit();
	}

	@Test(dataProvider = "provider")
	public void verifySearchListingsCount(String searchStr) {
		HomePage homepage = PageFactory.initElements(this.driver, HomePage.class);
		homepage.navigateToHomePage();
		homepage.typeSearchEntry(searchStr);
		ListingsPage listingspage = homepage.clickSearchBtn();
		int count = listingspage.getListingsCount();
		Assert.assertTrue(count > zeroCOUNT, LISTING_COUNT_ERROR + count);

	}

}
