package Testsuite;

import Common.commonBase;
import Constans.CT_constans_Acounts;
import Page.LoginPage_Factory;
import Page.Rise_clientPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Day15_ClientsTestcase_rise extends commonBase {
    @BeforeMethod

    public void openUrlWithChrome(){
        driver=initChromeDriver(CT_constans_Acounts.URL_Rise);
    }
    @Test(priority = 1)
    public void createClientRisePage() throws InterruptedException {
    LoginPage_Factory login = new LoginPage_Factory(driver);
    login.LoginFunction("admin@demo.com","riseDemo");
    Rise_clientPage client = new Rise_clientPage(driver);
    client.addClientsFunction("Sinh's company","Sara Ann","134 Nguyễn Trãi","HÀ Nội",
            "Trần phú","123","Việt Nam","0123547890","https://www.youtube.com/","363774",
            "78855","VIP","AFN","64747","Corporate");
    client.VerifyAddClientSucess("Sinh's company","VIP","Corporate");
    }
    @AfterMethod
    public void closeDriver(){
        CloseAllDriver();
    }
}
