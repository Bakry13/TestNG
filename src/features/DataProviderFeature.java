package features;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderFeature {
	ChromeDriver driver;
	DataProviderFeature dataProviderFeature;
	
	@BeforeTest
	void browserInit()
	{
		try {
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\Mohamed\\Desktop\\Course\\TestNG\\src\\resources\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@DataProvider(name = "LoginModule")
		public static Object[][] credentials()
		{
			String[][] data = {{"user1", "test@123"}, {"test@moakt.cc", "Pass@w0rd"}};
			return data;
		}

	@Test(dataProvider = "LoginModule")
		public void loginTest(String mail, String password) 
		{
			try {
				driver.get("http://automationpractice.com/");
				driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
				driver.findElement(By.id("email")).sendKeys(mail);
				driver.findElement(By.id("passwd")).sendKeys(password);
				driver.findElement(By.name("SubmitLogin")).click();
				String errorMessage = driver.findElement(By.cssSelector("div[class='alert alert-danger'] ol li")).getText();
				driver.findElement(By.cssSelector("div[class='alert alert-danger'] ol li")).isDisplayed();
//				Assert.assertEquals(errorMessage, "Invalid email address.");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

}
