package assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment {
	
	WebDriver driver;
	int indexvalue;
	
	@Test
	public void open() throws InterruptedException
	{
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
		driver.findElement(By.xpath("(//input[@id='password'])[1]")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//input[@id='login-button']")).click();
		List<Double> all_elements_text=new ArrayList<Double>();
		List<WebElement> myList = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
		
		for(int i=0;i<myList.size();i++) {
			
		all_elements_text.add(Double.parseDouble(myList.get(i). getText().replace("$", "")));	
		
		}
		double obj = Collections.max(all_elements_text);
				
		for(int j=0;j<myList.size();j++) {
			
			if(Double.parseDouble(myList.get(j).getText().replace("$", ""))==obj)
			{
				System.out.println("The index value :"+ j); 
				 indexvalue=j;
			}
		}
		
		List<WebElement> addtocart = driver.findElements(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory']"));
		
			addtocart.get(indexvalue).click();
			
		}
		
	@BeforeTest
	public void openbrowser()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		
	}
	
	
	  @AfterTest
	  public void quit()
	  {
		  driver.quit();
	  
	  }
	 
	
}
