package Testsuite;
import Common.commonBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.*;

public class day12_checkbox  extends commonBase{
    @BeforeTest
    public void OpenChrome(){
        driver= initChromeDriver("https://demo.seleniumeasy.com/basic-checkbox-demo.html");
    }
    @Test(priority=1)
    public void clickOnCheckbox(){
        // check xem checkbox đc check chưa
        WebElement defcheck = driver.findElement(By.xpath("//input[@checked and not(@disabled)]"));
        boolean stt = defcheck.isSelected();
        System.out.println("Status is: " + stt);
        //
        WebElement defcheck2 = driver.findElement(By.xpath("//input[@id='isAgeSelected']"));
//        boolean stt2 = defcheck2.isSelected();
        if (defcheck2.isSelected()== false){
            defcheck2.click();
            System.out.printf("check box đã đc click");
        }

    }

    @Test(priority=2)
    public void clickOnMultiBox(){
        // check xem checkbox đc check chưa
        // lấy tổng số check
        List<WebElement> listCheckbock;
        listCheckbock= driver.findElements(By.xpath("//div[@class='checkbox']/label/input[@type='checkbox']"));
        for (int i=0; i<listCheckbock.size(); i++){
            WebElement checkbox = listCheckbock.get(i);
            if (checkbox.isSelected()== false){
                checkbox.click();
                System.out.println("multi box "+ (i+1) +" đã đc click");
            }
        }


    }

    @Test(priority=2)
    public void clickOnMultiBoxC2(){
        // check xem checkbox đc check chưa
        // lấy tổng số check
        List<WebElement> listCheckbock;
        listCheckbock= driver.findElements(By.xpath("//div/label/input[@type='checkbox']"));
        for (int i=0; i<listCheckbock.size(); i++){
            WebElement defcheck3= driver.findElement(By.xpath("//div["+i+"]/label/input[@type='checkbox']"));
            //        boolean stt2 = defcheck2.isSelected();
            if (defcheck3.isSelected()== false){
                defcheck3.click();
                System.out.println("multi box "+ (i+1) +" đã đc click");
            }

            }
        }



    @AfterTest
    public void closeChrome(){
        driver.close();
    }

}
