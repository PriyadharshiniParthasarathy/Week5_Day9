package Week5_Day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Ass1_ChildClass4_DuplicateLead extends Ass1_BaseClass{
	
		@Test
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


			}
		}
	