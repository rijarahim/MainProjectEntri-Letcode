package Workspace;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WindowAutomation extends Base{
	@Test
	public void Window() {
				
		driver.navigate().to("https://letcode.in/window");
		String mainWindow = driver.getWindowHandle();
		WebElement homePageButton = driver.findElement(By.xpath("//button[@id='home']"));
		wait.until(ExpectedConditions.visibilityOf(homePageButton));
		homePageButton.click();
		Set<String> allWindows = driver.getWindowHandles();
		for (String window : allWindows) {
		    if (!window.equals(mainWindow)) {
		        driver.switchTo().window(window);
		        String Currenturl = driver.getCurrentUrl();
		   	    System.out.println(Currenturl);
		   	    Assert.assertTrue(Currenturl.contains("test"),"click did not work");
		        driver.close();  // Close new window
		    }
		}

		// Switch back to main window
		driver.switchTo().window(mainWindow);		
   }
}
