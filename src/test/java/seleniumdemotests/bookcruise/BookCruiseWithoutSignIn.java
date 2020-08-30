package seleniumdemotests.bookcruise;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.CruisePage;
import pages.HomePage;
import seleniumdemotests.BaseTest;

public class BookCruiseWithoutSignIn extends BaseTest{
	HomePage homePage;
	CruisePage cruiseFinder;

	@BeforeTest
	public void initialize() {
		// Initialize pages
		homePage = new HomePage(driver);
		homePage.navigateToHome();
	}

	@Test
	public void testBookFlightWithoutSignIn() throws Exception {

		homePage.cruiseLink.click();
		cruiseFinder = new CruisePage(driver);
		
		// Verify navigated to 'Cruise Finder' page
		Assert.assertTrue(cruiseFinder.cruiseFinderText.isDisplayed(), "Not navigated to Cruise Finder page");
		

	}
}
