package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleAlerts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "/Users/PRASAD/eclipse-workspace/Selenium/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/dropdownsPractise/"); // URL in the browser
		// switch context from driver browser to alert
		driver.switchTo().alert().accept(); // click on OK alert
		driver.switchTo().alert().dismiss(); // click on cancel alert

		// format using ctrl+shift+F
	}

}
