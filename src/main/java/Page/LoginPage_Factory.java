package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

public class LoginPage_Factory {
    private WebDriver driver;
    @FindBy(id="email")
    WebElement textEmail;

    @FindBy(id="password")
    WebElement textPassword;

    @FindBy(xpath="//button[@type='submit']")
    WebElement buttonSignin;
    @FindBy(xpath="//a[@id='user-dropdown']")
    WebElement USER_DROPDOWN;
    @FindBy(xpath="//a[normalize-space()='Sign Out']")
    WebElement LABLE_SIGNOUT;

    public LoginPage_Factory(WebDriver _driver){
        this.driver =_driver;
        PageFactory.initElements(_driver, this);
    }

    public void LoginFunction(String email, String password){
        textEmail.clear();
        textEmail.sendKeys(email);

        textPassword.clear();
        textPassword.sendKeys(password);

        buttonSignin.click();
    }

    public void LogoutFunction(){
        USER_DROPDOWN.click();
        LABLE_SIGNOUT.click();
        textPassword.isDisplayed();

    }
}
