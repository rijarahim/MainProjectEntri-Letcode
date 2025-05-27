package Workspace;

import java.nio.file.Paths;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FileAutomation {
	public WebDriver driver;      // Global
	public WebDriverWait wait;
	
	 @BeforeClass
	 public void launchBrowser() {
	    
  	    ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://letcode.in/file/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(500));
	}

	@Test(priority = 1)
	public void fileUploading()  {
		// Locate file input and send file path
		WebElement fileupload = driver.findElement(By.xpath("//input[@type='file']"));
		String filePath = Paths.get("src", "test", "resources", "dummy.pdf").toAbsolutePath().toString();
		fileupload.sendKeys(filePath);
		
		try {	
			WebElement alertmessage = driver.findElement(By.xpath("//p[@class='label']"));
			boolean alertpopup = alertmessage.isDisplayed();
			if(alertpopup) {
				System.out.println("File Uploaded Succcessfully");
			}
			else { 
				System.out.println("File Upload Failed");
			}
		}
		catch(Exception e) {
	    	System.out.println("File Upload Failed");
	    }
	}
	
	@Test(priority = 1)
	public void fileDownload() throws InterruptedException {
		
		System.out.println("Starting to download");
 		WebElement downloadExcel = wait.until(ExpectedConditions.elementToBeClickable(By.id("xls")));
	    downloadExcel.click();
	    System.out.println("Excel Downloaded");
	    WebElement downloadPDF = wait.until(ExpectedConditions.elementToBeClickable(By.id("pdf")));
	    downloadPDF.click();
	    System.out.println("PDF Downloaded");
	    WebElement downloadText = wait.until(ExpectedConditions.elementToBeClickable(By.id("txt")));
	    downloadText.click();
	    System.out.println("Text Downloaded");	    
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
