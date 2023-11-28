package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AladaLoginPage_Factory {
    private WebDriver driver;
    public AladaLoginPage_Factory(WebDriver _driver){
        this.driver =_driver;
        PageFactory.initElements(_driver, this);
    }

    @FindBy(id="txtLoginUsername")
    WebElement txtboxDiachiEmai;
    @FindBy(id="txtLoginPassword")
    WebElement txtboxMatKhau;
    @FindBy(xpath="//div[@class='field']/button")
    WebElement btnDangNhap;
    @FindBy(xpath="//div[@class='avatar2']/img")
    WebElement imgAvartar;
    @FindBy(xpath="//div[@class='info']//a[text()='Chỉnh sửa thông tin']")
    WebElement lableChinhSuaThongTin;
    @FindBy(id="txtnewpass")
    WebElement txtboxMatKhauMoi;
    @FindBy(id="txtrenewpass")
    WebElement txtboxNhapLaiMatKhauMoi;
    @FindBy(xpath="//button[@onclick='checkFormPass();']")
    WebElement btnLuuMatKhauMoi;
    @FindBy(xpath="//input[@id='txtpassword']")
    WebElement textboxNhapMatKhauCu;


    public void dangNhapAlada(String user, String password){
        txtboxDiachiEmai.sendKeys(user);
        txtboxMatKhau.sendKeys(password);
        btnDangNhap.click();

    }

    public void vaoTrangChinhSuaThongTinDangNhap(){
        imgAvartar.click();
        lableChinhSuaThongTin.click();

    }
    public void doiMatKhau(String oldPassword, String newPassword){
        textboxNhapMatKhauCu.sendKeys(oldPassword);
        txtboxMatKhauMoi.sendKeys(newPassword);
        txtboxNhapLaiMatKhauMoi.sendKeys(newPassword);
        btnLuuMatKhauMoi.click();
    }
}
