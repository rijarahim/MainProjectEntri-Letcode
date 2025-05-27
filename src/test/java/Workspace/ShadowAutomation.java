package Workspace;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ShadowAutomation extends Base {

    @Test
    public void shadowDOM() {
        // Step 1: Navigate to the page
        driver.navigate().to("https://letcode.in/shadow");

        // Now access element inside the shadow root  by using jss selecter
        String firstNameField = "return document.querySelector('#open-shadow').shadowRoot.querySelector('#fname')";
        JavascriptExecutor js =(JavascriptExecutor) driver;
		WebElement fname =(WebElement)js.executeScript(firstNameField);
        fname.sendKeys("koushik");
       
    }
 
}
