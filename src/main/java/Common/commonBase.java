package Common;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    public void CloseAllDriver(){
        if (driver!=null){
            driver.close();
//            driver.quit();

        }

    }
}
