package practice;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Locators2 {

public static void main(String[] args) throws InterruptedException {

// TODO Auto-generated method stub

//implicit wait-2 seconds time out

System.setProperty("webdriver.chrome.driver", "/Users/PRASAD/eclipse-workspace/Selenium/chromedriver.exe");

WebDriver driver = new ChromeDriver();
String password = getPassword(driver);
System.out.println(password);

driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


driver.findElement(By.xpath("//button[text()='Go to Login']")).click();
Thread.sleep(3000);
driver.findElement(By.id("inputUsername")).sendKeys("rahul");
driver.findElement(By.name("inputPassword")).sendKeys(password);
driver.findElement(By.className("signInBtn")).click();
Thread.sleep(5000);
System.out.println(driver.findElement(By.xpath("//p")).getText());
}

public static String getPassword(WebDriver driver) throws InterruptedException {
	driver.get("https://rahulshettyacademy.com/locatorspractice/");
	driver.findElement(By.linkText("Forgot your password?")).click();

	Thread.sleep(1000);//

	driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("John");

	driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("john@rsa.com");

	driver.findElement(By.xpath("//input[@type='text'][2]")).clear();

	driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("john@gmail.com");

	driver.findElement(By.xpath("//form/input[3]")).sendKeys("9864353253");

	driver.findElement(By.cssSelector(".reset-pwd-btn")).click();

	String pwd = driver.findElement(By.cssSelector("form p")).getText();
	String[] password = pwd.split("'");
	password[1].split("'");
	
	return password[1].split("'")[0];
}
}