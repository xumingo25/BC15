package bc15.agusVilla.unidad2.tests;

import bc15.agusVilla.unidad2.Pages.HomePage;
import bc15.agusVilla.unidad2.Pages.RegisterPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import javax.print.DocFlavor;

public class TestCases {
    //Atributos
    private WebDriver driver;
    private HomePage homePage;
    private RegisterPage registerPage;
    private static String urlDriver = System.getProperty("user.dir") +"\\src\\test\\resources\\drivers\\chromedriver.exe";;
    private static String property = "webdriver.chrome.driver";
    private static String browser = "chrome";

    @Test
    public void CP001_CreacionCta_Spotify(){

    }

    @BeforeEach
    public void preCondiciones(){
        homePage = new HomePage(driver);
        homePage.conexionDriver(browser, urlDriver, property);

    }

}
