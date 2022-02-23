package Week5_Day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Ass1_ChildClass3_DeleteLead extends Ass1_BaseClass{

		@Test
		public void DeleteLead() throws InterruptedException {

			driver.findElement(By.xpath("//a[contains(text(),'Leads')]")).click();
			driver.findElement(By.xpath("//a[contains(text(),'Find Leads')]")).click();
			driver.findElement(By.xpath("//span[contains(text(),'Phone')]")).click();
			driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("9876543210");
			driver.findElement(By.xpath("//button[contains(text(),'Find Leads')]")).click();
			Thread.sleep(3000);
			WebElement LeadID = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId'][1]//a"));
			String LeadID1 = LeadID.getText();// doubts why is covering into string
			System.out.println("First Resulting LeadID No:- " +LeadID1);
			LeadID.click();
			driver.findElement(By.xpath("//a[text()='Delete']")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//a[contains(text(),'Find Leads')]")).click();
			driver.findElement(By.xpath("//input[@name='id']")).sendKeys(LeadID1);
			driver.findElement(By.xpath("//button[contains(text(),'Find Leads')]")).click();
			Thread.sleep(3000);
			if (driver.findElement(By.className("x-paging-info")).isDisplayed())

				
	{
			System.out.println("No records to display- should be printed");
	}
			else
			{
				System.out.println("Records to displayed");
			}
			
		}
		

	}
