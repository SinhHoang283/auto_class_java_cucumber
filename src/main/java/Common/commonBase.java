package Common;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.*;

public class commonBase {
    public WebDriver driver;
    private int initWaitTime =10;

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

    public void handleAlert(String msgAlert){
        Alert alert = driver.switchTo().alert();
        // Get the text from the alert
        String alertText = alert.getText();
        System.out.println("Alert Text: " + alertText);
    }
    public void scrollDownPageByJS(int pixels){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,"+pixels+")");
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
