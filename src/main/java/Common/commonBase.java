package Common;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

public class commonBase {
    public WebDriver driver;
    private int initWaitTime =12;

    public WebDriver initChromeDriver(String URL)
    {
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);   // tắt save password popup
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("start-maximized");  //mở toàn màn hình ngay từ khởi tạo option
//        if (headless.equals("True")) {
//            options.addArguments("--headless");  //chạy healess - không cần mở màn hình
//        }
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});// xoá dòng Chrome is being controlled by automated test software
        options.addArguments("disable-infobars");
        System.setProperty("webdriver.chrome.driver",
                System.getProperty("user.dir") + "\\driver\\chromedriver.exe");
        // For MAC: System.getProperty("user.dir") + "/driver/chromedriver");
        driver = new ChromeDriver(options);
        driver.get(URL);
        driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
        return driver;
    }

    public boolean isElementPresent(By locator) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(initWaitTime));
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return driver.findElement(locator).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        } catch (org.openqa.selenium.TimeoutException e2) {
            return false;
        }
    }
    public WebElement getElementPresentDOM(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(initWaitTime));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator);
    }

    public void click(By locator) {
        WebElement element = getElementPresentDOM(locator);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(initWaitTime));
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }

    // 2. elementToBeClickable bị exception do element đó không cho phép Click(ElementClickInterceptedException)
    public void clickByJsExecutor(By locator)
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", locator);
    }

    /* Handle SenKeys
     * Happy case: FindElement và sendKey thành công
     * Unhappy case/ Negative case: 2 trường hợp
     * 1. FindElement văng ra exception (xử lý đợi explicit wait cho hàm FindElement) => done bằng getElementPresentDOM
     * */
    public void type(By locator, String value) {
        WebElement element = getElementPresentDOM(locator);
        element.clear();
        element.sendKeys(value);
    }

    // 2. SendKeys không thành công do element readonly/ không cho nhập bằng bình thường (ElementNotInteractableException)
    public void typeInValue_ByJsExecutor(By locator, String value) throws InterruptedException
    {
        WebElement element = getElementPresentDOM(locator);
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].value = '" + value + "'", element);
        } catch (StaleElementReferenceException ex) {
            pause(1000);
            typeInValue_ByJsExecutor(locator, value);
        }
    }
    public void inputTextJavaScript_ToInnerHTMLAttribute(By inputElement, String value) {
        WebElement element = driver.findElement(inputElement);
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        try {
            executor.executeScript("arguments[0].innerHTML = '" + value + "'", element);
        } catch (StaleElementReferenceException ex) {
            pause(1000);
            inputTextJavaScript_ToInnerHTMLAttribute(inputElement, value);
        }
    }

    // Handle Thread.sleep(miliSeconds);
    public void pause(long miliSeconds)
    {
        try {
            Thread.sleep(miliSeconds);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //Handle Scroll tới element MÀ VẪN NHÌN THẤY TRÊN MÀN HÌNH (scroll đến element cuối cùng nhìn thấy trên màn hình)
    public void scrollToElement(By locator) {
        WebElement element = getElementPresentDOM(locator);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }


    public void handleAlert(String expectedText){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(initWaitTime));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert();
        // Get the text from the alert
        String alertText = alert.getText();
        System.out.println("Alert Text: " + alertText);
        if (alertText.equals(expectedText)) {
            System.out.println("Alert text is equal to the expected value: " + expectedText);
        } else {
            System.out.println("Alert text is not equal to the expected value.");
        }
        driver.switchTo().alert().accept();


    }
    public void handleAcceptAlert(String expectedText){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(initWaitTime));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert();
        // Get the text from the alert
        String alertText = alert.getText();
        System.out.println("Alert Text: " + alertText);
        if (alertText.equals(expectedText)) {
            System.out.println("Alert text is equal to the expected value: " + expectedText);
        } else {
            System.out.println("Alert text is not equal to the expected value.");
        }
        driver.switchTo().alert().accept();
    }
    public void handleDimissAlert(String expectedText){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(initWaitTime));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert();
        // Get the text from the alert
        String alertText = alert.getText();
        System.out.println("Alert Text: " + alertText);
        if (alertText.equals(expectedText)) {
            System.out.println("Alert text is equal to the expected value: " + expectedText);
        } else {
            System.out.println("Alert text is not equal to the expected value.");
        }
        driver.switchTo().alert().dismiss();
    }

    public void handleAlertAndSendkey(String expectedText, String textSendkey){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(initWaitTime));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert();
        // Get the text from the alert
        String alertText = alert.getText();
        System.out.println("Alert Text: " + alertText);
        if (alertText.equals(expectedText)) {
            System.out.println("Alert text is equal to the expected value: " + expectedText);
        } else {
            System.out.println("Alert text is not equal to the expected value.");
        }
        driver.switchTo().alert().sendKeys(textSendkey);
        driver.switchTo().alert().accept();
    }

    public void scrollDownPageByJS(int pixels){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,"+pixels+")");
    }

    public void scrollDownPageByButton_PgDn(By startPositionLocator, By expectLocator){
        WebElement element = getElementPresentDOM(startPositionLocator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].focus();", element);
        for (int i=0; i<10;i++){
            Actions actions = new Actions(driver);
            actions.sendKeys(Keys.PAGE_DOWN).perform();
            boolean check = driver.findElement(expectLocator).isDisplayed();
            if (check==true) break;
        }
    }

    public void WaitElementIsVisibleAndClick(String locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(initWaitTime));
        WebElement element = driver.findElement(By.xpath(locator));
        wait.until(ExpectedConditions.visibilityOf(element));
        // Perform actions on the visible element
        element.click();
    }

    public void CloseAllDriver(){
        if (driver!=null){
            driver.close();
            driver.quit();

        }

    }

    public static void selectDropdownOption(WebDriver driver, String dropdownLocatorContainsText, String optionText) {
        WebElement dropdown = driver.findElement(By.xpath(dropdownLocatorContainsText)); // Replace By.id with your appropriate locator strategy
        String dropdownLocatorNew = dropdownLocatorContainsText + "[text()='"+optionText+"']";
        System.out.println(optionText + " Successfully selected");
        driver.findElement(By.xpath(dropdownLocatorNew)).click();
    }
}
