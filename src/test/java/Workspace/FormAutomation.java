package Workspace;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class FormAutomation extends Base {
	
	@Test
	public void form() {
				
		driver.navigate().to("https://letcode.in/forms");
		WebElement firstName = driver.findElement(By.xpath("//input[@id='firstname']"));
		wait.until(ExpectedConditions.visibilityOf(firstName));	
		firstName.sendKeys("John");
		
		WebElement lastName = driver.findElement(By.xpath("//input[@id='lasttname']"));
		wait.until(ExpectedConditions.visibilityOf(lastName));	
		lastName.sendKeys("Smith");
		
		WebElement emailField = driver.findElement(By.xpath("//input[@id='email']"));
		wait.until(ExpectedConditions.visibilityOf(emailField));	
		emailField.clear();
		
		WebElement emailField2 = driver.findElement(By.xpath("//input[@id='email']"));
		emailField2.sendKeys("johnsmith@gmail.com");
		
		WebElement countrycode = driver.findElement(By.xpath("//label[text()='Country code']/following::select[1]"));
		Select select1 = new Select(countrycode);
		select1.selectByValue("213");
		
		WebElement phoneNumberField = driver.findElement(By.xpath("//input[@id='Phno']"));
		phoneNumberField.sendKeys("9990005552");
		
		WebElement addressField1 = driver.findElement(By.xpath("//input[@id='Addl1']"));
		addressField1.sendKeys("testAddress1");
		
		WebElement addressField2 = driver.findElement(By.xpath("//input[@id='Addl2']"));
		addressField2.sendKeys("testAddress2");
		
		WebElement stateField = driver.findElement(By.xpath("//input[@id='state']"));
		stateField.sendKeys("TamilNadu");
		
		WebElement postalcodeField = driver.findElement(By.xpath("//input[@id='postalcode']"));
		postalcodeField.sendKeys("60001");
		
		WebElement country = driver.findElement(By.xpath("//label[@id='country']/following::select[1]"));
		Select select2 = new Select(country);
		select2.selectByValue("India");
		System.out.println("country selected");
		
		WebElement date = driver.findElement(By.xpath("//input[@id='Date']"));
		date.sendKeys("05-14-02025");
		System.out.println("Date is selected");
		
		WebElement femaleRadio = driver.findElement(By.id("female"));
		wait.until(ExpectedConditions.elementToBeClickable(femaleRadio));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", femaleRadio);
		
		boolean isFemaleSelected = femaleRadio.isSelected();
		System.out.println(isFemaleSelected);
		System.out.println("isFemaleSelected");
		
		WebElement checkbox = driver.findElement(By.xpath("//input[@type='checkbox']"));
		wait.until(ExpectedConditions.visibilityOf(checkbox));
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", checkbox);

		 // Click checkbox if not already selected
        if (!checkbox.isSelected()) {
            checkbox.click();
        }

        System.out.println("Checkbox selected: " + checkbox.isSelected());
	
		try {
		    WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(
		        By.xpath("//button[@type='submit'] | //input[@type='submit']")
		    ));
		    submit.click();
		    System.out.println("✅ Clicked the submit button.");
		} catch (org.openqa.selenium.NoSuchSessionException e) {
		    System.out.println("❌ ERROR: The browser session was lost. Reason: " + e.getMessage());
		} catch (Exception e) {
		    System.out.println("❌ General Error: " + e.getMessage());
		}
	    
	}
	
}
	


