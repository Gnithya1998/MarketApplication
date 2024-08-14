package Project2.Tests;


import org.testng.annotations.Test;

import Project2.TestComponents.BaseSetup;
import Project2.pageObjectModel.HomePage;

public class SubmitOrderTest extends BaseSetup {
	
	@Test
	public void submitOrder() throws InterruptedException {
		
		HomePage homePage = new HomePage(driver);	
		homePage.addItem("Mushroom - 1 Kg");
		Thread.sleep(1000);
		homePage.navigateToCheckout();
		
	}

}
