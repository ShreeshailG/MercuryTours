package seleniumdemotests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;  
public class BaseTest {
	
	public String baseUrl = "http://demo.guru99.com/test/newtours/";  
	String driverPath = System.getProperty("user.dir")+"//Driver//chromedriver.exe";  
	public WebDriver driver ;
	
	@BeforeSuite     
	public void setup() {      
		// set the system property for Chrome driver      
		System.setProperty("webdriver.chrome.driver", driverPath);  
		// Create driver object for CHROME browser  
		driver = new ChromeDriver();  
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);  
		driver.manage().window().maximize();  
		driver.get(baseUrl);  
		// get the current URL of the page  
		String URL= driver.getCurrentUrl();  
		System.out.print(URL);  
		//get the title of the page  
		String title = driver.getTitle();                  
		System.out.println(title);  
	}       
	     
	@AfterSuite
	public void afterTest() {  
		driver.quit();  
		System.out.println("after test");  
	}     
	
	public WebDriver getDriver() {
		if(driver != null) {
			return driver;
		}else {
			setup();
			return driver;
		}
		
	}
}  

