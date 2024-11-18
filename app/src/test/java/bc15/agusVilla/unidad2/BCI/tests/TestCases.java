package bc15.agusVilla.unidad2.BCI.tests;

import bc15.agusVilla.unidad2.BCI.Pages.HomePage;
import bc15.agusVilla.unidad2.BCI.Pages.RegisterPage;
import bc15.agusVilla.unidad2.BCI.utils.BaseClass;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestCases {
    //Atributos
    private WebDriver driver;
    private HomePage homePage;
    private RegisterPage registerPage;
    private BaseClass baseClass;
    private static String urlDriver = System.getProperty("user.dir") +"\\src\\test\\resources\\drivers\\chromedriver.exe";
    private static String property = "webdriver.chrome.driver";
    private static String browser = "chrome";
    private WebDriverWait wait;


    @Test
    public void CP001_Home_Register() throws InterruptedException {
        homePage.registerUser();
        driver.switchTo().frame(driver.findElement(By.id("myFrame")));
        registerPage.fill();
        //assertEquals("Hubo un error intentando enviar tus datos", driver.findElement(By.className("tituloError")).getText());
        assertTrue(driver.findElement(By.className("tituloError")).getText().contains("error"));
    }

    @BeforeEach
    public void preCondiciones(){
        baseClass = new BaseClass(driver, wait);
        driver = baseClass.conexionDriver(browser, urlDriver, property);
        wait = new WebDriverWait(driver,20);
        homePage = new HomePage(driver, wait);
        registerPage = new RegisterPage(driver, wait);
        driver.get("https://www.bci.cl/personas");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @AfterEach
    public void postCondition(){
        //driver.close();
    }

}
