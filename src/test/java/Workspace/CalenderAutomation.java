package Workspace;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CalenderAutomation extends Base {
	@BeforeClass
	public void navigation() {
	    driver.navigate().to("https://letcode.in/calendar/");
    }
	 
	@Test
	public void calender() {
	 WebElement calender = driver.findElement(By.xpath("//input[@id='birthday']"));
	 calender.sendKeys("05-14-02025");
	 System.out.println("Date is selected");
	 }
  }