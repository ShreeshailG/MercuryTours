package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	
	private final WebDriver driver;
	
	@FindBy(xpath = "//a[@href='login.php' and text()='SIGN-ON']")
	public WebElement signOn;
	
	@FindBy(xpath = "//a[@href='register.php' and text()='REGISTER']")
	public WebElement register;
	
	@FindBy(xpath = "//a[@href='index.php' and text()='SIGN-OFF']")
	public WebElement signOff;
	
	@FindBy(css = "a[href='reservation.php']")
	public WebElement flightsLink;
	
	@FindBy(xpath = "//a[text()='Cruises']")
	public WebElement cruiseLink;
	
	public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
