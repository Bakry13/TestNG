package features;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Parallelization {
	ChromeDriver driver;
	String driverPath = "C:\\Users\\Mohamed\\Desktop\\Course\\TestNG\\src\\resources\\chromedriver.exe";
	
	@Test
	void login()
	{
		try {
			System.setProperty("webdriver.chrome.driver", driverPath);
			driver = new ChromeDriver();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.get("http://automationpractice.com/");
			driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
			driver.findElement(By.id("email")).sendKeys("test@moakt.cc");
			driver.findElement(By.id("passwd")).sendKeys("Test@123");
			driver.findElement(By.name("SubmitLogin")).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void search()
	{
		try {
			System.setProperty("webdriver.chrome.driver", driverPath);
			driver = new ChromeDriver();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.get("http://automationpractice.com/");
			driver.findElement(By.id("search_query_top")).sendKeys("Blouse");
			driver.findElement(By.cssSelector("button[name='submit_search']")).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
}
