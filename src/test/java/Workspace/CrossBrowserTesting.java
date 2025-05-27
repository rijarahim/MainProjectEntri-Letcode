package Workspace;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTesting {
	
		WebDriver driver;
		
		@Test
		@Parameters({"browser"})
		public void initializeBrowser(String browser) throws Exception {
			if(browser.equalsIgnoreCase("Edge")) {
				driver = new EdgeDriver();
			}
			else if(browser.equalsIgnoreCase("Chrome")){
			    driver = new ChromeDriver();	
			}
			else if(browser.equalsIgnoreCase("Firefox")) {
				driver = new FirefoxDriver();
			}	
			else {
				System.out.println("no browser");
				throw new Exception("Browser is not correct");
			}
			  driver.manage().window().maximize();
			    driver.get("https://letcode.in/test/");
			    System.out.println("Testing in " + browser);
			}

		@AfterMethod
		public void browserQuit() {
			driver.quit();
		}

	}


