package bc15.dsaavedra.unidad2.tests;

import bc15.dsaavedra.unidad2.pages.RegisterPage;
import bc15.dsaavedra.unidad2.pages.HomePage;

import bc15.dsaavedra.unidad2.utils.DataDriven;
import bc15.dsaavedra.unidad2.utils.Propertiesdriven;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class TestCases {
    //Atributos
    private WebDriver driver;
    private HomePage homePage;
    private RegisterPage registerPage;
    private static String browser = Propertiesdriven.obtenerProperty("browser");
    private ArrayList<String> data;

    @Test
    public void CP001_CreacionCta_Spotify(){
        data = DataDriven.getTestData(Propertiesdriven.obtenerProperty("CP001"));
        homePage.irARegister();
        registerPage.crearCtaSpotify(data.get(1),data.get(2),data.get(3),Integer.parseInt(data.get(4)),data.get(5),Integer.parseInt(data.get(6)),Integer.parseInt(data.get(7)),Boolean.parseBoolean(data.get(8)),Boolean.parseBoolean(data.get(9)));
        Assertions.assertEquals(data.get(8),homePage.obtenerNombreUsuario());
    }

    //Métodos
    @BeforeEach
    public void preCondiciones(){
        data = new ArrayList<String>();
        homePage = new HomePage(driver);
        homePage.conexionDriver(browser);
        //homePage.conexionDriver(browser,urlDriver,property);
        registerPage = new RegisterPage(homePage.getDriver());
        homePage.cargarSitio(Propertiesdriven.obtenerProperty("url"));
        homePage.maximizarBrowser();
    }

    @AfterEach
    public void posCondiciones(){
        homePage.cerrarBrowser();
    }
}
