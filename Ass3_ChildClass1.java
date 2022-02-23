package Week5_Day1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Ass3_ChildClass1 extends Ass3_BaseClass1{
	String elementval;
	String Number1;

	@Test(priority=1)
	public void Create_new_incident() throws InterruptedException {
		
		WebElement search = driver.findElement(By.xpath("//input[@id='filter']"));
		search.sendKeys("incident");
		search.click();
		
		        //Click “All”
				driver.findElement(By.linkText("All")).click();
				
				//Click New button
				driver.switchTo().frame("gsft_main");
				driver.findElement(By.xpath("//button[text()='New']")).click();
				
				//Select a value for Caller and Enter value for short_description
				driver.findElement(By.xpath("//input[@id='sys_display.incident.caller_id']")).sendKeys("Sam Sorokin");
				driver.findElement(By.id("incident.short_description")).sendKeys("Incident - Short_description");
				
				//Read the incident number and save it a variable
				elementval = driver.findElement(By.xpath("(//span[text()='Number']/following::input)[2]")).getAttribute("value");
				System.out.println(elementval);
				Thread.sleep(3000);
				
				//Click on Submit button
				driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
				System.out.println("Submitted");
				
				//Search the same incident number 
				WebElement Number = driver.findElement(By.xpath("//span[@class='sr-only']/following-sibling::input[1]"));
				Number.sendKeys(elementval);
				Number.sendKeys(Keys.ENTER);
				
				//Verify the incident is created successful 
				driver.switchTo().defaultContent();
				driver.switchTo().frame("gsft_main");
				String Number1= driver.findElement(By.xpath("//a[@class='linked formlink']")).getText();
				System.out.println(Number1 +" ---------Incident is created successful");  					
	
	}	
}

	
