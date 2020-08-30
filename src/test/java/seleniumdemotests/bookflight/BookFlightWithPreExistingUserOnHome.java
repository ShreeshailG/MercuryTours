package seleniumdemotests.bookflight;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.FlightFinderPage;
import pages.HomePage;
import seleniumdemotests.BaseTest;

public class BookFlightWithPreExistingUserOnHome extends BaseTest {

	HomePage homePage;
	FlightFinderPage flightFinder;

	@BeforeTest
	public void initialize() {
		// Initialize pages
		homePage = new HomePage(getDriver());
		homePage.navigateToHome();

	}

	@Test
	public void testBookFlightWithPreExistingUserOnHome() throws Exception {


		homePage.login("testuday", "testuday");

		//Verify user is logged in
		Assert.assertTrue(homePage.loginSuccessMessage.isDisplayed(),"Not able to login");

		homePage.flightsLink.click();
		flightFinder = new FlightFinderPage(driver);

		//Verify navigated to 'Flight Finder' page
		Assert.assertTrue(flightFinder.flightFinderPageText.isDisplayed(), "Not navigated to Flight Finder page");
		
		flightFinder.fillFlightDetails(FlightFinderPage.TripType.ONE_WAY, "1", "Acapulco", "November",
				"12", "Paris", "November", "22", FlightFinderPage.ServiceClass.BUSINESS);

		Assert.assertTrue(
				flightFinder.successText.getText().contains("After flight finder - No Seats Avaialble"));


	}


}
