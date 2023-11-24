package Testsuite;
import Common.commonBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

public class Day12_dropdownList extends commonBase{
    @BeforeTest
    public void OpenChrome(){
        driver= initChromeDriver("https://demo.seleniumeasy.com/basic-select-dropdown-demo.html");
    }
    @Test
    public void selectDayofWeek() throws InterruptedException {
        WebElement selectTag=driver.findElement(By.id("select-demo"));
        Select dropdownList = new Select(selectTag);
        System.out.println("giá trị "+dropdownList.isMultiple());
        System.out.println("dr list size "+dropdownList.getOptions().size());
        selectTag.click();
        dropdownList.selectByValue("Sunday");
        System.out.println("option 1: " + dropdownList.getFirstSelectedOption().getText());
        Thread.sleep(3000);

        //
        selectTag.click();
        dropdownList.selectByVisibleText("Monday");
        System.out.println("option 2: " + dropdownList.getFirstSelectedOption().getText());
        Thread.sleep(2000);
        //
        selectTag.click();
        dropdownList.selectByIndex(4);
        System.out.println("option 3: " + dropdownList.getFirstSelectedOption().getText());
        Thread.sleep(3000);
    }

    @AfterTest
    public void closeChrome(){
        driver.close();
    }
}
