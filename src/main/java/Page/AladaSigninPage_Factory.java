package Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Random;


public class AladaSigninPage_Factory {
    private WebDriver driver;
    @FindBy(xpath="//span[@class='box-item-login']/a")
    WebElement btnDangKi;
    @FindBy(id="txtFirstname")
    WebElement txtboxHoVaTen;
    @FindBy(id="txtEmail")
    WebElement txtboxDiaChiEmail;
    @FindBy(id="txtCEmail")
    WebElement txtboxNhapLaiEmail;

    @FindBy(id="txtPassword")
    WebElement txtboxMatKhau;
    @FindBy(id="txtCPassword")
    WebElement txtboxNhapLaiMatKhau;
    @FindBy(id="txtPhone")
    WebElement txtboxSoDienThoai;
    @FindBy(id="chkRight")
    WebElement checkboxDongYDieuKhoan;
    @FindBy(xpath="//div[@class='field_btn']/button")
    WebElement buttonDangKi;
    public String hoVaTen;
    public String soDienThoai;
    public String Email;

    public void setHoVaTen(String hoVaTen) {
        Random generator = new Random();
        int rdTen = generator.nextInt(90000)+10000;
        String hoVaTenRd = hoVaTen +" " +rdTen;
        this.hoVaTen = hoVaTenRd;
    }
    public void setSoDienThoai() {
        Random generator = new Random();
        int rdSDT = generator.nextInt(23456789)+10000000;
        String soDienThoaiRd = "09" +rdSDT;
        this.soDienThoai = soDienThoaiRd;
    }

    public void setEmail() {
        Random generator = new Random();
        int rd = generator.nextInt(56789)+3000;
        String Email = "sinhhoang" +rd+"@gmail.com";
        this.Email = Email;
    }
    public AladaSigninPage_Factory(WebDriver _driver){
        this.driver =_driver;
        PageFactory.initElements(_driver, this);
    }
    public void dangKiTaiKhoan(String hoVaTen, String email, String matKhau, String soDienThoai) {

        buttonDangKi.click();
        txtboxHoVaTen.sendKeys(hoVaTen);
        txtboxDiaChiEmail.sendKeys(email);
        txtboxNhapLaiEmail.sendKeys(email);
        txtboxMatKhau.sendKeys(matKhau);
        txtboxNhapLaiMatKhau.sendKeys(matKhau);
        txtboxSoDienThoai.sendKeys(soDienThoai);
        if (checkboxDongYDieuKhoan.isSelected()==false){
            checkboxDongYDieuKhoan.click();
        }
        buttonDangKi.click();
    }
}
