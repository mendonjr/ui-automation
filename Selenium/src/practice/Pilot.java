package practice;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Pilot {

	public static void main(String[] args) {
		//TODO Auto-generated method stub
		
		System.setProperty("webdriver.chromedriver.exe", "/Users/PRASAD/eclipse-workspace/Selenium/Chromedriver");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.freeCodeCamp.org");
		System.out.println(driver.getTitle());
		
		
	}

}
