package features;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ParallelizationThreadLocal {
    public static ThreadLocal <WebDriver> driver = new ThreadLocal<>();

    @BeforeTest
    public void setDriver(){
        driver.set(new ChromeDriver());
    }

    public WebDriver getDriver(){
        return driver.get();
    }

    @BeforeMethod
    void setup(){
        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        getDriver().get("https://opensource-demo.orangehrmlive.com");
    }

    @AfterMethod
    void teardown(){
        getDriver().quit();
    }

    @Test
    void validLogin()
    {
        getDriver().findElement(By.name("username")).sendKeys("Admin");
        getDriver().findElement(By.name("password")).sendKeys("admin123");
        getDriver().findElement(By.xpath("//button[normalize-space()='Login']")).click();
        getDriver().findElement(By.xpath("//img[@class='oxd-userdropdown-img']")).isDisplayed();
    }

    @Test
    void invalidLogin()
    {
        getDriver().findElement(By.name("username")).sendKeys("Admin");
        getDriver().findElement(By.name("password")).sendKeys("admin12");
        getDriver().findElement(By.xpath("//button[normalize-space()='Login']")).click();
        String invalidText = getDriver().findElement(By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']")).getText();
        Assert.assertEquals(invalidText, "Invalid credentials");
    }
}
