package bc15.gAcevedo.Unidad2.test;

import bc15.gAcevedo.Unidad2.pages.HomePage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class TestCases {
    private WebDriver driver;
    private HomePage homePage;
    private static bc15.dsaavedra.unidad2.utils.Propertiesdriven Propertiesdriven;
    private static String browser = Propertiesdriven.obtenerProperty("browser");
    private ArrayList<String> data;
    
    @Test
    public void CP001_IngresarHombre_Section(){
        homePage.SectionHombre();
        
    }
    @BeforeEach
    public void preCondiciones(){
        data = new ArrayList<String>();
        homePage = new HomePage(driver);
        homePage.conexionDriver(browser);
        homePage.cargarSitio(bc15.dsaavedra.unidad2.utils.Propertiesdriven.obtenerProperty("https://www.sporting.com.ar/"));
        homePage.maximizarBrowser();
    }
}
