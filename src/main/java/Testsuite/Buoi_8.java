package Testsuite;

import Common.commonBase;
import org.openqa.selenium.By;
import org.testng.annotations.*;

public class Buoi_8 extends commonBase {
    @BeforeTest
//    public void OpenChrome(){
//        driver= initChromeDriver("https://rise.fairsketch.com/signin");
//    }
    public void OpenChrome(){
        driver= initChromeDriver("https://selectorshub.com/xpath-practice-page/");
    }
    @Test
//    public void Test(){
//        System.out.printf("Đã mở thành công URL");
//    }
    public void openlocatorID(){
        System.out.println("userId locator "+driver.findElement(By.id("userId")));
        System.out.println("pass locator "+driver.findElement(By.id("pass")));
        System.out.println("company locator "+driver.findElement(By.name("company")));
        System.out.println("mobile locator "+driver.findElement(By.name("mobile number")));
    }
    @AfterMethod
    public void closeChrome(){
        driver.close();
    }
}


