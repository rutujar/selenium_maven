package com.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class webdriver1 {
  @Test
  public void f() throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver","C:\\Users\\training_b6B.01.16\\Desktop\\browser_drivers\\chromedriver.exe");
	  WebDriver driver=new ChromeDriver();
	  String url="http://demowebshop.tricentis.com/login";
	  driver.navigate().to(url);
	  driver.manage().window().maximize();
	  WebElement search=driver.findElement(By.id("small-searchterms"));
	  Actions act1=new Actions(driver);
	  Thread.sleep(5000);
	  act1.sendKeys(search,"computer").perform();
	  Thread.sleep(5000);
	  act1.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
  }
  
}
