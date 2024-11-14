package bc15.BenjaMontero.unidad2.BCI.test;

import bc15.BenjaMontero.unidad2.utils.BaseClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

public class BaseTest {

    protected WebDriver driver;
    private static String urlDriver = System.getProperty("user.dir") +"\\src\\test\\resources\\drivers\\chromedriver.exe";
    private static String property = "webdriver.chrome.driver";
    private static String browser = "chrome";

    @BeforeEach
    public void setUp() {
        try{
            WebDriver driver = BaseClass.generateDriver(browser, urlDriver, property);
            BaseClass.setMaximWindow(driver);
        }catch (Exception e){
            Assertions.fail("Can not create driver session");
        }
    }

    @AfterEach
    public void tearDown() {
        this.driver.quit();
    }
}
