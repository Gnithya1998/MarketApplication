package Project2.pageObjectModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (css = "[class = 'product']")
	List<WebElement> products;
	
	public void goTo() {
		
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	}
	
	public int productSize() {
		
		int size = products.size();
		return size;
	}
	
	public boolean ProductMatch(String prod) {
		
		boolean match = products.stream().anyMatch(product-> product.getText().contains(prod));
		return match;
		
	}
	
	public void addItem(String prod) {
		
		WebElement element = (WebElement) products.stream().filter(product-> product.findElement(By.className("product-name")).getText()
				.contains(prod)).findFirst().orElse(null);
		//System.out.print(element.getText());
		element.findElement(By.cssSelector("[type = 'button']")).click();
	}
	
	public void navigateToCheckout() {
		
		driver.findElement(By.cssSelector("[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
	}
	
	
	
	
}
