package bc15.rodrigoDiaz.Unidad2.tests;

import bc15.rodrigoDiaz.Unidad2.pages.FormPage;
import bc15.rodrigoDiaz.Unidad2.pages.InicioPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;


public class BciTest {
    //Atributos
    private WebDriver driver;
    private InicioPage inicioPage;
    private FormPage formPage;
    private static String urlDriver = System.getProperty("user.dir") +"\\src\\test\\resources\\drivers\\chromedriver.exe";
    private static String property = "webdriver.chrome.driver";
    private static String browser = "chrome";

    @Test //crear test
    public void CP001_RegistroNoPosible() throws InterruptedException {
    inicioPage.HazteCliente();
    formPage.RegistrarCtaBci("3.683.925-2",523225038,38049737,"juanto@mail.com","juanto@mail.com");
    formPage.validarTexto("Hubo un error intentando enviar tus datos");


    }@BeforeEach
    public void preCondiciones(){
        inicioPage = new InicioPage(driver);
        inicioPage.conexionDriver(browser,urlDriver,property);
        formPage = new FormPage(inicioPage.getDriver());
        inicioPage.cargarSitio("https://www.bci.cl/personas");
        inicioPage.maximizarBrowser(); }

    @AfterEach
    public void posCondiciones(){

    }
}
