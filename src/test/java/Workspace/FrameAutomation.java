package Workspace;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FrameAutomation extends Base{
	 @Test
     public void frame() {
	        // Setup
		    driver.navigate().to("https://letcode.in/frame");
	        //Step 1: Switch to outer iframe      
	        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='firstFr']"));
	        wait.until(ExpectedConditions.visibilityOf(iframe));
	        driver.switchTo().frame(iframe);

	        // Step 2: Enter first and last name
	        WebElement firstName = driver.findElement(By.xpath("//input[@name='fname']"));
	        firstName.sendKeys("JOHN");

	        WebElement lastName = driver.findElement(By.xpath("//input[@name='lname']"));
	        lastName.sendKeys("DOE");
	        
	        WebElement message =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[contains(text(),'You have entered')]")));
	      	String actual = message.getText();
	        System.out.println(actual);
	        String expected = "You have entered JOHN DOE";
            Assert.assertEquals(actual, expected);

	        // Step 3: Switch to inner iframe (inside outer iframe)
	        driver.switchTo().frame(0); // First iframe inside the current frame

	        // Step 4: Enter email in nested frame
	        WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
	        email.sendKeys("rija@example.com");

	        // Step 5: Come back to the main page (outside all iframes)
	        driver.switchTo().defaultContent();

	        // Optional: Print title to verify you're back
	        System.out.println("Title: " + driver.getTitle());
	    }
	}
