package Week5_Day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Ass1_ChildClass1_CreateContact extends Ass1_BaseClass{

	@Test
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
	
	}
	}