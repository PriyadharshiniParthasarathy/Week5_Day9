package Week5_Day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ass1_BaseClass
{
	WebDriver  driver;
@BeforeMethod
	 public void loginPage() {
     WebDriverManager.chromedriver().setup();
	 driver = new ChromeDriver();
     driver.get("http://leaftaps.com/opentaps/control/main");
     driver.manage().window().maximize();
     driver.findElement(By.xpath("//input[@id='username']")).sendKeys("Demosalesmanager");
     driver.findElement(By.xpath("//input[@name='PASSWORD']")).sendKeys("crmsfa");
     driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
     driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();	
	}

@AfterMethod
public void Close() {
driver.close();	
	}

	}