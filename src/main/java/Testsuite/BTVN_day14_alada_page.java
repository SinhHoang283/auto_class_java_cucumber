package Testsuite;

import Common.commonBase;
import Constans.CT_constans_Acounts;
import Page.AladaLoginPage_Factory;
import Page.AladaSigninPage_Factory;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.*;

import static Constans.CT_constans_Acounts.*;
import static org.testng.Assert.assertTrue;


public class BTVN_day14_alada_page extends commonBase {
    @BeforeMethod
    public void openUrlWithChrome(){
//        driver=initChromeDriver(CT_constans_Acounts.URL_ALADA_SIGNIN);
        driver=initChromeDriver(CT_constans_Acounts.URL_ALADA_LOGIN);
    }
    @Test(priority = 1)
    public void TC1dangKiTaiKhoanAlada() throws InterruptedException {
        AladaSigninPage_Factory signin = new AladaSigninPage_Factory(driver);
        signin.setHoVaTen("Nguyen thu");
        signin.setEmail();
        System.out.println(signin.Email);
        signin.setSoDienThoai();
        signin.dangKiTaiKhoan(signin.hoVaTen,signin.Email,PASS1_USER1,signin.soDienThoai);
        Thread.sleep(5000);
        assertTrue(driver.findElement(CT_constans_Acounts.LABLE_USER_IMAGE).isDisplayed());
    }
    @Test(priority = 2)
    public void TC1DangNhapTaiKhoanVaDoiMatKhauAlada() throws InterruptedException {
        AladaLoginPage_Factory login = new AladaLoginPage_Factory(driver);
        login.dangNhapAlada(ALADA_USER1,PASS1_USER1);
        Thread.sleep(5000);
        assertTrue(driver.findElement(CT_constans_Acounts.LABLE_USER_IMAGE).isDisplayed());
        login.vaoTrangChinhSuaThongTinDangNhap();
        Thread.sleep(5000);
        assertTrue(driver.findElement(CT_constans_Acounts.LABLE_TAB_THONG_TIN_CHUNG).isDisplayed());

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");
        Thread.sleep(3000);
        login.doiMatKhau(PASS1_USER1,PASS2_USER1);
        Thread.sleep(5000);


    }
    @AfterMethod
    public void closeDriver(){
        CloseAllDriver();
    }
}
