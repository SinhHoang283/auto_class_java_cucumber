package Testsuite;
import Common.commonBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class day12_radiobtn extends commonBase{
    @BeforeTest
    public void OpenChrome(){
        driver= initChromeDriver("https://demo.seleniumeasy.com/basic-radiobutton-demo.html");
    }
    @Test
    public void ClikOnRadioBtb(){
        // kiểm tra giá trị
        WebElement radio1 =driver.findElement(By.xpath("//input[@value='Male' and @name='optradio']"));
        WebElement radio2 =driver.findElement(By.xpath("//input[@value='Female' and @name='optradio']"));
        System.out.println("stt mặc định của radio: " + radio1.isSelected());
        System.out.println("stt mặc định của radio: " + radio2.isSelected());
        if (radio1.isEnabled()==true && radio1.isSelected()== false){
            radio1.click();
            System.out.println("Radio "+ radio1 +" đã đc click");
        }
        else if (radio2.isEnabled()==true && radio2.isSelected()== false){
            radio2.click();
            System.out.println("Radio "+ radio2 +" đã đc click");
        }
    }

    @AfterTest
    public void closeChrome(){
        driver.close();
    }
}
