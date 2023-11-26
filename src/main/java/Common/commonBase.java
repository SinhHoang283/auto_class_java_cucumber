package Common;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class commonBase {
    public WebDriver driver;
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
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        return driver;
    }

    public void CloseAllDriver(){
        if (driver!=null){
            driver.close();
            driver.quit();

        }

    }
}
