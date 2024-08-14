package Project2.TestComponents;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.bouncycastle.oer.its.ieee1609dot2.basetypes.PublicVerificationKey;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Project2.pageObjectModel.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseSetup {
	
	public WebDriver driver;
	public HomePage homePage;
	
	public WebDriver initialization() throws IOException {
		
		Properties properties = new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\Team EERO\\Documents\\Crio\\ShopApplication\\src\\main\\java\\Project1\\resources\\Global.properties");
		properties.load(file);
		String browserName = properties.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome")){
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		return driver;
	}
	
	@BeforeMethod
	public HomePage setup() throws IOException {
		
		driver = initialization();
		homePage = new HomePage(driver);
		homePage.goTo();
		return homePage;
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.close();
	}
	
	
	

}
