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
}
