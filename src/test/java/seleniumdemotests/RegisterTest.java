package seleniumdemotests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.RegisterPage;

public class RegisterTest extends BaseTest{
	HomePage homePage;
	RegisterPage registerPage;
	
	@BeforeTest
	public void initialize() {
		
		homePage = new HomePage(getDriver());
		homePage.navigateToHome();
	}
	
	@Test(dataProvider = "registrationAndFlight")
	public void register(String firstName,String lastName,String phone,String email,String address,
			String city,String state,String postalCode,String country,String username,String password,String confirmPassword) throws InterruptedException {		
		
		homePage.register.click();
		registerPage = new RegisterPage(driver);

		// Verify user is navigated to 'Register Page'
		Assert.assertTrue(registerPage.registerPageText.isDisplayed(), "Not navigated to Register Page");

		registerPage.fillRegistrationForm(firstName, lastName, phone, email, address, city, state, postalCode, country, username, password, confirmPassword);

		// Verify user is registerd
		Assert.assertEquals(registerPage.successText.get(0).getText(), "Dear "+firstName + " "+lastName+",");
	}
	
	@DataProvider(name="registrationAndFlight")
	public Object[][] getDataFromDataprovider(){
		return new Object[][] 
				{
			{ "firstName1", "lastName1", "9999999999", "emai@email.com",
				"address","city", "state", "111111", "IRAQ", "firstName1", "password", "password" },

				};

	}

}
