package features;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DataProviderFeature {
	ChromeDriver driver;

	@DataProvider(name = "LoginModule")
		public static Object[][] credentials()
		{
			String[][] data = {{"dmin", "admin123"}, {"Admin", "admin"}};
			return data;
		}

	@Test(dataProvider = "LoginModule")
		public void loginTest(String username, String password)
		{
			driver = new ChromeDriver();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.get("https://opensource-demo.orangehrmlive.com");
			driver.findElement(By.name("username")).sendKeys(username);
			driver.findElement(By.name("password")).sendKeys(password);
			driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
			String invalidText = driver.findElement(By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")).getText();
			Assert.assertEquals(invalidText, "Invalid credentials");
			driver.quit();
		}

}
