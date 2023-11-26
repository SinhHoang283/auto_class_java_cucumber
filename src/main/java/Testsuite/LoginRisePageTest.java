package Testsuite;

import Common.commonBase;
import Constans.*;
import Page.LoginPage;
import org.testng.annotations.*;

import static org.testng.Assert.*;

public class LoginRisePageTest extends commonBase {
    @BeforeMethod
    public void openChrome(){
        driver=initChromeDriver(CT_constans_Acounts.URL_Rise);

    }
    @Test(priority=1)
    public void LoginSuccess(){
        LoginPage login= new LoginPage(driver);
        login.LoginFunction("admin@demo.com","riseDemo");
        assertTrue(driver.findElement(CT_constans_Acounts.DASHBOARD_TXT).isDisplayed());
    }
    @Test(priority=2)
    public void LoginFailWithPassword(){
        LoginPage login= new LoginPage(driver);
        login.LoginFunction("admin@demo.com","12345");
        assertTrue(driver.findElement(CT_constans_Acounts.AUTHENTICATION_ALERT).isDisplayed());
    }
    @Test(priority=3)
    public void LoginFailWithEmail(){
        LoginPage login= new LoginPage(driver);
        login.LoginFunction("admin12345@demo.com","riseDemo");
        assertTrue(driver.findElement(CT_constans_Acounts.AUTHENTICATION_ALERT).isDisplayed());
    }

    @Test(priority=4)
    public void loginFailWithEmailAndPassword(){
        LoginPage login= new LoginPage(driver);
        login.LoginFunction("admin12345@demo.com","riseDemo1234");
        assertTrue(driver.findElement(CT_constans_Acounts.AUTHENTICATION_ALERT).isDisplayed());
    }

    @Test(priority=5)
    public void loginSuccessAndLogout() throws InterruptedException {
        LoginPage login= new LoginPage(driver);
        login.LoginFunction("admin@demo.com","riseDemo");
        assertTrue(driver.findElement(CT_constans_Acounts.DASHBOARD_TXT).isDisplayed());
        Thread.sleep(3000);
        login.LogoutFunction();
        assertTrue(driver.findElement(CT_constans_Acounts.TXT_EMAIL).isDisplayed());
        Thread.sleep(3000);

    }
    @AfterMethod
    public void closeDriver(){
        CloseAllDriver();
    }
}
