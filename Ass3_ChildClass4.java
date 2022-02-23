package Week5_Day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Ass3_ChildClass4 extends Ass3_ChildClass3{

		@Test(priority=4, enabled =false)
		public void Deleted_incident() throws InterruptedException { 
			
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
		
		//Click on update button
			Thread.sleep(3000);
			driver.switchTo().defaultContent();
			driver.switchTo().frame("gsft_main");
			driver.findElement(By.xpath("//button[@id='sysverb_delete']")).click();
			driver.findElement(By.xpath("(//button[text()='Delete'])[3]")).click();
						
		// No records to display
			driver.switchTo().defaultContent();
			driver.switchTo().frame("gsft_main");
		    WebElement No_record = driver.findElement(By.xpath("//td[contains(text(),'No records to display')]"));
			String No_record2= No_record.getText();
			System.out.println("Verify the deleted incident--" + No_record2);
			
						
		
		}
}
	
