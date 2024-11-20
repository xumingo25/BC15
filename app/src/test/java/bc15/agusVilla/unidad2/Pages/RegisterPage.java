package bc15.agusVilla.unidad2.Pages;

import bc15.agusVilla.unidad2.utils.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage extends BaseClass {
    //Centralizamos localizadores
    By byTxtUserName = By.id("username");
    By byBtnCerrarPopUp = By.xpath("button[@aria-label='Cerrar']");
    //By
    //By
    //By
    //By
    //By
    //By

    //Acciones de la pagina
    //public void

    public RegisterPage(WebDriver driver){
        super(driver);
    }
}
