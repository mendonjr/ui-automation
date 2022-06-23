package functionalTests;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Base {

	static WebDriver driver = new ChromeDriver();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "/Users/PRASAD/eclipse-workspace/Selenium/chromedriver.exe");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(6));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");

		String[] cartSelection = { "Cucumber", "Brocolli", "Beetroot", "Carrot" };

		List<WebElement> expectedOptions = driver.findElements(By.cssSelector("h4.product-name"));

		sendToCart(cartSelection, expectedOptions);
		proceedToCheckout();
		placeOrder(w);
		selectCountry("India");

	}

	private static void selectCountry(String name) {
		WebElement country = driver.findElement(By.xpath("//select"));
		Select dropdown = new Select(country);
		dropdown.selectByValue(name);
		driver.findElement(By.cssSelector("input.chkAgree")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("input.chkAgree")).isSelected());
		driver.findElement(By.xpath("//button[text()='Proceed']")).click();
	}

	static void sendToCart(String[] expectedSelection, List<WebElement> options) {
		int j = 0;
		for (int i = 0; i < options.size() && j < expectedSelection.length; i++) {
			// click only on Add to Cart for Cucumber
			List<String> exp = Arrays.asList(expectedSelection);
			String[] a = options.get(i).getText().split("-");
			String formattedString = a[0].trim();
			if (exp.contains(formattedString)) {

				// do not depend upon text while building locators
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				j++;
			}

		}

	}

	static void proceedToCheckout() {
		driver.findElement(By.cssSelector("a.cart-icon")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
	}

	static void placeOrder(WebDriverWait w) {
		w.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("input.promoCode"))));
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("span.promoInfo")).getText(), "Code applied ..!");

		// explicit wait
		// wait until specific element is visible on screen

		w.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("span.promoInfo"))));

		driver.findElement(By.xpath("//button[text()='Place Order']")).click();
	}

}
