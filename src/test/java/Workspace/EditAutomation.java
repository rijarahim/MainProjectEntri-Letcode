package Workspace;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EditAutomation extends Base {
	
	@BeforeClass
	public void navigation() {
		driver.get("https://letcode.in/edit");
	}
	
	@SuppressWarnings("deprecation")
	@Test(priority = 1)
	public void SendKeys()  {
		WebElement NameField = driver.findElement(By.xpath("//input[@id='fullName']"));
		String actualvalue = "John Doe";
		NameField.sendKeys(actualvalue);
		WebElement NameField1 = driver.findElement(By.xpath("//input[@id='fullName']"));
		String NewText = NameField1.getAttribute("value");
		System.out.println("Entered text is " + NewText);
		Assert.assertEquals(actualvalue, NewText, "not equal");
	}
	
	@Test(priority = 2)
	public void keyBoardTab() {	
		WebElement NameField1 = driver.findElement(By.xpath("//input[@id='join']"));
		NameField1.sendKeys(" girl");
		NameField1.sendKeys(Keys.TAB);
		// ToDo: Use Assert here to check if next text box is selected
	}
	
	@SuppressWarnings("deprecation")
	@Test(priority = 3)
		public void GetAttribute() {
		WebElement getAttributeField = driver.findElement(By.xpath("//input[@id='getMe']"));
		String actualvalue = getAttributeField.getAttribute("value"); //value = "ortonikc"
		String expectedValue = "ortonikc"; // The expected text inside the input
		Assert.assertEquals(actualvalue, expectedValue, "Value attribute did not match!");
	}
		
	@SuppressWarnings("deprecation")
	@Test(priority = 4)
		public void ClearText() {	
		WebElement clearme = driver.findElement(By.xpath("//input[@id='clearMe']"));
	    clearme.clear();
	    //Screenshot("cleartext.jpg");
	    WebElement clearme1 = driver.findElement(By.xpath("//input[@id='clearMe']"));
	    String actualValue = clearme1.getAttribute("value");
	    System.out.println(actualValue);
	    Assert.assertEquals(actualValue, "", "Input field is not cleared");
	}
	
	 @Test(priority = 5)
	 public void IsEnabled() {	
		 WebElement noEdit = driver.findElement(By.xpath("//input[@id='noEdit']"));
		 noEdit.isEnabled();
		 Assert.assertFalse(noEdit.isEnabled(),"Field is enabled, but it should be disabled!");
	}
	 
	@SuppressWarnings("deprecation")
	@Test(priority = 6)
	public void readOnly() {	
		WebElement readonly1 = driver.findElement(By.xpath("//input[@id='dontwrite']"));
		String fieldValue = readonly1.getAttribute("value");
		String isReadOnly = readonly1.getAttribute("readonly");
		Assert.assertNotNull(isReadOnly, "The email field should be readonly");
		Assert.assertEquals(fieldValue, "This text is readonly", "The field value is not correct");
	 }
}
