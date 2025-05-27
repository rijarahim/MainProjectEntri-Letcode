package Workspace;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DropAutomation extends Base {
	@Test(priority = 1)  
	public void DragAndDrop() {
		driver.navigate().to("https://letcode.in/draggable");
		WebElement draggable = driver.findElement(By.xpath("//div[@id='sample-box']"));
		Actions action = new Actions(driver);
		// Drag and drop to x,y position (for example, 100px right and 150px down)
		action.dragAndDropBy(draggable, 100, 150).perform();
		System.out.println("Draggable");
	 	}
}