package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage extends BasePage {

	public final WebDriver driver;
	@FindBy(css = "img[src='images/mast_register.gif']")
	public WebElement registerPageText;

	@FindBy(css = "input[name='firstName']")
	public WebElement firstNameTextbox;

	@FindBy(css = "input[name='lastName']")
	public WebElement lastNameTextbox;

	@FindBy(css = "input[name='phone']")
	public WebElement phoneTextbox;

	@FindBy(css = "input[name='userName']")
	public WebElement emailTextbox;

	@FindBy(css = "input[name='address1']")
	public WebElement addressTextbox;

	@FindBy(css = "input[name='city']")
	public WebElement cityTextbox;

	@FindBy(css = "input[name='state']")
	public WebElement stateTextbox;

	@FindBy(css = "input[name='postalCode']")
	public WebElement postalCodeTextbox;

	@FindBy(css = "select[name='country']")
	public WebElement countryDropdownElementElement;
	Select countryDropdown = new Select(countryDropdownElementElement);

	@FindBy(css = "input[name='email']")
	public WebElement userNameTextbox;

	@FindBy(css = "input[name='password']")
	public WebElement passwordTextbox;

	@FindBy(css = "input[name='confirmPassword']")
	public WebElement confirmPasswordTextbox;
	
	@FindBy(css = "input[name='submit']")
	public WebElement submitButton;
	
	@FindBy(xpath = "(//img[@src='images/mast_register.gif']/ancestor::tbody)[4]/tr[3]//p")
	public List<WebElement> successText;

	public RegisterPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	public void fillRegistrationForm(String firstName,String lastName,String phone,String email,String  address,String city,String state, String postalCode, String country, String username,String password,String confirmPassword) throws InterruptedException {
		firstNameTextbox.clear();
		firstNameTextbox.sendKeys(firstName);
		
		lastNameTextbox.clear();
		lastNameTextbox.sendKeys(lastName);
		
		phoneTextbox.clear();
		phoneTextbox.sendKeys(phone);
		
		emailTextbox.clear();
		emailTextbox.sendKeys(email);
		
		addressTextbox.clear();
		addressTextbox.sendKeys(address);
		
		cityTextbox.clear();
		cityTextbox.sendKeys(city);
		
		stateTextbox.clear();
		stateTextbox.sendKeys(state);
		
		postalCodeTextbox.clear();
		postalCodeTextbox.sendKeys(postalCode);
		
		countryDropdown.selectByVisibleText(country);
		
		userNameTextbox.clear();
		userNameTextbox.sendKeys(username);
		
		passwordTextbox.clear();
		passwordTextbox.sendKeys(password);
		
		confirmPasswordTextbox.clear();
		confirmPasswordTextbox.sendKeys(confirmPassword);
		
		submitButton.click();
	}

}
