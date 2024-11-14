package bc15.dsaavedra.unidad2.pages;

import bc15.dsaavedra.unidad2.utils.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BaseClass {
    //Centralizamos localizadores
    By byLocalorBtnRegistrarte = By.xpath("//button[contains(text(),'Reg')]");
    By byTextUsername = By.xpath("//button[@data-testid='user-widget-link']");


    public HomePage(WebDriver driver) {
        super(driver);
    }

    //acciones de la página
    public void irARegister(){
        click(esperaExplicita(byLocalorBtnRegistrarte,10));
    }

    public String obtenerNombreUsuario(){
        return obtenerTextoAtributo(esperaExplicita(byTextUsername,10),"aria-label");
    }
}
