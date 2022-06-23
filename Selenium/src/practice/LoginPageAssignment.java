package practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageAssignment {

	// TODO Auto-generated method stub
	static WebDriver driver = new ChromeDriver();

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "/Users/PRASAD/eclipse-workspace/Selenium/chromedriver.exe");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");

		String[] cartSelection = { "Cucumber", "Brocolli", "Beetroot", "Carrot" };
		enterLoginDetails(w);
		addAllItemsToCart(w);
	}

	private static void addAllItemsToCart(WebDriverWait w) throws InterruptedException {
		// TODO Auto-generated method stub
		
		List<WebElement> elements = driver.findElements(By.cssSelector("button[class*='btn-info']"));
		
		for(int i=0;i<elements.size();i++) {
			elements.get(i).click();
		}
		//click on checkout
		driver.findElement(By.cssSelector("a.btn-primary")).click();
		driver.findElement(By.cssSelector("button.btn-success")).click();
		
		
		// Code to click on USA from dropdown

				driver.findElement(By.id("country")).sendKeys("Ind");

				// List<WebElement> options =
				// driver.findElements(By.xpath("//li[@class='ui-menu-item']/a"));
				List<WebElement> options = driver.findElements(By.xpath("//div[@class='suggestions']/ul/li/a"));

				for (WebElement option : options) {
					if (option.getText().contains("India")) {
						option.click();
						break;
					}
				}
				//wait until element is clickable to avoid ElementClickInterceptedException
				w.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("checkbox2")))).click();
				
				driver.findElement(By.cssSelector("input[value='Purchase']")).click();

	}

	private static void enterLoginDetails(WebDriverWait w) {
		// TODO Auto-generated method stub
		driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("password")).sendKeys("learning");
		//select radio button
		driver.findElement(By.xpath("//input[@value='user']/following-sibling::span")).click();
		w.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".modal-body"))));
		//driver.switchTo().alert().dismiss();
		driver.findElement(By.cssSelector("button#okayBtn")).click();
		WebElement element = driver.findElement(By.cssSelector("select.form-control"));
		Select dd = new Select(element);
		dd.selectByValue("consult");
		//click on agree terms checkbox
		driver.findElement(By.cssSelector("input#terms")).click();
		
		driver.findElement(By.cssSelector("input#signInBtn")).click();
		
	}
	

}
