import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserActivities {

	public static void main(String[] args) {
		//TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "/Users/PRASAD/eclipse-workspace/Selenium/chromedriver.exe");
		WebDriver driver = new ChromeDriver();	
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.navigate().to("https://www.reddit.com/");
		driver.navigate().back();
		driver.navigate().forward();
		
			
	}

}
