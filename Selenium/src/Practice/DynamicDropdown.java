package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "/Users/PRASAD/eclipse-workspace/Selenium/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		//origin
		
		driver.findElement((By.id("ctl00_mainContent_ddl_originStation1_CTXT"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@value='JLR']")).click();
		Thread.sleep(3000);
		
		//destination
		
		driver.findElement((By.id("ctl00_mainContent_ddl_destinationStation1_CTXT"))).click();
		Thread.sleep(3000);
		
		//dynamic dropdown xpath with indexing
	//	driver.findElement(By.xpath("(//a[@value='HYD'])[2]")).click();
		
		//using parent-child relationship locator
		driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR']//a[@value='HYD']")).click();
		
	}

}
