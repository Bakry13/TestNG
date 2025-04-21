package features;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class Parameterization {
    public static ThreadLocal <WebDriver> driver = new ThreadLocal<>();

    @BeforeTest
    @Parameters("browser")
    public void setDriver(@Optional("Chrome") String browser){
        if(browser.equalsIgnoreCase("Chrome")){
            driver.set(new ChromeDriver());
        }
        else if(browser.equalsIgnoreCase("Firefox")){
            driver.set(new FirefoxDriver());
        }
    }

    public WebDriver getDriver(){
        return driver.get();
    }

    @BeforeMethod
    void setup(){
        getDriver().manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
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
