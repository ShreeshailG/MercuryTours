package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {
	
	public final WebDriver driver;
	@FindBy(css = "input[name='userName']")
	public WebElement userNameTextbox;
	
	@FindBy(css = "input[name='password']")
	public WebElement passwordTextbox;
	
	@FindBy(css = "input[name='submit']")
	public WebElement submitButton;
	
	@FindBy(xpath = "//h3[text()='Login Successfully']")
	public WebElement loginSuccessMessage;

	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void navigateToHome() {
//		driver.navigate().to("http://demo.guru99.com/test/newtours/");
	}
	
	public void login(String userName,String password) {
		userNameTextbox.clear();
		userNameTextbox.sendKeys(userName);
		
		passwordTextbox.clear();
		passwordTextbox.sendKeys(password);
		
		submitButton.click();
		
	}

}
