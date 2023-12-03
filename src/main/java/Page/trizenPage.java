package Page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.security.Key;

import static Common.commonBase.selectDropdownOption;
import static org.testng.Assert.assertTrue;

public class trizenPage {
    private WebDriver driver;
    @FindBy(xpath="(//label[text()='Departing'])[1]/following-sibling::div/input")
    WebElement textDepartingDate;
    @FindBy(xpath="//div[@id='one-way']//label[text()='Passengers']/..//a[@data-toggle='dropdown']")
    WebElement dropboxPassengers;
    @FindBy(xpath="//div[@id='one-way']//label[text()='Adults']/following-sibling::div//i[@class='la la-plus']")
    WebElement buttonAddAdults;
    @FindBy(id = "one-way-tab")
    WebElement radioOneWay;
    @FindBy(xpath = "//div[@id='one-way']//label[text()='Flying from']/following-sibling::div//input[1][@placeholder='City or airport']")
    WebElement textboxFlyingFrom;
    @FindBy(xpath = "//div[@id='one-way']//label[text()='Flying to']/following-sibling::div//input[1][@placeholder='City or airport']")
    WebElement textboxFlyingTo;
    @FindBy(xpath = "//div[@id='one-way']//button[@data-toggle='dropdown']")
    WebElement dropdownCoach;
    @FindBy(xpath = "//div[@id='one-way']//a[text()='Search Now']")
    WebElement buttonSearchNow;
    @FindBy(xpath = "//h2[text()='Flight Search Result']")
    WebElement lableSearchResult;

    public trizenPage(WebDriver _driver){
        this.driver =_driver;
        PageFactory.initElements(_driver, this);
    }
    public void HanderlDateTimeAddDropdownList(String citiFlyingFrom, String citiFlyingTo, String Date,String Coach) throws InterruptedException {
        Thread.sleep(2000);
        if (radioOneWay.isSelected()==false) {radioOneWay.click();}
        textboxFlyingFrom.sendKeys(citiFlyingFrom);
        textboxFlyingTo.sendKeys(citiFlyingTo);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].removeAttribute('readonly', 'readonly')", textDepartingDate);
        textDepartingDate.clear();
        textDepartingDate.sendKeys(Date);
        textDepartingDate.sendKeys(Keys.TAB);
        dropboxPassengers.click();
        Thread.sleep(1000);
        buttonAddAdults.click();
        dropdownCoach.click();
        selectDropdownOption(driver,"//div[@id='one-way']//span",Coach);
        Thread.sleep(1000);
        buttonSearchNow.click();

    }
    
    public void VerifySearchResult() throws InterruptedException {;
        Thread.sleep(2000);
        assertTrue(driver.findElement(By.xpath("//h2[text()='Flight Search Result']")).isDisplayed());

    }

}
