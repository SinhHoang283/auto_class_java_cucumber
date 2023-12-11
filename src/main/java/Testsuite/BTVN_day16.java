package Testsuite;

import Common.commonBase;
import Constans.CT_constans_Acounts;
import Page.AladaLoginPage_Factory;
import org.openqa.selenium.By;
import org.testng.annotations.*;


import static Constans.CT_constans_Acounts.*;
import static org.testng.Assert.assertTrue;

public class BTVN_day16 extends commonBase {
    public String URL_Alada ="https://alada.vn/";
    public String URL_SeleniumPractice ="https://seleniumpractise.blogspot.com/2019/01/alert-demo.html";
    public String lable_thong_tin_ca_nhan ="//div[text()='Thông tin cá nhân']";
    public String button_luu_mat_khau_moi ="//button[text()='Lưu mật khẩu mới']";
    public String button_tryIt ="//button[@onclick='myFunction()']";

    public void openUrlWithChrome(String url){
        driver=initChromeDriver(url);
    }
    @Test(priority = 1)
    public void aladaVerifyTitleAfterChangePassword(){
        openUrlWithChrome(URL_Alada);
        AladaLoginPage_Factory ala1 = new AladaLoginPage_Factory(driver);
        ala1.dangNhapAlada(ALADA_USER1,PASS1_USER1);
        assertTrue(driver.findElement(CT_constans_Acounts.LABLE_USER_IMAGE).isDisplayed());
        ala1.vaoTrangChinhSuaThongTinDangNhap();
        assertTrue(driver.findElement(CT_constans_Acounts.LABLE_TAB_THONG_TIN_CHUNG).isDisplayed());
        scrollDownPageByButton_PgDn(By.xpath(lable_thong_tin_ca_nhan),By.xpath(button_luu_mat_khau_moi));
        ala1.doiMatKhau(PASS1_USER1,PASS2_USER1);
        handleAcceptAlert("Cập nhật mật khẩu mới thành công!");
    }
    @Test(priority = 2)
    public void seleniumpractisePage(){
        openUrlWithChrome(URL_SeleniumPractice);
        click(By.xpath(button_tryIt));
        handleAcceptAlert("Welcome to Selenium WebDriver Tutorials");
    }
    @AfterMethod
    public void closeDriver(){
        CloseAllDriver();
    }
}
