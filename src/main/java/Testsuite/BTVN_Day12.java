package Testsuite;
import Common.commonBase;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;
public class BTVN_Day12 extends commonBase{
    @BeforeTest
    public void OpenChrome(){
        driver= initChromeDriver("https://demo.seleniumeasy.com/input-form-demo.html");
    }
    @Test
    public void dropdownListStage() throws InterruptedException {
        WebElement selectStage=driver.findElement(By.xpath("//select[@name='state']"));
        Select dropdownList = new Select(selectStage);
        dropdownList.selectByVisibleText("Alabama");
        System.out.println("option 1: " + dropdownList.getFirstSelectedOption().getText());
        Thread.sleep(2000);
        // cách 2
        selectStage.click();
        dropdownList.selectByIndex(4);
        System.out.println("option 2: " + dropdownList.getFirstSelectedOption().getText());

    }
    @Test
    public void checkboxHosting() throws InterruptedException {
        WebElement checkboxHostingYes = driver.findElement(By.xpath("//input[@value='yes']"));
        boolean stt = checkboxHostingYes.isSelected();
        if (checkboxHostingYes.isSelected()== false){
            checkboxHostingYes.click();
            System.out.println("check box yes đã đc click");
        }
        Thread.sleep(2000);
        //
        WebElement checkboxHostingNo = driver.findElement(By.xpath("//input[@value='no']"));
        if (checkboxHostingNo.isSelected()== false){
            checkboxHostingNo.click();
            System.out.println("check box No đã đc click");
        }
        Thread.sleep(2000);
    }
    @AfterTest
    public void closeChrome(){
        driver.close();
    }
}
