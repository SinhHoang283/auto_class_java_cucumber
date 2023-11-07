package Testsuite;
import Common.commonBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

public class Login extends commonBase{
    @BeforeTest
//    public void OpenChrome(){
//        driver= initChromeDriver("https://rise.fairsketch.com/signin");
//    }
    public void OpenChrome(){
        driver= initChromeDriver("https://bepantoan.vn/");
    }
    @Test
//    public void Test(){
//        System.out.printf("Đã mở thành công URL");
//    }
    public void openlocatorID(){
//        WebElement email = driver.findElement(By.id("email"));
//        System.out.println(email);
//        WebElement password = driver.findElement(By.id("password"));
//        System.out.println(password);
//        WebElement btnSubmit = driver.findElement(By.className("btn-primary"));
//        System.out.println(btnSubmit);
//        WebElement linktext1 = driver.findElement(By.linkText("Máy Rửa Chén Bát"));
//        WebElement linktext2 = driver.findElement(By.linkText("Máy Hút Mùi Cổ Điển"));
//        System.out.println(linktext1);
//        System.out.println(linktext2);
        System.out.println("Thẻ có tagName Input: " + driver.findElement(By.className("cursor-pointer")));
        System.out.println("Checkbox có class name là: " + driver.findElement(By.className("category-menus")));
        System.out.println("Thẻ có tagName Input: " + driver.findElement(By.tagName("input")));
    }
    @AfterTest
    public void closeChrome(){
        driver.close();
    }
}
