package Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class Test1 {
    WebDriver driver;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
    }

    @BeforeMethod
    public void openBrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rozetka.com.ua");
    }

    @Test
    public void Test(){
        WebElement searchElement = driver.findElement(By.xpath("//input[@name='search']"));
        searchElement.clear();
        searchElement.sendKeys("Монитор");

        WebElement searchButton = driver.findElement(By.xpath("/html/body/app-root/div/div/rz-header/header/div/div/div/form/button"));
        searchButton.click();
        

        WebElement firstProductElement = driver.findElement(By.xpath("//div[@data-goods-id='250703981']//span[@class='goods-tile__title']"));
        String firstElementTitle = firstProductElement.getText();


        Assert.assertTrue(firstElementTitle.contains("Mонитор"),"Not contain");
    }

    @AfterMethod
    public void quitBrowser(){
        driver.quit();
    }

}