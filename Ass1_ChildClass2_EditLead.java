package Week5_Day1;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Ass1_ChildClass2_EditLead extends Ass1_BaseClass{
		@Test
		public void EditLead() throws InterruptedException {

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

			
		}
		

	}
