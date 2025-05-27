package Workspace;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class DragAutomation extends Base {
	
	  @Test(priority = 1)  
      public void DragAndDrop() {
    	 driver.navigate().to("https://letcode.in/droppable");
    	 WebElement source = driver.findElement(By.xpath("//div[@id='draggable']")); // The source box
    	 WebElement target = driver.findElement(By.xpath("//div[@id='droppable']")); // The target box
    	 wait.until(ExpectedConditions.visibilityOf(source));
    	 wait.until(ExpectedConditions.visibilityOf(target));
         Actions actions = new Actions(driver);
         //actions.dragAndDrop(source,target).perform();
    	 //actions.dragAndDrop is not working therefore did it manually using x and y location.
    	 int xOffset = target.getLocation().getX() - source.getLocation().getX();
    	 int yOffset = target.getLocation().getY() - source.getLocation().getY();
    	  
    	 actions
    	     .clickAndHold(source)
    	     .moveByOffset(xOffset, yOffset)
    	     .pause(Duration.ofMillis(500))
    	     .release()
    	     .build()
    	     .perform();
         System.out.println("Drag and drop action completed.");
	  }
}
