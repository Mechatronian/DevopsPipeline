import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import java.net.MalformedURLException;
import java.net.URL;

import static java.lang.Thread.*;

public class InternetLogin {

    public WebDriver driver;

    @BeforeTest
    public void Initialize() throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver","D:\\DevopsTutorial\\JavaProjects\\Selenium_Drivers\\chromedriver.exe");
        //driver = new RemoteWebDriver(new URL("http://192.168.0.7:4444/"), new ChromeOptions());
        driver = new ChromeDriver();
    }

    @Test
    public void Login() throws InterruptedException {
        //Login
        driver.get("https://the-internet.herokuapp.com/login");
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.className("radius")).click();
        Thread.sleep(5000);
        String val_login = driver.findElement(By.xpath("//h2")).getText();
        //validation
        Assert.assertEquals(val_login.trim(),"Secure Area");
    }

    @AfterTest
    public void Terminate() {
        //terminate
        driver.quit();
    }



}
