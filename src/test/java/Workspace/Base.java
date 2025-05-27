package Workspace;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Base {

	public WebDriver driver;    // Global
	public WebDriverWait wait;  // Global
	
	@BeforeClass
	public void initializeBrowser() {
		
        System.out.println("Launching browser...");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://letcode.in/test");
        wait = new WebDriverWait(driver, Duration.ofSeconds(500));
    }

  	public void Screenshot(String filename) {
		System.out.println("Taking Screenshot");
		TakesScreenshot ts = (TakesScreenshot)driver;
	    File source = ts.getScreenshotAs(OutputType.FILE);
		File destination = new File(filename);
		try {
			Files.copy(source.toPath(),destination.toPath());
		} 
		catch (IOException e) { 
			System.out.println("File Name Already exists, Please change the file name");
		}
   }
  
    @AfterClass
  	public void browserQuit() {
	   System.out.println("Closing browser..."); 
	    if (driver != null) {
	        driver.quit();
	    }
    }
}
