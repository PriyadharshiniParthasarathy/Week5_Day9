package Week5_Day1;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ass3_BaseClass1
{
	WebDriver driver;
	@BeforeMethod
		 public void loginPage1() {
		WebDriverManager.chromedriver().setup(); 
		driver = new ChromeDriver();
		driver.manage().window().maximize(); 
		driver.get("https://dev76574.service-now.com"); 
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        driver.switchTo().frame(0);
		WebElement Username = driver.findElement(By.name("user_name"));
		Username.sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("gJOBntpDH23i");
		driver.findElement(By.name("not_important")).click();

	}
	
	@AfterMethod
	public void Close() {
	driver.close();	
		}


}

