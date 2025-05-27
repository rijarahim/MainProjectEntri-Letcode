package Workspace;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AlertAutomation extends Base {
	
	@BeforeClass
	public void navigation() {
		driver.get("https://letcode.in/alert");
	}
	
	@Test(priority = 1)
	public void SimpleAlert() throws Exception {
		Thread.sleep(3000);
		WebElement simpleAlertButton = driver.findElement(By.xpath("//button[@id='accept']"));
		simpleAlertButton.click();
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept(); 
	}

	@Test(priority = 2)
	public void ConfirmAlert() throws Exception {
		Thread.sleep(3000);
		WebElement confirmationAlertButton = driver.findElement(By.xpath("//button[@id='confirm']"));
		confirmationAlertButton.click();
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().dismiss();
	}
	
	@Test(priority = 3)
	public void PromptAlert()throws Exception {
		Thread.sleep(3000);
		WebElement confirmationAlertButton = driver.findElement(By.xpath("//button[@id='prompt']"));
		confirmationAlertButton.click();
		wait.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().sendKeys("John Doe");
		driver.switchTo().alert().accept();
	}
	
	@Test(priority = 4)
	public void ModernAlert() throws Exception{
		Thread.sleep(3000);
		WebElement confirmationAlertButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='modern']")));
		confirmationAlertButton.click();	
		WebElement CloseButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='modal-close is-large']")));
		CloseButton.click();
	}
}
