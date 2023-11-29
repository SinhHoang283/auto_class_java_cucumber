package Constans;

import org.openqa.selenium.By;

public class CT_constans_Acounts {
    public static String URL_Rise ="https://rise.fairsketch.com/signin";
    public static By TXT_EMAIL = By.id("email");
    public static By TXT_PASSWORD = By.id("password");
    public static By BTN_SIGNIN = By.xpath("//button[@type='submit']");
    public static By DASHBOARD_TXT = By.xpath("//span[text()='Dashboard']");
    public static By AUTHENTICATION_ALERT = By.xpath("//div[normalize-space()='Authentication failed!']");
    public static By USER_DROPDOWN = By.xpath("//a[@id='user-dropdown']");
    public static By LABLE_SIGNOUT = By.xpath("//a[normalize-space()='Sign Out']");
    /// Trang Alada
    public static String URL_ALADA ="https://alada.vn/";
    public static String ALADA_USER1="sinhhoang2546@gmail.com";
    public static String PASS1_USER1 ="12345678";
    public static String PASS2_USER1 ="abc123456";
    public static By LABLE_USER_IMAGE = By.xpath("//div[@class='avatar2']/img");
    public static By LABLE_TAB_THONG_TIN_CHUNG = By.id("thongtinchung");

}
