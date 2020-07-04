import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import static java.lang.Thread.*;

public class InternetLogin {

    public WebDriver driver;

    @BeforeTest
    public void Initialize(){
        System.setProperty("webdriver.chrome.driver","D:\\Selenium_Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void MainTest() throws InterruptedException {
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
    public void Terminate(){
        //termina
        driver.quit();
    }
}
