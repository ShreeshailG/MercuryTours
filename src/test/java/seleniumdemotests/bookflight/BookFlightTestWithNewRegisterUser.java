package seleniumdemotests.bookflight;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.FlightFinderPage;
import pages.HomePage;
import pages.RegisterPage;
import seleniumdemotests.BaseTest;

public class BookFlightTestWithNewRegisterUser extends BaseTest{

	RegisterPage registerPage;
	HomePage homePage;
	FlightFinderPage flightFinder;

	@BeforeTest
	public void initialize() {
		// Initialize pages

		homePage = new HomePage(driver);
		homePage.navigateToHome();

	}


	@Test(dataProvider = "registrationAndFlight")
	public void testBookFlightTestWithNewRegisterUser(String firstName,String lastName,String phone,String email,String address,
			String city,String state,String postalCode,String country,String username,String password,String confirmPassword) throws Exception {

		homePage.register.click();
		registerPage = new RegisterPage(driver);

		// Verify user is navigated to 'Register Page'
		Assert.assertTrue(registerPage.registerPageText.isDisplayed(), "Not navigated to Register Page");

		registerPage.fillRegistrationForm(firstName, lastName, phone, email, address, city, state, postalCode, country, username, password, confirmPassword);

		// Verify user is registerd
		Assert.assertEquals(registerPage.successText.get(0).getText(), "Dear "+firstName + " "+lastName+",");

		homePage.flightsLink.click();
		flightFinder = new FlightFinderPage(driver);

		// Verify user is navigated to 'Flight FInder' page
		Assert.assertTrue(flightFinder.flightFinderPageText.isDisplayed(), "Not navigated to Flight Finder page");

		// Fill details for flight
		flightFinder.fillFlightDetails(FlightFinderPage.TripType.ONE_WAY, "1", "Acapulco", "November",
				"12", "Paris", "November", "22", FlightFinderPage.ServiceClass.BUSINESS);

		// Assert flight is not available
		Assert.assertTrue(
				flightFinder.successText.getText().contains("After flight finder - No Seats Avaialble"));


	}

	@DataProvider(name="registrationAndFlight")
	public Object[][] getDataFromDataprovider(){
		return new Object[][] 
				{
			{ "firstName", "lastName", "9999999999", "emai@email.com",
				"address","city", "state", "111111", "IRAQ", "username", "password", "password" },

				};

	}

}
