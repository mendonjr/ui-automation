import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class UpdatedDropdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "/Users/PRASAD/eclipse-workspace/Selenium/chromedriver.exe");
		WebDriver driver = new ChromeDriver();	
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		Select dropdown=new Select(driver.findElement(By.xpath(".//*[@id='ctl00_mainContent_ddl_Adult']")));

		dropdown.selectByIndex(4);

		dropdown.selectByVisibleText("9 Adults");

		dropdown.selectByValue("8");
		
	}

}
