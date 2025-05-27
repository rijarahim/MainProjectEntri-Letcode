package Workspace;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ElementsAutomation extends Base {
	 
	   @Test
	   public void elements() {
	   driver.navigate().to("https://letcode.in/elements");
	   WebElement usernameField = driver.findElement(By.xpath("//input[@name='username']"));
	   usernameField.sendKeys("rahibrasheed");
	   WebElement SearchField = driver.findElement(By.xpath("//button[@id='search']"));
	   SearchField.click();
	   
       WebElement image = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[@class='is-rounded']")));
       boolean isDisplayed = image.isDisplayed();
       System.out.println("images is displayed" + isDisplayed);
       Assert.assertTrue(isDisplayed, "Image is not visible on the page!");
       
       WebElement publicRepoCount = driver.findElement(By.xpath("//p[text()='Public Repos']/following-sibling::p"));
       System.out.println(" Public Repositories Count: " + publicRepoCount.getText().trim());
       String repoCountText = publicRepoCount.getText().trim(); // For example: "5"
       int displayedCount = Integer.parseInt(repoCountText);
           
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("app-repos div.box")));
       List<WebElement> repoBoxes = driver.findElements(By.cssSelector("app-repos div.box"));
       int boxcount = repoBoxes.size();
       Assert.assertEquals(boxcount, displayedCount, "not equal");    
      }
}

