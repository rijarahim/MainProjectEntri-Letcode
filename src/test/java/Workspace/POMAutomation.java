package Workspace;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

  public class POMAutomation {
	  
	  WebDriver driver;
	  WebDriverWait wait;
	  
	  @BeforeClass
	  public void launchBrowser() {      
  	    ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://letcode.in/test");
        wait = new WebDriverWait(driver, Duration.ofSeconds(500));	       
	  }
	
	   @Test(priority = 1)
		public void PositiveLoginTest() {
		    driver.navigate().to("https://letcode.in/login"); 
		    driver.manage().window().maximize();
		    WebElement usernameField = driver.findElement(By.xpath("//input[@placeholder='Enter Username']"));
		    wait.until(ExpectedConditions.visibilityOf(usernameField));
		    usernameField.sendKeys("mor_2314");
			WebElement passwordField = driver.findElement(By.xpath("//input[@placeholder='Enter Password']"));
			wait.until(ExpectedConditions.visibilityOf(passwordField));
			passwordField.sendKeys("83r5^_");
			WebElement LoginButton = driver.findElement(By.xpath("//button[@class='button is-primary']"));
			LoginButton.click();
			wait.until(ExpectedConditions.urlContains("home"));
		    String currentUrl1 = driver.getCurrentUrl();
		    System.out.println(currentUrl1);
	   }
		  
	   @Test(priority = 2, dependsOnMethods = "PositiveLoginTest")
	   public void HomePage() {
		  WebElement product1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class, 'column') and contains(@class, 'is-one-quarter-desktop')]//div[contains(@class, 'card')]//p[contains(@class, 'card-header-title') and contains(text(), 'Mens Casual Premium Slim Fit')]")));
		  product1.click();
		  WebElement addtoCart1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'is-primary') and contains(., 'Add to Cart')]")));
		  addtoCart1.click();  
		  WebElement addtoCartIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[.//i[contains(@class, 'fa-cart-shopping')] and .//span[contains(@class, 'tag is-success') and text()='1']]")));
		  addtoCartIcon.click();
		  WebElement checkout = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='button is-success']")));
		  checkout.click();
		  driver.switchTo().alert().accept(); 
	   }

	    @Test(priority = 3)
		public void NegetiveLoginTest() {
		    driver.navigate().to("https://letcode.in/login");
			driver.manage().window().maximize();
			WebElement usernameField = driver.findElement(By.xpath("//input[@placeholder='Enter Username']"));
			wait.until(ExpectedConditions.visibilityOf(usernameField));
			usernameField.sendKeys("dgdsgs");
			WebElement passwordField = driver.findElement(By.xpath("//input[@placeholder='Enter Password']"));
			wait.until(ExpectedConditions.visibilityOf(usernameField));
			passwordField.sendKeys("fdsfdsf");
			WebElement LoginButton = driver.findElement(By.xpath("//button[@class='button is-primary']"));
			wait.until(ExpectedConditions.visibilityOf(LoginButton));
			LoginButton.click();
			wait.until(ExpectedConditions.urlContains("letcode.in"));
		    // Assertion: check that the user is still on the login page
		    String currentUrl = driver.getCurrentUrl();
		    System.out.println(currentUrl);
		    Assert.assertTrue(currentUrl.contains("/login"), "Test Failed: User was redirected to home page after invalid login");
		}
	    
	    @AfterClass
      	public void browserQuit() {
		   System.out.println("Closing browser..."); 
		    if (driver != null) {
		        driver.quit();
	        System.out.println("Browser closed successfully.");
		} 
	}			    
}
  