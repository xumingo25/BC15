package bc15.rodrigoDiaz.Unidad2.pages;

import bc15.rodrigoDiaz.Unidad2.utils.MetodosGenericos;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InicioPage extends MetodosGenericos {
    public InicioPage(WebDriver driver) { super(driver);}
    //Centralizar Localizadores
    By btnHazteCliente = By.xpath("//a[text()=\"Hazte Cliente\"]");

    //acciones de la página
    public void HazteCliente(){click(esperaExplicita(btnHazteCliente,10));

    }
}
