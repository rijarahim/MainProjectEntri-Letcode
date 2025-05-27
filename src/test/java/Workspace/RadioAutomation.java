package Workspace;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioAutomation extends Base {

	@Test(priority = 1)
	public void SelectAnyOne() {
		driver.navigate().to("https://letcode.in/radio");
		WebElement RadioButton1 = driver.findElement(By.xpath("//input[@id='yes']"));
		RadioButton1.click();
	}	
		
	@Test(priority = 2)
	public void ConfirmSelectOnlyone() {
		WebElement RadioButton1 = driver.findElement(By.xpath("//input[@id='one']"));
		RadioButton1.click();
		WebElement RadioButton2 = driver.findElement(By.xpath("//input[@id='two']"));
		RadioButton2.click();		
		Boolean isSelected1 = RadioButton1.isSelected();
		Boolean isSelected2 = RadioButton2.isSelected();		
		Assert.assertTrue(isSelected2 && !isSelected1, "Both are selected");
	}		
	
	@Test(priority = 3)
	public void FindWhichOneIsselected() {
		WebElement RadioButton3 = driver.findElement(By.xpath("//input[@id='foo']"));
		RadioButton3.isSelected();
	}
	
	@Test(priority = 4)
	public void FindBug() {
		WebElement RadioButton1 = driver.findElement(By.xpath("//input[@id='nobug']"));
		RadioButton1.click();		
		WebElement RadioButton2 = driver.findElement(By.xpath("//input[@id='bug']"));
		RadioButton2.click();		
		Boolean isSelected1 = RadioButton1.isSelected();
		Boolean isSelected2 = RadioButton2.isSelected();		
		Assert.assertTrue(isSelected2 && !isSelected1, "Both are selected");
	}
		@Test(priority = 5)
		public void ConfirmLastFieldIsDisabled() {
			WebElement RadioButton1 = driver.findElement(By.xpath("//input[@id='going']"));
			RadioButton1.click();			
			WebElement RadioButton2 = driver.findElement(By.xpath("//input[@id='notG']"));
			RadioButton2.click();
			Boolean isSelected1 = RadioButton1.isSelected();
			Boolean isSelected2 = RadioButton2.isSelected();			
			Assert.assertTrue(isSelected2 && !isSelected1, "Both are selected");
			
			WebElement RadioButton3 = driver.findElement(By.xpath("//input[@id='maybe']"));
			RadioButton2.click();
			RadioButton3.isEnabled();
		    Assert.assertFalse(RadioButton3.isEnabled(),"Field is enabled, but it should be disabled!");		
	}
	
}
	