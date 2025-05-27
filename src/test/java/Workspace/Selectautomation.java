package Workspace;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Selectautomation extends Base {
	
	@BeforeClass
	public void navigation() {
		driver.get("https://letcode.in/dropdowns");
	}		
	
   @Test
   public void SelectFruit() {
     WebElement fruits = driver.findElement(By.xpath("//select[@id='fruits']"));
     Select select = new Select(fruits);
     String fruit = "Orange";
     select.selectByVisibleText(fruit);
     String fruitSelected =  select.getFirstSelectedOption().getText();
     Assert.assertEquals(fruit, fruitSelected, "Error");
   }
 
   @Test
   public void SelectSuperHero() {
     WebElement superHero = driver.findElement(By.xpath("//select[@id='superheros']"));
     Select select = new Select(superHero);
     String superhero = "Batman";
     select.selectByValue("bt");
     String SuperHeroSelected =  select.getFirstSelectedOption().getText();
     Assert.assertEquals(superhero, SuperHeroSelected, "Error");
   }
 
   @Test
   public void SelectLanguage() {
	   WebElement PgmLanguage = driver.findElement(By.xpath("//select[@id='lang']"));
       Select select = new Select(PgmLanguage);

       // Store all options as a list and print all the options
       List<WebElement> allOptions = select.getOptions();
       System.out.println("Available languages:");
       for (WebElement option : allOptions) {
           System.out.println(option.getText());
       }
	       
	     String language = "JavaScript";
	     select.selectByIndex(0); //index value starts from 0
	     String LanguageSelected =  select.getFirstSelectedOption().getText();
	     Assert.assertEquals(language, LanguageSelected, "Error");
	    
	   }
 
   @Test
   public void SelectCountry() {
     WebElement Country = driver.findElement(By.xpath("//select[@id='country']"));
     Select select = new Select(Country);
     String Country1 = "India";
     select.selectByIndex(6); //index value starts from 0
     String CountrySelected =  select.getFirstSelectedOption().getText();
     Assert.assertEquals(Country1, CountrySelected, "Error");
   }
  	
 } 
  