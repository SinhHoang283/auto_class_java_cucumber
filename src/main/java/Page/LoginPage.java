package Page;
import Constans.CT_constans_Acounts;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriver driver;



    public  LoginPage(WebDriver _driver){
        this.driver=_driver;
    }
    public void LoginFunction(String emailValue, String passwordValue){
        driver.findElement(By.id("email"));
        WebElement email =driver.findElement(CT_constans_Acounts.TXT_EMAIL);
        if (email.isEnabled()){
            email.clear();
            email.sendKeys(emailValue);
        }
        WebElement password =driver.findElement(CT_constans_Acounts.TXT_PASSWORD);
        if (password.isEnabled()){
            password.clear();
            password.sendKeys(passwordValue);
        }
        WebElement loginBTN =driver.findElement(CT_constans_Acounts.BTN_SIGNIN);
        if (loginBTN.isEnabled()){
            loginBTN.click();
        }

    }

    public void LogoutFunction(){
        WebElement UserDropdown =driver.findElement(CT_constans_Acounts.USER_DROPDOWN);
        UserDropdown.click();
        driver.findElement(CT_constans_Acounts.LABLE_SIGNOUT).click();
    }
}
