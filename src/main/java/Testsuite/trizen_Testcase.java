package Testsuite;

import Common.commonBase;
import Constans.CT_constans_Acounts;
import Page.trizenPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class trizen_Testcase extends commonBase {
    @BeforeMethod

    public void openUrlWithChrome(){
        driver=initChromeDriver("https://techydevs.com/demos/themes/html/trizen-demo/trizen/index.html");
    }
    @Test(priority = 1)
    public void trizenTest() throws InterruptedException{
        trizenPage testdropdownlist = new trizenPage(driver);
        testdropdownlist.HanderlDateTimeAddDropdownList("Ha Noi","Ho Chi Minh","30092024","Business");
        testdropdownlist.VerifySearchResult();
    }
    @AfterMethod
    public void closeDriver(){
        CloseAllDriver();
    }
}
