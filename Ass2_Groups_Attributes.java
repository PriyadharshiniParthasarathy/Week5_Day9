package Week5_Day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Ass2_Groups_Attributes{

@Test(groups={"Execute"})
public void CreateContact() {
    WebDriverManager.chromedriver().setup();
    ChromeDriver driver = new ChromeDriver();
    driver.get("http://leaftaps.com/opentaps/control/main");
    driver.manage().window().maximize();
    driver.findElement(By.xpath("//input[@id='username']")).sendKeys("Demosalesmanager");
    driver.findElement(By.xpath("//input[@name='PASSWORD']")).sendKeys("crmsfa");
    driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
    driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();	
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
	
	driver.findElement(By.partialLinkText("Leads")).click();
	driver.findElement(By.partialLinkText("Create Lead")).click();
	driver.findElement(By.id("createLeadForm_companyName")).sendKeys("CTS");
	driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Priya");
	driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Dharshini");
	driver.findElement(By.className("smallSubmit")).click();
	System.out.println("CreateContact-----------");
		}


@Test(groups={"Test1"})
public void EditLead() throws InterruptedException {
    WebDriverManager.chromedriver().setup();
    ChromeDriver driver = new ChromeDriver();
    driver.get("http://leaftaps.com/opentaps/control/main");
    driver.manage().window().maximize();
    driver.findElement(By.xpath("//input[@id='username']")).sendKeys("Demosalesmanager");
    driver.findElement(By.xpath("//input[@name='PASSWORD']")).sendKeys("crmsfa");
    driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
    driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();	
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

	driver.findElement(By.xpath("//a[contains(text(),'Leads')]")).click();
	driver.findElement(By.xpath("//a[contains(text(),'Find Leads')]")).click();
	driver.findElement(By.xpath("(//input[@name='firstName'])[3]")).sendKeys("Demo");
	driver.findElement(By.xpath("//button[contains(text(),'Find Leads')]")).click();
	Thread.sleep(3000);
	driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a")).click();
	Thread.sleep(3000);
	String actualTitle = driver.getTitle();
	String expectedTitle ="View Lead | opentaps CRM";

	if(actualTitle.equalsIgnoreCase(expectedTitle))
	{
		System.out.println("Title Matched");
	}
	else {
		System.out.println("Title didn't match");
		}
	driver.findElement(By.xpath("//a[contains(text(),'Edit')]")).click();
	driver.findElement(By.xpath("(//input[@name='companyName'])[2]")).clear();
	String Companyname = "Org1";
	driver.findElement(By.xpath("(//input[@name='companyName'])[2]")).sendKeys(Companyname);
	driver.findElement(By.xpath("(//input[@name='submitButton'])[1]")).click();
	if (driver.findElement(By.xpath("//span[contains(text(),'Org1')]")).isDisplayed())
			{
		System.out.println("EditLead is succeed");
			}
}
	
	@Test(groups={"Execute"}, invocationCount =5, threadPoolSize = 2)
	public void DuplicateLead() throws InterruptedException {
	    WebDriverManager.chromedriver().setup();
	    ChromeDriver driver = new ChromeDriver();
	    driver.get("http://leaftaps.com/opentaps/control/main");
	    driver.manage().window().maximize();
	    driver.findElement(By.xpath("//input[@id='username']")).sendKeys("Demosalesmanager");
	    driver.findElement(By.xpath("//input[@name='PASSWORD']")).sendKeys("crmsfa");
	    driver.findElement(By.xpath("//input[@class='decorativeSubmit']")).click();
	    driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();	
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
	driver.findElement(By.xpath("//a[contains(text(),'Leads')]")).click();
	driver.findElement(By.xpath("//a[contains(text(),'Find Leads')]")).click();
	driver.findElement(By.xpath("//span[contains(text(),'Email')]")).click();
	driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys("abc@gmail.com");
	driver.findElement(By.xpath("//button[contains(text(),'Find Leads')]")).click();
	Thread.sleep(3000);
	WebElement Firstname = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-firstName'][1]//a"));
	String Firstname1 = Firstname.getText();
	System.out.println("First Resulting name is:- " +Firstname1);
	Firstname.click();
	driver.findElement(By.xpath("//div[@class='frameSectionExtra'][1]//a[1]")).click();
	if(driver.getTitle().contains("Duplicate Lead"))
	{
		System.out.println("Verified title");
	}
	else
	{
		System.out.println("Title name is mismatching as per expected");
	}
	driver.findElement(By.xpath("//input[@class='smallSubmit']")).click();
	WebElement Duplicate_Firstname =driver.findElement(By.xpath("//span[@id='viewLead_firstName_sp']"));
	String Duplicate_Firstname1 = Duplicate_Firstname.getText();

	if(Duplicate_Firstname1.equals(Firstname1))
	{
		System.out.println("Duplicate name & Captured name are same");
	}
	else
	{
		System.out.println("Duplicate name & Captured name are not same");
	}
}



	}