package Project2.Tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.dockerjava.api.model.Driver;

import Project2.TestComponents.BaseSetup;
import Project2.pageObjectModel.HomePage;

public class ProductCountsTest extends BaseSetup{
	
	@Test
	public void totalNumberOfProduct() throws IOException {
		
		HomePage homePage = new HomePage(driver);
		int productCount = homePage.productSize();
		String count = String.valueOf(productCount);
		Assert.assertEquals(count, "30");
		boolean match = homePage.ProductMatch("Cashews - 1 Kg");
		Assert.assertTrue(match);
	}

}
