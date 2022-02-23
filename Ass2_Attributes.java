package Week5_Day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Ass2_Attributes extends Ass2_BaseClass{	
	
@Test(priority=1)
	public void EditLead() throws InterruptedException
{
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
		System.out.println("Updated Company name is displayed");
			}

		System.out.println("EditLead");	
	}

@Test(priority=2, dependsOnMethods="EditLead",alwaysRun =true)

	public void CreateLead() {
		
		driver.findElement(By.partialLinkText("Leads")).click();
		driver.findElement(By.partialLinkText("Create Lead")).click();

		//Enter all the fields in CreateLead page

		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("CTS");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Priya");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Dharshini");
		Select Source = new Select(driver.findElement(By.name("dataSourceId")));
		Source.selectByVisibleText("Other");
		Select Campaign = new Select(driver.findElement(By.name("marketingCampaignId")));
		Campaign.selectByIndex(3);
		driver.findElement(By.name("firstNameLocal")).sendKeys("Hello");
		driver.findElement(By.name("lastNameLocal")).sendKeys("Hi");
		driver.findElement(By.name("personalTitle")).sendKeys("Java");
		driver.findElement(By.id("createLeadForm_birthDate")).sendKeys("01/6/22");
		driver.findElement(By.name("generalProfTitle")).sendKeys("Selenium");
		driver.findElement(By.name("departmentName")).sendKeys("Automation Testing");
		driver.findElement(By.name("annualRevenue")).sendKeys("10000");
		Select Industry = new Select(driver.findElement(By.name("industryEnumId")));
		Industry.selectByIndex(5);
		Select Preferred_Currency = new Select(driver.findElement(By.name("currencyUomId")));
		Preferred_Currency.selectByIndex(8);
		Select Ownership = new Select(driver.findElement(By.name("ownershipEnumId")));
		Ownership.selectByVisibleText("Corporation");
		driver.findElement(By.id("createLeadForm_numberEmployees")).sendKeys("100");
		driver.findElement(By.name("sicCode")).sendKeys("A001");
		driver.findElement(By.name("tickerSymbol")).sendKeys("$001");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("No comments");
		driver.findElement(By.name("importantNote")).sendKeys("NA");
	

		//Enter all the fields in contact information   
		driver.findElement(By.id("createLeadForm_primaryPhoneCountryCode")).sendKeys("234");
		driver.findElement(By.id("createLeadForm_primaryPhoneAreaCode")).sendKeys("86231");
		driver.findElement(By.name("primaryPhoneExtension")).sendKeys("123456");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("test123@gmail.com");
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("9876543210");
		driver.findElement(By.name("primaryPhoneAskForName")).sendKeys("Extended");
		driver.findElement(By.id("createLeadForm_primaryWebUrl")).sendKeys("www.gmail.com");

		//Enter all the fields in Primary Address
		driver.findElement(By.name("generalToName")).sendKeys("Hello");
		driver.findElement(By.id("createLeadForm_generalAddress1")).sendKeys("Kuberan nagar");
		driver.findElement(By.name("generalCity")).sendKeys("Chennai");
		driver.findElement(By.id("createLeadForm_generalPostalCode")).sendKeys("600210");
		driver.findElement(By.id("createLeadForm_generalPostalCodeExt")).sendKeys("789456");
		driver.findElement(By.id("createLeadForm_generalAttnName")).sendKeys("Hi");
		driver.findElement(By.id("createLeadForm_generalAddress2")).sendKeys("Kuberan nagar 1st");
		Select Country = new Select(driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId")));
		Country.selectByIndex(5);

		//Click on create Lead Button

		driver.findElement(By.className("smallSubmit")).click();
		System.out.println("CreateLead");	
		
		
	}
	
@Test(priority=5,invocationCount=5)
	public void CreateContact() {
		
		driver.findElement(By.xpath("//a[contains(text(),'Contacts')][1]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Create Contact')][1]")).click();
		driver.findElement(By.id("firstNameField")).sendKeys("Priyadharshini");
		driver.findElement(By.id("lastNameField")).sendKeys("Parthasarathy");
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("Hi");
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("Hello");
		driver.findElement(By.xpath("//input[@name='departmentName']")).sendKeys("IT");
		driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys("Automation testing");
		driver.findElement(By.xpath("//input[@id='createContactForm_primaryEmail']")).sendKeys("alpha123@gmail.com");
		WebElement State = (driver.findElement(By.xpath("//select[@name='generalStateProvinceGeoId']")));
		Select State1 = new Select(State);
		State1.selectByVisibleText("New York");
		driver.findElement(By.xpath("//input[@name='submitButton']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Edit')]")).click();
		driver.findElement(By.xpath("//textarea[@name='description']")).clear();
		driver.findElement(By.xpath("//textarea[@name='importantNote']")).sendKeys("Modified by the user");
		driver.findElement(By.xpath("//input[@value='Update']")).click();
		System.out.println("Browser title :- " +driver.getTitle());	
		System.out.println("CreateContact");	
	
	}
 
@Test(priority=4, enabled =false)
	public void DuplicateLead() throws InterruptedException {
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
	System.out.println("DuplicateLead");
	}
	
@Test(priority=3)
public void DuplicateLead2() throws InterruptedException {
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
System.out.println("DuplicateLead2");
}

	}
		
