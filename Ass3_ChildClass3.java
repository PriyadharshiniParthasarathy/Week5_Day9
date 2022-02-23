package Week5_Day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Ass3_ChildClass3 extends Ass3_ChildClass2{

		@Test(priority=3, dependsOnMethods="Update_existing_incident",alwaysRun =true)
		public void Assign_incident() throws InterruptedException { 
			
			
		//Enter Incident in filter navigator and press enter
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
			driver.findElement(By.xpath("//input[@ng-model='filterTextValue']")).sendKeys("incident");
			driver.findElement(By.xpath("(//div[text()='All'])[2]")).click();
			Thread.sleep(3000);
			driver.switchTo().frame("gsft_main");
			WebElement Number3 = driver.findElement(By.xpath("//div[@class='input-group']//input[1]"));
			Number3.click();
			Number3.sendKeys(elementval);
			Number3.sendKeys(Keys.ENTER);
			System.out.println(elementval);
			
		// Click on Incident number
			driver.switchTo().defaultContent();
			driver.switchTo().frame("gsft_main");
			driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
			
		// Select the Assignment group
			driver.findElement(By.xpath("//input[@id='sys_display.incident.assignment_group']")).sendKeys("Database");
			
		// Select the Assigned To
	        WebElement Assigned_To = driver.findElement(By.xpath("//input[@data-name='assigned_to']"));
	        Thread.sleep(3000);
			Assigned_To.sendKeys("ITIL User",Keys.ENTER);
			
		//Click on update button
			Thread.sleep(3000);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("gsft_main");
			driver.findElement(By.xpath("//button[@id='sysverb_update']")).click();
			
		// Get the Assignment group text
			driver.switchTo().defaultContent();
			driver.switchTo().frame("gsft_main");
			WebElement Assignment_group = driver.findElement(By.xpath("//a[contains(text(),'Database')]"));
			String Assignment_group1 = Assignment_group.getText();
			System.out.println("Assignment_group------- " + Assignment_group1);
						
		// Get the Assigned To text
		    WebElement Assigned_To1 = driver.findElement(By.xpath("//a[contains(text(),'ITIL User')]"));
			String Assigned_To2= Assigned_To1.getText();
			System.out.println("Assigned_To------- " + Assigned_To2);
						
		// Verified the State and Priority
			if(Assignment_group1.contains("Database"))
			{
			System.out.println("Assignment_group is verified");
			}
			 else
			System.out.println("Assignment_group is not verified");
			if(Assigned_To2.contains("ITIL User"))
			{
			System.out.println("Assigned to is verified");
			 }
			else
		System.out.println("Assigned to is not verified");
		}
}
	
