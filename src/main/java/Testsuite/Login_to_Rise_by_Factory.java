package Testsuite;


import Common.commonBase;
import Constans.*;
import Page.LoginPage_Factory;
import org.testng.annotations.*;

import static org.testng.Assert.*;

public class Login_to_Rise_by_Factory extends commonBase {
    @BeforeMethod
    public void openChrome(){
        driver=initChromeDriver(CT_constans_Acounts.URL_Rise);

    }
    @Test(priority=1)
    public void LoginSuccess(){
        LoginPage_Factory login= new LoginPage_Factory(driver);
        login.LoginFunction("admin@demo.com","riseDemo");
        assertTrue(driver.findElement(CT_constans_Acounts.DASHBOARD_TXT).isDisplayed());
    }
    @Test(priority=2)
    public void LoginFailWithPassword(){
        LoginPage_Factory login= new LoginPage_Factory(driver);
        login.LoginFunction("admin@demo.com","12345");
//        assertTrue(driver.findElement(CT_constans_Acounts.AUTHENTICATION_ALERT).isDisplayed());
        assertFalse(isElementPresent(CT_constans_Acounts.DASHBOARD_TXT));

    }
    @Test(priority=3)
    public void LoginFailWithEmail(){
        LoginPage_Factory login= new LoginPage_Factory(driver);
        login.LoginFunction("admin12345@demo.com","riseDemo");
        assertTrue(driver.findElement(CT_constans_Acounts.AUTHENTICATION_ALERT).isDisplayed());
    }

    @Test(priority=4)
    public void loginFailWithEmailAndPassword(){
        LoginPage_Factory login= new LoginPage_Factory(driver);
        login.LoginFunction("admin12345@demo.com","riseDemo1234");
        assertTrue(driver.findElement(CT_constans_Acounts.AUTHENTICATION_ALERT).isDisplayed());
    }

    @Test(priority=5)
    public void loginSuccessAndLogout() throws InterruptedException {
        LoginPage_Factory login= new LoginPage_Factory(driver);
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

//public class Login_to_Rise_by_Factory {
//}

