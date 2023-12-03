package Page;

import Constans.CT_constans_Acounts;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.PageFactory;

import static Common.commonBase.*;
import static org.testng.Assert.assertTrue;

public class Rise_clientPage {
    private WebDriver driver;
    @FindBy(xpath="//span[text()='Clients']")
    WebElement clientsLink;
    @FindBy(xpath="//a[@data-title='Add client']")
    WebElement buttonAddClient;
    @FindBy(id="type_person")
    WebElement radioPerson;
    @FindBy(id="s2id_created_by")
    WebElement dropdownlistOwer;
    @FindBy(xpath="//li[@role='presentation']/div")
    WebElement textboxOwerOption;  //sendkeys: SARANA
    @FindBy(id="company_name")
    WebElement textboxName;
    @FindBy(xpath="//button[@type='submit']")
    WebElement buttonSave;
    @FindBy(id="address")
    WebElement txtAreaAddress;
    @FindBy(id="city")
    WebElement textboxCity;
    @FindBy(id="state")
    WebElement textboxState;
    @FindBy(id="zip")
    WebElement textboxZip;
    @FindBy(id="country")
    WebElement textboxCountry;
    @FindBy(id="phone")
    WebElement textboxPhone;
    @FindBy(id="website")
    WebElement textboxWebsite;
    @FindBy(id="vat_number")
    WebElement textboxVATNumber;
    @FindBy(id="gst_number")
    WebElement textboxGSTNumber;
    @FindBy(id = "s2id_group_ids")
    WebElement dropdownGroup;
    @FindBy(id = "s2id_currency")
    WebElement dropdownCurrency;
    @FindBy(id = "currency_symbol")
    WebElement textboxCurrencySymbol;
    @FindBy(id = "s2id_client_labels")
    WebElement dropdownClientLabels;
    @FindBy(id="disable_online_payment")
    WebElement checkboxDisableOnlinePayment;
    @FindBy(xpath="//a[@data-bs-toggle='tab'][text()='Clients']")
    WebElement tabClients;
    @FindBy(xpath="//div[@id='client-table_filter']//input")
    WebElement textboxSearch;
    String LableOptionSlect ="//div[@role='option']";
    String LablPresentationSlect ="//li[@role='presentation']/div";

    public Rise_clientPage(WebDriver _driver){
        this.driver =_driver;
        PageFactory.initElements(_driver, this);
    }
    public void addClientsFunction(String Name, String Owner, String Address, String City, String Satte,
    String Zip, String Country, String Phone, String Website, String VAT_Number,
    String GST_Number, String Client_groups, String Currency, String Currency_Symbol, String Labels) throws InterruptedException {
        // pre- Login
        Thread.sleep(1000);
        clientsLink.click();
        Thread.sleep(1000);
        buttonAddClient.click();
        Thread.sleep(2000);
        if (radioPerson.isSelected()==false) {radioPerson.click();}
        Thread.sleep(1000);
        textboxName.sendKeys(Name);
        //// chon Owner
        Thread.sleep(1000);
        dropdownlistOwer.click();
        Thread.sleep(2000);
        selectDropdownOption(driver,LablPresentationSlect,Owner);
        Thread.sleep(1000);
        txtAreaAddress.sendKeys(Address);
        textboxCity.sendKeys(City);
        textboxState.sendKeys(Satte);
        textboxZip.sendKeys(Zip);
        textboxCountry.sendKeys(Country);
        textboxPhone.sendKeys(Phone);
        textboxWebsite.sendKeys(Website);
        textboxVATNumber.sendKeys(VAT_Number);
        textboxGSTNumber.sendKeys(GST_Number);
        dropdownGroup.click();
        selectDropdownOption(driver,LableOptionSlect,Client_groups);
        dropdownCurrency.click();
        selectDropdownOption(driver,LableOptionSlect,Currency);
        textboxCurrencySymbol.sendKeys(Currency_Symbol);
        dropdownClientLabels.click();
        selectDropdownOption(driver,LableOptionSlect,Labels);
        Thread.sleep(1000);
        buttonSave.click();
        Thread.sleep(2);
    }

    public void VerifyAddClientSucess(String Name, String Client_groups,String Labels) throws InterruptedException {
        tabClients.click();
        Thread.sleep(2000);
        textboxSearch.sendKeys(Name);
        textboxSearch.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        assertTrue(driver.findElement(By.xpath("//a[text()=\""+Name+"\"]")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("//li[text()='"+Client_groups+"']")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("//span[text()='"+Labels+"']")).isDisplayed());
    }
}
