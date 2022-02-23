package Week5_Day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Ass3_ChildClass2 extends Ass3_ChildClass1{


		@Test(priority=2, invocationCount=2)
		public void Update_existing_incident() throws InterruptedException { 
			
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
			
		// Select the State
			driver.switchTo().defaultContent();
			driver.switchTo().frame("gsft_main");
			Thread.sleep(3000);
			Select State = new Select(driver.findElement(By.xpath("//select[@id='incident.state']")));
			State.selectByVisibleText("In Progress");
			
		// Select the Urgency
			driver.switchTo().defaultContent();
			driver.switchTo().frame("gsft_main");
			Select Urgency = new Select(driver.findElement(By.xpath("//select[@id='incident.urgency']")));
			Urgency.selectByVisibleText("1 - High");
			
		// Enter the Work notes
			driver.switchTo().defaultContent();
			driver.switchTo().frame("gsft_main");
			driver.findElement(By.xpath("//textarea[@id='activity-stream-textarea']")).sendKeys("Testdata");	
			
	    // Click on Resolution information
			driver.switchTo().defaultContent();
			driver.switchTo().frame("gsft_main");
			driver.findElement(By.xpath("//span[contains(text(),'Resolution Information')]")).click();
			
		// Select the Resolution code
			driver.switchTo().defaultContent();
			driver.switchTo().frame("gsft_main");
			Select Resolution = new Select(driver.findElement(By.xpath("//select[@id='incident.close_code']")));
			Resolution.selectByVisibleText("Solved (Work Around)");
			
		// Provide the Resolution notes
			driver.switchTo().defaultContent();
			driver.switchTo().frame("gsft_main");
			driver.findElement(By.xpath("//textarea[@id='incident.close_notes']")).sendKeys("Testdata123");
			
		//Click on update button
			driver.switchTo().defaultContent();
			driver.switchTo().frame("gsft_main");
			driver.findElement(By.xpath("//button[@id='sysverb_update']")).click();
			
		// Get the Priority text
			driver.switchTo().defaultContent();
			driver.switchTo().frame("gsft_main");
			WebElement Priority = driver.findElement(By.xpath("//td[contains(text(),'3 - Moderate')]"));
			String Priority1 = Priority.getText();
			System.out.println("Priority------- " + Priority1);
			
		// Get the State text
		    WebElement State1 = driver.findElement(By.xpath("//td[contains(text(),'In Progress')]"));
		    String State2= State1.getText();
			System.out.println("State------- " + State2);
			
		// Verified the State and Priority
			if(Priority1.contains("Moderate"))
		       {
		    		  System.out.println("Priority is verified");
		       }
		       else
		    	   
		    	   System.out.println("Priority is not verified");
			if(State2.contains("In Progress"))
		       {
		    		  System.out.println("State is inprogress");
		       }
		       else
		    	   
		    	   System.out.println("State is not inprogress");
		}
}
	
