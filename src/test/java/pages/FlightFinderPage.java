package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class FlightFinderPage extends BasePage {
	public final WebDriver driver;	
	public static enum TripType{
		ROUND_TRIP,ONE_WAY
	}
	
	public static enum ServiceClass{
		ECONOMY,BUSINESS,FIRST
	}
	
	@FindBy(css="img[src='images/mast_flightfinder.gif']")
	public WebElement flightFinderPageText;
	
	@FindBy(css= "input[name='tripType']")
	public List<WebElement> tripTypeRadiobutton;
	
	@FindBy(css = "select[name='passCount']")
	public WebElement passengerCountElemet;
	Select passengerCount = new Select (passengerCountElemet);
	
	@FindBy(css = "select[name='fromPort']")
	public WebElement departingFromElement;
	Select departingFrom = new Select(departingFromElement);
	
	@FindBy(css = "select[name='fromMonth']")
	public WebElement onMonthElement;
	Select onMonth = new Select(onMonthElement);
	
	@FindBy(css = "select[name='fromDay']")
	public WebElement onDayElement;
	Select onDay = new Select(onDayElement);
	
	@FindBy(css = "select[name='toPort']")
	public WebElement arrivingInElement;
	Select arrivingIn =  new Select(arrivingInElement);
	
	@FindBy(css = "select[name='toMonth']")
	public WebElement returningMonthElement;
	Select returningMonth = new Select(returningMonthElement);
	
	@FindBy(css = "select[name='toDay']")
	public WebElement returningDayElement;
	Select returningDay = new Select(returningDayElement);
	
	@FindBy(css="input[name='servClass']")
	public List<WebElement> serviceClassRadioButton;
	
	@FindBy(css = "select[name='airline']")
	public WebElement airline;
	
	@FindBy(css = "input[name='findFlights']")
	public WebElement continueButton;
	
	@FindBy(xpath = "(//table)[8]//p")
	public WebElement successText;

	public FlightFinderPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void fillFlightDetails(TripType tripType,String passenger,String departingFrom,String departingMonth,
			String departingDay,String arrivingAt,String arrivingMonth,String arrivingDay,ServiceClass serviceClass) {
		switch (tripType) {
		case ONE_WAY:
			tripTypeRadiobutton.get(0).click();
			break;
		case ROUND_TRIP:
			tripTypeRadiobutton.get(1).click();
			break;
		}
		
		passengerCount.selectByVisibleText(passenger);
		
		this.departingFrom.selectByVisibleText(departingFrom);
		
		onMonth.selectByVisibleText(departingMonth);
		
		onDay.selectByVisibleText(departingDay);
		
		arrivingIn.selectByVisibleText(arrivingAt);
		
		returningMonth.selectByVisibleText(arrivingMonth);
		
		returningDay.selectByVisibleText(arrivingDay);
		
		switch (serviceClass) {
		case ECONOMY:
			serviceClassRadioButton.get(0).click();
			break;
			
		case BUSINESS:
			serviceClassRadioButton.get(1).click();
			break;
			
		case FIRST:
			serviceClassRadioButton.get(2).click();
		}
		
		continueButton.click();
		
	}

}
