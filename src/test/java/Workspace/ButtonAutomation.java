package Workspace;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class ButtonAutomation extends Base  {
	  @Test(priority = 1)  
      public void GoToHome() {
    	 driver.navigate().to("https://letcode.in/button");
    	 WebElement button1 = driver.findElement(By.xpath("//button[@id='home']"));
    	 wait.until(ExpectedConditions.visibilityOf(button1));
    	 button1.click();
    	 String title = driver.getTitle();
    	 System.out.println(title);
    	 String Currenturl = driver.getCurrentUrl();
    	 System.out.println(Currenturl);
		 Assert.assertTrue(Currenturl.contains("letcode.in"),"click did not work");
		 Assert.assertTrue(title.contains("Let"),"click did not work");
		
      }
	  @Test(priority = 2)
	  public void findLocation() {
    	 driver.navigate().to("https://letcode.in/button");
    	 WebElement button2 = driver.findElement(By.xpath("//button[@id='position']"));
    	 wait.until(ExpectedConditions.visibilityOf(button2));
    	 Point point =button2.getLocation();
    	 int x = point.getX();
    	 int y = point.getY();
    	 System.out.println("X Coordinate: " + x);
    	 System.out.println("Y Coordinate: " + y);
	    	 
	  }
	  
	  @Test(priority = 3, dependsOnMethods = "findLocation")
	  public void findCOLOR() {
    	 WebElement button3 = driver.findElement(By.xpath("//button[@id='position']"));
    	 wait.until(ExpectedConditions.visibilityOf(button3));
    	 String color = button3.getCssValue("color");
    	 System.out.println("Color: " + color);
	  }
	  
	  @Test(priority = 4, dependsOnMethods = "findCOLOR")
	  public void findSize() {
    	 WebElement button4 = driver.findElement(By.xpath("//button[@id='property']"));
    	 wait.until(ExpectedConditions.visibilityOf(button4));
    	 Dimension size = button4.getSize();
    	 int width = size.getWidth();
    	 int height = size.getHeight();
    	 System.out.println("Width: " + width);
    	 System.out.println("Height: " + height);
	  
	  }
	  
	  @Test(priority = 5, dependsOnMethods = "findSize")
	  public void IsEnabled() {
	    WebElement noEdit = driver.findElement(By.xpath("//button[@id='isDisabled']"));
	    noEdit.isEnabled();
	    Assert.assertFalse(noEdit.isEnabled(), "Field is enabled, but it should be disabled!");
	  }
	  
      @Test (priority = 6, dependsOnMethods = "IsEnabled")
      public void Buttonhold() {
    	  WebElement sourceElement = wait.until(
    	  ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#isDisabled.button.is-primary")));
    	  Actions actions = new Actions(driver);
    	  actions.clickAndHold(sourceElement).perform(); 
    	  System.out.println("Hold action performed");
      }
}
