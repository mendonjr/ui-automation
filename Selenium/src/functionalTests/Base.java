package functionalTests;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {
	
	 static WebDriver driver = new ChromeDriver();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
System.setProperty("webdriver.chrome.driver", "/Users/PRASAD/eclipse-workspace/Selenium/chromedriver.exe");
		
	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		
		
		String[] cartSelection = {"Cucumber", "Brocolli", "Beetroot", "Carrot"};
		
		List<WebElement> expectedOptions = driver.findElements(By.cssSelector("h4.product-name"));
		
		sendToCart(cartSelection, expectedOptions);
		
		
	}
	
	
	 static void sendToCart(String[] expectedSelection, List<WebElement> options) {
		 int j=0;
		for(int i=0; i<options.size() && j<expectedSelection.length;i++) {
			//click only on Add to Cart for Cucumber
			List<String> exp = Arrays.asList(expectedSelection);
			String[] a = options.get(i).getText().split("-");
			String formattedString = a[0].trim();
				if(exp.contains(formattedString)){
					
					//do not depend upon text while building locators
					driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
					j++;
				}
				
			}

	}

}
