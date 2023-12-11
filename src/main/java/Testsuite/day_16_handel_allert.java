package Testsuite;

import Common.commonBase;
import Constans.CT_constans_Acounts;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

public class day_16_handel_allert extends commonBase {
    @BeforeMethod
    public void openUrlWithChrome(){
        driver=initChromeDriver("https://demo.automationtesting.in/Alerts.html");
    }
    @Test(priority = 1)
    public void deleteCustomerSuccessfully(){
    type(By.xpath("//input[@name='cusid']"),"2458");
    click(By.xpath("//input[@name='submit']"));
    handleAlert("Do you really want to delete this Customer?");
    handleAlert("Customer Successfully Delete!");
    }
    @Test(priority = 2)
    public void handleAlert2Success(){
        click(By.xpath("//button[@onclick='alertbox()']"));
        handleAcceptAlert("I am an alert box!");
        Assert.assertTrue(driver.findElement(By.xpath("//button[@onclick='alertbox()']")).isDisplayed());

        //
        click(By.xpath("//a[text()='Alert with OK & Cancel ']"));
        click(By.xpath("//button[text()='click the button to display a confirm box ']"));
        handleAcceptAlert("Press a Button !");
        Assert.assertTrue(driver.findElement(By.xpath("//button[text()='click the button to display a confirm box ']")).isDisplayed());
        //
        click(By.xpath("//button[text()='click the button to display a confirm box ']"));
        handleDimissAlert("Press a Button !");
        Assert.assertTrue(driver.findElement(By.xpath("//button[text()='click the button to display a confirm box ']")).isDisplayed());
        //
        click(By.xpath("//a[text()='Alert with Textbox ']"));
        click(By.xpath("//button[text()='click the button to demonstrate the prompt box ']"));
        handleAlertAndSendkey("Please enter your name","HT Sinh");
        Assert.assertTrue(driver.findElement(By.xpath("//button[text()='click the button to demonstrate the prompt box ']")).isDisplayed());

    }
    @AfterMethod
    public void closeDriver(){
        CloseAllDriver();
    }
}
