package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class apachepoi2 {
  @Test
  public void f() throws IOException {
	  File src=new File("C:\\Users\\training_b6B.01.16\\Desktop\\testdata.xlsx");
	  FileInputStream fis=new FileInputStream(src);
	  XSSFWorkbook wb=new XSSFWorkbook(fis);
	  XSSFSheet sh=wb.getSheetAt(0);
	  System.out.println("first row number"+sh.getFirstRowNum());
	  System.out.println("last row number"+sh.getLastRowNum());
	  int rowCount=sh.getFirstRowNum()+sh.getLastRowNum();
	  System.out.println("row Count"+rowCount);
	  for(int i=1;i<=rowCount;i++)
	  {
		  System.out.println("username" +sh.getRow(i).getCell(0).getStringCellValue());
		  System.out.println("pwd" +sh.getRow(i).getCell(1).getStringCellValue());
		  System.setProperty("webdriver.chrome.driver","C:\\Users\\training_b6B.01.16\\Desktop\\browser_drivers\\chromedriver.exe");
		  WebDriver driver=new ChromeDriver();
		  driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
		  driver.findElement(By.linkText("SignIn")).click();
		  driver.findElement(By.id("userName")).sendKeys(sh.getRow(i).getCell(0).getStringCellValue());
		  driver.findElement(By.id("password")).sendKeys(sh.getRow(i).getCell(1).getStringCellValue());
		  driver.findElement(By.name("Login")).click();
		  driver.findElement(By.xpath("//*[@id=\"menu3\"]/li[4]/a/span")).click();
		  WebElement obj=driver.findElement(By.xpath("/html/body/b/section/div"));
		  List<WebElement> Allrows=obj.findElements(By.tagName("tr"));
		  for(int n=1;n<Allrows.size();n++)
		  {
			  List<WebElement> cells=obj.findElements(By.tagName("td"));
			  System.out.println("orderid:"+cells.get(0).getText());
			  System.out.println("price:"+cells.get(2).getText());
		  }
		  /*
		  for(WebElement row : Allrows)
		  {
			  List<WebElement> cells=obj.findElements(By.tagName("td"));
			  for(WebElement cell : cells)
			  {
				  System.out.println(cell.getText());
			  };
		  }

		   */
	  }
	  ExtentHtmlReporter reporter=new ExtentHtmlReporter("C:\\Users\\training_b6B.01.16\\Desktop\\testdata.html");
	  ExtentReports extent=new ExtentReports();
	  extent.attachReporter(reporter);
	  ExtentTest logger=extent.createTest("DemoWebShop");
	  logger.log(Status.INFO,"APACHE poi is used in this test script");
	  logger.log(Status.PASS,"excel is done");
	  logger.log(Status.FAIL, MarkupHelper.createLabel("test case fail",ExtentColor.BLUE));
	  extent.flush();
	  
	  
	  /*
	  XSSFRow header=sh.getRow(0);
	  XSSFCell header2=header.createCell(2);
	  header2.setCellValue("status");
	  sh.getRow(1).createCell(2).setCellValue("Pass");
	  sh.getRow(2).createCell(2).setCellValue("Fail");
	  FileOutputStream fos=new FileOutputStream(src);
	  wb.write(fos);
	  */
	  }
}
