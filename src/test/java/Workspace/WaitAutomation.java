package Workspace;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

  public class WaitAutomation extends Base{
	  @Test(priority = 1)
		public void waitAutomation() {
		  driver.navigate().to("https://letcode.in/waits");
		  WebElement simpleAlertWait = driver.findElement(By.xpath("//button[@id='accept']"));
		  simpleAlertWait.click();
		  wait.until(ExpectedConditions.alertIsPresent());
		  driver.switchTo().alert().accept(); 
		  System.out.println("alertclosed");
	 }
} 