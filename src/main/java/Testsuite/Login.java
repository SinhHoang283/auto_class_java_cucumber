package Testsuite;
import Common.commonBase;
import org.testng.annotations.*;

public class Login extends commonBase{
    @BeforeTest
    public void OpenChrome(){
        driver= initChromeDriver("https://www.youtube.com/");
    }
    @Test
    public void Test(){
        System.out.printf("Đã mở thành công URL");
    }
}
