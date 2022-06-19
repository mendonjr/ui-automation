package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.input.Input;
import org.testng.Assert;

public class HandleCheckbox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/PRASAD/eclipse-workspace/Selenium/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

		// click on checkbox using reg expression in xpath

		Assert.assertFalse(driver.findElement((By.cssSelector("input[id*='SeniorCitizenDiscount']"))).isSelected(),
				"Checkbox should not be selected");

		driver.findElement((By.cssSelector("input[id*='SeniorCitizenDiscount']"))).click();

		// check if checkbox is selected or not
		Assert.assertTrue(driver.findElement((By.cssSelector("input[id*='SeniorCitizenDiscount']"))).isSelected());

		// count the number of checkboxes with common xpath using size method

		System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
	}

}
