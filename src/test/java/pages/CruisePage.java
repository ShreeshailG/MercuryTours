package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CruisePage extends BasePage{

	public final WebDriver driver;
	public static enum TripType{
		ROUND_TRIP,ONE_WAY
	}
	
	public static enum ServiceClass{
		ECONOMY,BUSINESS,FIRST
	}
	
	@FindBy(css="img[src='images/mast_cruisefinder.gif']")
	public WebElement cruiseFinderText;
	

	public CruisePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
}
