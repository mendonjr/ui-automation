package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/PRASAD/eclipse-workspace/Selenium/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");

		WebElement ddElement = driver.findElement(By.id("exampleFormControlSelect1"));
		Select dropdown = new Select(ddElement);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.findElement(By.xpath("(//input[@name='name'])[1]")).sendKeys("Prasad Mendon");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("wdw@wd.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("ola@amigos");
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();

		dropdown.selectByIndex(1);
		driver.findElement(By.xpath("//label[text()='Student']")).click();
		driver.findElement(By.xpath("//label[text()='Date of Birth']/following-sibling::input")).sendKeys("01-02-1964");

		driver.findElement(By.xpath("//input[@type='submit']")).click();
		boolean isVisible = driver.findElement(By.xpath("//a[@class='close']/parent::div[1]")).isDisplayed();

		Assert.assertTrue(isVisible);

		System.out.println("Test Case Passed");

	}

}
