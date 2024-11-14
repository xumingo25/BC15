package bc15.dsaavedra.unidad2.tests;

import bc15.dsaavedra.unidad2.pages.RegisterPage;
import bc15.dsaavedra.unidad2.pages.HomePage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class TestCases {
    //Atributos
    private WebDriver driver;
    private HomePage homePage;
    private RegisterPage registerPage;
    private static String urlDriver = System.getProperty("user.dir") +"\\src\\test\\resources\\drivers\\chromedriver.exe";
    private static String property = "webdriver.chrome.driver";
    private static String browser = "chrome";

    @Test
    public void CP001_CreacionCta_Spotify(){

        homePage.irARegister();
        registerPage.crearCtaSpotify("pruebaBC0016001@gmail.com","qMe@31qw23","User BC 0001",31,"Marzo",1999,0,true,true);
        Assertions.assertEquals("User BC 0001",homePage.obtenerNombreUsuario());
    }

    //Métodos
    @BeforeEach
    public void preCondiciones(){
        homePage = new HomePage(driver);
        homePage.conexionDriver(browser,urlDriver,property);
        registerPage = new RegisterPage(homePage.getDriver());
        homePage.cargarSitio("https://open.spotify.com/intl-es");
        homePage.maximizarBrowser();
    }

    @AfterEach
    public void posCondiciones(){

    }
}
