package Testsuite;

import Common.commonBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

public class BTVN_buoi_8 extends commonBase {
    @BeforeTest
    public void OpenChrome(){
        driver= initChromeDriver("https://automationfc.github.io/basic-form/index.html");
    }
    @Test(priority=1)
    public void findLocatorById (){
        WebElement name = driver.findElement(By.id("name"));
        System.out.println(name);
        WebElement address = driver.findElement(By.id("address"));
        System.out.println(address);
        WebElement email = driver.findElement(By.id("email"));
        System.out.println(email);
        WebElement password = driver.findElement(By.id("password"));
        System.out.println(password);
    }
    @Test(priority=2)
    public void findLocatorByTagName (){
        WebElement name = driver.findElement(By.name("name"));
        System.out.println(name);
        WebElement address = driver.findElement(By.name("address"));
        System.out.println(address);
        WebElement email = driver.findElement(By.name("email"));
        System.out.println(email);
        WebElement password = driver.findElement(By.name("password"));
        System.out.println(password);
    }
    @Test(priority=3)
    public void findLocatorByLinktext (){
        WebElement input = driver.findElement(By.tagName("input"));
        System.out.println(input);
        WebElement textarea = driver.findElement(By.tagName("textarea"));
        System.out.println(textarea);
    }
    @AfterTest
    public void closeChrome(){
        driver.close();
    }
}
